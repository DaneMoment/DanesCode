
package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot {

  private WPI_VictorSPX leftMotor, rightMotor;
  private XboxController stick;
  private DifferentialDrive tankDrive;


  @Override
  public void robotInit() {
    leftMotor = new WPI_VictorSPX(1);
    rightMotor = new WPI_VictorSPX(2);
    stick = new XboxController(0);
    tankDrive = DifferentialDrive(leftMotor, rightMotor);

  }

  private DifferentialDrive DifferentialDrive(WPI_VictorSPX leftMotor2, WPI_VictorSPX rightMotor2) {
    return null;
  }

  @Override
  public void robotPeriodic() {
    tankDrive.arcadeDrive(-stick.getRawAxis(1) / 2, stick.getRawAxis(4) /2);
  }

  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void testPeriodic() {

  }
}
