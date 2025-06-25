package day1.overloading;

public class OverLoadRide extends Overload {
	
	public static void main(String[] args) {
		
		Overload over = new Overload();
		Overload.main();
		Overload.main("hema");
		
		String [] arg = {"hema","nisha"};
		Overload.main(arg);

	}

}
