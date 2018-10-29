package com.kh.baraonda.dietSupport.model.vo;

import java.io.Serializable;

public class BMI implements Serializable{
	private String gender;
	private int age;
	private int height;
	private int weight;
	private double bmi;
	
	public BMI() {
		
	}

	public BMI(String gender, int age, int height, int weight, double bmi) {
		super();
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	@Override
	public String toString() {
		return "BMI [gender=" + gender + ", age=" + age + ", height=" + height + ", weight=" + weight + ", bmi=" + bmi
				+ "]";
	}

	

	
	
}
