package task;

public class ImmutableMain {
	
	public static void main(String[] args) {
		
		ImmutableClass obj = new ImmutableClass("hema",101);
		System.out.println(obj);
		obj = new ImmutableClass("rrr",444);
	}

}
