package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class hardwareMapCompetition
{
    double position;

    public DcMotor leftWheel  = null;
    public DcMotor rightWheel = null;
    public DcMotor intake     = null;
    public DcMotor uptake     = null;
    public DcMotor flipper    = null;
    public DcMotor lift       = null;
    public Servo hook         = null;

    HardwareMap hwMap         = null;
    private ElapsedTime period = new ElapsedTime();

    public hardwareMapCompetition(){}

    public void init(HardwareMap ahwMap){
        hwMap = ahwMap;
        position = 1.0;

        //Define and init motors and servos
        leftWheel  = hwMap.dcMotor.get("motorLeft");
        rightWheel = hwMap.dcMotor.get("motorRight");
        rightWheel.setDirection(DcMotor.Direction.REVERSE);

        intake     = hwMap.dcMotor.get("intake");
        intake.setDirection(DcMotorSimple.Direction.REVERSE);
        uptake     = hwMap.dcMotor.get("uptake");

        flipper    = hwMap.dcMotor.get("flipper");
        lift       = hwMap.dcMotor.get("lift");

        hook       = hwMap.servo.get("hook");
        hook.setDirection(Servo.Direction.FORWARD); //Be prepared to reverse

        //Set all motors to zero power
        leftWheel.setPower(0);
        rightWheel.setPower(0);

        intake.setPower(0);
        uptake.setPower(0);

        flipper.setPower(0);
        lift.setPower(0);

        //Set motors to run w/o encoders
        leftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        uptake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        flipper.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //Define and init all installed servos
        hook = hwMap.servo.get("hook");
        hook.setPosition(position);
    }

}
