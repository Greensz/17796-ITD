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
        rotator.Vertical();

        if (opModeIsActive()) {
            //preload
            slides.moveHighBasket();

            Actions.runBlocking(
                    drive.actionBuilder(beginPose)
                            .strafeToLinearHeading(new Vector2d(61, 61), Math.toRadians(45))
                            .build());
        claw.setClawOpen();

            Actions.runBlocking(
                    drive.actionBuilder(beginPose)
                            .strafeToLinearHeading(new Vector2d(54, 54), Math.toRadians(45))
                            .build());
            slides.Reset();
        }}}}
