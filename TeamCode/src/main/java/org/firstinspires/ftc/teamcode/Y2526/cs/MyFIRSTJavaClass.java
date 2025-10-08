package org.firstinspires.ftc.teamcode.Y2526.cs;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name = "Cailin hearts" )
public class MyFIRSTJavaClass extends LinearOpMode {


    @Override
    public void runOpMode() {

        for (int loopCount = 0; loopCount<5; loopCount++) {


            telemetry.addData("Loop count",loopCount);
            telemetry.update();
            sleep(1000);
        }
    }


}

