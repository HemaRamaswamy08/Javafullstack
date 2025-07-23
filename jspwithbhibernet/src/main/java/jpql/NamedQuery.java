package jpql;

import dto.StudentInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class NamedQuery {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();

		String jpql = "select e from StudentInfo e where e.name = :name";
		TypedQuery<StudentInfo> record = entityManager.createNamedQuery("StudentInfo.findByName", StudentInfo.class);
		record.setParameter("name", "nish");

		System.out.println(record.getSingleResult());

		emf.close();
		entityManager.close();

	}

}
