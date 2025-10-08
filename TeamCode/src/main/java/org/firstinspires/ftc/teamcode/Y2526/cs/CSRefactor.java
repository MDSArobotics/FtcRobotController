package org.firstinspires.ftc.teamcode.Y2526.cs;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name = "Cailin refactors" )
public class CSRefactor extends LinearOpMode {


    @Override
    public void runOpMode() {
        goStraight();
        turnRight();


    }

    public void goStraight() {
        telemetry.addData("goingStraight", 0);
        telemetry.update();
        sleep(1000);

    }

    public void turnRight() {
        telemetry.addData("turningRight", 0);
        telemetry.update();
        sleep(1000);
    }
}





