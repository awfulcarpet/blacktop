// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ScoringConstants;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class IntakeBasketball extends Command {
  private Intake intake;
  private Indexer indexer;
  /** Creates a new IntakeBasketball. */
  public IntakeBasketball(Intake intake, Indexer indexer) {
    this.intake = intake;
    this.indexer = indexer;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake, indexer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!indexer.isNotePresent() && !intake.isNotePresent()) {
        intake.runIntake(ScoringConstants.intakeTargetSpeed);
    } 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.disable();
    indexer.disable();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return indexer.isNotePresent();
  }
}
