package day4;

import java.io.Serializable;

public class SeriazableExmple implements Serializable {
	
	/* all propertirs from POJO is present along with Serializable interface */
	
	private String name;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
