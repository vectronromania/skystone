package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain {

    public DcMotor rightFront;
    public DcMotor rightBack;
    public DcMotor leftBack;
    public DcMotor leftFront;

    public void getHardwareMap(HardwareMap hardwareMap) {
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
    }

    public void setDirections() {
        rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.FORWARD);
        leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void setIdenticalPowers(double p) {
        rightFront.setPower(p);
        rightBack.setPower(p);
        leftBack.setPower(p);
        leftFront.setPower(p);
    }

    public void setDifferentPowers(double a, double b, double c, double d) {
        rightFront.setPower(a);
        rightBack.setPower(b);
        leftBack.setPower(c);
        leftFront.setPower(d);
    }

    public void drive(Gamepad gamepad) {
        double powerMultiplier = 1.0;

        if (gamepad.a == true) powerMultiplier = 0.25;
        if (gamepad.b == true) powerMultiplier = 0.5;
        if (gamepad.y == true) powerMultiplier = 0.75;
        if (gamepad.x == true) powerMultiplier = 1.0;

        if (gamepad.left_stick_x != 0 || gamepad.left_stick_y != 0) {
            double x = gamepad.left_stick_x * powerMultiplier;
            double y = -gamepad.left_stick_y * powerMultiplier;
            setDifferentPowers(
                    - x - y,
                    + x - y,
                    - x + y,
                    + x + y
            );
        }

        if (gamepad.right_stick_x != 0) {
            setIdenticalPowers(powerMultiplier * -gamepad.right_stick_x);
        }

        setIdenticalPowers(0.0);
    }
}
