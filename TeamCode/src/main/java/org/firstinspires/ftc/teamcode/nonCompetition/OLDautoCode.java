package org.firstinspires.ftc.teamcode.nonCompetition;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Disabled
@Autonomous(name = "Auto")
public class OLDautoCode extends OpMode {
    public OLDautoCode(){
    } //Nothing needs to be put here; I don't know what this does; Best to not get rid of it for now.

    //Variables to be initiated outside of a class go here
    //If they are initiated inside of a class, only the class can use it



    private ElapsedTime runtime = new ElapsedTime();

    //Booleans / Floats / Ints
    boolean debugMode;
    boolean selectButton1; //Controller1

    //Motors
    DcMotor motorWheelBackLeft;
    DcMotor motorWheelBackRight;

    //Time of OpMode
    int step1;
    int step2;


  //  DcMotor intake;
  //  DcMotor launcher;


    //--------------------------------------------------------------------------------------------------
    public void init(){ //This initiates variables and configures them

        //Wheels
        motorWheelBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
        motorWheelBackRight = hardwareMap.dcMotor.get("motorBackRight"); //Must be the exact same as the config file on phone

        motorWheelBackLeft.setDirection(DcMotor.Direction.REVERSE);

        /*This reverses the left motor so that
        when the motors are placed on the robot
        they move the robot forwards instead of
        in a circle.
        */

        //Launcher
       // intake = hardwareMap.dcMotor.get("intake"); //Again, must be exact same as phone's config
       // launcher = hardwareMap.dcMotor.get("launcher");

        //Debug Mode to help resolve errors
        debugMode = true; //During competition, turn this to false
       /* if (debugMode = true){ //telemetry SHOULD send data to the phone
            telemetry.addLine("Back Left Motor Speed | ")
                    .addData("Y value", leftWheel.getPower());
            telemetry.addLine("Back Right Motor Speed | ")
                    .addData("Y value", motorWheelBackRight.getPower());

            //This I will implement if I have enough spare time
        }
        */
    }
    //--------------------------------------------------------------------------------------------------
    public void loop(){ //Instructions to be executed
        step1 = 0; //This ensures that step2 doesn't start before 1
        //Step 1 of OpMode
       while ((runtime.seconds() < 3.0) ) {
           motorWheelBackLeft.setPower(1);
           motorWheelBackRight.setPower(1);
           try {
               wait(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
        step1 = 1;
        //Step 2
        while ((runtime.seconds() < 4.5) && (step1 == 1)){
            motorWheelBackLeft.setPower(1);
            motorWheelBackRight.setPower(-1);
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        step2 = 2;
        //Step 3


        //Bottom Intake
       // //launcher.setPower(1);

       // //launcher.setPower(0);


        //EMERGENCY EXIT

        selectButton1 = gamepad1.y;
        if (selectButton1 && debugMode) {
            telemetry.addLine("Emergency Stop Activated");
            telemetry.update();
            requestOpModeStop();
        }

    }

//--------------------------------------------------------------------------------------------------

    public void stop(){
    } //Nothing should be put in here; this tells the compiler that it’s safe to exit as all previous code was successfully executed

}