package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.systems.Drivetrain;

@TeleOp(name = "TeleOpMode", group = "TeleOp")
public class TeleOpMode extends LinearOpMode {

    public ElapsedTime runtime = new ElapsedTime();
    public Drivetrain drivetrain = new Drivetrain();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        drivetrain.getHardwareMap(hardwareMap);
        drivetrain.setDirections();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            drivetrain.drive(gamepad1);
        }
    }
}
