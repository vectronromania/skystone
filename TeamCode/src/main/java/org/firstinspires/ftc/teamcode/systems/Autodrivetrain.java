//package org.firstinspires.ftc.teamcode.systems;
//
//import com.qualcomm.robotcore.hardware.DcMotor;
//
//import org.firstinspires.ftc.teamcode.hardware.Robot;
//
//public class Autodrivetrain {
//
//    public final double diameter = 10.0;
//    public final double wheelCircumference = diameter * Math.PI;
//    public final double ticksPerRotation = 1120.0;
//    public final double gearRatio = 1.0 / 1.0;
//    public final double scaleFactor = 1.0;
//    public final double ticksPerCentimeter = (ticksPerRotation * scaleFactor) / (gearRatio * wheelCircumference);
//
//    public Robot robot = new Robot();
//
//    public void runToPosition() {
//        robot.drivetrain.rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.drivetrain.rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.drivetrain.leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.drivetrain.leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//    }
//
//    public boolean motorsBusy() {
//        if (robot.drivetrain.rightFront.isBusy() && robot.drivetrain.rightBack.isBusy() && robot.drivetrain.leftBack.isBusy() && robot.drivetrain.leftFront.isBusy()) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public void move(double centimeters, double power) {
//        double ticks = centimeters * ticksPerCentimeter;
//
//        robot.drivetrain.rightFront.setTargetPosition((int) (robot.drivetrain.rightFront.getCurrentPosition() - ticks));
//        robot.drivetrain.rightBack.setTargetPosition((int) (robot.drivetrain.rightBack.getCurrentPosition() - ticks));
//        robot.drivetrain.leftBack.setTargetPosition((int) (robot.drivetrain.leftBack.getCurrentPosition() + ticks));
//        robot.drivetrain.leftFront.setTargetPosition((int) (robot.drivetrain.leftFront.getCurrentPosition() + ticks));
//
//        runToPosition();
//
//        robot.drivetrain.setIdenticalPowers(power);
//
//        while (motorsBusy()) {
//
//        }
//
//        robot.drivetrain.setIdenticalPowers(0.0);
//
//        return;
//    }
//
//    public void strafe(double centimeters, double power) {
//        double ticks = centimeters * ticksPerCentimeter;
//
//        robot.drivetrain.rightFront.setTargetPosition((int) (robot.drivetrain.rightFront.getCurrentPosition() + ticks));
//        robot.drivetrain.rightBack.setTargetPosition((int) (robot.drivetrain.rightBack.getCurrentPosition() - ticks));
//        robot.drivetrain.leftBack.setTargetPosition((int) (robot.drivetrain.leftBack.getCurrentPosition() - ticks));
//        robot.drivetrain.leftFront.setTargetPosition((int) (robot.drivetrain.leftFront.getCurrentPosition() + ticks));
//
//        runToPosition();
//
//        robot.drivetrain.setIdenticalPowers(power);
//
//        while (motorsBusy()) {
//
//        }
//
//        robot.drivetrain.setIdenticalPowers(0.0);
//
//        return;
//    }
//
//    public void rotate(double centimeters, double power) {
//        double ticks = centimeters * ticksPerCentimeter;
//
//        robot.drivetrain.rightFront.setTargetPosition((int) (robot.drivetrain.rightFront.getCurrentPosition() + ticks));
//        robot.drivetrain.rightBack.setTargetPosition((int) (robot.drivetrain.rightBack.getCurrentPosition() + ticks));
//        robot.drivetrain.leftBack.setTargetPosition((int) (robot.drivetrain.leftBack.getCurrentPosition() + ticks));
//        robot.drivetrain.leftFront.setTargetPosition((int) (robot.drivetrain.leftFront.getCurrentPosition() + ticks));
//
//        runToPosition();
//
//        robot.drivetrain.setIdenticalPowers(power);
//
//        while (motorsBusy()) {
//
//        }
//
//        robot.drivetrain.setIdenticalPowers(0.0);
//
//        return;
//    }
//}