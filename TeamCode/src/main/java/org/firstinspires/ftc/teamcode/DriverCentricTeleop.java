package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.DriverCentricDrive;
import org.firstinspires.ftc.teamcode.subsystems.Rotator;
import org.firstinspires.ftc.teamcode.subsystems.Slide;


@TeleOp
public class DriverCentricTeleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Slide slide = new Slide(this);
        DriverCentricDrive driverCentricDrive= new DriverCentricDrive(this);
        Claw claw = new Claw(this);
        Arm arm = new Arm(this);
        Rotator rotator = new Rotator(this);

        waitForStart();
        while (opModeIsActive()) {
            driverCentricDrive.driverCentric();
            claw.teleOp();
            slide.teleOp();
            arm.teleOp();
            rotator.teleOp();

        }
    }
}
