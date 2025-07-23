package onetomany;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="pencilBox")
public class PencilBox {
	
	private int pid;
	private String pname;

}
