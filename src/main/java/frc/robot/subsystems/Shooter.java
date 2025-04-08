// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.Command;

public class Shooter extends SubsystemBase {
	private SparkMax turnmotor = new SparkMax(2, MotorType.kBrushless);
	private Servo hoodController = new Servo(9);

	/** Creates a new Shooter. */
	public Shooter() {
		hoodController.setBoundsMicroseconds(2000, 1800, 1500, 1200, 1000);
		// hoodController.setBoundsMicroseconds(2400, 2000, 1500, 1000, 600);
	}

	public Command setHoodCoverPercent(double percent) {
		return run(() -> {
			hoodController.setSpeed(percent);
		});
	}

	public double getHoodAngle() {
		return 0.0;
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}
