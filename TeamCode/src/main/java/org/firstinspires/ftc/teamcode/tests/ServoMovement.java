package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Robot;

@Autonomous(name = "Servo movement", group = "Debug")
public class ServoMovement extends LinearOpMode {

    public Servo servo;

    public ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        servo = hardwareMap.get(Servo.class, "servo");
        servo.setDirection(Servo.Direction.FORWARD);

        waitForStart();
        runtime.reset();

        servo.setPosition(1.0);
        sleep(2000);
        servo.setPosition(0.0);

        telemetry.addData("Status", "Done");
        telemetry.update();
    }
}
