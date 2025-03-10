// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.io.File;
import java.util.function.Supplier;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import swervelib.SwerveDrive;
import swervelib.parser.SwerveParser;
import swervelib.telemetry.SwerveDriveTelemetry;
import swervelib.telemetry.SwerveDriveTelemetry.TelemetryVerbosity;

public class Swerve extends SubsystemBase {
	private final SwerveDrive swerve;
	private final double maxSpeed = 5;

	/** Creates a new Swerve. */
	public Swerve(File dir) {
		 SwerveDriveTelemetry.verbosity = TelemetryVerbosity.HIGH;
		try {
			swerve = new SwerveParser(dir).createSwerveDrive(maxSpeed);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void simulationPeriodic() {
		swerve.setHeadingCorrection(false);
		swerve.setCosineCompensator(false);
	}

	public Command drive(Supplier<Double> x, Supplier<Double> y, Supplier<Double> rotation, boolean fieldRelative) {
		return run(() -> {
			swerve.drive(new Translation2d(x.get(), y.get()), rotation.get(), fieldRelative, false);
		});
	}

	@Override
	public void periodic() {
		SmartDashboard.putNumber("gyro", swerve.getGyroRotation3d().getZ());
	}
}
