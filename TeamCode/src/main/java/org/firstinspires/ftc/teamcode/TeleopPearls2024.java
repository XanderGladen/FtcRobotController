package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "CompetitionTeleop", group = "IntoTheDeep2024")
public class TeleopPearls2024 extends Base { // extends base instead of linearopmode
    @Override
    public void runOpMode() throws InterruptedException {

        initHardware(); // inits hardware
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        //matchTime.reset();

        while (opModeIsActive()) {
            // Updates
            //only call reset cache if you are using manual mode in your lynxmodule
            //resetCache();

            // move arm up when 'a' is pressed
            if(gamepad1.a){
                armModule.moveArmMotorTicks(500);
            }

            // move arm back down when 'b' is pressed
            if(gamepad1.b){
                armModule.moveArmMotorTicks(0);
            }

            // Display Values
            telemetry.addLine("Program is running");
            telemetry.update();
        }
    }
}
