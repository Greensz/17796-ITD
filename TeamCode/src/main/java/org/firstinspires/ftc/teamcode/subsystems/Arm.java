package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {
    private static Servo leftServo;
    private static Servo rightServo;
    private static Gamepad Driver1;
    private static Gamepad Driver2;
    private static double scorePosition = 0.2;
    private static double intakePosition = 0.59;

    public Arm(OpMode opMode) {
        Driver1 = opMode.gamepad1;
        Driver2 = opMode.gamepad2;
        leftServo = (Servo) opMode.hardwareMap.get("LArm");
        rightServo = (Servo) opMode.hardwareMap.get("RArm");
        leftServo.setDirection(Servo.Direction.REVERSE);
        rightServo.setDirection(Servo.Direction.FORWARD);
        rightServo.setPosition(scorePosition);
        leftServo.setPosition(scorePosition);
    }

    public static void teleOp() throws InterruptedException {
        if (Driver2.a) {
            rightServo.setPosition(scorePosition);
            leftServo.setPosition(scorePosition);
        }
        if (Driver2.b) {
            rightServo.setPosition(intakePosition);
            leftServo.setPosition(intakePosition);
        }}
    public void ArmScore() {
        rightServo.setPosition(scorePosition);
        leftServo.setPosition(scorePosition);
    }
    public void ArmIntake() {
        rightServo.setPosition(intakePosition);
        leftServo.setPosition(intakePosition);
    }
}