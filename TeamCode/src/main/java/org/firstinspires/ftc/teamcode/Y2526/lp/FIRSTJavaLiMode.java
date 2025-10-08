package org.firstinspires.ftc.teamcode.Y2526.lp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name = "Joslin rules")
public class FIRSTJavaLiMode extends LinearOpMode {

    @Override
  /*  public void runOpMode() {

        telemetry.addData("hello sudyjgytgvdu", 0);
        telemetry.update();
        sleep(5000);
    }*/

    public void runOpMode() {

        for (int loopcount = 0; loopcount < 8; loopcount++) {

            telemetry.addData("AHHHHHHHH", loopcount);
            telemetry.update();
            sleep(5000);
        }
    }
}
