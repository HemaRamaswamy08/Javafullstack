package manytomany;

import java.util.List;

import javax.annotation.processing.Generated;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student_information")
public class StudentInformatation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) //To get Auto generated value
	//SEQUENCE - use this for PostgressSql(best)
	private int sid;
	private String name;

	@ManyToMany(cascade =  CascadeType.ALL , mappedBy = "studInfo")
	//studeInfo is a reference variable present in CourseInfo class
	private List<CourseInfo> course;

}
