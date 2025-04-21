// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends SubsystemBase {
	private SparkMax shootMotor = new SparkMax(2, MotorType.kBrushless);
	private SparkClosedLoopController shootPID = shootMotor.getClosedLoopController();
	private Servo hoodController = new Servo(9);

	private double target_rpm = 0;

	/** Creates a new Shooter. */
	public Shooter() {
		shootMotor.configure(ShooterConstants.shooterConfigs, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
		hoodController.setBoundsMicroseconds(2000, 1800, 1500, 1200, 1000);
		// hoodController.setBoundsMicroseconds(2400, 2000, 1500, 1000, 600);
	}

	public void setHoodCoverPercent(double percent) {
		/* setSpeed uses range of -1 and 1 for position, with 0 being midway out */
		hoodController.setSpeed((percent * 2.0) - 1.0);
	}

	public void setSpeed(double rpm) {
		target_rpm = rpm;
		shootPID.setReference(target_rpm, SparkMax.ControlType.kVelocity);
	}

	public double getSpeed() {
		return shootMotor.getEncoder().getVelocity();
	}

	public double getSpeedError() {
		return getSpeed() - target_rpm;
	}

	@Override
	public void periodic() {
	}
}
