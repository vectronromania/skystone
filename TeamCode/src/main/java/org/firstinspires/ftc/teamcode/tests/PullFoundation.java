package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Robot;

@Autonomous(name = "Pull foundation (red right)", group = "Tests")
public class PullFoundation extends LinearOpMode {

    public Robot robot = new Robot();
    public ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        robot.initialize(hardwareMap);

        waitForStart();
        runtime.reset();

        robot.autodrivetrain.move(-80, 0.5);
        robot.foundation.down();
        sleep(3000);
        robot.foundation.stop();
        robot.autodrivetrain.move(20, 0.5);
        robot.autodrivetrain.rotate(52, 0.5);
        robot.foundation.up();
        sleep(1000);
        robot.foundation.stop();
        robot.autodrivetrain.move(115, 0.5);

        while (opModeIsActive()) {

        }

        telemetry.addData("Status", "Done");
        telemetry.update();
    }
}
