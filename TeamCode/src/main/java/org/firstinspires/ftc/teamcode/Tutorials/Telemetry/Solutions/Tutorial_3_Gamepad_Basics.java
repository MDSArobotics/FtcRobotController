package org.firstinspires.ftc.teamcode.Tutorials.Telemetry.Solutions;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.concurrent.ThreadLocalRandom;

@TeleOp(name = "Tutorial 3: Gamepad Basics", group="Tutorials")
@Disabled
public class Tutorial_3_Gamepad_Basics extends LinearOpMode {
/* This Class provides an introduction on;
    - Creating a teleoperated (driver controlled) program for the FTC robot by
        creating a class which *extends* Linear OpMode.
    - Introduces the use of formatted messages using the Telemetry object via the
        inherited *telemetry* variable.
 */
    // Create and initialize variables for use by the Telemetry object
    Telemetry.Item rightMotorStatus = telemetry.addData("right motor status",0);
    Telemetry.Item leftMotorStatus = telemetry.addData("left motor status",0);
    Telemetry.Item programStatus = telemetry.addData("Status","Initialized");

    @Override
    public void runOpMode() {
        // Do NOT erase the display between telemetry refreshes
        telemetry.setAutoClear(false);
        telemetry.update();

        //Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            programStatus.setValue("Running at " + System.currentTimeMillis());
            rightMotorStatus.setValue(getBoundedRandomInt(-5,5));
            leftMotorStatus.setValue(getBoundedRandomInt(-5,5));
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
                return 0.0 when at rest.
                    Joysticks: left_stick_y, left_stick_x, right_stick_x, right_stick_y
                    Triggers: left_trigger, right_trigger
             */

            //  X, Y, A, and B buttons.
            if (gamepad1.a == true){
                // Do something
            }
            else{
                // Do something else
            }if (gamepad1.b){ // same as (gamepad1.b == true)

            }
            else{
            }
            if (gamepad1.x){

            }
            else{

            }
            if (gamepad1.y){

            }
            else{

            }

            if(gamepad1.atRest()){
                // Nothing happening here
            }

            telemetry.update();
        }
    }
    private int getBoundedRandomInt(int minInclusive, int maxInclusive) {
        return ThreadLocalRandom.current().nextInt(minInclusive, maxInclusive + 1);
    }
}
