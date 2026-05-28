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
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TetrixBot_Arm_TeleOp")
//@Disabled
public class TetrixBot_Arm_TeleOp extends LinearOpMode {

    // Motors
    final ElapsedTime runtime = new ElapsedTime();
    public DcMotor  leftDrive   = null; //the left drivetrain motor
    public DcMotor  rightDrive  = null; //the right drivetrain motor
    public DcMotor  armMotor    = null; //the arm motor
    public Servo    wrist       = null; //the wrist servo
    public Servo    claw        = null; //the claw servo

    public double DRIVE_SPEED = 0.8;
    public double TURN_SPEED;
    final double SPEED_STEP = 0.2;
    public double ARM_SPEED = 0.4;

    // wrist positions.
    final double UP   = 0.6;
    final double DOWN = 0.35;
    final double PARKED = 0.95;

    // Claw gripper positions.
    final double CLOSED = 0.20; // 18 degrees
    final double OPEN = 0.65;  // 120 degrees

    @Override
    public void runOpMode() {
        telemetry.addData("*  Left Joystick Up/Down: ", "Drive Forward/Backward");
        telemetry.addData("*  Right Joystick Left/Right ", "Turn Left/Right");
        telemetry.addData("*  Bumper Left/Right ", "Drive Speed Down/Up");
        telemetry.addData("*  Trigger Left/Right ", "Arm Position Down/Up");
        telemetry.addData("*  DPAD Left/Right", "Claw Closed/Open");
        telemetry.addData("*  DPAD Down/Up", "Wrist Down/Up");
        telemetry.addData("Status", "Run Time: " + runtime);
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
        armMotor   = hardwareMap.get(DcMotor.class, "arm");

        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // The settings here assume a 3:1 gear ratio for the drive motors requiring direction flips
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        armMotor.setDirection(DcMotor.Direction.REVERSE);

        /* Setting zeroPowerBehavior to BRAKE enables a "brake mode". This causes the motor to slow down
        much faster when it is coasting. This creates a much more controllable drivetrain. As the robot
        stops much quicker. */

        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        /* Define and initialize servos.*/
        wrist  = hardwareMap.get(Servo.class, "wrist");
        claw  = hardwareMap.get(Servo.class, "claw");

        /* The wrist is parked and the claw is closed.*/
        wrist.setPosition(PARKED);
        claw.setPosition(CLOSED);

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

            if (gamepad1.dpad_up){
                wrist.setPosition(UP);
            }
            else if (gamepad1.dpad_down){
                wrist.setPosition(DOWN);
            }
            if (gamepad1.dpad_left){
                claw.setPosition(CLOSED);
            }
            else if (gamepad1.dpad_right){
                claw.setPosition(OPEN);
            }

            if (gamepad1.right_trigger > 0.1) {
                armMotor.setPower(ARM_SPEED); // Arm speed forward
            } else if (gamepad1.left_trigger > 0.1) {
                armMotor.setPower(-ARM_SPEED); // Arm speed reverse
            } else {
                armMotor.setPower(0.0); // Stop
            }

            // Show the elapsed game time and wheel power.
            telemetry.addData("*  Left Joystick Up/Down: ", "Drive Forward/Backward");
            telemetry.addData("*  Right Joystick Left/Right ", "Turn Left/Right");
            telemetry.addData("*  Bumper Left/Right ", "Drive Speed Down/Up");
            telemetry.addData("*  Trigger Left/Right ", "Arm Position Down/Up");
            telemetry.addData("*  DPAD Left/Right", "Claw Closed/Open");
            telemetry.addData("*  DPAD Down/Up", "Wrist Down/Up");
            telemetry.addData("Status", "Run Time: " + runtime);
            telemetry.addData("Drive Motors Power", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.addData("Motor Speed", "drive (%.2f), turn (%.2f), arm (%.2f)", DRIVE_SPEED, TURN_SPEED, ARM_SPEED);
            telemetry.update();
        }
    }
}


