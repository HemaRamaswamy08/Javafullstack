package onetoone;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
	@Id
	private int id ;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="vid")
	private VoterIdCard vote;
	

}
