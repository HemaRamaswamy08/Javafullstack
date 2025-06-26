package day2.stackoverflow;

public class InfiniteLoopClassA {
	
	InfiniteLoopClassB b = new InfiniteLoopClassB();
	
	public void methodA() {
		System.out.println("Method A is called");
		b.display();
	}

}
