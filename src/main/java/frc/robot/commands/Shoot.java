// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.lib.util.LimelightHelpers;
import frc.robot.subsystems.Shooter;

public class Shoot extends Command {
	private Shooter shooter;

	public Shoot(Shooter shooter) {
		this.shooter = shooter;
		addRequirements(shooter);
	}

	@Override
	public void initialize() {
		// TODO: calculate with distance from hoop
		shooter.setHoodCoverPercent(1.0);
	}

	@Override
	public void execute() {
	}

	@Override
	public void end(boolean interrupted) {
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
