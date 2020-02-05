package org.firstinspires.ftc.teamcode.tests;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.hardware.Robot;

@Autonomous(name ="Sensor detection (red)", group = "Debug")
public class SensorColorRed extends LinearOpMode {

    int nr = 0;
    String position = "null";

    public ColorSensor colorSensor1;
    public ColorSensor colorSensor2;

    public Robot robot = new Robot();
    public ElapsedTime runtime = new ElapsedTime();

    public void getHardwareMap() {
        colorSensor1 = hardwareMap.get(ColorSensor.class, "colorSensor1");
        colorSensor2 = hardwareMap.get(ColorSensor.class, "colorSensor2");
    }

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        getHardwareMap();

        robot.initialize(hardwareMap);

        robot.autodrivetrain.strafe(-90,0.75);

        while (true) {
            if ((colorSensor1.red() * colorSensor1.green()) / (colorSensor1.blue() * colorSensor1.blue()) < 2) {
                position = "left";
                robot.arm.down();
                sleep(2000);
                robot.arm.take();
                sleep(2000);
                robot.arm.up();
                robot.autodrivetrain.strafe(20, 0.75);
                robot.autodrivetrain.move(80, 0.75);
                robot.arm.down();
                robot.arm.release();
                robot.arm.up();
                robot.autodrivetrain.move(-40, 0.5);
                break;
            } else if ((colorSensor2.red() * colorSensor2.green()) / (colorSensor2.blue() * colorSensor2.blue()) < 2) {
                position = "middle";
                robot.autodrivetrain.move(-10, 0.75);
                robot.arm.down();
                sleep(2000);
                robot.arm.take();
                sleep(2000);
                robot.arm.up();
                robot.autodrivetrain.strafe(20, 0.75);
                robot.autodrivetrain.move(110, 0.75);
                robot.arm.down();
                robot.arm.release();
                robot.arm.up();
                robot.autodrivetrain.move(-40, 0.5);
                break;
            }
            nr++;
            if (nr == 5)
                break;
        }

        if (position == "null") {
            position = "right";
            robot.autodrivetrain.move(-30, 0.75);
            robot.arm.down();
            sleep(2000);
            robot.arm.take();
            sleep(2000);
            robot.arm.up();
            robot.autodrivetrain.strafe(20, 0.75);
            robot.autodrivetrain.move(130, 0.75);
            robot.arm.down();
            robot.arm.release();
            robot.arm.up();
            robot.autodrivetrain.move(-40, 0.5);
        }

        telemetry.addData("Position", position);
        telemetry.addData("Status", "Done");
        telemetry.addData("Status", "Working");
        telemetry.update();
    }
}