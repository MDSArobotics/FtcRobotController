/*
 * This file contains a sample "TeleOp" Linear OpMode program intended for the Tetrix robot arm.
 * The arm is position is driven by a single DC motor, whereas the wrist and claw positions are each
 * driven by 180-degree servos.  The robot arm intended to provide a test bed for programming
 * exercises and robot demonstrations.
 */

package org.firstinspires.ftc.teamcode.Demos.TetrixBot;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Tetrix_Arm", group = "Demos")
@Disabled
public class Tetrix_Arm_TeleOp extends LinearOpMode {

    // Motors
    final ElapsedTime runtime = new ElapsedTime();
    public DcMotor  armMotor    = null; //the arm motor
    public Servo    wrist       = null; //the wrist servo
    public Servo    claw        = null; //the claw servo
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
        // to 'get' must correspond to the names assigned in the robot configuration file.

        // Get references to motor objects
        armMotor   = hardwareMap.get(DcMotor.class, "arm");
        // The arm motor orientation and 1:4 gear ratio with the arm axle require a direction flip
        armMotor.setDirection(DcMotor.Direction.REVERSE);

        /* Setting zeroPowerBehavior to BRAKE enables a "brake mode". This causes the motor to slow down
        much faster when it is coasting.  */

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

            // Store the gamepad values from the previous loop and current loop
            previousGamepad1.copy(currentGamepad1);
            currentGamepad1.copy(gamepad1);

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

            // Show the elapsed game time and arm positions
            telemetry.addData("*  Bumper Left/Right ", "Drive Speed Down/Up");
            telemetry.addData("*  Trigger Left/Right ", "Arm Position Down/Up");
            telemetry.addData("*  DPAD Left/Right", "Claw Closed/Open");
            telemetry.addData("*  DPAD Down/Up", "Wrist Down/Up");
            telemetry.addData("Arm Motor Speed", "arm (%.2f)", ARM_SPEED);
            telemetry.addData("Status", "Run Time: " + runtime);
            telemetry.update();
        }
    }
}


