// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.InvertType;
import frc.robot.Constants.DriveBaseConstants;

public class DriveBase extends SubsystemBase {
  private final WPI_TalonSRX leftWheel = new WPI_TalonSRX(DriveBaseConstants.leftMotorPort);
  private final WPI_TalonSRX rightWheel = new WPI_TalonSRX(DriveBaseConstants.rightMotorPort); 
  private final DifferentialDrive differentialDrive = new DifferentialDrive(leftWheel, rightWheel);
  

  /** Creates a new ExampleSubsystem. */
  public DriveBase(){
    rightWheel.setInverted(InvertType.InvertMotorOutput);
  }

  public void drive(double speed, double rotation){
    differentialDrive.arcadeDrive(speed, rotation);
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
