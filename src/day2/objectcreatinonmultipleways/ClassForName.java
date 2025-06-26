package day2.objectcreatinonmultipleways;

public class ClassForName {
	void ride() {
		System.out.println("On Long Ride");
	}

	public static void main(String[] args) throws Exception {
		Class<?> clss = Class.forName("day2.objectcreatinonmultipleways.ClassForName");
		ClassForName clsforname = (ClassForName) clss.getDeclaredConstructor().newInstance();
		clsforname.ride();
	}

}
