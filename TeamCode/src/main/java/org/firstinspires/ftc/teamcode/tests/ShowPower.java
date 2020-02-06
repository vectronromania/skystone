package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Robot;

@TeleOp(name = "Show power", group = "TeleOpModes")
public class ShowPower extends LinearOpMode {

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
            robot.drivetrain.showPower(telemetry);
        }

        telemetry.addData("Status", "Done");
        telemetry.update();
    }
}
