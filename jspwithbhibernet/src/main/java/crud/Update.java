package crud;

import dto.StudentInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Update {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entitiManager = emf.createEntityManager();
		StudentInfo info = entitiManager.find(StudentInfo.class, 5);
		 //StudentInfo info = entitiManager.getReference(StudentInfo.class, 1);
		EntityTransaction transaction = entitiManager.getTransaction();
		transaction.begin();
		info.setName("Nisarga");
		transaction.commit();
		System.out.println("Record updated");
		entitiManager.close();
		emf.close();

	}

}
