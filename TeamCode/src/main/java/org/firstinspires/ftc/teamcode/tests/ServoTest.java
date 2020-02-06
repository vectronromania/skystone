
package org.firstinspires.ftc.teamcode.tests;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name ="Servo test", group = "Debug")
public class ServoTest extends LinearOpMode {

    private ElapsedTime runtime  = new ElapsedTime();

    Servo armServo;
    Servo catchServo;
    Servo outtakeServo;

    @Override
    public void runOpMode () throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        armServo = hardwareMap.servo.get("armServo");
        catchServo = hardwareMap.servo.get("catchServo");
        outtakeServo = hardwareMap.servo.get("outtakeServo");

        waitForStart();
        runtime.reset();

      //  outtakeServo.setPosition(0);
       // sleep(2000);
       // outtakeServo.setPosition(1);

        armServo.setPosition(0);
        sleep(2000);
        catchServo.setPosition(1);
        sleep(2000);
        armServo.setPosition(1);

    }
}
