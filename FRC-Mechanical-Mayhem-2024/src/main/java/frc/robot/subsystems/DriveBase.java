// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;

public class DriveBase extends SubsystemBase {
  private final PWMTalonSRX leftWheel = new PWMTalonSRX(0);
  private final PWMTalonSRX rightWheel = new PWMTalonSRX(0); // 0 is used as a placeholder for the device number
  private final DifferentialDrive differentialDrive = new DifferentialDrive(leftWheel, rightWheel);

  /** Creates a new ExampleSubsystem. */
  public DriveBase(){
    
  }

  public void drive(double speed, double rotation){
    differentialDrive.arcadeDrive(rotation, speed);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
