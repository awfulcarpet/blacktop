// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;

public class Shooter extends SubsystemBase {
	private SparkMax turnmotor = new SparkMax(2, MotorType.kBrushless);
	private SparkMax shootermotor = new SparkMax(1, MotorType.kBrushless);

  /** Creates a new Shooter. */
  public Shooter() {}

  public Command test() {
	return run(() -> {
	turnmotor.setVoltage(1);
	shootermotor.setVoltage(1);
  });
  }
  public Command stop() {
	return run(() ->{
	turnmotor.setVoltage(0);
	shootermotor.setVoltage(0);
  });
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
