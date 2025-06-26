package day2.objectcreatinonmultipleways;

/*The clone() method creates a shallow copy of the object. 
 * It does not invoke any constructor. 
 * The class must implement the Cloneable interface and override the clone() method.
*/
public class CloneMethod implements Cloneable {
	String instanceVariable = "dyashin";

	// Overriding the clone() method from Object class
	protected Object clone() throws CloneNotSupportedException {
		return super
		// call's object class clone method
		.clone();
	}

	public static void main(String[] args) {

		try {
			// creating first object
			CloneMethod obj = new CloneMethod();

			// creating copyof obj without using new keyword
			CloneMethod obj2 = (CloneMethod) obj.clone();

			System.out.println(obj2.instanceVariable);

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}

}
