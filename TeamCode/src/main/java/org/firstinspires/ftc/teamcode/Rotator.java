package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Rotator {
    private static Servo Rotator;
    private static Gamepad Driver1;
    private static Gamepad Driver2;
    private static double Vertical = 0;
    private static double Horizontal = 0.3;

    public Rotator(OpMode opMode) {
        Driver1 = opMode.gamepad1;
        Driver2 = opMode.gamepad2;
        Rotator = (Servo) opMode.hardwareMap.get("Rotator");
        Rotator.setDirection(Servo.Direction.REVERSE);
        Rotator.setPosition(Horizontal);
        //        opMode.time
    }

    public static void teleOp() throws InterruptedException {
        if (Driver2.left_bumper){
            Rotator.setPosition(Horizontal);
        }
        if (Driver2.right_bumper){
            Rotator.setPosition(Vertical);
        }}}