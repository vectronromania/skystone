package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.systems.Drivetrain;

public class Robot {

    public Drivetrain drivetrain = new Drivetrain();

    public void initialize(HardwareMap hardwareMap) {
        drivetrain.getHardwareMap(hardwareMap);
        drivetrain.setDirections();
    }
}
