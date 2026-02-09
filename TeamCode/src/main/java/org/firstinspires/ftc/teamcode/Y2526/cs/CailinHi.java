package org.firstinspires.ftc.teamcode.Y2526.cs;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="NataliOp", group="Cailautonomous")
public class CailinHi extends LinearOpMode {

    @Override
    public void runOpMode() {
        // You can add telemetry before waitForStart() to show initialization status
        telemetry.addData("HIIIII", "Te Cailin Op");
        telemetry.update(); // Necessary to send the data to the Driver Station

        waitForStart();

        // The OpMode is now active (after pressing Play)
        while (opModeIsActive()) {
            // Add the "Hello World" message and any other data
            telemetry.addData("Message", "LONG LIVE THE LI NATALIA WAR");
            telemetry.addData("chicken", "The ramp that desire doesn't know");
            telemetry.update(); // Update the display with new data
            sleep(10000);

            // Optional: add a sleep or other robot logic here
        }
    }
}
