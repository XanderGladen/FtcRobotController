package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Arm{

    DcMotor motor;
    // class constructor
    public Arm(DcMotor armMotor){
        this.motor = armMotor; // reinit motors for use within class functions.
    }

    public void moveArmMotorTicks(int ticksToBeMoved){
        motor.setTargetPosition(ticksToBeMoved);  //Sets Target Tick Position
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(1);  //Sets Motor to go to position at 1 power.
    }

}
