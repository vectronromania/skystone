package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    public DcMotor intakeMotor1;
    public DcMotor intakeMotor2;

    public void getHardwareMap(HardwareMap hardwareMap) {
        intakeMotor1 = hardwareMap.get(DcMotor.class, "intakeMotor1");
        intakeMotor2 = hardwareMap.get(DcMotor.class, "intakeMotor2");
    }

    public void setDirections() {
        intakeMotor1.setDirection(DcMotorSimple.Direction.FORWARD);
        intakeMotor2.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void move(Gamepad gamepad) {
        if (gamepad.right_trigger == 1) {
            intakeMotor1.setPower(0.5);
            intakeMotor2.setPower(-0.5);
        } else if (gamepad.left_trigger == 1) {
            intakeMotor1.setPower(-0.5);
            intakeMotor2.setPower(0.5);
        }
    }
}
