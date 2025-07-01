package practice;

import java.util.ArrayList;
import java.util.Iterator;

public class AddStudent extends Students {

	public AddStudent(String name, int rollNumber, String grade) {
		super(name, rollNumber, grade);
	}

	public AddStudent() {

	}

	ArrayList<Students> stu = new ArrayList<Students>();

	public void isUnique(Students s) {
		boolean grade = true;
		boolean id = true;
		if (s.getGrade().equals("A+") || s.getGrade().equals("B+")) {
			grade = true;
		}else {
			grade =false;
		}
		for (Students students : stu) {
			if (students.getRollNumber() == s.getRollNumber()) {
				id=false;
			}
		}
		if (grade && id) {
			stu.add(s);
			System.out.println("Added");
		} else if (grade && !id) {
			System.out.println(" ID is already prsesnt");

		} else {
			System.out.println("Student is Failed so not added");
		}
	}

	public void display() {
		Iterator<Students> itr = stu.iterator();
		while (itr.hasNext()) {
			Students students = (Students) itr.next();
			System.out.println(students);
		}
	}

	public static void main(String[] args) {
		
		AddStudent st = new AddStudent();

		AddStudent stud = new AddStudent("hema", 101, "B+");
		AddStudent stu2 = new AddStudent("hema", 103, "C");
		AddStudent stu3 = new AddStudent("Nish", 106, "B+");
		
		st.isUnique(stud);
		st.isUnique(stu2);
		st.isUnique(stu3);
		st.display();

	}
}
