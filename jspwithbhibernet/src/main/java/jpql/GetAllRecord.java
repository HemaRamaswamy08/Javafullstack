package jpql;

import java.util.List;

import dto.StudentInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class GetAllRecord {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();
		
		String jpql = "select s from StudentInfo s";
		TypedQuery<StudentInfo> record = entityManager.createQuery(jpql,StudentInfo.class);
		
		List<StudentInfo> listRecord = record.getResultList();
		
		for (StudentInfo studentInfo : listRecord) {
			System.out.println(studentInfo);
		}
		
		emf.close();
		entityManager.close();
		
	}

}
