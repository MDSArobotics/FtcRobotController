package org.firstinspires.ftc.teamcode.Y2627;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Mover Auto", group="Start Position")
public class MoveOnlyAuto extends LinearOpMode {

    //declare motors and servos here - NOT DONE
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;

    //declare motor measurement here - NOT DONE
    private final ElapsedTime runtime = new ElapsedTime();

    static final double wheelDiameter = 96.0; //millimeters
    static final double driveSpeed = 0.6;
    static final double CPR = 288; //tentative, I don't know what this actually is
    static final double CPI = CPR/(wheelDiameter*Math.PI);

    @Override
    public void runOpMode(){

        leftMotor  = hardwareMap.get(DcMotor.class, "left_drive");
        rightMotor = hardwareMap.get(DcMotor.class, "right_drive");

        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();
        telemetry.addData("Starting code",0);
        telemetry.update();
        while (opModeIsActive()){
            telemetry.addData("Running code",0);
            telemetry.update();

            drive(driveSpeed,2500,2500); //hypothetically moves forward but we'll have to wait to find out
            //          turn slightly if needed
            //          park

            break; //ends the program
        }
    }
    //takes speed variable, left and right in millimeters, to make the robot turn, make the way you want to turn a lower value
    public void drive(double speed, double left, double right){

        int newLeftTarget = leftMotor.getCurrentPosition() + (int)(left * CPI);
        int newRightTarget = rightMotor.getCurrentPosition() + (int)(right * CPI);
        leftMotor.setTargetPosition(newLeftTarget);
        rightMotor.setTargetPosition(newRightTarget);

        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        runtime.reset();
        leftMotor.setPower(Math.abs(speed));
        rightMotor.setPower(Math.abs(speed));

        leftMotor.setPower(0);
        rightMotor.setPower(0);

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        sleep(250);

    }
}
