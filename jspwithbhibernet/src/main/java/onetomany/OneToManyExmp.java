package onetomany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToManyExmp {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction tran = null;

		emf = Persistence.createEntityManagerFactory("persistence");
		entityManager = emf.createEntityManager();
		tran = entityManager.getTransaction();

		/* for first time creating a box */ 
		
//		PencilBox box = new PencilBox();
//		box.setPid(4);
//		box.setPname("Nataraj");
//		entityManager.persist(box);

		try {
			// for the PencilBox with Id 4 Iam adding one more pencil
			PencilBox box2 = entityManager.find(PencilBox.class, 4);
			Pencils pencli = new Pencils();
			if (box2 == null) {
				System.out.println("PencilBox with ID 4 not found.");
				return;
			}
			
			pencli.setId(105);
			pencli.setName("Pencil 5");
			pencli.setPencilBox(box2);
			tran.begin();
			entityManager.persist(pencli);
			tran.commit();
			System.out.println(pencli);

		} catch (Exception e) {
			tran.rollback();
		}

	}
}
