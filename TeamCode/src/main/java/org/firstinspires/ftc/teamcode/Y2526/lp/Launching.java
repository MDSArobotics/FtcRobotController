package org.firstinspires.ftc.teamcode.Y2526.lp;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp(name = "Test Stuff", group = "Te")
public class Launching extends LinearOpMode {
    private DcMotor launchMotor = null;
    private CRServo rightServo = null;
    private CRServo leftServo = null;

    private void TeleOpCode() {
        launchMotor = hardwareMap.get(DcMotor.class, "launcher");
        launchMotor.setDirection(DcMotor.Direction.FORWARD);
        launchMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        launchMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        launchMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        launchMotor.setPower(0.0);

    }
    public void runOpMode() {
    }
    }

