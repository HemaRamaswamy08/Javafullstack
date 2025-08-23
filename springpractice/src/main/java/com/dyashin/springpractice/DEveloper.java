package com.dyashin.springpractice;

public class DEveloper {
	
	private Laptop laptop;


	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}


	public DEveloper(Laptop lap) {
		this.laptop = lap;
	}

	public void getDeviceDetails() {
		System.out.println("Developer");
		laptop.typeOfDEvice();

	}

}
