package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.internal.android.dx.ssa.LiteralOpUpgrader;
import org.firstinspires.ftc.teamcode.systems.Arm;
import org.firstinspires.ftc.teamcode.systems.Drivetrain;
import org.firstinspires.ftc.teamcode.systems.Foundation;
import org.firstinspires.ftc.teamcode.systems.Intake;
import org.firstinspires.ftc.teamcode.systems.Lift;
import org.firstinspires.ftc.teamcode.systems.Outtake;

public class Robot {

    public Drivetrain drivetrain = new Drivetrain();
    public Drivetrain.Autodrivetrain autodrivetrain = new Drivetrain.Autodrivetrain();
    public Foundation foundation = new Foundation();
    public Intake intake = new Intake();
    public Lift lift = new Lift();
    public Outtake outtake = new Outtake();
    public Arm arm = new Arm();

    public void initialize(HardwareMap hardwareMap) {

        drivetrain.getHardwareMap(hardwareMap);
        drivetrain.setDirections();

        foundation.getHardwareMap(hardwareMap);
        foundation.setDirection();

        intake.getHardwareMap(hardwareMap);
        intake.setDirections();

        lift.getHardwareMap(hardwareMap);
        lift.setDirection();

        outtake.getHardwareMap(hardwareMap);
        outtake.setDirection();

//        arm.getHardwareMap(hardwareMap);
//        arm.setDirection();
    }
}
