package jpql;

import dto.StudentInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class NameParameter {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		String jpql = "select e from StudentInfo e where e.id = :sid";
		TypedQuery<StudentInfo> record = entityManager.createQuery(jpql, StudentInfo.class);
		record.setParameter("sid", 5);

		System.out.println(record.getSingleResult());

		emf.close();
		entityManager.close();
	}

}
