package crud;

import dto.StudentInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Display {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();
		StudentInfo info = entityManager.find(StudentInfo.class, 1);
		System.out.println("Student Id : " + info.getId());
		System.out.println("Student Name : " + info.getName());
		System.out.println("Student Age : " + info.getAge());

		entityManager.close();
		emf.close();

	}

}
