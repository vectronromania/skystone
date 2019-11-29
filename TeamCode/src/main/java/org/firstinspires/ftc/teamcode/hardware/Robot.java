package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.systems.Drivetrain;
import org.firstinspires.ftc.teamcode.systems.Foundation;

public class Robot {

    public Drivetrain drivetrain = new Drivetrain();
    public Foundation foundation = new Foundation();

    public void initialize(HardwareMap hardwareMap) {
        drivetrain.getHardwareMap(hardwareMap);
        drivetrain.setDirections();

        foundation.getHardwareMap(hardwareMap);
        foundation.setDirections();
    }
}
