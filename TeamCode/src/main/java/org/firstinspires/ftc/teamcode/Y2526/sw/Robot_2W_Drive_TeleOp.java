/*
 * This file contains a sample "TeleOp" Linear OpMode program intended for the TetrixDemoBot robot.
 * The robot consists of a basic two-motor POV drive chassis with two servos, two color sensors,
 * one touch sensor, and one 2M distance sensor.  The robot is intended to provide a test bed for
 * programming exercises and robot demonstrations. This OpMode follows programming examples and copies
 * some code directly from  the package org.firstinspires.ftc.robotcontroller.external.samples, namely
 *      BasicOpMode_Linear.java
 * To do: Color, distance, and touch sensors are declared but have no functionality.  Apply logic from
 *      SensorColor.java
 *      SensorREV2mDistance.java
 *      SensorDigitalTouch.java
 */

package org.firstinspires.ftc.teamcode.Y2526.sw;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Robot_2W_Drive_TeleOp")
//@Disabled
public class Robot_2W_Drive_TeleOp extends LinearOpMode {
    // Motors
    final ElapsedTime runtime = new ElapsedTime();
    public DcMotor  leftDrive   = null; //the left drivetrain motor
    public DcMotor  rightDrive  = null; //the right drivetrain motor

    public double DRIVE_SPEED = 0.8;
    public double TURN_SPEED;
    final double SPEED_STEP = 0.2;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize gamepad states.  Setting these values to new Gamepad() will default all
        // boolean values as false and all float values as 0
        Gamepad currentGamepad1 = new Gamepad();
        Gamepad previousGamepad1 = new Gamepad();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration step
        // (using the FTC Robot Controller app on the phone).

        // Get references to motor objects
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");

        // To drive forward, most robots need the motor on one side to be reversed, because the shafts point in opposite directions.
        // Forward motion for a motor is generally defined as clockwise (CW) rotation when viewed from the output shaft end.
        // Clockwise rotation adds to the encoder count, while counterclockwise (CCW) subtracts.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips.
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

            // Store the gamepad values from the previous loop and current loop
            previousGamepad1.copy(currentGamepad1);
            currentGamepad1.copy(gamepad1);

            if (currentGamepad1.left_bumper && !previousGamepad1.left_bumper) {
                DRIVE_SPEED = Range.clip( DRIVE_SPEED - SPEED_STEP, 0.4, 1.0);
            } else if (currentGamepad1.right_bumper && !previousGamepad1.right_bumper) {
                DRIVE_SPEED = Range.clip( DRIVE_SPEED + SPEED_STEP, 0.4, 1.0);
            }
            TURN_SPEED = DRIVE_SPEED - 0.2;

            // Drive the bot in "Point of View" POV Mode versus tank drive
            // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.
            double drive = -gamepad1.left_stick_y * DRIVE_SPEED;
            double turn  =  gamepad1.right_stick_x * TURN_SPEED;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

            // Send calculated power to wheels
            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime);
            telemetry.addData("Motor Speed", "drive (%.2f), turn (%.2f)", DRIVE_SPEED, TURN_SPEED);
            telemetry.addData("Drive Motors Power", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}
