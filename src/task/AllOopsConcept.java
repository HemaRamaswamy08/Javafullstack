package task;

public class AllOopsConcept {

	private String name;
	private static int id;
	public static int num = 1;

	public AllOopsConcept(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public AllOopsConcept(String name) {
		this.name = name;
		this.id =genaerateId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public static int genaerateId() {
		id = num++;
		return id;

	}
	@Override
	public String toString() {
		return this.name + " "+ this.id;
	}
	
	public static void main(String[] args) {
		AllOopsConcept stu = new AllOopsConcept("hema");
		System.out.println(stu);
		
		AllOopsConcept stus = new AllOopsConcept("hema");
		System.out.println(stus);
		
		AllOopsConcept student = new AllOopsConcept("hema" , 2);
		System.out.println(student);
		
	}

}
