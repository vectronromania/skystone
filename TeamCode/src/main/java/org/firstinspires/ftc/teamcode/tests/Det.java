package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Robot;

@Autonomous(name = "Det", group = "Tests")
public class Det extends LinearOpMode {
    public ColorSensor sensor;

    public Robot robot = new Robot();
    public ElapsedTime runtime = new ElapsedTime();

    public void getHardwareMap() {
        sensor = hardwareMap.get(ColorSensor.class, "color");
    }

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        robot.initialize(hardwareMap);

        waitForStart();
        runtime.reset();



        while(opModeIsActive()) {

        }

    }
}

