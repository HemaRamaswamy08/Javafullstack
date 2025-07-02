package task;

public class Employee {

	private String name;
	private int id;
	private String address;

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public Employee(String name, int id, String address) {
		this.name = name;
		this.id = id;
		this.address = address;
	}
	
	@Override
	public String toString() {
		
		return id + " " + name;
		
	}


}
