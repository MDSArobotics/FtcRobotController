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

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TetrixDemoBot_TeleOp")
public class TetrixDemoBot_TeleOp extends LinearOpMode {

    // Motors
    final ElapsedTime runtime = new ElapsedTime();
    public DcMotor  leftDrive   = null; //the left drivetrain motor
    public DcMotor  rightDrive  = null; //the right drivetrain motor
    public DcMotor  launchMotor = null; //the flywheel motor

    // Servos
    public CRServo CR_servoLeft = null; //left CR servo pushes artifact towards flywheel
    public CRServo CR_servoRight = null; //right CR servo pushes artifact towards flywheel
    public Servo servoGate = null; //the gate servo pushes artifact into flywheel

    // Sensors
    /** The colorSensor field will contain a reference to our color sensor hardware object */
    //public NormalizedColorSensor colorSensorLeft = null;
    //public NormalizedColorSensor colorSensorRight = null;
    //public DistanceSensor sensorDistance = null;
    //public TouchSensor sensorTouch = null;

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
        launchMotor = hardwareMap.get(DcMotor.class, "launch");

        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        // Get references to servo objects.
        CR_servoRight = hardwareMap.get(CRServo.class, "CR_servo_right");
        CR_servoLeft = hardwareMap.get(CRServo.class, "CR_servo_left");
        servoGate = hardwareMap.get(Servo.class, "servo_left");

        // Get a references to  sensor objects.
        // It's recommended to use NormalizedColorSensor over ColorSensor, because NormalizedColorSensor
        // consistently gives values between 0 and 1, while the values you get from ColorSensor are
        // dependent on the specific sensor you're using.
        //colorSensorLeft = hardwareMap.get(NormalizedColorSensor.class, "sensor_color_left");
        //colorSensorRight = hardwareMap.get(NormalizedColorSensor.class, "sensor_color_right");
        //sensorDistance = hardwareMap.get(DistanceSensor.class, "sensor_distance");
        //sensorTouch = hardwareMap.get(TouchSensor.class, "sensor_touch");
        // To do: Add functionality to the color and distance sensors

        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Setup a variable for each drive wheel to save power level for telemetry
            double leftPower;
            double rightPower;
            double launchPower;
            double CR_servoPower;

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

            // Press right trigger to run flywheel launch motor forward at full speed (power = +1.0)
            // Press left trigger to run the CR servos to move the artifact towards the flywheel
            // Press the right bumper to move the gate servo forward to push artifact into flywheel and launch
            // Press the left bumper to move the gate servo back to original position


            if(gamepad1.left_bumper){
                servoGate.setPosition(0);
            }
            if(gamepad1.right_bumper){
                servoGate.setPosition(1);
            }

            launchPower = gamepad1.right_trigger;
            launchMotor.setPower(launchPower);

            CR_servoPower = gamepad1.left_trigger;
            CR_servoLeft.setPower(CR_servoPower);
            CR_servoRight.setPower(CR_servoPower);

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Drive Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.addData("Launch Motor",  "%.2f", launchPower);
            telemetry.update();
        }
    }
}
