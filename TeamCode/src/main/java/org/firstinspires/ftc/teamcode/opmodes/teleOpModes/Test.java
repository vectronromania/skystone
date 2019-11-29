package org.firstinspires.ftc.teamcode.opmodes.teleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Test", group="TeleOp")
public class Test extends LinearOpMode {
    public DcMotor rightFront;
    public DcMotor rightBack;
    public DcMotor leftBack;
    public DcMotor leftFront;

    public void getHardwareMap(HardwareMap hw) {
        rightFront = hw.get(DcMotor.class, "rightFront");
        rightBack = hw.get(DcMotor.class, "rightBack");
        leftBack = hw.get(DcMotor.class, "leftBack");
        leftFront = hw.get(DcMotor.class, "leftFront");
    }

    public ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        getHardwareMap(hardwareMap);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            double drive = gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double twist = gamepad1.right_stick_x;

            double[] speeds = {
                    (drive - strafe - twist),
                    (drive + strafe - twist),
                    (drive - strafe + twist),
                    (drive + strafe + twist),
            };

            double max = Math.abs(speeds[0]);
            for (int i = 0; i < speeds.length; i++)
                if (max < Math.abs(speeds[i])) max = Math.abs(speeds[i]);

            if (max > 1)
                for (int i = 0; i < speeds.length; i++) speeds[i] /=max;

            rightFront.setPower(speeds[0]);
            rightBack.setPower(speeds[1]);
            leftBack.setPower(speeds[2]);
            leftFront.setPower(speeds[3]);
        }
    }
}
