package org.firstinspires.ftc.teamcode.Y2627;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Shooter Auto", group="Start Position")

public class ShootingAuto extends LinearOpMode {

    //declare motors and servos here - NOT DONE
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;

    //declare motor measurement here - NOT DONE

    @Override
    public void runOpMode(){

        leftMotor  = hardwareMap.get(DcMotor.class, "left_drive");
        rightMotor = hardwareMap.get(DcMotor.class, "right_drive");

        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();
        telemetry.addData("Starting code",0);
        telemetry.update();
        while (opModeIsActive()){
            telemetry.addData("Running code", 0);
            telemetry.update();
            //          move
            //          turn
            //          align
            //          shoot
            //          move again to park MAYBE
        }
    }
}

