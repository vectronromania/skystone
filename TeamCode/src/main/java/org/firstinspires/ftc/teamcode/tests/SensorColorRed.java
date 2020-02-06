package org.firstinspires.ftc.teamcode.tests;


import com.qualcomm.hardware.lynx.LynxI2cColorRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.hardware.Robot;

@Autonomous(name ="Sensor detection (red)", group = "Tests")
public class SensorColorRed extends LinearOpMode {

    int nr = 0;
    String position = "null";

    private LynxI2cColorRangeSensor colorSensor;

    public Robot robot = new Robot();
    public ElapsedTime runtime = new ElapsedTime();

    public void getHardwareMap() {
        colorSensor = hardwareMap.get(LynxI2cColorRangeSensor.class, "colorSensor");
    }

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        getHardwareMap();
        colorSensor.initialize();

        robot.initialize(hardwareMap);

        robot.autodrivetrain.strafe(-90,0.75);
        sleep(1000);

        NormalizedRGBA rgba = colorSensor.getNormalizedColors();

        if ((double)(rgba.alpha / rgba.red) >= 3.0) {
            telemetry.addData("Position", 1);
        } else {
            robot.autodrivetrain.move(-10, 0.75);

            if ((double)(rgba.alpha / rgba.red) >= 3.0) {
                telemetry.addData("Position", 2);
            } else {
                robot.autodrivetrain.move(-10, 0.75);

                if ((double)(rgba.alpha / rgba.red) >= 3.0) {
                    telemetry.addData("Position", 3);
                } else {
                    telemetry.addData("Position", "NONE");
                }
            }
        }

        telemetry.update();

        while(opModeIsActive()) {

        }


        telemetry.addData("Position", position);
        telemetry.addData("Status", "Done");
        telemetry.addData("Status", "Working");
        telemetry.update();
    }
}