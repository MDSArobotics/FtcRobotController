/*
 * This file contains a sample "TeleOp" Linear OpMode program intended for Ivan, the Tetrix DemoBot.
 * The robot consists of a basic two-wheel drive chassis with POV or Arcade-style drive coding for
 * controlling the drive train.  The robot is intended to provide a test bed for programming
 * exercises and robot demonstrations.
 */

package org.firstinspires.ftc.teamcode.Demos.TetrixBot;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TetrixBot_Drive", group = "Demos")
@Disabled
public class TetrixBot_Drive_TeleOp extends LinearOpMode {

    // Motors
    final ElapsedTime runtime = new ElapsedTime();
    public DcMotor  leftDrive   = null; //the left drivetrain motor
    public DcMotor  rightDrive  = null; //the right drivetrain motor

    @Override
    public void runOpMode() {
        telemetry.addData("*  Left Joystick Up/Down: ", "Drive Forward/Backward");
        telemetry.addData("*  Right Joystick Left/Right ", "Turn Left/Right");
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration step
        // (using the FTC Robot Controller app on the phone).

        // Get references to motor objects
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");

        // The design includes a 3:1 gear ratio for the drive motors requiring direction flips
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        /* Setting zeroPowerBehavior to BRAKE enables a "brake mode". This causes the motor to slow down
        much faster when it is coasting. This creates a much more controllable drivetrain. As the robot
        stops much quicker. */

        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Set up a variable for each drive wheel to save power level for telemetry
            double leftPower;
            double rightPower;

            // Drive the bot in "Point of View" POV Mode versus tank drive
            // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.
            double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

            // Send calculated power to wheels
            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);

            // Show the elapsed game time and wheel power.
            telemetry.addData("*  Left Joystick Up/Down: ", "Drive Forward/Backward");
            telemetry.addData("*  Right Joystick Left/Right ", "Turn Left/Right");
            telemetry.addData("Drive Motors Power", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.addData("Status", "Run Time: " + runtime);
            telemetry.update();
        }
    }
}
