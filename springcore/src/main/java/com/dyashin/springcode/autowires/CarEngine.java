package com.dyashin.springcode.autowires;

import org.springframework.stereotype.Component;

@Component //-->this is also must
public class CarEngine {
	
	public void carEngineMethod() {
		System.out.println("Method insidea Car");
	}

}
