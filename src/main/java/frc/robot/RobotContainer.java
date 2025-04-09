// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.DriverConstants;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.Shooter;

import java.io.File;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
	private final XboxController driveController = new XboxController(DriverConstants.kDriverControllerPort);

	public Supplier<Double> leftX = () -> DriverConstants.deadbandVal(-driveController.getLeftX(), DriverConstants.joystickDeadzone);
	public Supplier<Double> leftY = () -> DriverConstants.deadbandVal(-driveController.getLeftY(), DriverConstants.joystickDeadzone);
	public Supplier<Double> rightX = () -> DriverConstants.deadbandVal(-driveController.getRightX(), DriverConstants.joystickDeadzone);

	private final Shooter shooter = new Shooter();

	// private Trigger resetGyro = new Trigger(() -> driveController.getYButton());
	private Trigger shoot = new Trigger(() -> driveController.getYButton());

	public RobotContainer() {
		// Configure the trigger bindings
		configureBindings();
	}

	private void configureBindings() {
		shoot.onTrue(new Shoot(shooter));
		// swerve.setDefaultCommand(swerve.drive(leftY, leftX, rightX, () -> true, () -> false));
	}

	public Command getAutonomousCommand() {
		return Commands.none();
	}
}
