package com.dyashin.springcode.autowires;

import org.springframework.stereotype.Component;

@Component//-->in this class we are adding a dependency injection of another class
public class Bike {
	BikeEngine engine;

	public void start() {
		System.out.println("started");
		engine.stop();
	}

	public BikeEngine getEngine() {
		return engine;
	}

	public void setEngine(BikeEngine engine) {
		this.engine = engine;
	}

}
