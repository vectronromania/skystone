//package org.firstinspires.ftc.teamcode.tests;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.util.ElapsedTime;
//
//@TeleOp(name = "Sleep", group = "Debug")
//public class Sleep extends LinearOpMode {
//
//    int i;
//
//    public ElapsedTime runtime = new ElapsedTime();
//
//    @Override
//    public void runOpMode() {
//        telemetry.addData("Status", "Initialized");
//        telemetry.update();
//
//        waitForStart();
//        runtime.reset();
//
//        while (opModeIsActive()) {
//            sleep(1000);
//            i++;
//            telemetry.addData("Value", i);
//            telemetry.update();
//        }
//
//        telemetry.addData("Status", "Done");
//        telemetry.update();
//    }
//}
