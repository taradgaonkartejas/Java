package com.core;

public enum Plan {
SILVER(1000,1), GOLD(2000,2), DIAMOND(5000,6), PLATINUM(10000,12);
	private double charges;
	private long months;

	private Plan(double charges, long months) {
		this.charges = charges;
		this.months=months;
	}

	public double getCharges() {
		return charges;
	}

	public long getMonths() {
		return months;
	}
	
	
}
