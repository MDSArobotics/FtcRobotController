package org.firstinspires.ftc.teamcode.Y2526.lp;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class BasicMecanumMoving {
    private DcMotor leftFront = null;
    private DcMotor rightFront = null;
    private DcMotor leftBack = null;
    private DcMotor rightBack = null;
    private IMU imu;

    public void init(HardwareMap hwMap){
        leftFront = hwMap.get(DcMotor.class, "front_left");
        rightFront = hwMap.get(DcMotor.class, "front_right");
        leftBack = hwMap.get(DcMotor.class, "back_left");
        rightBack = hwMap.get(DcMotor.class, "back_left");

        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        imu = hwMap.get(IMU.class, "imu");

        RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
        );
        imu.initialize(new IMU.Parameters(RevOrientation));
    }
    public void drive(double forward, double strafe, double rotate){
        double leftFrontP = forward + strafe + rotate;
        double leftBackP = forward - strafe + rotate;
        double rightFrontP = forward - strafe - rotate;
        double rightBackP = forward + strafe - rotate;

        double maxPower = 1.0;
        double maxSpeed = 1.0;

        maxPower = Math.max(maxPower, Math.abs(leftBackP));
        maxPower = Math.max(maxPower, Math.abs(leftFrontP));
        maxPower = Math.max(maxPower, Math.abs(rightFrontP));
        maxPower = Math.max(maxPower, Math.abs(rightBackP));

        leftFront.setPower(maxSpeed * (leftFrontP / maxPower));
        leftBack.setPower(maxSpeed * (leftBackP / maxPower));
        rightFront.setPower(maxSpeed * (leftBackP / maxPower));
        rightBack.setPower(maxSpeed * (leftBackP / maxPower));
    }

    public void driveFieldRelative(double forward, double strafe, double rotate){
        double theta = Math.atan2(forward, strafe);
        double r = Math.hypot(strafe, forward);

        theta = AngleUnit.normalizeRadians(theta -
                imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS));

        double newForward = r * Math.sin(theta);
        double newStrafe = r * Math.cos(theta);

        this.drive(newForward, newStrafe, rotate);
    }

}
