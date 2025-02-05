package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;



@Autonomous(name="New Auto", group="Robot")
public class NewAuto extends LinearOpMode {
    private DcMotor rightMotor = null;
    private DcMotor leftMotor = null;
    //private DcMotor armMotor = null;


    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        rightMotor = hardwareMap.get(DcMotor.class, "right_drive");
        leftMotor = hardwareMap.get(DcMotor.class, "left_drive");
        // armMotor = hardwareMap.get(DcMotor.class,"arm");


    }

    private double currX;
    private double currY;

    // when set it collects current x and y which is soon to be determined
    public void curr(double currX, double currY)
    {
        this.currX = currX;
        this.currY = currY;

    }

    boolean isMovable = true;


    // when set it collects new coords wanting to input
    // now thinking abt this
    // it feels rlly pointless and might take out later
    // can just set vars in methods when needed
    // public void newCoords(int newX, int newY)
    // {
    //     newX += currX;
    //     newY += currY;

    // }

    // sets the new current x pos when called
    public void currX(int newX)
    {
        int leftCurrPos = (int)(currX += newX);
        int rightCurrPos = (int)(currX += newX);
    }

    // sets the new current x pos when called
    public void currY(int newY)
    {
        int leftCurrPos = (int) (currY += newY);
        int rightCurrPos = (int)(currY += newY);
    }

    // moves either forwards or backwards based on the current pos of the robot
    // compared to the new input of coords requested to move
    public void moveX(int newX)
    {
        if(isMovable)
        {
            if (newX < currX)
            {
                moveBackwards(newX);
            }

            else if (newX > currX)
            {
                moveForward(newX);
            }

            else
            {
                stop();
            }
        }
        else
        {
            stop();
        }
    }

    private void stop() {
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }

    private void moveForward(int newX) {
        leftMotor.setTargetPosition((int) Math.abs(newX -currX));
        rightMotor.setTargetPosition((int) Math.abs(newX -currX));

        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        rightMotor.setDirection(DcMotor.Direction.FORWARD);
        int leftCurrPos = (int)(currX += newX);
        int rightCurrPos = (int)(currX += newX);
        isMovable = false;
    }

    private void moveBackwards(int newX) {
        leftMotor.setTargetPosition((int) Math.abs(newX -currX));
        rightMotor.setTargetPosition((int) Math.abs(newX -currX));

        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        int leftCurrPos = (int) (currX -= newX);
        int rightCurrPos = (int) (currX -= newX);
        isMovable = false;
    }

    // moves either forwards or backwards based on the current pos of the robot
    // compared to the new input of coords requested to move
    public void moveY(int newY)
    {
        if(isMovable)
        {
            if (newY < currY)
            {
                leftMotor.setTargetPosition((int) Math.abs(newY-currY));
                rightMotor.setTargetPosition((int) Math.abs(newY-currY));

                leftMotor.setDirection(DcMotor.Direction.FORWARD);
                rightMotor.setDirection(DcMotor.Direction.REVERSE);
                isMovable = false;
            }

            else if (newY > currY)
            {
                leftMotor.setTargetPosition((int) Math.abs(newY-currY));
                rightMotor.setTargetPosition((int) Math.abs(newY-currY));

                leftMotor.setDirection(DcMotor.Direction.REVERSE);
                rightMotor.setDirection(DcMotor.Direction.FORWARD);
                isMovable = false;
            }

            else
            {
                stop();
            }
        }
        else
        {
            stop();
        }

    }

    // sets the right turn (soon to be decided the correct amount for it)
    // same will be made for left turn
    // see if we can get degree based sensors on robot for easy turning
    public void rightTurn(int turn)
    {
        if(!isMovable)
        {
            leftMotor.setDirection(DcMotor.Direction.REVERSE);
            rightMotor.setDirection(DcMotor.Direction.REVERSE);

            leftMotor.setTargetPosition(turn);
            rightMotor.setTargetPosition(turn);
        }

    }

    public void leftTurn(int turn)
    {
        if(!isMovable)
        {
            leftMotor.setDirection(DcMotor.Direction.FORWARD);
            rightMotor.setDirection(DcMotor.Direction.FORWARD);

            leftMotor.setTargetPosition(turn);
            rightMotor.setTargetPosition(turn);
        }

    }
}

