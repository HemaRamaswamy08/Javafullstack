package practice;

public class Students {

	private String name;
	private int rollNumber;
	private String grade;

	public String getName() {
		return name;
	}

	public Students() {
		
	}
	public Students(String name, int rollNumber, String grade) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.grade = grade;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public String getGrade() {
		return grade;
	}
	
	@Override
	public String toString() {
		return this.getName() + " " + this.getGrade();
	}

}
