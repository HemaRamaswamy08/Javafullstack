package day5;

public class FunctionalIntMain  implements FunctionalInterfaceB{

	@Override
	public void abstractMethodExample() {
		System.out.println("We can have onlt one Abstract methods");
		
	}

	public static void main(String[] args) {
		FunctionalIntMain fu = new FunctionalIntMain();
		fu.abstractMethodExample();
		fu.otherMethods();
		FunctionalInterfaceExample.otherMenthods();
	}
}
