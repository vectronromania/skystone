package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Foundation {

    public Servo foundationServo;

    public void getHardwareMap(HardwareMap hardwareMap) {
        foundationServo = hardwareMap.get(Servo.class, "foundationServo");
    }

    public void setDirection() {
        foundationServo.setDirection(Servo.Direction.FORWARD);
    }

    public void up() {
        foundationServo.setPosition(0);
    }

    public void down() {
        foundationServo.setPosition(1);
    }

    public void drive(Gamepad gamepad) {
        if (gamepad.right_bumper) {
            down();
        } else if (gamepad.left_bumper) {
            up();
        }
    }
}