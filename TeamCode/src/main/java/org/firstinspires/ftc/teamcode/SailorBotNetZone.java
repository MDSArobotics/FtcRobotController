package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
@Autonomous(name="SailorBot Net Zone", group="Robot")
public class SailorBotNetZone extends LinearOpMode {
    private DcMotor rightMotor = null;
    private DcMotor leftMotor = null;
    private DcMotor armMotor = null;
    //private DcMotor armMotor = null;


    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        rightMotor = hardwareMap.get(DcMotor.class, "right_drive");
        leftMotor = hardwareMap.get(DcMotor.class, "left_drive");
        armMotor = hardwareMap.get(DcMotor.class, "arm");

        doAll();

    }

    private void doAll(){
        setLaceyPosition(5);
        rightTurn(2);
        setLaceyPosition(10);
        rightTurn(2);
        setArm(3);
    }
    private void setLaceyPosition(int position) {

        int targetPosition = position;
        //int MOTOR_MAX_TICK = 538;

        rightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setTargetPosition(targetPosition);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftMotor.setTargetPosition(targetPosition);
        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.addData("Currently at", " at %7d :%7d",
                leftMotor.getCurrentPosition(), rightMotor.getCurrentPosition());


        telemetry.addData("moving to", rightMotor.getTargetPosition());
        leftMotor.setPower(.1);
        rightMotor.setPower(.1);


        while ( //opModeIsActive
                (leftMotor.isBusy() || rightMotor.isBusy())) {

            // Display it for the driver.
            telemetry.addData("Running to", " %7d :%7d", targetPosition, targetPosition);
            telemetry.addData("Currently at", " at %7d :%7d",
                    leftMotor.getCurrentPosition(), rightMotor.getCurrentPosition());
            telemetry.update();
        }
    }

    private void rightTurn(int position) {

        int TARGET_POSITION =  position;
        //int MOTOR_MAX_TICK = 538;

        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setTargetPosition(TARGET_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftMotor.setTargetPosition(TARGET_POSITION);
        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.addData("Currently at", " at %7d :%7d",
                leftMotor.getCurrentPosition(), rightMotor.getCurrentPosition());


        telemetry.addData("moving to", rightMotor.getTargetPosition());
        leftMotor.setPower(.1);
        rightMotor.setPower(.1);


        while ( //opModeIsActive
                (leftMotor.isBusy() || rightMotor.isBusy())) {

            // Display it for the driver.
            telemetry.addData("Running to", " %7d :%7d", TARGET_POSITION, TARGET_POSITION);
            telemetry.addData("Currently at", " at %7d :%7d",
                    leftMotor.getCurrentPosition(), rightMotor.getCurrentPosition());
            telemetry.update();
        }
    }

    private void setArm(int position) {

        int TARGET_POSITION = position;
        //int MOTOR_MAX_TICK = 538;

        armMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armMotor.setTargetPosition(TARGET_POSITION);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.addData("Currently at", " at %7d :%7d",
                armMotor.getCurrentPosition());


        telemetry.addData("moving to", armMotor.getTargetPosition());
        armMotor.setPower(.1);


        while ( //opModeIsActive
                armMotor.isBusy()) {

            // Display it for the driver.
            telemetry.addData("Running to", " %7d :%7d", TARGET_POSITION, TARGET_POSITION);
            telemetry.addData("Currently at", " at %7d :%7d",
                    armMotor.getCurrentPosition());
            telemetry.update();
        }
    }
}