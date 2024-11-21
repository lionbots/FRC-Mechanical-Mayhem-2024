// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveBase;
import edu.wpi.first.wpilibj.Timer;

/** An example command that uses an example subsystem. */
public class LeaveStart extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveBase driveBase; //Represents the drive base subsystem
  private final Timer timer = new Timer(); //Represents the timer to time our autonomous 

  /**
   * Creates a new LeaveStart command 
   *
   * @param driveBase The subsystem used by this command.
   */
  public LeaveStart(DriveBase driveBase) {
    this.driveBase = driveBase;
    

  }

  // Starts the timer when the command is first scheduled
  @Override
  public void initialize() {
    timer.start();
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Drives the robot backwards
    driveBase.drive(-1, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
