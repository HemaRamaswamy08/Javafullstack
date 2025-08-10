package com.dyashin.springcode.annotation;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student  {

	private String name;
	private int age;

	public void init() {
		System.out.println("Init method");
	}
	public void destroy() {
		System.out.println("Destroyed");
	}
	public Student() {
		// for Property Injection default constructor is must
		// Setter is must in order to have setter injection
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}


	public void getVariables() {
		System.out.println(name + " " + age);
	}

//	@Override
//	public void destroy() throws Exception {
//		System.out.println("Disposable Bean method -destroy (this will not print)");
//	}
//
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("InitializingBean - afterPropertiesSet");
//
//	}

}
