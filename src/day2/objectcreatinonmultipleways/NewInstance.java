package day2.objectcreatinonmultipleways;

import java.lang.reflect.Constructor;

public class NewInstance {

	private String name;

	public NewInstance() {

	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		/*
		 * Constructor.newInstance() method is part of Java's Reflection API can be used
		 * to invoke private constructors, parameterized constructors, or even bypass
		 * normal object instantiation flow
		 */
		try {
			Constructor<NewInstance> constructor = NewInstance.class.getDeclaredConstructor();
			constructor.setAccessible(true);

			// creating a new object
			NewInstance obje = constructor.newInstance();
			obje.setName("hema");
			System.out.println(obje.name);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
