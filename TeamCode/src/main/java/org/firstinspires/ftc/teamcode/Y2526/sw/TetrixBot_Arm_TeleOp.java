/*
 * This file contains a sample "TeleOp" Linear OpMode program intended for the TetrixDemoBot robot.
 * The robot consists of a basic two-motor POV drive chassis with two servos, two color sensors,
 * one touch sensor, and one 2M distance sensor.  The robot is intended to provide a test bed for
 * programming exercises and robot demonstrations. This OpMode follows programming examples and copies
 * some code directly from  the package org.firstinspires.ftc.robotcontroller.external.samples, namely
 *      BasicOpMode_Linear.java
 * To do: Color, distance, and touch sensors are declared but have no functionality.  Apply logic from
 *      SensorColor.java
 *      SensorREV2mDistance.java
 *      SensorDigitalTouch.java
 */

package org.firstinspires.ftc.teamcode.Y2526.sw;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TetrixBot_Arm_TeleOp")
@Disabled
public class TetrixBot_Arm_TeleOp extends LinearOpMode {

    // Motors
    final ElapsedTime runtime = new ElapsedTime();
    public DcMotor  leftDrive   = null; //the left drivetrain motor
    public DcMotor  rightDrive  = null; //the right drivetrain motor
    public DcMotor  armMotor    = null; //the arm motor
    public Servo    wrist       = null; //the wrist servo
    public Servo    gripper     = null; // gripper servo

    // Sensors
    /** The colorSensor field will contain a reference to our color sensor hardware object */
    //public NormalizedColorSensor colorSensorLeft = null;
    //public NormalizedColorSensor colorSensorRight = null;


    /* The COUNTS_PER_INCH constant is the number of encoder counts for each of inch of travel by the robot.
    The motors we use for this robot are TETRIX MAX TorqueNADOs which have a 60:1 gear ratio,
    delivering roughly 100 RPM and 700 oz-in. of stall torque at 12 volts.
    The motor encoder outputs 1440 pulses or counts per revolution of the motor shaft.
    The motors are driving the wheels directly with no external gearing.
     */

    static final double     COUNTS_PER_MOTOR_REV    = 1440 ;   // TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 1.0;     // No external drive gearing
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;    // For calculating circumference
    static final double     COUNTS_PER_INCH  = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double     DRIVE_SPEED             = 0.6;
    static final double     TURN_SPEED              = 0.5;

    /* The ARM_COUNTS_PER_DEGREE constant is the number of encoder counts for each degree of arm rotation.
    This value reflects both the internal gearing of the motor and the external gearing driving the arm.
     */
    static final double     ARM_GEAR_REDUCTION    = 1.5;     // 120T spur driven by 80T pinion gear.
    final double ARM_COUNTS_PER_DEGREE =  COUNTS_PER_MOTOR_REV * ARM_GEAR_REDUCTION  * 1/360.0;
    static final double     ARM_SPEED              = 0.5;


    /* These constants hold the position that the arm is commanded to run to.
    These are relative to where the arm was located when you start the OpMode. So make sure the
    arm is reset to collapsed inside the robot before you start the program.

    In these variables you'll see a number in degrees, multiplied by the ticks per degree of the arm.
    This results in the number of encoder ticks the arm needs to move in order to achieve the ideal
    set position of the arm.  */

    final double ARM_HOME  = 0.0;   // ARM starting position, about 6" above battery
    final double ARM_DOWN  = 10 * ARM_COUNTS_PER_DEGREE;  // About 1" above battery
    final double ARM_LEVEL = 80 * ARM_COUNTS_PER_DEGREE;  // Level with ground


    /* Variables to store the wrist and gripper positions. */
    final double WRIST_STRAIGHT   = 1.0;
    final double WRIST_BENT = 0.5;
    final double GRIPPER_CLOSED = 0;
    final double GRIPPER_OPEN = 90;

    /* A number in degrees that the triggers can adjust the arm position by */
    final double FUDGE_FACTOR = 15 * ARM_COUNTS_PER_DEGREE;

    /* Variables that are used to set the arm to a specific position */
    double armPosition = ARM_HOME;
    double armPositionFudgeFactor;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration step
        // (using the FTC Robot Controller app on the phone).

        // Get references to motor objects
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        armMotor   = hardwareMap.get(DcMotor.class, "arm");

        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        armMotor.setDirection(DcMotor.Direction.FORWARD);

        /* Setting zeroPowerBehavior to BRAKE enables a "brake mode". This causes the motor to slow down
        much faster when it is coasting. This creates a much more controllable drivetrain. As the robot
        stops much quicker. */

        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        /* Before starting the armMotor. We'll make sure the TargetPosition is set to 0.
        Then we'll set the RunMode to RUN_TO_POSITION. And we'll ask it to stop and reset encoder.
        If you do not have the encoder plugged into this motor, it will not run in this code. */
        armMotor.setTargetPosition(0);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        /* Define and initialize servos.*/
        wrist  = hardwareMap.get(Servo.class, "wrist");
        gripper  = hardwareMap.get(Servo.class, "gripper");

        /* The wrist is straight and the gripper is closed.*/
        wrist.setPosition(WRIST_STRAIGHT);
        gripper.setPosition(GRIPPER_CLOSED);

        // Get a references to  sensor objects.
        // It's recommended to use NormalizedColorSensor over ColorSensor, because NormalizedColorSensor
        // consistently gives values between 0 and 1, while the values you get from ColorSensor are
        // dependent on the specific sensor you're using.
        //colorSensorLeft = hardwareMap.get(NormalizedColorSensor.class, "sensor_color_left");
        //colorSensorRight = hardwareMap.get(NormalizedColorSensor.class, "sensor_color_right");
        // To do: Add functionality to the color sensors

        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Set up a variable for each drive wheel to save power level for telemetry
            double leftPower;
            double rightPower;

            // Drive the bot in "Point of View" POV Mode versus tank drive
            // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.
            double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

            // Send calculated power to wheels
            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);

            // Press left trigger to run the CR servos to move the artifact towards the flywheel
            // Press the right bumper to move the gate servo forward to push artifact into flywheel and launch
            // Press the left bumper to move the gate servo back to original position

            if(gamepad1.right_bumper){
                moveArm(ARM_DOWN);
            }
            else if (gamepad1.left_bumper){
                moveArm(ARM_LEVEL);
            }

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Drive Motors Power", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
    public void  moveArm(double position){
        double armPower = 0.5;
        armMotor.setTargetPosition((int) position);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setPower(armPower);
    }
}


