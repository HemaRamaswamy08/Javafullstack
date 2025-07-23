package jpql;

import dto.StudentInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class NativeQuery {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();

		String jpql = "select * from student  where stud_name =?";
		Query query = entityManager.createNativeQuery(jpql,StudentInfo.class);
		query.setParameter(1, "nish");
		
		System.out.println(query.getSingleResult());
		
		entityManager.close();
		emf.close();
		
	}

}
