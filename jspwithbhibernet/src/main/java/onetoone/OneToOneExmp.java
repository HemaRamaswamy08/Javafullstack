package onetoone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToOneExmp {

	public static void main(String[] args) {

		VoterIdCard vote = new VoterIdCard();
		vote.setVid(4);
		vote.setVname("DEF432");

		User user = new User();
		user.setId(105);
		user.setName("Samya");

		user.setVote(vote);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = emf.createEntityManager();

		EntityTransaction tran = entityManager.getTransaction();
		tran.begin();
		VoterIdCard v = entityManager.find(VoterIdCard.class, 1);
		System.out.println(" Voter name :"+ v.getVname());
		System.out.println(" Voter Id :"+v.getVid());
		System.out.println("User Id :"+v.getUser().getId());
		System.out.println("User Name :"+ v.getUser().getName());

		// entityManager.persist(user); //-->add to the database
		System.out.println("User Id recoerd details inserted succesfully");
		tran.commit();

		entityManager.close();
		emf.close();

	}

}
