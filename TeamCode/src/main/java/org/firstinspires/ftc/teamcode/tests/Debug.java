package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Debug", group = "TeleOp")
public class Debug extends LinearOpMode {

    public ElapsedTime runtime = new ElapsedTime();

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

    public void powers(Gamepad gamepad) {
        rightFront.setPower(gamepad.left_stick_x);
        rightBack.setPower(gamepad.left_stick_x);
        leftBack.setPower(gamepad.left_stick_x);
        leftFront.setPower(gamepad.left_stick_x);
    }

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        getHardwareMap(hardwareMap);
        setDirections();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            powers(gamepad1);
        }
    }
}
