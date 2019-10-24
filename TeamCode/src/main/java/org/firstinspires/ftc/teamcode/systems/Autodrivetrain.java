package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Autodrivetrain {

    public final double diameter = 10.0;
    public final double wheelCircumference = diameter * Math.PI;
    public final double ticksPerRotation = 1120.0;
    public final double gearRatio = 1.0 / 1.0;
    public final double scaleFactor = 1.0;
    public final double ticksPerCentimeter = (ticksPerRotation * scaleFactor) / (wheelCircumference * gearRatio);

    public Drivetrain drivetrain = new Drivetrain();

    public void runUsingEncoder() {
        drivetrain.rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        drivetrain.rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        drivetrain.leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        drivetrain.leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void stopAndResetEncoder() {
        drivetrain.rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        drivetrain.rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        drivetrain.leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        drivetrain.leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void runWithoutEncoder() {
        drivetrain.rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        drivetrain.rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        drivetrain.leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        drivetrain.leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void runToPosition() {
        drivetrain.rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drivetrain.rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drivetrain.leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drivetrain.leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public boolean motorsBusy() {
        if (drivetrain.rightFront.isBusy() || drivetrain.rightBack.isBusy() || drivetrain.leftBack.isBusy() || drivetrain.leftFront.isBusy()) {
            return true;
        } else {
            return false;
        }
    }

    public void moveToPosition(double centimeters, double power) {

    }

    public void strafeToPosition(double centimeters, double power) {

    }

    public void rotate(double angle, double power) {

    }
}