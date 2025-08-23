package com.dyashin.springpractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		ApplicationContext contect = new ClassPathXmlApplicationContext("spring.xml"); // this line creates the container (IOC)
		DEveloper deve =contect.getBean(DEveloper.class);
		deve.getDeviceDetails();
	}

}
