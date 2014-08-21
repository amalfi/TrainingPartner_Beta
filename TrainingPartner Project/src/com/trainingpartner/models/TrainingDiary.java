package com.trainingpartner.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diaries")
public class TrainingDiary 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long diaryId;
	@Column(name="diaryName")
	private String diaryName;
	@Column(name="trainingsIds")
	private String trainingsIds; //ids of trainings from db (sequence?)
	@Column(name="diaryCreator")
	private String diaryCreator; //creator username
	@Column(name="diaryCreationDate")
	private String diaryCreationDate; //
	@Column(name="diaryDescription")
	private String diaryDescription;
	@Column(name="trainingProgram")
	private String trainingProgram;
	

	public String getTrainingsIds() {
		return trainingsIds;
	}
	public void setTrainingsIds(String trainingsIds) {
		this.trainingsIds = trainingsIds;
	}
	public long getDiaryId() {
		return diaryId;
	}
	public void setDiaryId(long diaryId) {
		this.diaryId = diaryId;
	}
	public String getDiaryName() {
		return diaryName;
	}
	public void setDiaryName(String diaryName) {
		this.diaryName = diaryName;
	}
	public String getDiaryCreator() {
		return diaryCreator;
	}
	public void setDiaryCreator(String diaryCreator) {
		this.diaryCreator = diaryCreator;
	}
	public String getDiaryCreationDate() {
		return diaryCreationDate;
	}
	public void setDiaryCreationDate(String diaryCreationDate) {
		this.diaryCreationDate = diaryCreationDate;
	}
	public String getDiaryDescription() {
		return diaryDescription;
	}
	public void setDiaryDescription(String diaryDescription) {
		this.diaryDescription = diaryDescription;
	}
	public String getTrainingProgram() {
		return trainingProgram;
	}
	public void setTrainingProgram(String trainingProgram) {
		this.trainingProgram = trainingProgram;
	}
	
	
}
