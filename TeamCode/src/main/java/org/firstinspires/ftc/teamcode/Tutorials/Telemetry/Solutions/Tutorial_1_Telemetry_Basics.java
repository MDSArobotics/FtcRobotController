/* Tutorial 1 Telemetry Basics Goals:
  1.  Understand the purpose of the "package" statement and how it relates to directory structure
  2.  Explain the "extends" keyword and behavior
  3.  What is the source of the "telemetry" variable?
  4.  What type of variable (class) is the "telemetry" object?
  5.  What's the difference between "telemetry" and "Telemetry" in this program?
  6.  What does "waitForStart" and "while (opModeIsActive())" do?
  7.  What purpose does the @Teleop annotation serve?
  8.  Explain what the "import" statement does.

Step by Step:
      DO NOT cut and paste the program. Retype it (it's short; you won't die)
      Change the class name from Tutorial1_Telemetry to something more meaningful
      Remember to keep the class name and file name consistent.
      Place the program in a directory of your choosing; don't create a mess in the TeamCode directory
      As you're retyping the program, use Android Studio code completion to import necessary
        libraries, change file names, and resolve errors as necessary.
      Download the code to the robot and run the program.
      Be sure to understand what the code is doing vis-a-vis the information being displayed on the
      robot controller.
Notes:
    This class provides an introduction on:
    - Creating a teleoperated (driver controlled) program for the FTC robot by creating a class
    which *extends* LinearOpMode
    - Intruduces the use of messages via the Telemetry object using the built-in *telemetry*
    variable inherited from the *extends LinearOpMode* syntax
 */
package org.firstinspires.ftc.teamcode.Tutorials.Telemetry.Solutions;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.concurrent.ThreadLocalRandom;

@TeleOp(name = "Tutorial 1: Telemetry Basics", group="Tutorials")
@Disabled
public class Tutorial_1_Telemetry_Basics extends LinearOpMode {

    //  What does @Override do?
    //  Is runOpMode mandatory?
    //  If so, why?
    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Initialized - waiting for operator to press start");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        long now = System.currentTimeMillis();
        telemetry.addData("Starting at ", now);
        telemetry.update();
        sleep(500);

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            now = System.currentTimeMillis();
            int naptime = ThreadLocalRandom.current().nextInt(200, 1000);

            telemetry.addData("Snooze ", "Sleeping for " + naptime + " milliseconds");
            telemetry.update();

            sleep(naptime);


        }
        telemetry.addData("End", "Program terminated by operator.");
    }
}


