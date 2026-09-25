package org.firstinspires.ftc.teamcode.Y2627;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Shooter Auto", group="Start Position")

public class ShootingAuto extends LinearOpMode {

    //declare motors and servos here - NOT DONE
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;

    //declare motor measurement here - NOT DONE

    @Override
    public void runOpMode(){
        //set motor behaviors here - NOT DONE
        waitForStart();
        while (opModeIsActive()){
            //          move
            //          turn
            //          align
            //          shoot
            //          move again to park MAYBE
        }
    }
    }

