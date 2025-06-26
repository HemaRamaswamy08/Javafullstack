package day2.stackoverflow;

public class InfiniteLoopClassB {
	
	InfiniteLoopClassA a = new InfiniteLoopClassA();
	
	public void display() {
		System.out.println("Method B");
		a.methodA();
	}
	
	public static void main(String[] args) {
		InfiniteLoopClassB tryProg = new InfiniteLoopClassB();
		tryProg.display();
		
	}
	
	
}
