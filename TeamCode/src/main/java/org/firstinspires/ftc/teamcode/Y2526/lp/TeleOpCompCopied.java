package org.firstinspires.ftc.teamcode.Y2526.lp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp (name = "Te Li Op", group = "Te")
@Disabled
public class TeleOpCompCopied extends LinearOpMode {
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;
    private DcMotor launchMotor = null;
    private CRServo rightServo = null;
    private CRServo leftServo = null;
    public long LastAct = 1000000000;
    public long OtherTime = 1000000000;

    public void runOpMode() {

        // display
        telemetry.addData("code is correct", 0);
        telemetry.update();
        sleep(500);

        // get motors
        leftMotor = hardwareMap.get(DcMotor.class, "left_drive");
        rightMotor = hardwareMap.get(DcMotor.class, "right_drive");
        launchMotor = hardwareMap.get(DcMotor.class, "launcher");
        leftServo = hardwareMap.get(CRServo.class, "left_feeder");
        rightServo = hardwareMap.get(CRServo.class, "right_feeder");

        // drive motors
        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        // launch motor
        launchMotor.setDirection(DcMotor.Direction.FORWARD);
        launchMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        launchMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        launchMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        launchMotor.setPower(0.0);

        waitForStart();
        telemetry.addData("meowmeowmeow", 0);
        telemetry.update();
        LastAct = System.currentTimeMillis();
        sleep(1000);

        while (opModeIsActive()){

            double leftPower;
            double rightPower;

//            if (gamepad1.dpadUpWasPressed()) {
//
//                double drive = gamepad1.left_stick_y;
//                double turn  =  -gamepad1.right_stick_x;
//
//                leftMotor.setDirection(DcMotor.Direction.FORWARD);
//                rightMotor.setDirection(DcMotor.Direction.REVERSE);
//
//                leftPower    = Range.clip(drive + turn, -0.8, 0.8) ;
//                rightPower   = Range.clip(drive - turn, -0.8, 0.8) ;
//
//            }
            if (gamepad1.dpadDownWasPressed()){

                double drive = -gamepad1.left_stick_y;
                double turn  =  -gamepad1.right_stick_x;

                leftMotor.setDirection(DcMotor.Direction.REVERSE);
                rightMotor.setDirection(DcMotor.Direction.FORWARD);

                leftPower    = Range.clip(drive + turn, -0.8, 0.8) ;
                rightPower   = Range.clip(drive - turn, -0.8, 0.8) ;

            }

            else {

                double drive = gamepad1.left_stick_y;
                double turn  =  -gamepad1.right_stick_x;

                leftMotor.setDirection(DcMotor.Direction.FORWARD);
                rightMotor.setDirection(DcMotor.Direction.REVERSE);

                leftPower    = Range.clip(drive + turn, -0.8, 0.8) ;
                rightPower   = Range.clip(drive - turn, -0.8, 0.8) ;

            }

            leftMotor.setPower(leftPower);
            rightMotor.setPower(rightPower);

            if (gamepad2.y){
                leftServo.setPower(1.0);
                rightServo.setPower(-1.0);
            }
            else if (gamepad2.x){
                OtherTime=LastAct+500;
                if (System.currentTimeMillis() >= OtherTime) {
                    leftServo.setPower(-1.0);
                    rightServo.setPower(1.0);
                    LastAct = System.currentTimeMillis();
                }
            }
            else{
                leftServo.setPower(0.0);
                rightServo.setPower(0.0);
            }

            if (gamepad2.a){
                launchMotor.setPower(0.6);
                LastAct = System.currentTimeMillis();
            }
            else if (gamepad2.b){
                launchMotor.setPower(0.0);
            }
        }
    }
}
