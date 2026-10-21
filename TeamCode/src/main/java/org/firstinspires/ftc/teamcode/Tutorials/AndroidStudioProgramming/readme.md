Open the Android Studio Programming Tutorial web page from FTC Docs at 
 
https://ftc-docs.firstinspires.org/en/latest/programming_resources/android_studio_java/Android-Studio-Tutorial.html

This tutorial covers more than is really needed to start writing your first OpMode in Android 
Studio. At this point, the following steps covered in the tutorial should already have been 
completed:
    Android Studio has been installed and configured on your laptop.
    Git has been installed and configured in Android Studio.
    The MDSArobotics/FtcRobotController repository has been cloned.
    The hardware needed for the tutorial has been configured in a Sailbots programming kit:
*        REV control hub (with built-in IMU as "imu")
*        12V battery and power switch
*        goBILDA 312RPM DC motor as "motorTest"
*        REV Smart Servo as "servoTest"
*        REV Color distance sensor as "sensorColorRange"
*        REV Touch sensor as "digitalTouch"
*        Web camera (for use with future tutorials)
*        REV driver station
*        REV PS4 gamepad

To begin the tutorial, skip directly to the "Writing an Op Mode" section in the tutorial document 
and start at "Creating and Running an OpMode." Follow these instructions to write your first Java 
OpMode and control a DC motor.  Continue with "Controlling a Servo" and finish with "Using Sensors."

To begin coding, right-click on the Tutorials.AndroidStudioProgramming package, and select 
"New" at the top of the pop-up menu, then select "Java Class" to create your class file. 
Choose a unique name for your class file instead of calling it "MyFirstJavaOpMode" as shown in 
the tutorial instructions.  Answer yes to the pop-up question asking if you want to add the new 
class file to Git. This is the first step to adding your code to the team's software repository.

Your new class file will be added to the tutorial package and opened in the editor window. You will 
continue to use the same class file as you add more code to control a motor, servo, and sensors.  
The solution package includes a sequence of files with the accumulated code at each step of the 
tutorial for reference.

Note that Android Studio will automatically save your changes as you work, however, these changes 
are only saved locally on your computer. You should also make it a practice to commit your 
changes (Ctrl+K) and push them back to the software repository (Ctrl+Shift+K) at the end of each 
programming session. This both protects your code and allows for sharing with other developers. 
At the beginning of each programming session, you should also perform a project update (Ctrl+T) 
to make sure that you're working with the latest version of code.

Future Sailbot tutorial modules will add the web camera for robot vision, the Inertial Measurement 
Unit (IMU) for measuring the robot's orientation and movement, and other more advanced programming 
topics.
