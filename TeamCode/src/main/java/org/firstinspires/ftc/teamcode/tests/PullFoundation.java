package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.systems.Autodrivetrain;
import org.firstinspires.ftc.teamcode.systems.Drivetrain;
import org.firstinspires.ftc.teamcode.systems.Foundation;

@Autonomous(name = "Pull foundation", group = "Autonomous")
public class PullFoundation extends LinearOpMode {

    public ElapsedTime runtime = new ElapsedTime();
    public Drivetrain drivetrain = new Drivetrain();
    public Foundation foundation = new Foundation();
    public Autodrivetrain autodrivetrain = new Autodrivetrain();

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

    public void up() {
        foundation.foundationServo1.setPosition(0.0);
        foundation.foundationServo2.setPosition(0.75);
    }

    public void down() {
        foundation.foundationServo1.setPosition(0.75);
        foundation.foundationServo2.setPosition(0.0);
    }

    public void move(double centimeters, double power) {
        double ticks = centimeters * autodrivetrain.ticksPerCentimeter;

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
        double ticks = centimeters * autodrivetrain.ticksPerCentimeter;

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

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        drivetrain.getHardwareMap(hardwareMap);
        drivetrain.setDirections();

        foundation.getHardwareMap(hardwareMap);
        foundation.setDirections();

        waitForStart();
        runtime.reset();

        move(70, 0.5);
        strafe(63, 0.5);
        sleep(500);
        down();
        sleep(500);
        while (foundation.foundationServo1.getPosition() != 0.75 && foundation.foundationServo2.getPosition() != 0.0) {
            down();
        }
        move(-80, 0.5);
        sleep(500);
        up();
        sleep(500);
        while (foundation.foundationServo1.getPosition() != 0.0 && foundation.foundationServo2.getPosition() != 0.75) {
            up();
        }
        strafe(-135, 0.5);

        while (opModeIsActive()) {

        }

        telemetry.addData("Status", "Done");
        telemetry.update();
    }
}
