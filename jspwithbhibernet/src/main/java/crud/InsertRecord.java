package crud;

import dto.StudentInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InsertRecord {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		StudentInfo studentInfo = new StudentInfo();
		
		studentInfo.setId(5);
		studentInfo.setName("whitey");
		studentInfo.setAge(21);
		
		transaction.begin();
		
		entityManager.persist(studentInfo);
		
		System.out.println("Student Record inserted sucessfully");
		transaction.commit();
		entityManager.close();
		emf.close();

	
		
	}

}
