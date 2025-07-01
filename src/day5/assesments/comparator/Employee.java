package day5.assesments.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;

public class Employee {

	private String name;
	private int age;
	private float salary;

	public Employee(String name, int age, float salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public float getSalary() {
		return salary;
	}

	public static void main(String[] args) {
		ArrayList<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee("resh", 20, 50000));
		emp.add(new Employee("hema", 21, 90000));
		emp.add(new Employee("nisha", 25, 90000));
		
		Collections.sort(emp, new EmployeeComparator());

		ListIterator<Employee> list = emp.listIterator();
		while (list.hasNext()) {
			Employee emp1 = (Employee) list.next();
			System.out.println(emp1.getName() +" "+ emp1.getAge() + " " +emp1.getSalary());
		}

	}

}
