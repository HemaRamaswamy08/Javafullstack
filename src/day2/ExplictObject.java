package day2;

public class ExplictObject extends Object{
	
	public String name ="Hema";
	public int id = 10;
	
	public void informatation() {
		System.out.println("Whether we extend Object Explictly or implicitly the result is same");
	}
	
	public String toString() {
		return "Name - " +name+"\nId - "+id;
	}
	
	public static void main(String[] args) {
		ExplictObject obj = new ExplictObject();
		obj.informatation();
		System.out.println(obj.toString());
	}

}
