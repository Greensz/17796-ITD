package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Slide;
import org.firstinspires.ftc.teamcode.subsystems.Rotator;

@Config
@Autonomous(name = "LeftAuto", group = "Autonomous")
public final class LeftAuto extends LinearOpMode {

    // Declare subsystem variables

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize the pose
        Pose2d beginPose = new Pose2d(33, 63, Math.toRadians(270));
        Pose2d basket = new Pose2d(56, 56, Math.toRadians(45));
        Pose2d first = new Pose2d(50, 42, Math.toRadians(270));
        Pose2d second = new Pose2d(61, 40, Math.toRadians(270));



        // Initialize the drivetrain
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);

        // Initialize other subsystems
        Claw claw = new Claw(this);  // Assuming Claw class exists
        Arm arm = new Arm(this);    // Assuming Arm class exists
        Slide slides = new Slide(this); // Assuming Slides class exists
        Rotator rotator = new Rotator(this);

        while (!opModeIsActive()&&!isStopRequested()){

        waitForStart();

        claw.setClawClosed();
        arm.ArmScore();
        rotator.Horizontal();

        if (opModeIsActive()) {
            //preload
            slides.moveHighBasket();

            Actions.runBlocking(
                    drive.actionBuilder(beginPose)
                            .splineToLinearHeading(new Pose2d(56, 56,Math.toRadians(45)), Math.toRadians(35))
                            .build());
            sleep(1000);
        claw.setClawOpen();
        sleep(1000);

            Actions.runBlocking(
                    drive.actionBuilder(basket)
                            .splineToLinearHeading(new Pose2d(50, 42, Math.toRadians(270)), Math.toRadians(225))
                            .build());
            slides.Reset();
sleep(2000);
            arm.ArmIntake();
            sleep(500);
            claw.setClawClosed();
            sleep(500);
            arm.ArmScore();
            sleep(500);
            slides.moveHighBasket();

            Actions.runBlocking(
                    drive.actionBuilder(first)
                            .splineToLinearHeading(new Pose2d(56, 56, Math.toRadians(45)), Math.toRadians(35))
                            .build());
            sleep(1000);
            claw.setClawOpen();

            Actions.runBlocking(
                    drive.actionBuilder(basket)
                            .splineToLinearHeading(new Pose2d(61, 42,Math.toRadians(280)), -Math.PI / 2)
                            .build());

            slides.Reset();
            sleep(2000);
            arm.ArmIntake();
            sleep(500);
            claw.setClawClosed();
            sleep(500);
            arm.ArmScore();
            sleep(500);
            slides.moveHighBasket();

            Actions.runBlocking(
                    drive.actionBuilder(first)
                            .splineToLinearHeading(new Pose2d(56, 56, Math.toRadians(45)), Math.toRadians(35))
                            .build());
            sleep(1000);
            claw.setClawOpen();
            sleep(2000);

            Actions.runBlocking(
                    drive.actionBuilder(first)
                            .splineTo(new Vector2d(20, -11), Math.toRadians(270))
                            .build());

        }}}}
