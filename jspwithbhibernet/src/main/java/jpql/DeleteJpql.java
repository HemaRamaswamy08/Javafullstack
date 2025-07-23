package jpql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class DeleteJpql {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();
		String jpql = "Delete from StudentInfo e where e.id = :sid";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("sid", 2);

		int res = query.executeUpdate();
		System.out.println(res);
		transaction.commit();
	}

}
