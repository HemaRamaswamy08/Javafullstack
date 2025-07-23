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
@Table(name="voterIdCart")
public class VoterIdCard {
	@Id
	private int vid ;
	private String vname;

	//mappedBy --> refers to BIdirectional (reference variable of that (VoterIdCard vote) is passed
	@OneToOne(cascade = CascadeType.ALL , mappedBy = "vote")
	private User user;

}
