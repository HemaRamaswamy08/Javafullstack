package practice;

import java.util.ArrayList;
import java.util.Iterator;

import util.UserInput;

public class AddStudent {

	ArrayList<Students> stu = new ArrayList<Students>();

	public void isUnique(Students s) {
		boolean grade = true;
		boolean id = true;
		if (s.getGrade().equals("A") || s.getGrade().equals("B")) {
			grade = true;
		} else {
			grade = false;
		}
		for (Students students : stu) {
			if (students.getRollNumber() == s.getRollNumber()) {
				id = false;
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

	public static final void main(String[] args) {
		
		AddStudent st = new AddStudent();

		int noOfStudents = UserInput.getuserInputInt("Number of Students");
		for (int i = 0; i < noOfStudents; i++) {
			String name = UserInput.getuserInputString("Student Name");
			int id = UserInput.getuserInputInt("Roll number");
			String grade = UserInput.getuserInputString("Grade");
			st.isUnique(new Students(name, id, grade));
		}
		st.display();

	}
}
