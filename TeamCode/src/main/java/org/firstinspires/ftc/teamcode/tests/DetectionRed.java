package org.firstinspires.ftc.teamcode.tests;


import com.qualcomm.hardware.lynx.LynxI2cColorRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.hardware.Robot;

@Autonomous(name = "ColorSensor (red)", group = "Tests")
public class DetectionRed extends LinearOpMode {

    int nr = 0;
    String position = "null";

    private LynxI2cColorRangeSensor colorSensor;

    public Robot robot = new Robot();
    public ElapsedTime runtime = new ElapsedTime();

    public void getHardwareMap() {
        colorSensor = hardwareMap.get(LynxI2cColorRangeSensor.class, "ColorSensor");
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

        robot.autodrivetrain.move(50,0.75);
        robot.autodrivetrain.rotate(51, 0.75);
        robot.autodrivetrain.strafe(-15, 1);
        sleep(1000);

        NormalizedRGBA rgba = colorSensor.getNormalizedColors();

        if ((double)(rgba.alpha / rgba.red) >= 3.0) {
            telemetry.addData("Position", 1);
            robot.arm.down();
            sleep(1000);
            robot.arm.take();
            sleep(1000);
            robot.autodrivetrain.strafe(30, 1);
            robot.autodrivetrain.move(90, 0.75);
            sleep(1000);
            robot.arm.release();
            sleep(1000);
            robot.arm.up();
            sleep(1000);
            robot.arm.take();
            sleep(1000);
            robot.autodrivetrain.move(-150,0.75);
            robot.autodrivetrain.strafe(-30, 1);
            if((double)(rgba.alpha / rgba.red) >= 3.0) {
                telemetry.addData("Position", 4);
                robot.arm.release();
                sleep(1000);
                robot.arm.down();
                sleep(1000);
                robot.arm.take();
                sleep(1000);
                robot.autodrivetrain.strafe(30, 1);
                robot.autodrivetrain.move(150, 0.75);
                sleep(1000);
                robot.arm.release();
                sleep(1000);
                robot.arm.up();
                sleep(1000);
                robot.arm.take();
                sleep(1000);
                robot.autodrivetrain.move(-50, 0.75);
            } else {
                robot.autodrivetrain.move(-20, 0.75);
                sleep(1000);
            }
        } else {
            robot.autodrivetrain.move(-20, 0.75);
            sleep(1000);

            if ((double)(rgba.alpha / rgba.red) >= 3.0) {
                telemetry.addData("Position", 2);
                robot.arm.down();
                sleep(1000);
                robot.arm.take();
                sleep(1000);
                robot.autodrivetrain.strafe(30, 1);
                robot.autodrivetrain.move(110, 0.75);
                sleep(1000);
                robot.arm.release();
                sleep(1000);
                robot.arm.up();
                sleep(1000);
                robot.arm.take();
                sleep(1000);
                robot.autodrivetrain.move(-170,0.75);
                robot.autodrivetrain.strafe(-30, 1);
                if((double)(rgba.alpha / rgba.red) >= 3.0) {
                    telemetry.addData("Position", 5);
                    robot.arm.release();
                    sleep(1000);
                    robot.arm.down();
                    sleep(1000);
                    robot.arm.take();
                    robot.autodrivetrain.strafe(30, 1);
                    robot.autodrivetrain.move(170, 0.75);
                    robot.arm.release();
                    sleep(1000);
                    robot.arm.up();
                    sleep(1000);
                    robot.arm.take();
                    sleep(1000);
                    robot.autodrivetrain.move(-50, 0.75);
                } else {
                    robot.autodrivetrain.move(-20, 0.75);
                    sleep(1000);
                }
            } else {
                robot.autodrivetrain.move(-20, 0.75);
                sleep(1000);

                if ((double)(rgba.alpha / rgba.red) >= 3.0) {
                    telemetry.addData("Position", 3);
                    robot.arm.down();
                    sleep(1000);
                    robot.arm.take();
                    sleep(1000);
                    robot.autodrivetrain.strafe(30, 1);
                    robot.autodrivetrain.move(120, 0.75);
                    sleep(1000);
                    robot.arm.release();
                    sleep(1000);
                    robot.arm.up();
                    sleep(1000);
                    robot.arm.take();
                    sleep(1000);
                    robot.autodrivetrain.move(-190,0.75);
                    robot.autodrivetrain.strafe(- 30, 1);
                    if((double)(rgba.alpha / rgba.red) >= 3.0) {
                        telemetry.addData("Position", 6  );
                        robot.arm.release();
                        sleep(1000);
                        robot.arm.down();
                        sleep(1000);
                        robot.arm.take();
                        sleep(1000);
                        robot.autodrivetrain.strafe(30, 1);
                        robot.autodrivetrain.move(190, 0.75);
                        sleep(1000);
                        robot.arm.release();
                        sleep(1000);
                        robot.arm.up();
                        sleep(1000);
                        robot.arm.take();
                        sleep(1000);
                        robot.autodrivetrain.move(-50, 0.75);
                    } else {
                        telemetry.addData("Position", "NONE");
                    }
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
