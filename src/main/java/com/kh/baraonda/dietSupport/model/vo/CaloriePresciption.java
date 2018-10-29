package com.kh.baraonda.dietSupport.model.vo;

import java.io.Serializable;

public class CaloriePresciption implements Serializable{
	private String gender;
	private int height;
	private int weight;
	private int goalweight;
	private int age;
	private int dateweight;
	private String activity;
	private double avgweight;
	private int basal;			//기초대사량
	private int energy;			//소화를 위한 에너지
	private int acienergy;		//활동대사량
	private int needenergy;		//필요 열량
	private int exercise;		//소모해야 할 칼로리
	
	public CaloriePresciption() {
		
	}

	public CaloriePresciption(String gender, int height, int weight, int goalweight, int age, int dateweight,
			String activity, double avgweight, int basal, int energy, int acienergy, int needenergy, int exercise) {
		super();
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.goalweight = goalweight;
		this.age = age;
		this.dateweight = dateweight;
		this.activity = activity;
		this.avgweight = avgweight;
		this.basal = basal;
		this.energy = energy;
		this.acienergy = acienergy;
		this.needenergy = needenergy;
		this.exercise = exercise;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getGoalweight() {
		return goalweight;
	}

	public void setGoalweight(int goalweight) {
		this.goalweight = goalweight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDateweight() {
		return dateweight;
	}

	public void setDateweight(int dateweight) {
		this.dateweight = dateweight;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public double getAvgweight() {
		return avgweight;
	}

	public void setAvgweight(double avgweight) {
		this.avgweight = avgweight;
	}

	public int getBasal() {
		return basal;
	}

	public void setBasal(int basal) {
		this.basal = basal;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getAcienergy() {
		return acienergy;
	}

	public void setAcienergy(int acienergy) {
		this.acienergy = acienergy;
	}

	public int getNeedenergy() {
		return needenergy;
	}

	public void setNeedenergy(int needenergy) {
		this.needenergy = needenergy;
	}

	public int getExercise() {
		return exercise;
	}

	public void setExercise(int exercise) {
		this.exercise = exercise;
	}

	@Override
	public String toString() {
		return "CaloriePresciption [gender=" + gender + ", height=" + height + ", weight=" + weight + ", goalweight="
				+ goalweight + ", age=" + age + ", dateweight=" + dateweight + ", activity=" + activity + ", avgweight="
				+ avgweight + ", basal=" + basal + ", energy=" + energy + ", acienergy=" + acienergy + ", needenergy="
				+ needenergy + ", exercise=" + exercise + "]";
	}
	
	
	
}
