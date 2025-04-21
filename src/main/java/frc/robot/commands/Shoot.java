// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class Shoot extends Command {
	private Shooter shooter;
	private double percent;
	private double rpm;

	public Shoot(Shooter shooter, double percent, double rpm) {
		this.shooter = shooter;
		this.percent = percent;
		this.rpm = rpm;
		addRequirements(shooter);
	}

	@Override
	public void initialize() {
		// TODO: calculate with distance from hoop
		shooter.setHoodCoverPercent(percent);
		shooter.setSpeed(rpm);
	}

	@Override
	public void execute() {
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
