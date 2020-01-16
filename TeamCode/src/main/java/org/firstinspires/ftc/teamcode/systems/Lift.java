package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Lift {

    public DcMotor liftMotor;

    public void getHardwareMap(HardwareMap hardwareMap) {
        liftMotor = hardwareMap.get(DcMotor.class, "liftMotor");
    }

    public void setDirection() {
        liftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void up() {
        liftMotor.setPower(-0.2);
    }

    public void down() {
        liftMotor.setPower(0.2);
    }

    public void stop() {
        liftMotor.setPower(0);
    }

    public void drive(Gamepad gamepad) {
        if (gamepad.left_stick_y < 0) {
            up();
        } else if (gamepad.left_stick_y > 0) {
            down();
        } else {
            stop();
        }
    }
}
