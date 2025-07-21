package crud;

import dto.StudentInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Delete {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();

		StudentInfo info = entityManager.find(StudentInfo.class, 1);
		//before remving a data we have to start transaction
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(info);
		System.out.println("Removed Succesfully");
		
		transaction.commit();
		entityManager.close();
		emf.close();
		
	}

}
