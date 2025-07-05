package collections.set.tree;

import java.util.TreeMap;

import exceptions.InvalidIdException;

public class StudentsAdd extends Students {

	TreeMap<Integer, String> stud = new TreeMap<Integer, String>(new Students());

	public String addStudent(int id, String name) throws InvalidIdException {
		if (id < 1 || id > 3) {
			throw new InvalidIdException("enter a valid id");
		}
		stud.put(id, name);
		return "sucessfully added";
	}

	public void display() {
		System.out.println(stud);
	}

	public static void main(String[] args) {

		String name = "hema";
		int id = 1;

		StudentsAdd st = new StudentsAdd();
		try {
			System.out.println(st.addStudent(2, "raju"));
			System.out.println(st.addStudent(id, name));
			
		} catch (InvalidIdException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
		st.display();

	}

}
