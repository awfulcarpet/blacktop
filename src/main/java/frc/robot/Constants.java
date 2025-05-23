// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.config.ClosedLoopConfig;
import com.revrobotics.spark.config.EncoderConfig;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

 /* TODO: find all CAN ids for all motors */
public final class Constants {
	public static class DriverConstants {
		public static final int kDriverControllerPort = 0;
		public static final double joystickDeadzone = 0.1;

		public static double deadbandVal(double val, double deadband) {
			return MathUtil.applyDeadband(val, deadband);
		}
	}

	public static class IntakeConstants {
		public static final int intakeMotorID = 0;
		public static final int intakeDistanceSensorID = 0;

		public static final double intakeNoteThreshold = 0.0;
	}

	public static class IndexerConstants {
		public static final int indexRightID = 1;
		public static final int indexLeftID = 2;
		public static final int indexerDistanceSensorID = 0;

		public static final double indexerHasBallDistance = 30.0; /* TODO: find actual value */

		public static final SparkBaseConfig rightIndexConfig = new SparkMaxConfig()
			.inverted(false) /* counterclockwise */
			.idleMode(IdleMode.kBrake)
		;

		public static final SparkBaseConfig leftIndexConfig = new SparkMaxConfig()
			.follow(indexRightID, true)
		;
	}

	public static class ShooterConstants {
		public static final int shooterMotorID = 0;

		public static final double speedError = 5;

		public static final SparkBaseConfig shooterConfigs = new SparkMaxConfig()
			.inverted(true) // TODO: verify that invecrted means counterclocwise
			.idleMode(IdleMode.kBrake)
			.apply(new EncoderConfig()
					.velocityConversionFactor(1) // TODO: find ratio between inside of spark and wheels
			)
			.apply(new ClosedLoopConfig()
					.pidf(0, 0, 0, 0, ClosedLoopSlot.kSlot0)
			)
		;
	}

	public static class ScoringConstants {
		public static final double intakeTargetSpeed = 0;
	}

	public static final class DriveConstants {
		// Driving Parameters - Note that these are not the maximum capable speeds of
		// the robot, rather the allowed maximum speeds
		public static final double kMaxSpeedMetersPerSecond = 4.8;
		public static final double kMaxAngularSpeed = 2 * Math.PI; // radians per second

		// Chassis configuration
		public static final double kTrackWidth = Units.inchesToMeters(26.5);
		// Distance between centers of right and left wheels on robot
		public static final double kWheelBase = Units.inchesToMeters(26.5);
		// Distance between front and back wheels on robot
		// TODO: find actual values
		public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
				new Translation2d(kWheelBase / 2, kTrackWidth / 2),
				new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
				new Translation2d(-kWheelBase / 2, kTrackWidth / 2),
				new Translation2d(-kWheelBase / 2, -kTrackWidth / 2));

		// Angular offsets of the modules relative to the chassis in radians
		// TODO: Tune
		public static final double kFrontLeftChassisAngularOffset = 0;
		public static final double kFrontRightChassisAngularOffset = 0;
		public static final double kBackLeftChassisAngularOffset = 0;
		public static final double kBackRightChassisAngularOffset = 0;

		// SPARK MAX CAN IDs
		public static final int kFrontLeftDrivingCanId = 11;
		public static final int kRearLeftDrivingCanId = 13;
		public static final int kFrontRightDrivingCanId = 15;
		public static final int kRearRightDrivingCanId = 17;

		public static final int kFrontLeftTurningCanId = 10;
		public static final int kRearLeftTurningCanId = 12;
		public static final int kFrontRightTurningCanId = 14;
		public static final int kRearRightTurningCanId = 16;

		public static final int kFrontLeftEncoderId = 18;

		public static final int kPigeonId = 22;

		public static final boolean kGyroReversed = false;
	}

	public static final class ModuleConstants {
		// The MAXSwerve module can be configured with one of three pinion gears: 12T,
		// 13T, or 14T. This changes the drive speed of the module (a pinion gear with
		// more teeth will result in a robot that drives faster).
		public static final int kDrivingMotorPinionTeeth = 14;

		// Calculations required for driving motor conversion factors and feed forward
		public static final double kDrivingMotorFreeSpeedRps = NeoMotorConstants.kFreeSpeedRpm / 60;
		public static final double kWheelDiameterMeters = Units.inchesToMeters(4);
		public static final double kWheelCircumferenceMeters = kWheelDiameterMeters * Math.PI;
		// 45 teeth on the wheel's bevel gear, 22 teeth on the first-stage spur gear, 15
		// teeth on the bevel pinion
		public static final double kDrivingMotorReduction = (45.0 * 22) / (kDrivingMotorPinionTeeth * 15);
		public static final double kDriveWheelFreeSpeedRps = (kDrivingMotorFreeSpeedRps * kWheelCircumferenceMeters)
				/ kDrivingMotorReduction;
	}

	public static final class AutoConstants {
		public static final double kMaxSpeedMetersPerSecond = 3;
		public static final double kMaxAccelerationMetersPerSecondSquared = 3;
		public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
		public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;

		public static final double kPXController = 1;
		public static final double kPYController = 1;
		public static final double kPThetaController = 1;

		// Constraint for the motion profiled robot angle controller
		public static final TrapezoidProfile.Constraints kThetaControllerConstraints = new TrapezoidProfile.Constraints(
				kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
	}

	public static final class NeoMotorConstants {
		public static final double kFreeSpeedRpm = 5676;
	}
}
