// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.ControllerConstants;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.Autos;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ClawCommand;
import frc.robot.commands.MoveArmCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DriveBase;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ClawSubsystem clawSubsystem = new ClawSubsystem();
  private final DriveBase driveBaseSubsystem = new DriveBase();
  private final ArmSubsystem armSubsystem = new ArmSubsystem();
  private final CommandXboxController driverController = new CommandXboxController(ControllerConstants.driverControllerPort);
  private final CommandXboxController manipulatorController = new CommandXboxController(ControllerConstants.manipulatorControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    driveBaseSubsystem.setDefaultCommand(new ArcadeDriveCommand(driveBaseSubsystem, () -> driverController.getRightTriggerAxis(), () -> driverController.getLeftX(), () -> driverController.getLeftTriggerAxis()));
    armSubsystem.setDefaultCommand(new MoveArmCommand(armSubsystem, () -> manipulatorController.getLeftY()));
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {  
    manipulatorController.leftBumper().whileTrue(new ClawCommand(clawSubsystem, false));
    manipulatorController.rightBumper().whileTrue(new ClawCommand(clawSubsystem, true));
  }

  public Command getAutonomousCommand(){
    return Autos.LeaveAutonomous(driveBaseSubsystem);
  }
}
