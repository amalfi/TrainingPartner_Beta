package com.trainingpartner.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trainings")
public class Training 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long trainingId;
	@Column(name="trainingDiary")
	String trainingDiary;
	@Column(name="trainingSchedule")
	String trainingSchedule;
	@Column(name="trainingExcersises")
	String trainingExcersises;
	@Column(name="trainingDescription")
	String trainingDescription;
	
	
	public long getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(long trainingId) {
		this.trainingId = trainingId;
	}
	public String getTrainingDiary() {
		return trainingDiary;
	}
	public void setTrainingDiary(String trainingDiary) {
		this.trainingDiary = trainingDiary;
	}
	public String getTrainingSchedule() {
		return trainingSchedule;
	}
	public void setTrainingSchedule(String trainingSchedule) {
		this.trainingSchedule = trainingSchedule;
	}
	public String getTrainingExcersises() {
		return trainingExcersises;
	}
	public void setTrainingExcersises(String trainingExcersises) {
		this.trainingExcersises = trainingExcersises;
	}
	public String getTrainingDescription() {
		return trainingDescription;
	}
	public void setTrainingDescription(String trainingDescription) {
		this.trainingDescription = trainingDescription;
	}

	
}
