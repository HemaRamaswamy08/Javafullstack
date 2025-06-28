package day4;

public class PojoClass {
	/*POJO - oldest Java object 
	 * Rules --> 1. Class should be a Concrete class
	 * 		 -->2. All data members should be private
	 * 		 --> Getter and Setter must be available for the variables
	*/
	private String name;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
