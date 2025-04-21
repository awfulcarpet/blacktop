// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static edu.wpi.first.units.Units.Volts;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;

public class Shoot extends Command {
	private Shooter shooter;
	private Indexer indexer;
	private double percent;
	private double rpm;

	public Shoot(Shooter shooter, Indexer indexer, double percent, double rpm) {
		this.shooter = shooter;
		this.indexer = indexer;
		this.percent = percent;
		this.rpm = rpm;
		addRequirements(shooter, indexer);
	}

	@Override
	public void initialize() {
		// TODO: calculate with distance from hoop
		shooter.setHoodCoverPercent(percent);
		shooter.setSpeed(rpm);
	}

	@Override
	public void execute() {
		if (shooter.isAtSetpoint()) {
			indexer.runIndexer(Volts.of(5));
		}
	}

	@Override
	public void end(boolean interrupted) {
		shooter.stop();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
