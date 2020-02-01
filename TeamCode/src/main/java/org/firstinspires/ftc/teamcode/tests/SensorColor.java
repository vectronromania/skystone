package org.firstinspires.ftc.teamcode.tests;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.hardware.Robot;

@Autonomous(name ="Sensor detection", group = "Debug")
public class SensorColor extends LinearOpMode {

    public ColorSensor color;

    public Robot robot = new Robot();
    public ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        color = hardwareMap.get(ColorSensor.class, "color");

        waitForStart();
        runtime.reset();

        robot.initialize(hardwareMap);

        robot.autodrivetrain.move(60, 0.75);
        robot.autodrivetrain.rotate(-57, 0.75);
        sleep(1000);


        while (!(color.red() >= 1 && color.red() <= 3 &&
                color.green() >= 1 && color.green() <= 5 &&
                color.blue() >= 0 && color.blue() <= 2 &&
                color.alpha() >= 3 && color.alpha() <= 10)) {

            telemetry.addData("red :", color.red());
            telemetry.addData("green :", color.green());
            telemetry.addData("blue :", color.blue());
            telemetry.addData("alpha :", color.alpha());
        }

        robot.autodrivetrain.stop();
        robot.autodrivetrain.move(-20, 0.75);
        robot.autodrivetrain.strafe(80, 0.75);
        robot.intake.in();
        robot.autodrivetrain.move(20, 0.75);
        robot.intake.stop();
        robot.autodrivetrain.strafe(-80, 0.75);
        robot.autodrivetrain.move(-150, 0.75);

        telemetry.update();

        telemetry.addData("Status", "Done");
        telemetry.update();
    }
}