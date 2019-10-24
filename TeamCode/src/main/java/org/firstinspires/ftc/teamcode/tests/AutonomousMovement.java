package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.systems.Autodrivetrain;
import org.firstinspires.ftc.teamcode.systems.Drivetrain;

@Autonomous(name = "Test: Autonomous movement (DO NOT USE)", group = "Autonomous")
public class AutonomousMovement extends LinearOpMode {

    public Drivetrain drivetrain = new Drivetrain();
    public Autodrivetrain autodrivetrain = new Autodrivetrain();
    public ElapsedTime runtime = new ElapsedTime();

    public void test() {
        autodrivetrain.moveToPosition(10, 0.5);
        autodrivetrain.moveToPosition(10, -0.5);
        autodrivetrain.strafeToPosition(10, 0.5);
        autodrivetrain.strafeToPosition(10, -0.5);
        autodrivetrain.rotate(10, 0.5);
        autodrivetrain.rotate(45, -0.5);
    }

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        drivetrain.getHardwareMap(hardwareMap);
        drivetrain.setDirections();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            test();
        }

        telemetry.addData("Status", "Done");
        telemetry.update();
    }
}
