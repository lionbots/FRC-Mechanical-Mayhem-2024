// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class ArmSubsystem extends SubsystemBase {
  // This represents the motor control for the arm motor
  private final CANSparkMax armMotor = new CANSparkMax(0, MotorType.kBrushed);
  /** Creates a new ExampleSubsystem. */
  public ArmSubsystem() {
    //Sets the current limit to 30 amps and sets the motor to brake mode
    armMotor.setSmartCurrentLimit(30);
    armMotor.setIdleMode(IdleMode.kBrake);
  }

  // This method sets motor movement speed
  public void moveMotor(double speed) {
    armMotor.set(speed);
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