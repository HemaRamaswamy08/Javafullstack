package crud;

import dto.StudentInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ReAttach {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entitiManager = emf.createEntityManager();
		StudentInfo info = entitiManager.find(StudentInfo.class, 2);
		EntityTransaction transaction = entitiManager.getTransaction();
		System.out.println("Before Detached --  " + entitiManager.contains(info));
		System.out.println("------------------------");
		entitiManager.detach(info);

		System.out.println("After Detached --  " + entitiManager.contains(info));
		// after detached we can't make any changes

		transaction.begin();
		info.setName("sam");
		System.out.println(info);
		StudentInfo stud = entitiManager.merge(info);
		// stud.setName("Hema");
		System.out.println(stud);
		transaction.commit();
		entitiManager.close();
		emf.close();
	}

}
