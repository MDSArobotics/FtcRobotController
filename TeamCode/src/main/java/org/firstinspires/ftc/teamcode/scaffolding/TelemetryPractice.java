package org.firstinspires.ftc.teamcode.scaffolding;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.concurrent.ThreadLocalRandom;

public class TelemetryPractice extends LinearOpMode {


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
