// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static class IntakeConstants {
    public static final int intakeMotorID = 0;
    public static final int intakeDistanceSensorID = 0;
    public static final double intakeNoteThreshold = 0.0;
  }
  public static class IndexerConstants {
    public static final int indexerMotorID = 0;
    public static final int indexerDistanceSensorID = 0;
    public static final double indexerNoteThreshold = 0.0;
  }
  public static class ShooterConstants {
    public static final int shooterMotor1 = 0;
    public static final int shooterMotor2 = 0; //TODO: GIVE THESE ACTUAL NAMES
  }
  public static class ScoringConstants {
    public static final double intakeTargetSpeed = 0;
  }
	public static class DriverConstants {
		public static final int kDriverControllerPort = 0;
		public static final double joystickdeadzone = 0.1;

		public static double deadbandval(double val, double deadband) {
			return MathUtil.applyDeadband(val, deadband);
		}
	}
}
