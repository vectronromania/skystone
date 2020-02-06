package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Drivetrain {

    private static DcMotor rightFront;
    private static DcMotor rightBack;
    private static DcMotor leftBack;
    private static DcMotor leftFront;

    private double speed = 1.0;

    public void showPower(Telemetry telemetry) {
        telemetry.addData("RF", rightFront.getPower());
        telemetry.addData("RF", rightBack.getPower());
        telemetry.addData("RF", leftBack.getPower());
        telemetry.addData("RF", leftFront.getPower());
        telemetry.update();
    }

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

    private static void setIdenticalPowers(double p) {
        rightFront.setPower(p);
        rightBack.setPower(p);
        leftBack.setPower(p);
        leftFront.setPower(p);
    }

    private void setDifferentPowers(double a, double b, double c, double d) {
        rightFront.setPower(a);
        rightBack.setPower(b);
        leftBack.setPower(c);
        leftFront.setPower(d);
    }

    public void drive(Gamepad gamepad) {
        if (gamepad.a) speed = 0.4;
        if (gamepad.b) speed = 0.6;
        if (gamepad.y) speed = 0.8;
        if (gamepad.x) speed = 1.2;

        if (gamepad.left_stick_x != 0 || gamepad.left_stick_y != 0) {
            double x = gamepad.left_stick_x * speed;
            double y = -gamepad.left_stick_y * speed;
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

        private final double diameter = 10.0;
        private final double wheelCircumference = diameter * Math.PI;
        private final double ticksPerRotation = 1120.0;
        private final double gearRatio = 1.5 / 1.0;
        private final double scaleFactor = 1.0;
        private final double ticksPerCentimeter = (ticksPerRotation * scaleFactor) / (gearRatio * wheelCircumference);

        private void runToPosition() {
            rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }

        private boolean motorsBusy() {
            return (rightFront.isBusy() && rightBack.isBusy() && leftBack.isBusy() && leftFront.isBusy());
        }

        private void stop(){
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

            stop();
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

            stop();
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

            stop();
        }

        public void diagonal(double centimeters, double power) {
            double ticks = centimeters * ticksPerCentimeter;

            rightFront.setTargetPosition((int) (rightFront.getCurrentPosition() - ticks));
            rightBack.setTargetPosition((int) (rightBack.getCurrentPosition()));
            leftBack.setTargetPosition((int) (leftBack.getCurrentPosition()));
            leftFront.setTargetPosition((int) (leftFront.getCurrentPosition() + ticks));

            runToPosition();

            setIdenticalPowers(power);

            while (motorsBusy()) {

            }

            stop();
        }
    }
}
