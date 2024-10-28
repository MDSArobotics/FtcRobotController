# FAQ

[Connecting Driver Hub to Controller Hub](#connecting-driver-hub-to-controller-hub)

[Robot Device Map](#robot-device-map)

***

## Connecting Driver Hub to Controller Hub

- Plug battery into robot controller and power up the robot controller.
- Power *Driver Hub* on
- Go to *FTC Driver Status*

* Press the "three dots" icon
- Settings
  - Pair with Robot Controller
    - Wi-Fi Settings
      - FTC-1n36 (password is password)


***
## Robot Device Map
| Class   | Device | Device Name | Port | Purpose                 |
|---------|----|-------------|------|-------------------------|
| DcMotor | GoBILDA5202/3/4 series | left_drive  | 1    | Left side drive wheel   |
| DcMotor | GoBILDA5202/3/4 series | right_drive | 2    | Right side drive wheel |
| DcMotor | | arm_motor   | 3    | Arm motor               |
| CrServo | | sweeper     | 4    | Sweeper actuator        |
| Servo   | | wrist       | 5    | Wrist motion controller |
| Servo   | | hand        | 6    | Hand  motion controller |



