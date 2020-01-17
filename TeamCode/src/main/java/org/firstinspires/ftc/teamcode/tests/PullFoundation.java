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

        robot.autodrivetrain.move(-70, 0.5);
        robot.autodrivetrain.strafe(63, 0.5);
        robot.foundation.down();
        if (robot.foundation.foundationServo.getPosition() != 1){
            robot.foundation.down();
        }
        robot.autodrivetrain.move(-20, 0.5);
        robot.autodrivetrain.rotate(50, 0.5);
        robot.foundation.up();
        if (robot.foundation.foundationServo.getPosition() != 0){
            robot.foundation.up();
        }
        robot.autodrivetrain.move(135, 0.5);

        while (opModeIsActive()) {

        }

        telemetry.addData("Status", "Done");
        telemetry.update();
    }
}
