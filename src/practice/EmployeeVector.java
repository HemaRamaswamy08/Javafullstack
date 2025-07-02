package practice;

import java.util.Enumeration;
import java.util.Vector;

public class EmployeeVector {

	private String name;
	private int id;
	private float salary;

	public EmployeeVector(String name, int id, float salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public float getSalary() {
		return salary;
	}

	public static void main(String[] args) {

		Vector<EmployeeVector> employees = new Vector<EmployeeVector>();
		employees.add(new EmployeeVector("hema", 119, 60000));
		employees.add(new EmployeeVector("nisha", 129, 80000));
		employees.add(new EmployeeVector("moon", 109, 49000));
		employees.add(new EmployeeVector("resh", 100, 50000));

		Enumeration<EmployeeVector> emps = employees.elements();
		while (emps.hasMoreElements()) {
			EmployeeVector emp = emps.nextElement();
			if (emp.getSalary() > 50000) {
				System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getSalary());
			}
		}
	}

}
