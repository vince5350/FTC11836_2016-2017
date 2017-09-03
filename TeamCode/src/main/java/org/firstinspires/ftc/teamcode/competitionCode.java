package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Competition Driver Period")
public class competitionCode extends OpMode {
    public competitionCode(){/*Nothing needs to be put here*/} 

    //Variables to be initiated outside of a class go here
    //If they are initiated inside of a class that's private,
    //only that class can use it

    //Booleans / Floats / Ints
    double position1;
    double position2;
    boolean debugMode;
    boolean hooked;
    hardwareMapCompetition robot = new hardwareMapCompetition();

    public void init(){
        //This initiates variables and configures them if they weren't put in a hardware map
        robot.init(hardwareMap);
        position1 = 1;
        position2 = 0;
    }

    public void loop(){ //Instructions to be executed
        //Debug Mode to help resolve errors
        //TODO: [DONE] CHANGE THIS TO FALSE!
        debugMode = false; //During competition, turn this to false
        if (debugMode){ //Telemetry sends data to the phone
            telemetry.addLine("Left Motor| ")
                    .addData("Y value", robot.leftWheel.getPower());
            telemetry.addLine("Right Motor| ")
                    .addData("Y value", robot.rightWheel.getPower());
            telemetry.addLine("Hook| ")
                    .addData("Position", robot.hook.getPosition());
            telemetry.update();
        }

        //Wheels
        float lStickX, lTrigger, rTrigger;
        boolean slow;
        lStickX  = gamepad1.left_stick_x;
        lTrigger = gamepad1.left_trigger;
        rTrigger = gamepad1.right_trigger;
        slow     = gamepad1.x;

        lStickX = Range.clip(lStickX, -1, 1);
        lTrigger = Range.clip(lTrigger, 0, 1);
        rTrigger = Range.clip(rTrigger, 0, 1);

            //Set #1 of 18/36
        if(!slow) {
            robot.leftWheel.setPower(lStickX - rTrigger + lTrigger);
            robot.rightWheel.setPower(-lStickX - rTrigger + lTrigger);
        }
        else{
            robot.leftWheel.setPower((lStickX - rTrigger + lTrigger) / 2);
            robot.rightWheel.setPower((-lStickX - rTrigger + lTrigger) / 2);
        }

        //Intake
        boolean dpadLeft;
        dpadLeft = gamepad1.dpad_left;

        if(dpadLeft){
            robot.intake.setPower(1);
        }
        else{
            robot.intake.setPower(0);
        }

        //Uptake
        boolean rBumper, lBumper;
        rBumper = gamepad1.right_bumper;
        lBumper = gamepad1.left_bumper;

        if (rBumper){
            robot.uptake.setPower(1);
        }
        if (lBumper){
            robot.uptake.setPower(0);
        }

        //Flipper
        boolean flip;
        boolean reve;
        flip = gamepad1.a;
        reve = gamepad1.b;
        if(reve){
            robot.flipper.setPower(-1);
        }
        if (flip){
            robot.flipper.setPower(1);
        }
        else {
            robot.flipper.setPower(0);
        }

        //Hook
        boolean hookRelease;
        hookRelease = gamepad1.right_stick_button;
        hooked = false;
        if (hookRelease && (!hooked)){
            robot.hook.setPosition(position1);
            hooked = true;
        }
        if (hookRelease && (hooked)){
            robot.hook.setPosition(position2);
            hooked = false;
        }

        //Lift
        boolean up;
        boolean down;
        up = gamepad1.dpad_up;
        down = gamepad1.dpad_down;

        if(up){
            robot.lift.setPower(-1);
        }
        if(down){
            robot.lift.setPower(1);
        }
        else{
            robot.lift.setPower(0);
        }

        //EMERGENCY EXIT
        boolean y;
        y = gamepad1.y;
        if (y && (debugMode = true)) {
            telemetry.addLine("Emergency exit");
            telemetry.update();
            requestOpModeStop(); //Stops the code due to driver pressing button
        }
    }
//--------------------------------------------------------------------------------------------------
    //Nothing should be put in here; this tells the compiler
    // that it’s safe to exit as all previous code was
    // successfully executed.
    public void stop(){
    }

}
