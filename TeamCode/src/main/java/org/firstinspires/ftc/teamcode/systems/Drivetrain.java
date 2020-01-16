package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain {

    public static DcMotor rightFront;
    public static DcMotor rightBack;
    public static DcMotor leftBack;
    public static DcMotor leftFront;

    public double speed = 1.0;

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

    public static void setIdenticalPowers(double p) {
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
        if (gamepad.a == true) speed = 0.4;
        if (gamepad.b == true) speed = 0.6;
        if (gamepad.y == true) speed = 0.8;
        if (gamepad.x == true) speed = 1.0;

        if (gamepad.left_stick_x != 0 || gamepad.left_stick_y != 0) {
            Double x = gamepad.left_stick_x * speed;
            Double y = -gamepad.left_stick_y * speed;
            setDifferentPowers(
                    + x - y,
                    - x - y,
                    - x + y,
                    + x + y
            );
        }

        if (gamepad.right_stick_x != 0) {
            setIdenticalPowers(speed * gamepad.right_stick_x);
        }

        setIdenticalPowers(0.0);
    }

    public static class Autodrivetrain {

        public final double diameter = 10.0;
        public final double wheelCircumference = diameter * Math.PI;
        public final double ticksPerRotation = 1120.0;
        public final double gearRatio = 1.5 / 1.0;
        public final double scaleFactor = 1.0;
        public final double ticksPerCentimeter = (ticksPerRotation * scaleFactor) / (gearRatio * wheelCircumference);

        public void runToPosition() {
            rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }

        public boolean motorsBusy() {
            if (rightFront.isBusy() && rightBack.isBusy() && leftBack.isBusy() && leftFront.isBusy()) {
                return true;
            } else {
                return false;
            }
        }

        public void stop(){
            rightFront.setPower(0);
            rightBack.setPower(0);
            leftFront.setPower(0);
            leftBack.setPower(0);
        }

        public void move(double centimeters, double power){
            double ticks = centimeters * ticksPerCentimeter;

            rightFront.setTargetPosition((int) (rightFront.getCurrentPosition() - ticks));
            rightBack.setTargetPosition((int) (rightBack.getCurrentPosition() - ticks));
            leftBack.setTargetPosition((int) (leftBack.getCurrentPosition() + ticks));
            leftFront.setTargetPosition((int) (leftFront.getCurrentPosition() + ticks));

            runToPosition();

            setIdenticalPowers(power);

            while (motorsBusy()) {

            }

//            setIdenticalPowers(0);
            stop();

            return;
        }

        public void strafe(double centimeters, double power) {
            double ticks = centimeters * ticksPerCentimeter;

            rightFront.setTargetPosition((int) (rightFront.getCurrentPosition() + ticks));
            rightBack.setTargetPosition((int) (rightBack.getCurrentPosition() - ticks));
            leftBack.setTargetPosition((int) (leftBack.getCurrentPosition() - ticks));
            leftFront.setTargetPosition((int) (leftFront.getCurrentPosition() + ticks));

            runToPosition();

            setIdenticalPowers(power);

            while (motorsBusy()) {

            }

//            setIdenticalPowers(0);
            stop();

            return;
        }

        public void rotate(double centimeters, double power) {
            double ticks = centimeters * ticksPerCentimeter;

            rightFront.setTargetPosition((int) (rightFront.getCurrentPosition() + ticks));
            rightBack.setTargetPosition((int) (rightBack.getCurrentPosition() + ticks));
            leftBack.setTargetPosition((int) (leftBack.getCurrentPosition() + ticks));
            leftFront.setTargetPosition((int) (leftFront.getCurrentPosition() + ticks));

            runToPosition();

            setIdenticalPowers(power);

            while (motorsBusy()) {

            }

//            setIdenticalPowers(0);
            stop();

            return;
        }
    }
}
