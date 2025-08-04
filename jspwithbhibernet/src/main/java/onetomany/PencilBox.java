package onetomany;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="pencilBox")
public class PencilBox {
	@Id
	@Column
	private int pid;
	@Column
	private String pname;

}
