package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {

    public Servo armServo;

    public void getHardwareMap(HardwareMap hardwareMap) {
        armServo = hardwareMap.get(Servo.class, "armServo");
    }

    public void setDirection() {
        armServo.setDirection(Servo.Direction.FORWARD);
    }

    public void up() {
        armServo.setPosition(0);
    }

    public void down() {
        armServo.setPosition(1);
    }

}