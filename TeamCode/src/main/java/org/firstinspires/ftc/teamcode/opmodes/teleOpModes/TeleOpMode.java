package org.firstinspires.ftc.teamcode.opmodes.teleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.systems.Drivetrain;
import org.firstinspires.ftc.teamcode.systems.Foundation;

@TeleOp(name = "TeleOpMode", group = "TeleOp")
public class TeleOpMode extends LinearOpMode {

    public ElapsedTime runtime = new ElapsedTime();
    public Drivetrain drivetrain = new Drivetrain();
    public Foundation foundation = new Foundation();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        drivetrain.getHardwareMap(hardwareMap);
        drivetrain.setDirections();

        foundation.getHardwareMap(hardwareMap);
        foundation.setDirections();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            drivetrain.drive(gamepad1);
            foundation.move(gamepad1);
        }

        telemetry.addData("Status", "Done");
        telemetry.update();
    }
}
