package org.firstinspires.ftc.teamcode.nonCompetition;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardwareMapCompetition;

@Disabled
@Autonomous(name = "Test Auto")
public class autoTest extends LinearOpMode {
    hardwareMapCompetition robot   = new hardwareMapCompetition();
    private ElapsedTime    runtime = new ElapsedTime();

    double forward     = 1;  //For actual autonomous
    double reverse     = -1; //For actual autonomous
    double forwardHalf = 0.5;
    double reverseHalf = -0.5;
    double turnSpeed   = 0.5;

    public void runOpMode() throws InterruptedException {
        //Initialize hardware map
        robot.init(hardwareMap);
        telemetry.addData("Status:","Waiting for start command");
        telemetry.update();

        waitForStart();

        //Drive forwards at half speed for 1 second
        runtime.reset();
        telemetry.addData("Status:", "Starting step 1");
        telemetry.update();
        while(opModeIsActive() && (runtime.seconds() < 1)){
            robot.leftWheel.setPower(forwardHalf);
            robot.rightWheel.setPower(forwardHalf);
        }

        //Turn for half a second
        runtime.reset();
        telemetry.addData("Status:", "Starting step 2");
        telemetry.update();
        while(opModeIsActive() && (runtime.seconds() < 0.5)){
            robot.leftWheel.setPower(turnSpeed);
            robot.rightWheel.setPower(-turnSpeed);
            idle();
        }

        //Reverse at half speed for 1 second
        runtime.reset();
        telemetry.addData("Status:", "Starting step 3");
        telemetry.update();
        while(opModeIsActive() && (runtime.seconds() < 1)){
            robot.leftWheel.setPower(reverseHalf);
            robot.rightWheel.setPower(reverseHalf);
            idle();
        }

        //End
        telemetry.addLine("AUTONOMOUS COMPLETE");
        telemetry.update();
        sleep(1000);
        idle();
    }
   }