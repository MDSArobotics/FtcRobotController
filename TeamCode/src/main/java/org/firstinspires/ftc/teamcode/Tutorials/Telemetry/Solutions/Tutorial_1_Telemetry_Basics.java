package org.firstinspires.ftc.teamcode.Tutorials.Telemetry.Solutions;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.concurrent.ThreadLocalRandom;

@TeleOp(name = "Tutorial 1: Telemetry Basics", group="Tutorials")
@Disabled
public class Tutorial_1_Telemetry_Basics extends LinearOpMode {
/* This Class provides an introduction on;
    - Creating a teleoperated (driver controlled) program for the FTC robot by
        creating a class which *extends* Linear OpMode
    - Introduces the use of formatted messages via the Telemetry object using the
        built-in *telemetry* variable inherited from the *extends LinearOpMode* syntax
 */

    // Create and initialize variables for use by the Telemetry object
    Telemetry.Item rightMotorStatus = telemetry.addData("right motor",0);
    Telemetry.Item leftMotorStatus = telemetry.addData("left motor",0);
    Telemetry.Item timeStatus = telemetry.addData("time",System.currentTimeMillis());

    @Override
    public void runOpMode() throws InterruptedException {
        long now = System.currentTimeMillis();

        telemetry.setAutoClear(false);
        telemetry.update();

        //Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()){
            now = System.currentTimeMillis();
            timeStatus.setValue(now);

            if (now%2 == 0){
                rightMotorStatus.setValue(8);
                leftMotorStatus.setValue(6);
            }
            else {
                rightMotorStatus.setValue(9);
                leftMotorStatus.setValue(13);
            }
            telemetry.update();
            sleep (ThreadLocalRandom.current().nextInt(200,1000));
        }

    }
}
