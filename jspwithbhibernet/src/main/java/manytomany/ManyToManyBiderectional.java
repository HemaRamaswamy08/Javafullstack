package manytomany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ManyToManyBiderectional {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager manager = emf.createEntityManager();
		
		CourseInfo cou = manager.find(CourseInfo.class, 2);
		System.out.println("Students From Course -  "+cou.getStudInfo().get(0).getName());
		
		StudentInformatation stu = manager.find(StudentInformatation.class, 12);
		System.out.println("Course from Students - "+stu.getCourse().get(0).getCname());

	}
}
