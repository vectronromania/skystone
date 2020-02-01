package org.firstinspires.ftc.teamcode.opmodes.teleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Robot;

@TeleOp(name = "TeleOpMode", group = "TeleOp")
public class TeleOpMode extends LinearOpMode {

    public Robot robot = new Robot();
    public ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        robot.initialize(hardwareMap);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            robot.drivetrain.drive(gamepad1);
            robot.foundation.drive(gamepad1);
            robot.intake.drive(gamepad1);
            robot.lift.drive(gamepad2);
            robot.outtake.drive(gamepad2);
        }

        telemetry.addData("Status", "Done");
        telemetry.update();
    }
}
