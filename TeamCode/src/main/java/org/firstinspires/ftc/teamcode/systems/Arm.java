package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class Arm {

    public Servo armServo;
    public Servo catchServo;

    public void getHardwareMap(HardwareMap hardwareMap) {
        armServo = hardwareMap.get(Servo.class,  "armServo");
        catchServo = hardwareMap.get(Servo.class, "catchServo");
    }

    public void setDirection() {
        armServo.setDirection(Servo.Direction.FORWARD);
        catchServo.setDirection(Servo.Direction.FORWARD);
    }

    public void up() {
        armServo.setPosition(1);
    }

    public void down() {
        armServo.setPosition(0);
    }

    public void take() {
        catchServo.setPosition(1);
    }

    public void release() {
        catchServo.setPosition(0);
    }
}