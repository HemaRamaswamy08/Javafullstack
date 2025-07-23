package onetomany;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pencils")
public class Pencils {
	private int id;
	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	private PencilBox pencilBox;

}
