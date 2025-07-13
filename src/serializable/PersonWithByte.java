package serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class PersonWithByte implements Serializable {
	private String name;
	private int age;
	private transient long number;

	public PersonWithByte(String name, int age, long number) {
		this.name = name;
		this.age = age;
		this.number = number;

	}

	@Override
	public String toString() {
		return this.name + " " + this.age + this.number;
	}

	public static void main(String[] args) {

		PersonWithByte p = new PersonWithByte("moon", 22, 636274905);
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(p);
			byte[] arr = baos.toByteArray();
			System.out.println(Arrays.toString(arr));

			ByteArrayInputStream in = new ByteArrayInputStream(arr);
			ObjectInputStream ois = new ObjectInputStream(in);
			PersonWithByte data = (PersonWithByte) ois.readObject();

			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
