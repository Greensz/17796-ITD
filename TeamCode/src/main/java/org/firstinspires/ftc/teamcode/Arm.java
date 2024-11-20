package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {
    private static Servo leftServo;
    private static Servo rightServo;
    private static Gamepad Driver1;
    private static Gamepad Driver2;
    private static double scorePosition = 0.50;
    private static double intakePosition = 0.15;

    public Arm(OpMode opMode) {
        Driver1 = opMode.gamepad1;
        Driver2 = opMode.gamepad2;
        leftServo = (Servo) opMode.hardwareMap.get("L wrist");
        rightServo = (Servo) opMode.hardwareMap.get("R wrist");


        leftServo.setDirection(Servo.Direction.REVERSE);
        rightServo.setDirection(Servo.Direction.FORWARD);
        armServo(scorePosition, scorePosition);
        //        opMode.time
    }

    public static void teleOp() throws InterruptedException {
        if (Driver2.a) {
            armServo(intakePosition, intakePosition);
        }
        if (Driver2.y) {
            armServo(scorePosition, scorePosition);
        }
    }
        public static void armServo ( double setPositionRight, double setPositionLeft){
            rightServo.setPosition(setPositionRight);
            leftServo.setPosition(setPositionLeft);
        }
        }
