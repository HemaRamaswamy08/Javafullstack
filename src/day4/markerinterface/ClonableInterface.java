package day4.markerinterface;

public class ClonableInterface implements Cloneable {

	private String carName;
	private String model;

	public ClonableInterface(String carName, String model) {
		this.carName = carName;
		this.model = model;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public ClonableInterface clone() {
		try {
			return (ClonableInterface) super.clone();
		} catch (CloneNotSupportedException e) {
			// This should never happen since CarConfiguration implements Cloneable
			throw new AssertionError();
		}
	}
	
	public String toString() {
		return this.carName + " " + this.model;
	}

	public static void main(String[] args) {
		
		// Create a prototype car configuration
		ClonableInterface prototype = new ClonableInterface("Audi" ,"new-model" );
		
		ClonableInterface config1 = prototype.clone();
		ClonableInterface config2 = prototype.clone();
		
		config1.setCarName("Safari");
		config2.setCarName("BMW");
		System.out.println(prototype);
		System.out.println(config1);
		System.out.println(config2);

	}

}
