package org.firstinspires.ftc.teamcode.Y2627;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "run intake motor",group = "test")
public class RunMotor extends LinearOpMode {
    private DcMotor intakeMotor = null;

    public void runOpMode(){

        telemetry.addData("Code running",0);
        telemetry.update();
        sleep(1000);

        intakeMotor = hardwareMap.get(DcMotor.class, "motor name");

        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
        intakeMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setPower(0.0);

        waitForStart();
        telemetry.addData("Code starting",0);

        while(opModeIsActive()){
            if (gamepad1.a){
                intakeMotor.setPower(0.6);
            }
            if (gamepad1.b){
                intakeMotor.setPower(0.0);
            }
            if (gamepad1.y){
                intakeMotor.setDirection(DcMotor.Direction.REVERSE);
            }
        }
    }
}
