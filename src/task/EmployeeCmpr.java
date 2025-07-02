package task;

import java.util.Comparator;
import java.util.TreeMap;

public class EmployeeCmpr implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getId() - o2.getId();
	}

	public static void main(String[] args) {

//	TreeMap<Integer , Employee> emp2 = new TreeMap<>(new EmployeeCmpr());

		TreeMap<Employee, Integer> emp = new TreeMap<>(new EmployeeCmpr());
		emp.put(new Employee("hema", 20, "K R Pet"), 2);
		emp.put(new Employee("nisha", 10, "Kengeri"), 5);
		emp.put(new Employee("resh", 25, "Cptn"), 8);
		System.out.println(emp);

	}

}
