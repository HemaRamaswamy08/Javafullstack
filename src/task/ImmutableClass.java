package task;

public final class ImmutableClass {
	
	private final String name;
	private final int id;
	
	public ImmutableClass(String name, int id) {
		this.name=name;
		this.id=id;
	}
	
	
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return getName()+ " " + getId();
	}

}
