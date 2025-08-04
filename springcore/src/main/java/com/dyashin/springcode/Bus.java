package com.dyashin.springcode;

public class Bus implements Vehicle {
	
	public Bus(){
		
	}
	private Discount getDisc;
	
	public Bus(Discount disc) {
		this.getDisc=disc;
	}

	@Override
	public String milage() {
		return "80KMPh";
	}

	@Override
	public String getDiscount() {
		return getDisc.getDiscount();
	}

	public void setGetDisc(Discount getDisc) {
		this.getDisc = getDisc;
	}
}
