package day4.markerinterface;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableInterface implements Serializable {

	private String name;
	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SerializableInterface(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public static void main(String[] args) {
		// Create a UserProfile object
		SerializableInterface userProfile = new SerializableInterface("Hema", "cs25");
		// Save the UserProfile object to a file
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("userProfile.dat"))) {
			output.writeObject(userProfile);
			System.out.println("User profile saved successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Load the UserProfile object from the file
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("userprofile.dat"))) {
			SerializableInterface loadedProfile = (SerializableInterface) inputStream.readObject();
			System.out.println("Loaded user profile: " + loadedProfile.getName() + " " + loadedProfile.getId());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
