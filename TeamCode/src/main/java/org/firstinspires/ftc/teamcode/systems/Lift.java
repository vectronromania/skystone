package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Lift {

    public static DcMotor liftMotor;
    public double speed = 1.0;

    public final double diameter = 10.0;
    public final double wheelCircumference = diameter * Math.PI;
    public final double ticksPerRotation = 1120.0;
    public final double gearRatio = 1.5 / 1.0;
    public final double scaleFactor = 1.0;
    double ticksPerCentimeter =  (ticksPerRotation * scaleFactor) / (gearRatio * wheelCircumference);

    public void getHardwareMap(HardwareMap hardwareMap) {
        liftMotor = hardwareMap.get(DcMotor.class, "liftMotor");
    }

    public void setDirection() {
        liftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void up() {
        liftMotor.setPower(-0.5);
    }

    public void down() {
        liftMotor.setPower(0.5);
    }

    public void stop() {
        liftMotor.setPower(0);
    }

    public void drive(Gamepad gamepad) {
        if (gamepad.left_stick_y < 0) {
            up();
        } else if (gamepad.left_stick_y > 0) {
            down();
        } else {
            stop();
        }
    }

    public void runToPosition(){
        liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public boolean motorBusy() {
        if (liftMotor.isBusy()) {
            return true;
        } else {
            return false;
        }
    }

    public void move(double centimeters, double power){

        double ticks = centimeters * ticksPerCentimeter;

        liftMotor.setTargetPosition((int) (liftMotor.getCurrentPosition() - ticks));

        runToPosition();

        liftMotor.setPower(power);

        while (motorBusy()) {

        }

        stop();

        return;
    }
}
