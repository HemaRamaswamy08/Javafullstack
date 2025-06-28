package day4.problems;

public interface NDefaultMethods {
	
	void dostuff();
	void dostuffOne();
	
	// we can have N number of default methods in interface
	
	static void lunch() {
		System.out.println("Another Lunch");
	}
	
	default void breakFast() {
		System.out.println("Yes ");
	}
	
	
	
	

}
