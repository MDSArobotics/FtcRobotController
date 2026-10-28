Open the Android Studio Programming Tutorial web page from FTC Docs at 
 
https://ftc-docs.firstinspires.org/en/latest/programming_resources/android_studio_java/Android-Studio-Tutorial.html

The tutorial objectives are to
*     Create a new Java class file in Android Studio
*     Write a simple OpMode program that
*       Accepts user input from a gamepad
*       Controls a motor
*       Controls a servo
*       Reads input from a touch sensor
*       reads input from a color/distance sensor
*       sends text (telemetry) to the user's driver station
*     Save code (commit and push) to the team's GitHub software repository
*     Build code and download to the robot

The tutorial instructions cover more than is really needed to start writing your first OpMode in 
Android Studio. At this point, the following steps should already have been completed and may be 
skipped in the instructions:
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
"New" at the top of the pop-up menu, then select "Java Class" with the "Class" option highlighted 
to create your class file. Choose a unique name for your class file instead of calling it 
"MyFirstJavaOpMode" as shown in the tutorial instructions.  Answer yes to the pop-up question asking 
if you want to add the new class file to Git. This is the first step to adding your code to the 
team's software repository.

Your new class file will be added to the tutorial package and opened in the editor window. You will 
continue to use the same class file as you add more code to control a motor, servo, and sensors. 

The initial version of the JavaOpMode in the tutorial creates five private member variables for
hardware right from the start and assigns values to them using the hardwareMap method, even though 
they will not be used until later.  It would be better practice to add these only when needed, 
e.g. only declare the servo when you plan to add code for controlling the servo.  Otherwise, the 
code is cluttered with unused references and becomes confusing. The solution package includes a 
sequence of files with the accumulated code at each step of the tutorial for reference.

To save your code, upload it to the team's software repository.  
Note that Android Studio will automatically save your changes as you work, however, these changes 
are only saved locally on your computer.   Follow these simple steps to protect your code and allow 
sharing with other developers.

At the beginning of each programming session, you should perform a project update (Ctrl+T) to make 
sure that you're working with the latest version of code and avoid build problems.

At the end of each programming session, commit your changes (Ctrl+K) and push them back to the 
software repository (Ctrl+Shift+K).   Android Studio and Git require that you add a comment when 
you perform the commit action.  Take the time to write a short but meaningful comment that lists 
changes that you made. This should be a high-level statement of only a sentence or two. 
