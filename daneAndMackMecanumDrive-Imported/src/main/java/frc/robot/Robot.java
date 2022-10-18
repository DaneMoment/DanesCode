
package frc.robot;

//yooo robot
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class Robot extends TimedRobot {
  // Variable / Object Declarations
  private MecanumDrive robotDrive;
  private XboxController driveStick;
  private WPI_VictorSPX frontLeft, rearLeft, frontRight, rearRight;

  @Override
  public void robotInit() {
    frontLeft = new WPI_VictorSPX(1);
    rearLeft = new WPI_VictorSPX(2);
    frontRight = new WPI_VictorSPX(0);
    rearRight = new WPI_VictorSPX(4);

    driveStick = new XboxController(0);

    robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
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
    
  }

  @Override
  public void teleopPeriodic() {
   
  }
}

