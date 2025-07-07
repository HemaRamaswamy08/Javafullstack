package threads.day2;

public class Display {
	
	public synchronized void duStuff(String str )  {
		for (int i = 0; i <5; i++) {
			System.out.println("Something is running");
			System.out.println(str);
		}
	}

}
