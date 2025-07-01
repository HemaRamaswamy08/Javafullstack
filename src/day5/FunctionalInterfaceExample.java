package day5;

@FunctionalInterface
public interface FunctionalInterfaceExample {
	
	void abstractMethodExample();
	public static void otherMenthods() {
		System.out.println("We can have 'n' number of static mehods ");
	}
	
	public default void otherMethods() {
		System.out.println("We can have 'n' number of Default mehods ");
	}
	
	
	

}
