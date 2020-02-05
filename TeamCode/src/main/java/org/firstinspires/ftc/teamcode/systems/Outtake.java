package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Outtake {

    public Servo outtakeServo;
    public DcMotor outtakemotor;

    public void getHardwareMap(HardwareMap hardwareMap) {
        outtakeServo = hardwareMap.get(Servo.class, "outtakeServo");
        outtakemotor = hardwareMap.get(DcMotor.class, "outtakemotor");
    }

    public void setDirection(){
//        outtakeServo.setDirection(Servo.Direction.FORWARD);
        outtakemotor.setDirection(DcMotor.Direction.FORWARD);
    }

    public void take(){
        outtakeServo.setPosition(1);
    }

    public void release() {
        outtakeServo.setPosition(0);
    }

    public void out() {
        outtakemotor.setPower(0.5);
    }

    public void in() {
        outtakemotor.setPower(-0.5);
    }

    public void stop() {
        outtakemotor.setPower(0);
    }

    public void drive(Gamepad gamepad){
        if (gamepad.right_trigger == 1) {
            take();
        } else if (gamepad.left_trigger == 1){
            release();
        }

        if (gamepad.right_stick_y < 0) {
            out();
        } else if (gamepad.right_stick_y > 0) {
            in();
        } else {
            stop();
        }
    }
}