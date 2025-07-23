package dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
@NamedQuery(name = "StudentInfo.findByName", 
			query = "Select s from StudentInfo s where s.name =:name")

public class StudentInfo {
	@Id // indicates it has Primary key
	@Column(name = "stud_id")
	private int id;

	@Column(name = "stud_name") // database variable name is different so explictly map them
	private String name;
	private int age;

}
