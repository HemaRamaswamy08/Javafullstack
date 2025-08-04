package onetoone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToOneExmp {

	public static void main(String[] args) {

		VoterIdCard vote = new VoterIdCard();
		vote.setVid(1);
		vote.setVname("DEF432");

		User user = new User();
		user.setId(1);
		user.setName("Samya");

		// Set both sides of relationship
		user.setVote(vote);
		vote.setUser(user);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = emf.createEntityManager();

		EntityTransaction tran = entityManager.getTransaction();
		tran.begin();

		// First persist
		entityManager.persist(user);  // This will cascade persist to VoterIdCard
		tran.commit();

		System.out.println("User record inserted successfully");

		// Now fetch and display
		VoterIdCard v = entityManager.find(VoterIdCard.class, 1);

		if (v != null && v.getUser() != null) {
			System.out.println("Voter name: " + v.getVname());
			System.out.println("Voter ID: " + v.getVid());
			System.out.println("User ID: " + v.getUser().getId());
			System.out.println("User Name: " + v.getUser().getName());
		} else {
			System.out.println("VoterIdCard or User not found.");
		}

		entityManager.close();
		emf.close();
	}
}
