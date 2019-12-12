package org.firstinspires.ftc.teamcode.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Robot;

@Autonomous(name = "Forward & left", group = "Autonomous")
public class ForwardAndLeft extends LinearOpMode {

    public Robot robot = new Robot();
    public ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        robot.initialize(hardwareMap);

        waitForStart();
        runtime.reset();

        robot.autodrivetrain.move(60, 0.5);
        robot.autodrivetrain.strafe(-100, 0.5);

        while (opModeIsActive()) {

        }

        telemetry.addData("Status", "Done");
        telemetry.update();
    }
}
