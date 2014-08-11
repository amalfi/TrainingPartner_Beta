package com.trainingpartner.models;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TrainingDiary 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer diaryId;
	private String diaryName;
	private List<String> trainingsIds; //ids of trainings from db (sequence?)
	private String diaryCreator; //creator username
	private String diaryCreationDate; //
	private String diaryDescription;
	private String trainingProgram;
	
	public Integer getDiaryId() 
	{
		return diaryId;
	}
	public void setDiaryId(Integer diaryId) {
		this.diaryId = diaryId;
	}
	public String getDiaryName() {
		return diaryName;
	}
	public void setDiaryName(String diaryName) {
		this.diaryName = diaryName;
	}
	public List<String> getTrainingsIds() {
		return trainingsIds;
	}
	public void setTrainingsIds(List<String> trainingsIds) {
		this.trainingsIds = trainingsIds;
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
