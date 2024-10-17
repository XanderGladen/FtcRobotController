package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

import java.util.List;
import java.util.Locale;

public abstract class Base extends LinearOpMode {

    // Globally Declared Sensors
    public IMU gyro;

    // Module Classes
    public Arm armModule = null; // This is an actual class with various methods

    // Global Variables
    public int exampleVariable = 0;

    // Initialize Hardware Function
    public void initHardware() throws InterruptedException {
        // Hubs
        List<LynxModule> allHubs;
        allHubs = hardwareMap.getAll(LynxModule.class);
        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }

        // Motors
        DcMotor armMotor = hardwareMap.get(DcMotor.class, "Drive Motor");
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Init Module class
        armModule = new Arm(armMotor);
    }

    //Utility Functions
    public String formatDegrees(double degrees) {
        return String.format(Locale.getDefault(), "%.1f", AngleUnit.DEGREES.normalize(degrees));
    }

    // Allows you to connect opModes to the base class
    @Override
    public abstract void runOpMode() throws InterruptedException;
}
