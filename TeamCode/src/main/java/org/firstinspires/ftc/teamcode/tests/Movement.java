package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Robot;

@Autonomous(name = "Movement", group = "Debug")
public class Movement extends LinearOpMode {

    public Robot robot = new Robot();
    public ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        robot.initialize(hardwareMap);

        waitForStart();
        runtime.reset();

        robot.autodrivetrain.move(50, 0.5);
        robot.autodrivetrain.move(-50, 0.5);
        robot.autodrivetrain.rotate(52, 0.5);
        robot.autodrivetrain.rotate(-52, 0.5);
        robot.autodrivetrain.strafe(50, 0.5);
        robot.autodrivetrain.strafe(-50, 0.5);

        while (opModeIsActive()) {

        }

        telemetry.addData("Status", "Done");
        telemetry.update();
    }
}
