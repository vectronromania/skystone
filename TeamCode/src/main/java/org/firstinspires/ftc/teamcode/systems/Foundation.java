package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Foundation {

    public Servo foundationServo1;
    public Servo foundationServo2;

    public void getHardwareMap(HardwareMap hardwareMap) {
        foundationServo1 = hardwareMap.get(Servo.class, "foundationServo1");
        foundationServo2 = hardwareMap.get(Servo.class, "foundationServo2");
    }

    public void setDirections() {
        foundationServo1.setDirection(Servo.Direction.FORWARD);
        foundationServo2.setDirection(Servo.Direction.FORWARD);
    }

    public void move(Gamepad gamepad) {
        if (gamepad.right_bumper) {
            foundationServo1.setPosition(0);
            foundationServo2.setPosition(0);
        } else if (gamepad.left_bumper) {
            foundationServo1.setPosition(1);
            foundationServo2.setPosition(1);
        }
    }
}
