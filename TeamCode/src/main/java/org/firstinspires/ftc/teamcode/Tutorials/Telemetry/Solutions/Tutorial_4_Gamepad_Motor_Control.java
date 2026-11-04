/* Tutorial 4 Gamepad Motor Control
  Adding a motor and controlling it via the gamepad.
    Goals:
    1.  Add a DC motor to the robot
    2.  Name the motor on the Driver Station configuration file (motor1)
    3.  Access the HardwareMap to obtain a reference to the motor via a variable of your
        choosing (or use the firstMotor variable)
    4.  Associate motor behavior with a gamepad control
    5.  Remember to display motor information via the use of a Telemetry.Item variable
    6.  Turn the motor on via the motor's setPower() command
    7.  Report the motor's information via the motor's getPower() method and telemetry method(s)

Step by Step:
  Change the class name to something more meaningful
  Remember to keep the class name and file name consistent.
  Place the program in a directory of your choosing; don't create a mess in the TeamCode directory
  Download the code to the robot and run the program.
  Be sure to understand what the code is doing vis-a-vis the information being displayed on the
  robot controller

  BEFORE YOU WRITE CODE
    - Configure the motor using the Driver Station.  Name the motor "motorTest"

  Note how to declare a variable of type DcMotor
  Complete the hardwareMap.get() method to use the motor name as configured on the Driver Station
  Select a gamepad control and implement *both* motor function (on/off/power) and operator information
  via the firstMotorStatus variable.

*/

package org.firstinspires.ftc.teamcode.Tutorials.Telemetry.Solutions;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.concurrent.ThreadLocalRandom;

@TeleOp(name="Tutorial 4: Gamepad Motor Control", group="Tutorials")
@Disabled
public class Tutorial_4_Gamepad_Motor_Control extends LinearOpMode {

    private DcMotor firstMotor = null;

    // Create variable for use by the Telemetry object
    // Initialize those variable.
    Telemetry.Item firstMotorStatus = telemetry.addData("first motor status", 0);
    Telemetry.Item programStatus = telemetry.addData("Status", "Initialized");



    @Override
    public void runOpMode() {
        //  Enter the correct value for "deviceName"
        firstMotor = hardwareMap.get(DcMotor.class, "motorTest");

        // Do NOT erase the display between telemetry refreshes
        telemetry.setAutoClear(false);
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            programStatus.setValue("Running at " + System.currentTimeMillis());
            // set firstMotor status information here
            telemetry.update();
            sleep(1000);

            /*  Use if-else blocks to test the current state of gamepad boolean inputs.
                These return true if pressed, and false if not pressed:
                    Buttons: x, y, a, and b
                    Directional Pad: dpad_down, dpad_left, dpad_right, dpad_up
                    Bumpers:  left_bumper, right_bumper
                    Joystick Buttons:  left_stick_button, right_stick_button
                    Start button: start
                    Guide button: guide
                    Back button: back
                Use if-else blocks to test the current state of gamepad analog inputs.
                These return floating point values between -1.0 and 1.0 depending upon position and
                return 0.0 when at rest. Negative values represent up deflections along the Y-axis
                and positive values reflect down deflections along the Y-axis.
                    Joysticks: left_stick_y, left_stick_x, right_stick_x, right_stick_y
                    Triggers: left_trigger, right_trigger
             */
            if (gamepad1.a == true){

            }
            else {

            }
            if (gamepad1.b) {  // same as (gamepad1.b == true)

            }
            else {
            }
            if (gamepad1.x) {

            }
            else {

            }
            if (gamepad1.y) {

            }
            else {

            }
            if (gamepad1.dpad_down) {

            }
            else {

            }
            if (gamepad1.dpad_left) {

            }
            else {

            }
            if (gamepad1.dpad_right) {

            }
            else {

            }
            if (gamepad1.dpad_up) {

            }
            else {

            }
            if (gamepad1.left_trigger > 0.0) { // 0.0 to 1.0

            }
            else {

            }
            if (gamepad1.right_trigger > 0.0) {

            }
            else {

            }
            if (gamepad1.left_bumper) {

            }
            else {

            }
            if (gamepad1.right_bumper) {

            }
            else {

            }
            if (gamepad1.back) {

            }
            else {

            }
            if (gamepad1.start) {

            }
            else {

            }
            if (gamepad1.guide) {

            }
            else {

            }
            if (gamepad1.left_stick_x < 0.0) {

            }
            else {

            }
            if (gamepad1.left_stick_y < 0.0) {

            }
            else {

            }
            if (gamepad1.right_stick_x < 0.0) {

            }
            else {

            }
            if (gamepad1.right_stick_y < 0.0) {

            }
            else {

            }
            if (gamepad1.left_stick_button) {

            }
            else {

            }
            if (gamepad1.right_stick_button) {

            }
            else {

            }
            if (gamepad1.atRest()) {
                // Nothing happening here
            }
            telemetry.update();


        }
    }

    private int getBoundedRandomInt(int minInclusive, int maxInclusive) {
        return ThreadLocalRandom.current().nextInt(minInclusive, maxInclusive + 1);
    }
}

