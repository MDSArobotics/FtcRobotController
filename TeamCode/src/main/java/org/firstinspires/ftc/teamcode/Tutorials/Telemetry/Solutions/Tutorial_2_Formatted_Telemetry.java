/* Tutorial 2 Formatted Telemetry Goals:
    1.  Gain a greater understanding of how to use the Telemetry class to provide
        formatted meaningful information to the operator of the robot
    2.  Understand how to declare/initialize/update/display variables of type Telemetry.Item
    3.  Understand why "telemetry.setAutoClear(false)" is needed and what it does.
    4.  Introduce local methods (getBoundedRandomInt) and how to use them.

Step by Step:
      Change the class name to something more meaningful
      Remember to keep the class name and file name consistent.
      Place the program in a directory of your choosing; don't create a mess in the TeamCode directory
      As you're retyping the program, use Android Studio code completion to import necessary
      libraries, change file names, and resolve errors as necessary.
      Download the code to the robot and run the program.
      Be sure to understand what the code is doing vis-a-vis the information being displayed on the
      robot controller
      Add your own Telemtry.Item variable
        Declare it
        Initialize it
        Update it
        Display it

Notes:
    This class provides an introduction on:
    - Creating a teleoperated (driver controlled) program for the FTC robot by creating a class
    which *extends* LinearOpMode
    - Introduces the use of messages via the Telemetry object using the built-in *telemetry*
    variable inherited from the *extends LinearOpMode* syntax
 */
package org.firstinspires.ftc.teamcode.Tutorials.Telemetry.Solutions;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.concurrent.ThreadLocalRandom;

@TeleOp(name = "Tutorial 2: Formatted Telemetry", group="Tutorials")
@Disabled
public class Tutorial_2_Formatted_Telemetry extends LinearOpMode {
    // Create variables for use by the Telemetry object
    // Initialize those variables.
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

        }
    }

    private int getBoundedRandomInt(int minInclusive, int maxInclusive) {
        return ThreadLocalRandom.current().nextInt(minInclusive, maxInclusive + 1);
    }
}


