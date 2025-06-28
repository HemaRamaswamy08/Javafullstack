package day4.problems;

public interface StaticAndDefault {
	
	static void lunch() {
		System.out.println("Another Lunch");
	}
	
	default void breakFast() {
		System.out.println("Yes ");
	}

}
