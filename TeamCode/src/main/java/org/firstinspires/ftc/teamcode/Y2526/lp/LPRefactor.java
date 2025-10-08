package org.firstinspires.ftc.teamcode.Y2526.lp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name = "Li refactor")
public class LPRefactor extends LinearOpMode {

    @Override
    public void runOpMode() {
        goStraight();
        turnRight();

    }
    public void goStraight(){
        telemetry.addData("GO GO GOING STRAIGHT",1);
        telemetry.update();
        sleep(500);
    }
    public void turnRight(){
        telemetry.addData("TURN TURN TURNING RIGHTS",1);
        telemetry.update();
        sleep(800);
    }
}
