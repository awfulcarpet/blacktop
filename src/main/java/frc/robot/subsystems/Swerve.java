// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.io.File;
import java.util.function.Supplier;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.RobotBase;
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

		swerve.resetOdometry(new Pose2d(5, 5, Rotation2d.kZero));

		if (RobotBase.isSimulation()) {
			swerve.setHeadingCorrection(false);
			swerve.setCosineCompensator(false);
		}
	}

	public void resetGyro() {
		swerve.setGyro(Rotation3d.kZero);
		swerve.resetOdometry(new Pose2d(5, 5, Rotation2d.kZero));
	}

	public Command drive(Supplier<Double> x, Supplier<Double> y, Supplier<Double> rotation, Supplier<Boolean> fieldRelative, Supplier<Boolean> openLoop) {
		return run(() -> {
			swerve.drive(new Translation2d(x.get(), y.get()), rotation.get(), fieldRelative.get(), openLoop.get());
		});
	}

	public void fieldRelativeDrive(ChassisSpeeds vel) {
		swerve.driveFieldOriented(vel);
	}

	@Override
	public void periodic() {
		SmartDashboard.putNumber("gyro", swerve.getGyroRotation3d().getZ());
	}
}
