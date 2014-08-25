package com.trainingpartner.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trainingSchedules")
public class TrainingSchedule
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long trainingScheduleId;
	@Column(name="trainingScheduleName")
	String trainingScheduleName;
	@Column(name="trainingScheduleDescription")
	String trainingScheduleDescription;
	@Column(name="trainingScheduleExcersisesNumber")
	long trainingScheduleExcersisesNumber;
	
	
	public long getTrainingScheduleId() {
		return trainingScheduleId;
	}

	public void setTrainingScheduleId(long trainingScheduleId) {
		this.trainingScheduleId = trainingScheduleId;
	}

	public String getTrainingScheduleName() {
		return trainingScheduleName;
	}

	public void setTrainingScheduleName(String trainingScheduleName) {
		this.trainingScheduleName = trainingScheduleName;
	}

	public String getTrainingScheduleDescription() {
		return trainingScheduleDescription;
	}

	public void setTrainingScheduleDescription(String trainingScheduleDescription) {
		this.trainingScheduleDescription = trainingScheduleDescription;
	}

	public long getTrainingScheduleExcersisesNumber() {
		return trainingScheduleExcersisesNumber;
	}

	public void setTrainingScheduleExcersisesNumber(
			long trainingScheduleExcersisesNumber) {
		this.trainingScheduleExcersisesNumber = trainingScheduleExcersisesNumber;
	}

	
}
