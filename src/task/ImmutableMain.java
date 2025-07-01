package task;

public class ImmutableMain {
	
	public static void main(String[] args) {
		
		ImmutableClass obj = ImmutableClass.getInstance("hema",101);
		obj = ImmutableClass.getInstance("nish", 10);
		ImmutableClass obj2 = ImmutableClass.getInstance("resh",10);
		System.out.println(obj2);
	}

}
