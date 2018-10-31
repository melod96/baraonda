package com.kh.baraonda.dietSupport.model.vo;

import java.io.Serializable;

public class FoodCalorie implements Serializable{
	private int food_no;
	private String food_name;
	private int food_kcal;
	private int food_carbohydrate;
	private int food_protein;
	private int food_fat;
	private int food_cholesterol;
	private int food_fiber;
	private int food_natrium;
	
	public FoodCalorie() {
		
	}

	public FoodCalorie(int food_no, String food_name, int food_kcal, int food_carbohydrate, int food_protein,
			int food_fat, int food_cholesterol, int food_fiber, int food_natrium) {
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

	public int getFood_carbohydrate() {
		return food_carbohydrate;
	}

	public void setFood_carbohydrate(int food_carbohydrate) {
		this.food_carbohydrate = food_carbohydrate;
	}

	public int getFood_protein() {
		return food_protein;
	}

	public void setFood_protein(int food_protein) {
		this.food_protein = food_protein;
	}

	public int getFood_fat() {
		return food_fat;
	}

	public void setFood_fat(int food_fat) {
		this.food_fat = food_fat;
	}

	public int getFood_cholesterol() {
		return food_cholesterol;
	}

	public void setFood_cholesterol(int food_cholesterol) {
		this.food_cholesterol = food_cholesterol;
	}

	public int getFood_fiber() {
		return food_fiber;
	}

	public void setFood_fiber(int food_fiber) {
		this.food_fiber = food_fiber;
	}

	public int getFood_natrium() {
		return food_natrium;
	}

	public void setFood_natrium(int food_natrium) {
		this.food_natrium = food_natrium;
	}

	@Override
	public String toString() {
		return "FoodCalorie [food_no=" + food_no + ", food_name=" + food_name + ", food_kcal=" + food_kcal
				+ ", food_carbohydrate=" + food_carbohydrate + ", food_protein=" + food_protein + ", food_fat="
				+ food_fat + ", food_cholesterol=" + food_cholesterol + ", food_fiber=" + food_fiber + ", food_natrium="
				+ food_natrium + "]";
	}
	
	
}
