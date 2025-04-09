// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.io.File;
import java.util.function.Supplier;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Swerve extends SubsystemBase {
	private final double maxSpeed = 5;

	/** Creates a new Swerve. */
	public Swerve(File dir) {
	}

	public void resetGyro() {
	}

	public Command drive(Supplier<Double> x, Supplier<Double> y, Supplier<Double> rotation, Supplier<Boolean> fieldRelative, Supplier<Boolean> openLoop) {
		return Commands.none();
	}

	public void fieldRelativeDrive(ChassisSpeeds vel) {
	}

	@Override
	public void periodic() {
	}
}
