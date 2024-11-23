// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants.DriveBaseConstants;

public class DriveBase extends SubsystemBase {
  private final TalonSRX leftWheel = new TalonSRX(DriveBaseConstants.leftMotorPort);
  private final TalonSRX rightWheel = new TalonSRX(DriveBaseConstants.rightMotorPort); 
  // private final DifferentialDrive differentialDrive = new DifferentialDrive(leftWheel, rightWheel);
  

  /** Creates a new ExampleSubsystem. */
  public DriveBase(){
    
  }

  public void drive(double leftSpeed, double rightSpeed){
    leftWheel.set(TalonSRXControlMode.PercentOutput, leftSpeed);
    rightWheel.set(TalonSRXControlMode.PercentOutput, rightSpeed);
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
