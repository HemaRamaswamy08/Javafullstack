package day5.assesments.comparator;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{
	
	@Override
	public int compare(Employee o1, Employee o2) {
		if(o2.getSalary() != o1.getSalary()) {
			return (int) (o2.getSalary()-o1.getSalary());
		}
		return o1.getAge()-o2.getAge();
	}

}
