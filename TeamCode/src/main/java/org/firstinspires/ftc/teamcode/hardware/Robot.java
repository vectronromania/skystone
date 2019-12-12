package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.systems.Drivetrain;
import org.firstinspires.ftc.teamcode.systems.Foundation;
import org.firstinspires.ftc.teamcode.systems.Intake;

public class Robot {

    public Drivetrain drivetrain = new Drivetrain();
    public Drivetrain.Autodrivetrain autodrivetrain = new Drivetrain.Autodrivetrain();
    public Foundation foundation = new Foundation();
    public Intake intake = new Intake();

    public void initialize(HardwareMap hardwareMap) {

        drivetrain.getHardwareMap(hardwareMap);
        drivetrain.setDirections();

//        foundation.getHardwareMap(hardwareMap);
//        foundation.setDirections();

//        intake.getHardwareMap(hardwareMap);
//        intake.setDirections();
    }
}
