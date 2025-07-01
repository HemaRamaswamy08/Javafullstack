package task;

public final class ImmutableClass {
	
	private final String name;
	private final int id;
	private static ImmutableClass instance;
	
	private ImmutableClass(String name, int id) {
		this.name=name;
		this.id=id;
	}
	
	 public static ImmutableClass getInstance(String name, int id) {
	        if (instance == null) {
	            instance = new ImmutableClass(name, id);
	        }
	        return instance;
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
