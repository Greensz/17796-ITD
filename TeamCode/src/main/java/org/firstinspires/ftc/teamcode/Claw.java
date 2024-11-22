package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    private static Servo Claw;
    private static Gamepad Driver1;
    private static Gamepad Driver2;
    private static double Close = 0;
    private static double Open = 0;

    public Claw(OpMode opMode) {
        Driver1 = opMode.gamepad1;
        Driver2 = opMode.gamepad2;
        Claw = (Servo) opMode.hardwareMap.get("L claw");
        Claw.setDirection(Servo.Direction.REVERSE);
        Claw.setPosition(Close);
        //        opMode.time
    }

    public static void teleOp() throws InterruptedException {
            if (Driver2.x){
                Claw.setPosition(Close);
            }
            if (Driver2.y){
                Claw.setPosition(Open);
            }}}