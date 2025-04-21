// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.playingwithfusion.TimeOfFlight;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IndexerConstants;

@Logged
public class Indexer extends SubsystemBase {
  private SparkMax indexerMotorSparkMax = new SparkMax(IndexerConstants.indexerMotorID, MotorType.kBrushless);
  private TimeOfFlight indexerDistanceSensor = new TimeOfFlight(IndexerConstants.indexerDistanceSensorID);
  /** Creates a new Indexer. */
  public Indexer() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runIndexer (double speed) {
    indexerMotorSparkMax.set(speed);
  }
  public void disable() {
    runIndexer(0);
  }
  public boolean isNotePresent() {
    return indexerDistanceSensor.getRange() < IndexerConstants.indexerNoteThreshold;
  }
}
