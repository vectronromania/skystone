//package org.firstinspires.ftc.teamcode.tests;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.util.ElapsedTime;
//
//import org.firstinspires.ftc.teamcode.systems.Autodrivetrain;
//import org.firstinspires.ftc.teamcode.systems.Drivetrain;
//
//@Autonomous(name = "Forward and left parking", group = "Autonomous")
//public class ForwardAndLeft extends LinearOpMode {
//
//    public Drivetrain drivetrain = new Drivetrain();
//    public ElapsedTime runtime = new ElapsedTime();
//    public Autodrivetrain autodrivetrain = new Autodrivetrain();
//
//    public void runToPosition() {
//        drivetrain.rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        drivetrain.rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        drivetrain.leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        drivetrain.leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//    }
//
//    public boolean motorsBusy() {
//        if (drivetrain.rightFront.isBusy() && drivetrain.rightBack.isBusy() && drivetrain.leftBack.isBusy() && drivetrain.leftFront.isBusy())
//            return true;
//        else
//            return false;
//    }
//
//    public void move(double centimeters, double power) {
//        double ticks = centimeters * autodrivetrain.ticksPerCentimeter;
//
//        drivetrain.rightFront.setTargetPosition((int) (drivetrain.rightFront.getCurrentPosition() - ticks));
//        drivetrain.rightBack.setTargetPosition((int) (drivetrain.rightBack.getCurrentPosition() - ticks));
//        drivetrain.leftBack.setTargetPosition((int) (drivetrain.leftBack.getCurrentPosition() + ticks));
//        drivetrain.leftFront.setTargetPosition((int) (drivetrain.leftFront.getCurrentPosition() + ticks));
//
//        runToPosition();
//
//        drivetrain.setIdenticalPowers(power);
//
//        while (motorsBusy()) {
//            telemetry.addData("RF", drivetrain.rightFront.getCurrentPosition());
//            telemetry.addData("RB", drivetrain.rightBack.getCurrentPosition());
//            telemetry.addData("LB", drivetrain.leftBack.getCurrentPosition());
//            telemetry.addData("LF", drivetrain.leftFront.getCurrentPosition());
//            telemetry.update();
//        }
//
//        drivetrain.setIdenticalPowers(0.0);
//
//        return;
//    }
//
//    public void strafe(double centimeters, double power) {
//        double ticks = centimeters * autodrivetrain.ticksPerCentimeter;
//
//        drivetrain.rightFront.setTargetPosition((int) (drivetrain.rightFront.getCurrentPosition() + ticks));
//        drivetrain.rightBack.setTargetPosition((int) (drivetrain.rightBack.getCurrentPosition() - ticks));
//        drivetrain.leftBack.setTargetPosition((int) (drivetrain.leftBack.getCurrentPosition() - ticks));
//        drivetrain.leftFront.setTargetPosition((int) (drivetrain.leftFront.getCurrentPosition() + ticks));
//
//        runToPosition();
//
//        drivetrain.setIdenticalPowers(power);
//
//        while (motorsBusy()) {
//
//        }
//
//        drivetrain.setIdenticalPowers(0.0);
//
//        return;
//    }
//
//    @Override
//    public void runOpMode() {
//        telemetry.addData("Status", "Initialized");
//        telemetry.update();
//
//        drivetrain.getHardwareMap(hardwareMap);
//        drivetrain.setDirections();
//
//        waitForStart();
//        runtime.reset();
//
//        move(60, 0.5);
//        strafe(-100, 0.5);
//
//        while (opModeIsActive()) {
//
//        }
//
//        telemetry.addData("Status", "Done");
//        telemetry.update();
//    }
//}
