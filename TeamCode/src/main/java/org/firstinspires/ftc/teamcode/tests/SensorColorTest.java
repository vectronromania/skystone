package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Robot;

@Autonomous(name = "Sensor test", group = "Debug")
public class SensorColorTest extends LinearOpMode {

    public ColorSensor colorSensor1;
    public ColorSensor colorSensor2;

    public ElapsedTime runtime = new ElapsedTime();

    public void getHardwareMap(HardwareMap hardwareMap) {
        colorSensor1 = hardwareMap.get(ColorSensor.class, "colorSensor1");
        colorSensor2 = hardwareMap.get(ColorSensor.class, "colorSensor2");
    }

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        getHardwareMap(hardwareMap);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            telemetry.addData("1R", colorSensor1.red());
            telemetry.addData("1G", colorSensor1.green());
            telemetry.addData("1B", colorSensor1.blue());
            telemetry.addData("2R", colorSensor1.red());
            telemetry.addData("2G", colorSensor1.green());
            telemetry.addData("2B", colorSensor1.blue());
            telemetry.update();
        }

        telemetry.addData("Status", "Done");
        telemetry.update();
    }
}
