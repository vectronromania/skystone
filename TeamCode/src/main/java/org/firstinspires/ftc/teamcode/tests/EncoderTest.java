package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Encoder test", group = "Debug")
public class EncoderTest extends LinearOpMode {

    public DcMotor rightFront;
    public DcMotor rightBack;
    public DcMotor leftBack;
    public DcMotor leftFront;

    public ElapsedTime runtime = new ElapsedTime();

    int ticks = 4480;
    double p = 0.5;

    public void getHardwareMap(HardwareMap hardwareMap) {
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
    }

    public void runToPosition() {
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void stopAndResetEncoders() {
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public boolean motorsBusy() {
        if (rightFront.isBusy() && rightBack.isBusy() && leftBack.isBusy() && leftFront.isBusy()) {
            return true;
        } else {
            return false;
        }
    }

    public void setIdenticalPowers(double p) {
        rightFront.setPower(p);
        rightBack.setPower(p);
        leftBack.setPower(p);
        leftFront.setPower(p);
    }

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        getHardwareMap(hardwareMap);

        stopAndResetEncoders();

        rightFront.setTargetPosition((int) (rightFront.getCurrentPosition() - ticks));
        rightBack.setTargetPosition((int) (rightBack.getCurrentPosition() - ticks));
        leftBack.setTargetPosition((int) (leftBack.getCurrentPosition() + ticks));
        leftFront.setTargetPosition((int) (leftFront.getCurrentPosition() + ticks));

        runToPosition();

        setIdenticalPowers(p);

        while (motorsBusy() && opModeIsActive()) {
            telemetry.addData("RF", rightFront.getCurrentPosition());
            telemetry.addData("RB", rightBack.getCurrentPosition());
            telemetry.addData("LB", leftBack.getCurrentPosition());
            telemetry.addData("LF", leftFront.getCurrentPosition());
            telemetry.update();
        }

        setIdenticalPowers(0);

        telemetry.addData("Status", "Done");
        telemetry.update();
    }
}
