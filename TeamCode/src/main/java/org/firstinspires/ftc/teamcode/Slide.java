package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Slide {

    public static double POWER = 1;
    public static int HighBasket =2500;
    public static  int HighBasketRight = -2500;
    public static int SpecimenIntake = 2000;
    public static int HighRung = 100;
    public static int RESET = 0;
    public static int MANUAL_MOVE_SPEED = 10;
    private int position = 0;

    public final DcMotor slideLeft;
    public final DcMotor slideRight;

    private final HardwareMap hardwareMap;
    private final Gamepad Driver2;
    private final Gamepad Driver1;
    public final Telemetry telemetry;

    public Slide(OpMode opMode) {
        Driver2 = opMode.gamepad2;
        Driver1 = opMode.gamepad1;
        hardwareMap = opMode.hardwareMap;
        telemetry = opMode.telemetry;

        slideLeft = hardwareMap.get(DcMotor.class,"L Slide");
        slideLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        slideLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        slideRight = hardwareMap.get(DcMotor.class, "R Slide");
        slideRight.setDirection(DcMotorSimple.Direction.REVERSE);
        slideRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        slideLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slideRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        slideLeft.setTargetPosition(0);
        slideRight.setTargetPosition(0);

        slideLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);


    }

    public void teleOp(){
        if(Driver2.dpad_up) moveHighBasket();
        else if (Driver2.dpad_left) moveLowBasket();
//        else if (Driver2.dpad_right) moveHighRung();
        else if(Driver2.dpad_down) Reset();
//        else if (Driver2.left_bumper) moveMotors(position + MANUAL_MOVE_SPEED);
//        else if (Driver2.right_bumper) moveMotors(position - MANUAL_MOVE_SPEED);

        // Add telemetry data
        telemetry.addData("Slide Position", slideLeft.getCurrentPosition());

        // Update the telemetry to reflect the changes on the Driver Hub
        telemetry.update();
    }


    public void moveHighBasket(){
        slideLeft.setPower(1);
        slideLeft.setTargetPosition(HighBasket);

        slideRight.setPower(1);
        slideRight.setTargetPosition(HighBasket);
    }
    public void moveLowBasket() {
        slideLeft.setPower(1);
        slideLeft.setTargetPosition(SpecimenIntake);

        slideRight.setPower(1);
        slideRight.setTargetPosition(SpecimenIntake);

    }
    public void moveHighRung() {
        slideLeft.setPower(1);
        slideLeft.setTargetPosition(HighRung);

        slideRight.setPower(1);
        slideRight.setTargetPosition(HighRung);

    }
    public void Reset(){
        slideLeft.setPower(1);
        slideLeft.setTargetPosition(RESET);

        slideRight.setPower(1);
        slideRight.setTargetPosition(RESET);
    }
    public void moveMotors(int position){
        this.position = position;
        slideLeft.setTargetPosition(position);
        //slideRight.setTargetPosition(position);
        slideLeft.setPower(POWER);
        slideRight.setPower(POWER);

    }
}

