package org.firstinspires.ftc.teamcode.Y2526.cs;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@Disabled
@TeleOp(name = "Cailin hearts" )
public class MyFIRSTJavaClass extends LinearOpMode {


    @Override
    public void runOpMode() {

        for (int loopCount = 0; loopCount<5; loopCount++) {


            telemetry.addData("Loop count",loopCount);
            telemetry.update();
            sleep(1000); {

                DcMotor leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
                DcMotor rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
                leftDrive.setDirection(DcMotor.Direction.REVERSE);
                rightDrive.setDirection(DcMotor.Direction.FORWARD);
            }
           
        }
    }


}

//hi