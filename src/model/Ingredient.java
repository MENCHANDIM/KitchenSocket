package model;

import java.io.Serializable;

public class Ingredient implements Serializable {
	
	private String name;
	private String unit;
	private double amount;
	
	public Ingredient(String name, double amount, String unit) {
		this.name = name;
		this.unit = unit;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
    public String toString() {
        return "> " + name + " " + amount + unit + '\n';
    }
	
}
