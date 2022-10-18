package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Robot extends TimedRobot {
  // Variable / Object Declarations
  // Compressor c;
  XboxController driveController;
  Solenoid testSol, shootSol;
  TalonSRX turret;
  //hmmm variabkle
  
  @Override
  public void robotInit() {
    //   o
    driveController = new XboxController(0);
    testSol = new Solenoid(1);
    turret = new TalonSRX(3);
    turret.setNeutralMode(NeutralMode.Brake);
    turret.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    //loadSol = new Solenoid(1);
    shootSol = new Solenoid(2);
    // c = new Compressor();
  }

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void autonomousInit() {
    
  }

  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopInit() {
    turret.setSelectedSensorPosition(0);
  }

  @Override
  public void teleopPeriodic() {
    System.out.println(driveController.getPOV());
    if (driveController.getAButton()) {
      testSol.set(true);
    } else {
      testSol.set(false);
    }

    if (driveController.getPOV() == 90) {
      turret.set(ControlMode.Position, -68000);
    } else if (driveController.getPOV() == 180) {
      turret.set(ControlMode.Position, 0);
    } else if (driveController.getPOV() == 270){
      turret.set(ControlMode.Position, 68000);
    } else if (driveController.getX(Hand.kRight) > .2) {
      turret.set(ControlMode.PercentOutput, .2);
    } else if (driveController.getX(Hand.kRight) < -.2) {
      turret.set(ControlMode.PercentOutput, -.2);
    } else {
      turret.set(ControlMode.PercentOutput, driveController.getX(Hand.kRight));
    }
    

    // if (driveController.getBButton()) {
    //   loadSol.set(true);
    // } else {
    //   loadSol.set(false);
    // }

    if (driveController.getXButton() && driveController.getYButton()) {
      shootSol.set(true);
    } else {
      shootSol.set(false);
    }
  }
}
//:) this is literally 1984


//Hello past me
// bob
//(o o)
///   \
// have a nice day