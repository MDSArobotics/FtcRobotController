/* Tutorial 3 Gamepad Basics - The road to gamepad usage and operator interaction...
    Goals:
    1.  Use one of the gamepad built in variable to provide operator interaction with the robot
    2.  Become aware of all the buttons and controls available to the operator and programmer
    3.  Add one or more Telemetry.Item variables and update those variables by changing that
        variable data using one or more of the gamepad controls.

Step by Step:
  Change the class name to something more meaningful
  Remember to keep the class name and file name consistent.
  Place the program in a directory of your choosing; don't create a mess in the TeamCode directory
  Download the code to the robot and run the program.
  Be sure to understand what the code is doing vis-a-vis the information being displayed on the
  robot controller
  Add your own Telemtry.Item variable(s)
    Declare it
    Initialize it
    Update it
    Display it
  Select a control in the if/else portion of the code and modify the information displayed
  by your Telemetry.Item variable.  Remember to set the state of your variable based on the control
  being active or not.
*/

package org.firstinspires.ftc.teamcode.Tutorials.Telemetry.Solutions;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.concurrent.ThreadLocalRandom;

@TeleOp(name = "Tutorial 3: Gamepad Basics", group="Tutorials")
@Disabled
/* This class provides an introduction on:
  - Creating a teleoperated (driver controlled) program for the FTC robot by creating a class
  which *extends* LinearOpMode
  - Introduces the use of formatted Telemetry output using the Telemetry object via the
  inherited *telemetry* variable
*/
public class Tutorial_3_Gamepad_Basics extends LinearOpMode {
    // Create variables and initialize variables for use by the Telemetry object
    Telemetry.Item motorStatus = telemetry.addData("motor status", 0);
    Telemetry.Item programStatus = telemetry.addData("Status", "Initialized");



    @Override
    public void runOpMode() {
        // Do NOT erase the display between telemetry refreshes
        telemetry.setAutoClear(false);
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            programStatus.setValue("Running at " + System.currentTimeMillis());
            motorStatus.setValue(getBoundedRandomInt(-5,5));
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
