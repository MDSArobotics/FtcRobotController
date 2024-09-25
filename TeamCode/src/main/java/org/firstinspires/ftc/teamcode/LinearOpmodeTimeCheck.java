package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class to perform a minimal test of a LinerOpMode program providing telemetry.  Used to verify
 * the ability to download and execute code to the robot controller.
 */

@TeleOp(name = "Basic: Linear OpMode Time Check", group = "Linear OpMode")
//@Disabled
public class LinearOpmodeTimeCheck extends LinearOpMode {

    @Override
    public void runOpMode() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowString = sdf.format(new Date());

        telemetry.addData("At the tone, the time will be:", nowString);
        telemetry.addData("Say", "beep");
        telemetry.update();
        sleep(5000);

    }


}


