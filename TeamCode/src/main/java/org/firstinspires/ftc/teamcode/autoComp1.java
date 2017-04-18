package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "CompCodeREDLEFT")
public class autoComp1 extends LinearOpMode {
    hardwareMapCompetition robot = new hardwareMapCompetition();
    private ElapsedTime runtime = new ElapsedTime();

    double turn     = 0.3;
    double forward  = 0.1;
    public void runOpMode() throws InterruptedException {
       //Init hardware map
        robot.init(hardwareMap);
        telemetry.addData("Status:","Waiting for start command");
        telemetry.update();

        waitForStart();

        //Step 1
        runtime.reset();
        while(opModeIsActive() && (runtime.seconds() < 5)) {
            robot.leftWheel.setPower(forward);
            robot.rightWheel.setPower(forward);
        }

        //Step 5
        telemetry.addLine("Autonomous Complete");
        telemetry.update();
        idle();
    }
}