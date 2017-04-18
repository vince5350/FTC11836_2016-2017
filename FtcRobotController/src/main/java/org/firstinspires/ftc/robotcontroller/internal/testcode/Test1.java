package org.firstinspires.ftc.robotcontroller.internal.testcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by VINCENT DA KING!!! on 9/27/2016.
 */

public class Test1 extends OpMode {

    public Test1(){

    }

    DcMotor motorLeft;
    DcMotor motorRight;

    public void init(){ //Initiates variables

        motorLeft = hardwareMap.dcMotor.get("motor1");
        motorRight = hardwareMap.dcMotor.get("motor2"); //motor2 must be the exact same as the config file on phone

        motorLeft.setDirection(DcMotor.Direction.REVERSE);

    }
    public void loop(){ //Main code

        float left, right;
        left = gamepad1.left_stick_y;
        right = gamepad1.right_stick_y;

        right = Range.clip(right,-1,1);
        left = Range.clip(left, -1, 1);

        motorLeft.setPower(left);
        motorRight.setPower(right);


    }
    public void stop() { //Does what it sounds like

    }
}