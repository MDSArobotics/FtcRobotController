package org.firstinspires.ftc.teamcode.Y2526.lp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp (name = "Live With Love", group = "Linear OpMode")
public class TeleOpComp extends LinearOpMode {

    boolean launchMotorRunning = false;

    // declare motor variables
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;
    private DcMotor launchMotor = null;

    public void runOpMode() {

        // telemetry to verify that the code is on correctly
        telemetry.addData("Working", 0);
        telemetry.update();
        sleep(20000);

        // identify motor names on robot
        leftMotor = hardwareMap.get(DcMotor.class, "left_drive");
        rightMotor = hardwareMap.get(DcMotor.class, "right_drive");
        launchMotor = hardwareMap.get(DcMotor.class, "launch");

        // set motor directions
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        rightMotor.setDirection(DcMotor.Direction.FORWARD);
        launchMotor.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        // start opMode
        while (opModeIsActive()){
            leftMotorGo();
            rightMotorGo();
            launchMotorGo();
        }

    }

    // code to activate left motor. not working right now
    private void leftMotorGo(){
        if (gamepad1.left_stick_y > 0.0){
            leftMotor.setPower(1);
        }
        if (gamepad1.left_stick_y == 0.0){
            leftMotor.setPower(0);
        }
    }
    // code to activate right motor. not working right now
    private void rightMotorGo(){
        if (gamepad1.right_stick_y > 0.0){
            rightMotor.setPower(1);
        }
        if (gamepad1.right_stick_y == 0.0){
            rightMotor.setPower(0);
        }
    }
    // code to activate launch motor. borderline working right now
    private void launchMotorGo() {
        if (!launchMotorRunning) {
            if (gamepad1.aWasPressed()) {
                launchMotor.setPower(1);
                launchMotorRunning = true;
            }
        }
        if (launchMotorRunning) {
            if (gamepad1.bWasPressed()) {
                launchMotor.setPower(0);
                launchMotorRunning = false;
            }
        }
    }
}
