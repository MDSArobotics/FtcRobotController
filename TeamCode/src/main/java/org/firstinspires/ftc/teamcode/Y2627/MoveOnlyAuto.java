package org.firstinspires.ftc.teamcode.Y2627;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Mover Auto", group="Start Position")
public class MoveOnlyAuto extends LinearOpMode {

    //declare motors and servos here - NOT DONE
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;

    //declare motor measurement here - NOT DONE
    @Override
    public void runOpMode(){
        //set motor behaviors here
        waitForStart();
        while (opModeIsActive()){
            //          move forward
            //          turn slightly if needed
            //          park
        }
    }
}
