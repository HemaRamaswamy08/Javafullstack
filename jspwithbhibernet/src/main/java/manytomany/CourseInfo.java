package manytomany;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "course_information")
public class CourseInfo {

	@Id
	private int cid;
	private String cname;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "course_student_info", joinColumns = @JoinColumn(name = "cid"), 
	inverseJoinColumns = @JoinColumn(name = "sid"))
	private List<StudentInformatation> studInfo;

}
