package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Robot;

@Autonomous(name = "Pull foundation (red)", group = "Tests")
public class PullFoundationRed extends LinearOpMode {

    public Robot robot = new Robot();
    public ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        robot.initialize(hardwareMap);

        waitForStart();
        runtime.reset();

        robot.autodrivetrain.strafe(-45, 1);
        robot.autodrivetrain.move(-90, 0.5);
        robot.foundation.down();
        sleep(1000);
        robot.autodrivetrain.move(80, 0.5);
        robot.autodrivetrain.rotate(110, 0.5);
        robot.foundation.up();
        sleep(1000);
        robot.autodrivetrain.move(-25, 0.5);
        robot.autodrivetrain.strafe(-40, 1);
        robot.autodrivetrain.move(100, 0.5);

        while (opModeIsActive()) {

        }

        telemetry.addData("Status", "Done");
        telemetry.update();
    }
}
