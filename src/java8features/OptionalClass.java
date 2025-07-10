package java8features;

import java.util.Optional;

public class OptionalClass {
	
	String name;
	Optional<String> email;
	
	
	public OptionalClass(String name, String email) {
		this.name = name;
		this.email = Optional.ofNullable(email);
	}
	

	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(Optional<String> email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public Optional getEmail() {
		return email;
	}
	
	public static void main(String[] args) {
		
		OptionalClass t = new OptionalClass("hema",null);
		OptionalClass t1 = new OptionalClass("nish","nishr@gmail.com");
		System.out.println(t1.getName() + " "+ t1.getEmail());
		System.out.println(t.getName());
		System.out.println(t.getEmail().orElse("Email Id is Not Present"));
		
	}
	
	
	
	

}
