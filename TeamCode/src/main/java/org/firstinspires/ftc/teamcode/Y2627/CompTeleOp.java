package org.firstinspires.ftc.teamcode.Y2627;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Te Diya Op", group="TeleOp 2627")
@Disabled
public class CompTeleOp extends LinearOpMode {

    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;

    public void runOpMode(){

        leftMotor = hardwareMap.get(DcMotor.class, "left_drive");
        rightMotor = hardwareMap.get(DcMotor.class, "right_drive");

        waitForStart();

        telemetry.addData("Starting code", 0);
        telemetry.update();

        while (opModeIsActive()){

            telemetry.addData("Running code",0);
            telemetry.update();

            double leftPower;
            double rightPower;

            double drive = -gamepad1.left_stick_y;
            double turn  =  -gamepad1.right_stick_x;

            leftMotor.setDirection(DcMotor.Direction.REVERSE);
            rightMotor.setDirection(DcMotor.Direction.FORWARD);

            leftPower    = Range.clip(drive + turn, -0.8, 0.8) ;
            rightPower   = Range.clip(drive - turn, -0.8, 0.8) ;

            leftMotor.setPower(leftPower);
            rightMotor.setPower(rightPower);

        }

    }
}
