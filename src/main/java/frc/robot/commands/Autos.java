// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveBase;
import edu.wpi.first.wpilibj2.command.Command;

public final class Autos {
  /** This makes the robot back out of the starting area for 1.5 seconds */
  public static Command LeaveAutonomous(DriveBase driveBase) {
    return new LeaveStart(driveBase);

  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
