package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Autodrivetrain {

    public final double diameter = 10.0;
    public final double wheelCircumference = diameter * Math.PI;
    public final double ticksPerRotation = 1120.0;
    public final double gearRatio = 1.0 / 1.0;
    public final double scaleFactor = 1.0;
    public final double ticksPerCentimeter = (ticksPerRotation * scaleFactor) / (gearRatio * wheelCircumference);

    public Drivetrain drivetrain = new Drivetrain();

    public void runToPosition() {
        drivetrain.rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drivetrain.rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drivetrain.leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drivetrain.leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public boolean motorsBusy() {
        if (drivetrain.rightFront.isBusy() && drivetrain.rightBack.isBusy() && drivetrain.leftBack.isBusy() && drivetrain.leftFront.isBusy()) {
            return true;
        } else {
            return false;
        }
    }

    public void move(double centimeters, double power) {
        double ticks = centimeters * ticksPerCentimeter;

        drivetrain.rightFront.setTargetPosition((int) (drivetrain.rightFront.getCurrentPosition() - ticks));
        drivetrain.rightBack.setTargetPosition((int) (drivetrain.rightBack.getCurrentPosition() - ticks));
        drivetrain.leftBack.setTargetPosition((int) (drivetrain.leftBack.getCurrentPosition() + ticks));
        drivetrain.leftFront.setTargetPosition((int) (drivetrain.leftFront.getCurrentPosition() + ticks));

        runToPosition();

        drivetrain.setIdenticalPowers(power);

        while (motorsBusy()) {

        }

        drivetrain.setIdenticalPowers(0.0);

        return;
    }

    public void strafe(double centimeters, double power) {
        double ticks = centimeters * ticksPerCentimeter;

        drivetrain.rightFront.setTargetPosition((int) (drivetrain.rightFront.getCurrentPosition() + ticks));
        drivetrain.rightBack.setTargetPosition((int) (drivetrain.rightBack.getCurrentPosition() - ticks));
        drivetrain.leftBack.setTargetPosition((int) (drivetrain.leftBack.getCurrentPosition() - ticks));
        drivetrain.leftFront.setTargetPosition((int) (drivetrain.leftFront.getCurrentPosition() + ticks));

        runToPosition();

        drivetrain.setIdenticalPowers(power);

        while (motorsBusy()) {

        }

        drivetrain.setIdenticalPowers(0.0);

        return;
    }

    public void rotate(double centimeters, double power) {
        double ticks = centimeters * ticksPerCentimeter;

        drivetrain.rightFront.setTargetPosition((int) (drivetrain.rightFront.getCurrentPosition() + ticks));
        drivetrain.rightBack.setTargetPosition((int) (drivetrain.rightBack.getCurrentPosition() + ticks));
        drivetrain.leftBack.setTargetPosition((int) (drivetrain.leftBack.getCurrentPosition() + ticks));
        drivetrain.leftFront.setTargetPosition((int) (drivetrain.leftFront.getCurrentPosition() + ticks));

        runToPosition();

        drivetrain.setIdenticalPowers(power);

        while (motorsBusy()) {

        }

        drivetrain.setIdenticalPowers(0.0);

        return;
    }
}