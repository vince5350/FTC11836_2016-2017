package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Disabled
@Autonomous (name = "CompCodeREDRIGHT")
public class autoComp2 extends LinearOpMode {
    hardwareMapCompetition robot = new hardwareMapCompetition();
    private ElapsedTime runtime = new ElapsedTime();

    double turn     = -0.5;
    double forward  = -0.5;
    public void runOpMode() throws InterruptedException {
       //Init hardware map
        robot.init(hardwareMap);
        telemetry.addData("Status:","Waiting for start command");
        telemetry.update();

        waitForStart();

        //Step 1
        runtime.reset();
        while(opModeIsActive() && (runtime.milliseconds() < 1650)){
            robot.leftWheel.setPower(forward);
            robot.rightWheel.setPower(forward);
        }

        //Step 2
        runtime.reset();
        while(opModeIsActive() && (runtime.milliseconds() < 1650)){
            robot.leftWheel.setPower(turn);
            robot.rightWheel.setPower(forward);
        }

        //Step 3
        runtime.reset();
        while(opModeIsActive() && (runtime.milliseconds() < 1650)){
            robot.leftWheel.setPower(forward);
            robot.rightWheel.setPower(forward);
        }

        //Step 4
        telemetry.addLine("Autonomous Complete");
        telemetry.update();
        idle();
    }
}