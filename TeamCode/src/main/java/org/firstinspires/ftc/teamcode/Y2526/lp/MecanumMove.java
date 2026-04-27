package org.firstinspires.ftc.teamcode.Y2526.lp;

import static java.lang.Thread.sleep;

import android.util.AndroidRuntimeException;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp(name = "Mecanum TeCailinOp", group = "Robot")
public class MecanumMove extends OpMode {

    private CRServo rightServo = null;
    private CRServo leftServo = null;
    DcMotor frontLeftDrive;
    DcMotor frontRightDrive;
    DcMotor backLeftDrive;
    DcMotor backRightDrive;
    public void init(){
        telemetry.addData("hi", 0);
        telemetry.update();
        rightServo = hardwareMap.get(CRServo.class, "right_feeder");
        leftServo = hardwareMap.get(CRServo.class, "left_feeder");
    }

    @Override
    public void loop() {
        if(gamepad1.a){
            telemetry.addData("pressed a", 0);
            telemetry.update();
            spin();
        }
        else if(gamepad1.b){
            telemetry.addData("pressed b", 0);
            telemetry.update();
            antiSpin();
        }
        else if(gamepad1.x){
            telemetry.addData("pressed x", 0);
            telemetry.update();
            otherSpin();
        }
        else if(gamepad1.y){
            telemetry.addData("pressed y", 0);
            telemetry.update();
            otherAntiSpin();
        }
    }
    public void spin() {
        rightServo.setPower(1.0);
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void antiSpin() {
        rightServo.setPower(-1.0);
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void otherSpin() {
        leftServo.setPower(1.0);
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new AndroidRuntimeException(e);
        }
    }
    public void otherAntiSpin() {
        leftServo.setPower(-1.0);
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new AndroidRuntimeException(e);
        }
    }
}