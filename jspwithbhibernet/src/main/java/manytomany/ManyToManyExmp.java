package manytomany;

import java.util.ArrayList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ManyToManyExmp {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager manager = emf.createEntityManager();

		EntityTransaction tran = manager.getTransaction();

		StudentInformatation stud1 = new StudentInformatation();
		//stud1.setSid(13); // --> if id is auto generated no need to set iD
		stud1.setName("Triveni");

		StudentInformatation stud2 = new StudentInformatation();
		//stud2.setSid(23);
		stud2.setName("Poo");
		
		StudentInformatation stud3 = new StudentInformatation();
		stud3.setName("Moon");
		

		ArrayList<StudentInformatation> students = new ArrayList<StudentInformatation>();
		students.add(stud1);
		students.add(stud2);
		students.add(stud3);
		/*
		For first time creating a course and adding to it 
		*/
		 // CourseInfo course1 =new CourseInfo();
		//course1.setCid(1);
		//course1.setCname("Java");
		//course1.setStudInfo(students);

			/*	
				Finding the existing cousre ad adding to it
				*/
		CourseInfo course1 = manager.find(CourseInfo.class, 2);
		course1.setStudInfo(students);

		tran.begin();
		manager.persist(course1);

		tran.commit();

		emf.close();
		manager.close();

	}

}
