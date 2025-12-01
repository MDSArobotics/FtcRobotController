package org.firstinspires.ftc.teamcode.Y2526.lp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp (name = "but it was love too", group = "Linear OpMode")
public class TeleOpCompCopied extends LinearOpMode {
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;
    private DcMotor launchMotor = null;
    private CRServo rightServo = null;
    private CRServo leftServo = null;
    private double launchPosSet = 0.0;
    private final int launchOne = 0;
    private final int launchTwo = 10;
    private final int launchThree = 600;
    private final int launchFour = 5;

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
        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        // launch motor
        launchMotor.setDirection(DcMotor.Direction.FORWARD);
        launchMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        launchMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        launchMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        launchMotor.setPower(0.0);

        waitForStart();
        while (opModeIsActive()){

            // idk what this does but I'd rather have it and not need it than need it and not have it
//            launchMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//            launchMotor.setTargetPosition(launchOne);
//            launchMotor.setPower(1.0);
//            launchMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            double leftPower;
            double rightPower;

            double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;
            leftMotor.setPower(leftPower);
            rightMotor.setPower(rightPower);

            if (gamepad1.y){
                leftServo.setPower(1.0);
                rightServo.setPower(-1.0);
            }
            else if (gamepad1.x){
                leftServo.setPower(-1.0);
                rightServo.setPower(1.0);
            }
            else{
                leftServo.setPower(0.0);
                rightServo.setPower(0.0);
            }

            if (gamepad1.a){
                launchMotor.setPower(1.0);
            }
            else if (gamepad1.b){
                launchMotor.setPower(0.0);
            }
        }
    }
}
