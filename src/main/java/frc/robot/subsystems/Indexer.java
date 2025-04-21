// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Volts;

import com.playingwithfusion.TimeOfFlight;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IndexerConstants;

@Logged
public class Indexer extends SubsystemBase {
	private SparkMax indexLeader = new SparkMax(IndexerConstants.indexRightID, MotorType.kBrushless);
	private SparkMax indexFollower = new SparkMax(IndexerConstants.indexLeftID, MotorType.kBrushless);

	private TimeOfFlight indexerDistanceSensor = new TimeOfFlight(IndexerConstants.indexerDistanceSensorID);

	private Voltage target_volts = Volts.zero();

	/** Creates a new Indexer. */
	public Indexer() {
		indexLeader.configure(IndexerConstants.rightIndexConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
		indexFollower.configure(IndexerConstants.leftIndexConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
	}

	/* positive voltage will run the indexer towards the inside of the robot */
	public void runIndexer(Voltage volts) {
		target_volts = volts;
		indexLeader.setVoltage(target_volts);
	}

	public void disable() {
		runIndexer(Volts.of(0));
	}

	public boolean isNotePresent() {
		return indexerDistanceSensor.getRange() < IndexerConstants.indexerHasBallDistance;
	}

	@Override
	public void periodic() {
		/* this must be called periodically for voltage compensation to work */
		indexLeader.setVoltage(target_volts);
	}
}
