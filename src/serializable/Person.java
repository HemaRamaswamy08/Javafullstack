package serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable {
	private String name;
	private int age;
	private transient long number;

	/*
	 * Static data members and transient data members are not saved via
	 * Serialization process.
	 */
	public Person(String name, int age, long number) {
		this.name = name;
		this.age = age;
		this.number = number;

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public long getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return this.getName() + " " + this.getAge() + " " + this.number;
	}

	public static void main(String[] args) {
		Person p = new Person("hema", 21, 987654321);

		// Serializatation
		try {
			FileOutputStream file = new FileOutputStream(
					"D:\\JAVA-New\\javaadvancebyrahul\\src\\serializable\\serilazble.txt");
			ObjectOutputStream oos = new ObjectOutputStream(file);
			oos.writeObject(p);
			/*
			 * ByteArrayOutputStream - stores data in RAM so path and file is not required
			 * FileOutputStream -- Stored data in hard disk
			 */

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Deseriazable
		try {
			FileInputStream read = new FileInputStream(
					"D:\\JAVA-New\\javaadvancebyrahul\\src\\serializable\\serilazble.txt");
			ObjectInputStream oo = new ObjectInputStream(read);
			Person storedData = (Person) oo.readObject();
			System.out.println(storedData);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
