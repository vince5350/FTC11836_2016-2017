package org.firstinspires.ftc.teamcode.nonCompetition;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;


//-----------------------------------------------------------------------------------------------------------------------------
 @Disabled

public class robotRodeo extends OpMode {

    public robotRodeo(){

    } //Nothing needs to be put here; I don't know what this does -I don't think this does anything important

    //Variables to be initiated outside of a class go here


        DcMotor motorWheelBackLeft;
        DcMotor motorWheelBackRight;


//-----------------------------------------------------------------------------------------------------------------------------
    public void init(){ //This initiates variables and configures them
        //WheelsDisabled

        motorWheelBackLeft = hardwareMap.dcMotor.get("MotorLeft");
        motorWheelBackRight = hardwareMap.dcMotor.get("MotorRight"); //Must be the exact same as the config file on phone

        motorWheelBackLeft.setDirection(DcMotor.Direction.REVERSE); //Might need to be motorWheelBackLeft instead

        /*This reverses the left motor so that
        when the motors are placed on the robot
        they move the robot forwards instead of
        in a circle.
         */


    }
//-----------------------------------------------------------------------------------------------------------------------------


    public void loop(){ //Instructions to be executed
        //Wheels
        float left, right; //This creates the variables 'left' and 'right' that will be used to set the power and speed of the motors
        left = gamepad1.left_stick_y;
        right = gamepad1.right_stick_y;

        left = Range.clip(left,-1,1); //This makes the code more efficient by limiting the numerical range of the motors to -1 to +1
        right = Range.clip(right,-1,1);

        motorWheelBackLeft.setPower(left); //Sets the power of the motors to equal that of the 'left' and 'right' variables
        motorWheelBackRight.setPower(right);

    }

//-----------------------------------------------------------------------------------------------------------------------------

    public void stop(){
    } //Nothing needs to be put here; this stops the program when told to
}
