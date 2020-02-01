package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Foundation {

    public CRServo foundationServo;

    public void getHardwareMap(HardwareMap hardwareMap) {
        foundationServo = hardwareMap.get(CRServo.class, "foundationServo");
    }

    public void setDirection() {
        foundationServo.setDirection(CRServo.Direction.FORWARD);
    }

    public void up() {
        foundationServo.setPower(-1);
    }

    public void down() {
        foundationServo.setPower(1);
    }

    public void stop() {
        foundationServo.setPower(0);
    }

    public void drive(Gamepad gamepad) {
        if (gamepad.right_bumper) {
            down();
        } else if (gamepad.left_bumper) {
            up();
        } else {
            stop();
        }
    }
}