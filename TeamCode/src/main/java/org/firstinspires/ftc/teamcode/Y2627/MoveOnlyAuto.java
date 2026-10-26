package org.firstinspires.ftc.teamcode.Y2627;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class MoveOnlyAuto extends LinearOpMode{

        private DcMotor leftMotor;
        private DcMotor rightMotor;
    @Override
    public void runOpMode() throws InterruptedException {

        leftMotor = hardwareMap.get(DcMotor.class, "left_drive");
        rightMotor = hardwareMap.get(DcMotor.class, "right_drive");

        waitForStart();

    }
}