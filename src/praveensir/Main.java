package praveensir;

public class Main {

	public static void main(String[] args) {

		FunctionalnterfaceChecking f = () -> System.out.println("Iam working");
		f.check();
		FunctionalnterfaceChecking.display();

	}

}
