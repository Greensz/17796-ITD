package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    private static Servo leftServo;
    private static Servo rightServo;
    private static Gamepad Driver1;
    private static Gamepad Driver2;
    private static double scorePosition = 0.50;
    private static double intakePosition = 0.065;
    static boolean ArmIsUp;
    static int Count = 0;

    public Claw(OpMode opMode) {
        Driver1 = opMode.gamepad1;
        Driver2 = opMode.gamepad2;
        leftServo = (Servo) opMode.hardwareMap.get("L claw");
        rightServo = (Servo) opMode.hardwareMap.get("R claw");


        leftServo.setDirection(Servo.Direction.REVERSE);
        rightServo.setDirection(Servo.Direction.FORWARD);
        armServo(scorePosition, scorePosition);
        ArmIsUp=true;
        //        opMode.time
    }

    public static void teleOp() throws InterruptedException {
        if (Count>80){
            if (Driver2.x){
                if(ArmIsUp){
                    armServo(intakePosition,intakePosition);
                    ArmIsUp = false;
                    Count =0;
                } else {
                    armServo(scorePosition,scorePosition);
                    ArmIsUp = true;
                    Count =0;
                }
            }
        } else{Count++;}
        if (Driver2.dpad_right){
            armServo(intakePosition, intakePosition);
        }}

    public static void armServo(double setPositionRight, double setPositionLeft) {
        rightServo.setPosition(setPositionRight);
        leftServo.setPosition(setPositionLeft);
}}
