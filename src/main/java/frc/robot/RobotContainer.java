// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.DriverConstants;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Swerve;

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

	// private final Swerve swerve = new Swerve(new File(Filesystem.getDeployDirectory(), "swerve"));
	// private final Shooter shooter = new Shooter();

	private Trigger resetGyro = new Trigger(() -> drivController.getYButton());
	private Trigger test = new Trigger(() -> drivController.getBButton());

	public RobotContainer() {
		// Configure the trigger bindings
		configureBindings();
	}

	/**
	 * Use this method to define your trigger->command mappings. Triggers can be
	 * created via the
	 * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
	 * an arbitrary
	 * predicate, or via the named factories in {@link
	 * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
	 * {@link
	 * CommandXboxController
	 * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
	 * PS4} controllers or
	 * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
	 * joysticks}.
	 */
	private void configureBindings() {
		// resetGyro.onTrue(Commands.runOnce(() -> swerve.resetGyro(), swerve));
		// test.whileTrue(shooter.test());
		// swerve.setDefaultCommand(swerve.drive(leftY, leftX, rightX, () -> true, () -> false));
		// shooter.setDefaultCommand(shooter.test());
	}

	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousCommand() {
		// return swerve.drive(() -> 1.0, () -> 0.0, () -> 0.0, () -> true, () -> false);
		//return Commands.runOnce(() -> servo.setSpeed(1)).andThen(Commands.waitSeconds(1)).andThen(Commands.runOnce(() -> servo.setSpeed(-1)));
		return Commands.none();
	}
}
