package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Outtake {

    public Servo catchServo;
    public Servo rotationServo;

    public void getHardwareMap(HardwareMap hardwareMap){
        catchServo = hardwareMap.get(Servo.class, "catchServo");
        rotationServo = hardwareMap.get(Servo.class, "rotationServo");
    }

    public void setDirection(){
        catchServo.setDirection(Servo.Direction.FORWARD);
        rotationServo.setDirection(Servo.Direction.FORWARD);
    }

    public void take(){
        catchServo.setPosition(1);
    }

    public void release() {
        catchServo.setPosition(0);
    }

    public void left() {
        rotationServo.setPosition(1);
    }

    public void right() {
        rotationServo.setPosition(0);
    }

    public void drive(Gamepad gamepad){
        if(gamepad.dpad_up){
            take();
        } else if (gamepad.dpad_down) {
            release();
        }

        if (gamepad.dpad_right) {
            right();
        } else if (gamepad.dpad_left) {
            left();
        }
    }
}
