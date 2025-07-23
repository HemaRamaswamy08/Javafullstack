package jpql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class UpdateJpql {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityManagerFactory emf = null;
		EntityTransaction transaction = null;

		emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		entityManager = emf.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update StudentInfo e set e.name = :sname where e.id = :sid";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("sname", "Sampretha");
		query.setParameter("sid", 2);

		int res = query.executeUpdate();
		System.out.println(res);
		transaction.commit();

	}

}
