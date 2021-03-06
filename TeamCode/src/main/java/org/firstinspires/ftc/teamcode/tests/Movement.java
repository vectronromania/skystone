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

//        robot.autodrivetrain.move(80, 0.75);
//        robot.autodrivetrain.move(-80, 0.75);
//        robot.autodrivetrain.rotate(52, 0.75);
//        robot.autodrivetrain.rotate(-52, 0.75);
        robot.autodrivetrain.strafe(100, 1);
        robot.autodrivetrain.strafe(-100, 1);

        while (opModeIsActive()) {

        }

        telemetry.addData("Status", "Done");
        telemetry.update();
    }
}
