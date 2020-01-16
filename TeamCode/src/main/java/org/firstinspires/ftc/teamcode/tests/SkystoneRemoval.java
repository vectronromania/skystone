package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.teamcode.hardware.Robot;

import java.util.ArrayList;
import java.util.List;

import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.DEGREES;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.XYZ;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.YZX;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesReference.EXTRINSIC;
import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.BACK;

@Autonomous(name ="Skystone removal", group = "Tests")
public class SkystoneRemoval extends LinearOpMode {

    boolean firstTime = true;

    private static final VuforiaLocalizer.CameraDirection CAMERA_CHOICE = BACK;
    private static final boolean PHONE_IS_PORTRAIT = false;

    private static final String VUFORIA_KEY =
            "AX9Tt1f/////AAAAmZgP0a7xc00OtCKro8AxNIB0Ga4OEzIbXne8gRzbrIWLbdDHycjj1xMWsNBKrsRDAEiWKN3LTwH77nbmYSVM4LeDtJodEejVAlG6J+U0m1UhTz8+tvYYfOSptuQWhhIo3bJQS/ZZo0IO/emnTgjgcBU9S9dMdIxFTHA71SPKsoMaNyE+yFGgVur3UbU9uY0oPBzRnPEFW4GB1hVaV8LQHLRYCd7/6H1fqDggix7GCKpNzw5y/1mCTGJxTRTI+j//ZhvtW6PUCHYxPyRLUzjy/wTettLuB6oTslQDW3UTuxq6dCjOHJskVNVWVkFlTiWk1oxkjqhBd6Px60nwHHNL038o2WZUitk2whtkFkhB6DYX";

    private static final float mmPerCentimter = 10.0f;
    private static final float mmTargetHeight = (6) * mmPerCentimter;

    private static final float stoneZ = 2.00f * mmPerCentimter;

    private static final float bridgeZ = 6.42f * mmPerCentimter;
    private static final float bridgeY = 23 * mmPerCentimter;
    private static final float bridgeX = 5.18f * mmPerCentimter;
    private static final float bridgeRotY = 59;
    private static final float bridgeRotZ = 180;

    private static final float halfField = 72 * mmPerCentimter;
    private static final float quadField  = 36 * mmPerCentimter;

    private OpenGLMatrix lastLocation = null;
    private VuforiaLocalizer vuforia = null;
    private boolean targetVisible = false;
    private float phoneXRotate = 0;
    private float phoneYRotate = 0;
    private final float phoneZRotate = 45;

    public Robot robot = new Robot();
    public ElapsedTime runtime = new ElapsedTime();

    public void case1() {
        robot.autodrivetrain.strafe(60, 0.5);
        robot.autodrivetrain.stop();
        robot.autodrivetrain.move(80, 0.5);
        robot.autodrivetrain.stop();
        robot.autodrivetrain.move(-30, 0.5);
        robot.autodrivetrain.stop();
        robot.autodrivetrain.rotate(-50, 0.5);
        robot.autodrivetrain.stop();
        robot.intake.in();
        robot.autodrivetrain.move(20, 0.5);
        robot.autodrivetrain.stop();
        robot.intake.stop();
        robot.autodrivetrain.strafe(-50, 0.5);
        robot.autodrivetrain.stop();
        robot.autodrivetrain.move(-200, 0.5);
        robot.autodrivetrain.stop();
        robot.intake.out();
    }

    public void case2() {
        robot.autodrivetrain.strafe(40, 0.5);
        robot.autodrivetrain.stop();
        robot.autodrivetrain.move(80, 0.5);
        robot.autodrivetrain.stop();
        robot.autodrivetrain.move(-30, 0.5);
        robot.autodrivetrain.stop();
        robot.autodrivetrain.rotate(-50, 0.5);
        robot.autodrivetrain.stop();
        robot.intake.in();
        robot.autodrivetrain.move(20, 0.5);
        robot.autodrivetrain.stop();
        robot.intake.stop();
        robot.autodrivetrain.strafe(-50, 0.5);
        robot.autodrivetrain.stop();
        robot.autodrivetrain.move(-200, 0.5);
        robot.autodrivetrain.stop();
        robot.intake.out();

    }

    public void case3() {
        robot.autodrivetrain.strafe(20, 0.5);
//        robot.autodrivetrain.stop();
        robot.autodrivetrain.move(80, 0.5);
//        robot.autodrivetrain.stop();
        robot.autodrivetrain.move(-30, 0.5);
//        robot.autodrivetrain.stop();
        robot.autodrivetrain.rotate(-50, 0.5);
//        robot.autodrivetrain.stop();
        robot.intake.in();
        robot.autodrivetrain.move(30, 0.5);
//        robot.autodrivetrain.stop();
        robot.intake.stop();
        robot.autodrivetrain.strafe(-50, 0.5);
//        robot.autodrivetrain.stop();
        robot.autodrivetrain.move(-200, 0.5);
//        robot.autodrivetrain.stop();
        robot.intake.out();
    }

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = CAMERA_CHOICE;

        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        VuforiaTrackables targetsSkyStone = this.vuforia.loadTrackablesFromAsset("Skystone");

        VuforiaTrackable stoneTarget = targetsSkyStone.get(0);
        stoneTarget.setName("Stone Target");
        VuforiaTrackable blueRearBridge = targetsSkyStone.get(1);
        blueRearBridge.setName("Blue Rear Bridge");
        VuforiaTrackable redRearBridge = targetsSkyStone.get(2);
        redRearBridge.setName("Red Rear Bridge");
        VuforiaTrackable redFrontBridge = targetsSkyStone.get(3);
        redFrontBridge.setName("Red Front Bridge");
        VuforiaTrackable blueFrontBridge = targetsSkyStone.get(4);
        blueFrontBridge.setName("Blue Front Bridge");
        VuforiaTrackable red1 = targetsSkyStone.get(5);
        red1.setName("Red Perimeter 1");
        VuforiaTrackable red2 = targetsSkyStone.get(6);
        red2.setName("Red Perimeter 2");
        VuforiaTrackable front1 = targetsSkyStone.get(7);
        front1.setName("Front Perimeter 1");
        VuforiaTrackable front2 = targetsSkyStone.get(8);
        front2.setName("Front Perimeter 2");
        VuforiaTrackable blue1 = targetsSkyStone.get(9);
        blue1.setName("Blue Perimeter 1");
        VuforiaTrackable blue2 = targetsSkyStone.get(10);
        blue2.setName("Blue Perimeter 2");
        VuforiaTrackable rear1 = targetsSkyStone.get(11);
        rear1.setName("Rear Perimeter 1");
        VuforiaTrackable rear2 = targetsSkyStone.get(12);
        rear2.setName("Rear Perimeter 2");

        List<VuforiaTrackable> allTrackables = new ArrayList<VuforiaTrackable>();
        allTrackables.addAll(targetsSkyStone);

        stoneTarget.setLocation(OpenGLMatrix
                .translation(0, 0, stoneZ)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, -90)));

        blueFrontBridge.setLocation(OpenGLMatrix
                .translation(-bridgeX, bridgeY, bridgeZ)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, bridgeRotY, bridgeRotZ)));

        blueRearBridge.setLocation(OpenGLMatrix
                .translation(-bridgeX, bridgeY, bridgeZ)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, -bridgeRotY, bridgeRotZ)));

        redFrontBridge.setLocation(OpenGLMatrix
                .translation(-bridgeX, -bridgeY, bridgeZ)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, -bridgeRotY, 0)));

        redRearBridge.setLocation(OpenGLMatrix
                .translation(bridgeX, -bridgeY, bridgeZ)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, bridgeRotY, 0)));

        red1.setLocation(OpenGLMatrix
                .translation(quadField, -halfField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 180)));

        red2.setLocation(OpenGLMatrix
                .translation(-quadField, -halfField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 180)));

        front1.setLocation(OpenGLMatrix
                .translation(-halfField, -quadField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0 , 90)));

        front2.setLocation(OpenGLMatrix
                .translation(-halfField, quadField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 90)));

        blue1.setLocation(OpenGLMatrix
                .translation(-quadField, halfField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 0)));

        blue2.setLocation(OpenGLMatrix
                .translation(quadField, halfField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 0)));

        rear1.setLocation(OpenGLMatrix
                .translation(halfField, quadField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0 , -90)));

        rear2.setLocation(OpenGLMatrix
                .translation(halfField, -quadField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, -90)));

        if (CAMERA_CHOICE == BACK) {
            phoneYRotate = -90;
        } else {
            phoneYRotate = 90;
        }

        if (PHONE_IS_PORTRAIT) {
            phoneXRotate = 90 ;
        }

        final float CAMERA_FORWARD_DISPLACEMENT  = 14.0f * mmPerCentimter;
        final float CAMERA_VERTICAL_DISPLACEMENT = 30.0f * mmPerCentimter;
        final float CAMERA_LEFT_DISPLACEMENT     = 0;

        OpenGLMatrix robotFromCamera = OpenGLMatrix
                .translation(CAMERA_FORWARD_DISPLACEMENT, CAMERA_LEFT_DISPLACEMENT, CAMERA_VERTICAL_DISPLACEMENT)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, YZX, DEGREES, phoneYRotate, phoneZRotate, phoneXRotate));

        for (VuforiaTrackable trackable : allTrackables) {
            ((VuforiaTrackableDefaultListener) trackable.getListener()).setPhoneInformation(robotFromCamera, parameters.cameraDirection);
        }

        waitForStart();
        runtime.reset();

        robot.initialize(hardwareMap);

        robot.autodrivetrain.move(40, 0.5);

        targetsSkyStone.activate();
        while (!isStopRequested()) {
            targetVisible = false;
            for (VuforiaTrackable trackable : allTrackables) {
                if (((VuforiaTrackableDefaultListener)trackable.getListener()).isVisible()) {
                    telemetry.addData("Visible Target", trackable.getName());
                    targetVisible = true;

                    OpenGLMatrix robotLocationTransform = ((VuforiaTrackableDefaultListener)trackable.getListener()).getUpdatedRobotLocation();
                    if (robotLocationTransform != null) {
                        lastLocation = robotLocationTransform;
                    }
                    break;
                }
            }

            if (targetVisible && firstTime == true) {
                firstTime = false;

                VectorF translation = lastLocation.getTranslation();
                telemetry.addData("Pos (in)", "{X, Y, Z} = %.1f, %.1f, %.1f",
                        translation.get(0) / mmPerCentimter, translation.get(1) / mmPerCentimter, translation.get(2) / mmPerCentimter);

                Orientation rotation = Orientation.getOrientation(lastLocation, EXTRINSIC, XYZ, DEGREES);
                telemetry.addData("Rot (deg)", "{Roll, Pitch, Heading} = %.0f, %.0f, %.0f", rotation.firstAngle, rotation.secondAngle, rotation.thirdAngle);

                case3();
            }
            else {
                telemetry.addData("Visible Target", "none");
            }
            telemetry.update();

            if (firstTime == false) {
                break;
            }
        }

        robot.intake.stop();
        robot.autodrivetrain.strafe(40, 0.5);
        robot.autodrivetrain.move(80, 0.5);

        while (opModeIsActive()) {

        }

        telemetry.addData("Status", "Done");
        telemetry.update();
    }
}
