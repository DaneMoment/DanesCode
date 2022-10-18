/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
//import java.util.Scanner;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
 
        private WPI_TalonSRX leftMotor, rightMotor;
        private VictorSPX backLeftMotor, backRightMotor;
        private WPI_VictorSPX ballIntake,ballLift;
        private DifferentialDrive tankDrive; 
        private XboxController driveStick;
        private XboxController driveStickPartTwo;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    //Scanner input = new Scanner(System.in);
    leftMotor = new WPI_TalonSRX(1);
    backLeftMotor = new VictorSPX(1);
    System.out.println("(o o)");
    System.out.println("/___\\");
    System.out.println("his name is bob");
    System.out.println("...");
    System.out.println("say hi to bob");
    rightMotor = new WPI_TalonSRX(2);
    backRightMotor = new VictorSPX(2);

    ballIntake = new WPI_VictorSPX(3);
    ballLift = new WPI_VictorSPX(4);

    backLeftMotor.follow(leftMotor);
    backRightMotor.follow(rightMotor);


    driveStickPartTwo = new XboxController(001);
    driveStick = new XboxController(000);
    tankDrive = new DifferentialDrive(leftMotor,rightMotor);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    if (driveStick.getBumper(Hand.kLeft)){
      tankDrive.arcadeDrive(-driveStick.getRawAxis(1)/1.5, driveStick.getRawAxis(4)/1.5);
    } else {
      tankDrive.arcadeDrive(-driveStick.getRawAxis(1), driveStick.getRawAxis(4));
    }
    if (driveStickPartTwo.getRawButtonPressed(1) == true){
        ballIntake.set(0.5); 
    }else if (driveStickPartTwo.getRawButtonReleased(1) == true) {
      ballIntake.set(0);
    }
    if(driveStickPartTwo.getRawButtonPressed(2) == true){
      ballLift.set(-0.5);
    }else if (driveStickPartTwo.getRawButtonReleased(2) == true) {
      ballLift.set(0);
    }
    }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}


