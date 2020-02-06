package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.hardware.lynx.LynxI2cColorRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Robot;

@Autonomous(name = "Sensor test", group = "Debug")
public class SensorColorTest extends LinearOpMode {

    private LynxI2cColorRangeSensor colorSensor;

    public ElapsedTime runtime = new ElapsedTime();

    public void getHardwareMap(HardwareMap hardwareMap) {
        colorSensor = hardwareMap.get(LynxI2cColorRangeSensor.class, "colorSensor");
    }

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        getHardwareMap(hardwareMap);
        colorSensor.initialize();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            NormalizedRGBA rgba = colorSensor.getNormalizedColors();
            telemetry.addData("1R", rgba.red);
            telemetry.addData("1G", rgba.green);
            telemetry.addData("1B", rgba.blue);
            telemetry.addData("1A", rgba.alpha);
            telemetry.update();
        }

        telemetry.addData("Status", "Done");
        telemetry.update();
    }
}
