package task;

public class Son extends Father{
	
	public int siblings;

	public Son(String name, int age, int wives , int sib) {
		//calling super constructor
		super(name, age, wives);
		this.siblings=sib;
	}
	
	public static void main(String[] args) {
		Son s = new Son("hema",21,0,1);
	}

}
