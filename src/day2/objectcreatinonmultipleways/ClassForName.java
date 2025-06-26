package day2.objectcreatinonmultipleways;

public class ClassForName {
	void ride() {
		System.out.println("On Long Ride");
	}

	/*
	 * This method is deprecated in Java 9 because it throws checked exceptions
	 * awkwardly and only works with no-arg public constructors
	 */
	public static void main(String[] args) throws Exception {
		Class<?> clss = Class.forName("day2.objectcreatinonmultipleways.ClassForName");
		ClassForName clsforname = (ClassForName) clss.getDeclaredConstructor().newInstance();
		clsforname.ride();
	}

}
