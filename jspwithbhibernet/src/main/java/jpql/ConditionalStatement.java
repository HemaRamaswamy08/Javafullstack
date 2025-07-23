package jpql;

import java.util.List;

import dto.StudentInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ConditionalStatement {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();

		String jpql = "select s from StudentInfo s where s.id = 5";
		TypedQuery<StudentInfo> record = entityManager.createQuery(jpql, StudentInfo.class);
		StudentInfo res = record.getSingleResult();
		
		System.out.println(res);

	}

}
