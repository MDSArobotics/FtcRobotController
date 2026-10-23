package org.firstinspires.ftc.teamcode.Y2627;

import com.qualcomm.robotcore.hardware.DcMotor;

public class DiyaPID {

    public final static double errorTolerance = Math.toRadians(5);
    public final static double wheelRadius = 48.0;
    public double KP;
    public double KI;
    public double KD;

    public DiyaPID(double KP, double KI, double KD){
        this.KP = KP;
        this.KI = KI;
        this.KD = KD;
    }

    public void move(DcMotor left, DcMotor right, double goal, double radius){

        goal /= radius;
        double leftPosition = Math.toRadians(left.getCurrentPosition());
        goal += leftPosition;

        double error;

        do {

            leftPosition = Math.toRadians(left.getCurrentPosition());
            error = goal - leftPosition;
            double pOutput = error * KP;
            left.setPower(pOutput);
            right.setPower(pOutput);

        } while(Math.abs(error) < errorTolerance);

        left.setPower(0);
        right.setPower(0);

    }

}
