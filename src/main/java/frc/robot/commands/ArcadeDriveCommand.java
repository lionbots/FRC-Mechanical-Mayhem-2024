package frc.robot.commands;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveBase;

public class ArcadeDriveCommand extends Command{
  private Supplier<Double> speed;
  private Supplier<Double> rotation;
  // private Supplier<Double> /
  private Supplier<Double> backwardsSpeed;

  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveBase driveBase;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ArcadeDriveCommand(DriveBase driveBase, Supplier<Double> speed, Supplier<Double> rotation, Supplier<Double> backwardsSpeed) {
    this.driveBase = driveBase;
    this.speed = speed;
    this.rotation = rotation;
    this.backwardsSpeed = backwardsSpeed;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveBase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (speed.get() > 0) {
      driveBase.drive(speed.get(), rotation.get()/3);
    } else {
      driveBase.drive(backwardsSpeed.get() * -1, rotation.get()/3);
    }
    // driveBase.drive(speed.get(), rotation.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
