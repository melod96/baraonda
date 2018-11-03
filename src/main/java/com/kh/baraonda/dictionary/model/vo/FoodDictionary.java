package com.kh.baraonda.dictionary.model.vo;

import java.io.Serializable;

public class FoodDictionary implements Serializable{
	private int food_no;
	private String food_name;
	private int food_kcal;
	private double food_carbohydrate;
	private double food_protein;
	private double food_fat;
	private double food_cholesterol;
	private double food_fiber;
	private double food_natrium;
	
	public FoodDictionary() {
		
	}

	public FoodDictionary(int food_no, String food_name, int food_kcal, double food_carbohydrate, double food_protein,
			double food_fat, double food_cholesterol, double food_fiber, double food_natrium) {
		super();
		this.food_no = food_no;
		this.food_name = food_name;
		this.food_kcal = food_kcal;
		this.food_carbohydrate = food_carbohydrate;
		this.food_protein = food_protein;
		this.food_fat = food_fat;
		this.food_cholesterol = food_cholesterol;
		this.food_fiber = food_fiber;
		this.food_natrium = food_natrium;
	}

	public int getFood_no() {
		return food_no;
	}

	public void setFood_no(int food_no) {
		this.food_no = food_no;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public int getFood_kcal() {
		return food_kcal;
	}

	public void setFood_kcal(int food_kcal) {
		this.food_kcal = food_kcal;
	}

	public double getFood_carbohydrate() {
		return food_carbohydrate;
	}

	public void setFood_carbohydrate(double food_carbohydrate) {
		this.food_carbohydrate = food_carbohydrate;
	}

	public double getFood_protein() {
		return food_protein;
	}

	public void setFood_protein(double food_protein) {
		this.food_protein = food_protein;
	}

	public double getFood_fat() {
		return food_fat;
	}

	public void setFood_fat(double food_fat) {
		this.food_fat = food_fat;
	}

	public double getFood_cholesterol() {
		return food_cholesterol;
	}

	public void setFood_cholesterol(double food_cholesterol) {
		this.food_cholesterol = food_cholesterol;
	}

	public double getFood_fiber() {
		return food_fiber;
	}

	public void setFood_fiber(double food_fiber) {
		this.food_fiber = food_fiber;
	}

	public double getFood_natrium() {
		return food_natrium;
	}

	public void setFood_natrium(double food_natrium) {
		this.food_natrium = food_natrium;
	}

	@Override
	public String toString() {
		return "FoodDictionary [food_no=" + food_no + ", food_name=" + food_name + ", food_kcal=" + food_kcal
				+ ", food_carbohydrate=" + food_carbohydrate + ", food_protein=" + food_protein + ", food_fat="
				+ food_fat + ", food_cholesterol=" + food_cholesterol + ", food_fiber=" + food_fiber + ", food_natrium="
				+ food_natrium + "]";
	}
	
	
	
}
