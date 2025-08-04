package com.dyashin.springcode;

public class Car implements Vehicle {

	public Car() {
		
	}
	private Discount getDisc;

	public Car(Discount disc) {
		this.getDisc = disc;

	}

	public void setGetDisc(Discount getDisc) {
		this.getDisc = getDisc;
	}

	@Override
	public String milage() {
		return "100 KMPh";
	}

	@Override
	public String getDiscount() {
		return getDisc.getDiscount();
	}

}
