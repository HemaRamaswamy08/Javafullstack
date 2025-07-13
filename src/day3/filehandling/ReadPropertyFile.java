package day3.filehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) {

		Properties prop = new Properties();

		try {
			/*
			 * If file already present and if we want to set few more Key-value pairs old
			 * data will be removed if we didnt't read the file before writing into it
			 */

			// Step 1 : load the old data
			FileInputStream readfile = new FileInputStream("System.properties");
			prop.load(readfile);
			readfile.close();

			// Step 2: Add new key-value pairs
			// Writing to a property file
			prop.setProperty("age", "21");
			prop.setProperty("college", "Ghousia college of engineering");

			// Step 3: Save the updated properties back to the file
			FileOutputStream write = new FileOutputStream("System.properties");
			// store the file with comments
			prop.store(write, "Sucessfullt write it to prop");
			System.out.println("Written sucessfully");
			write.close();

			// Read the properties file
			FileInputStream file = new FileInputStream("System.properties");
			prop.load(file);

			String name = prop.getProperty("name");
			String age = prop.getProperty("age");
			String usn = prop.getProperty("usn");
			String college = prop.getProperty("college");

			System.out.println(
					"Student Name :" + name + " || college :" + college + " || Age : " + age + " || usn :" + usn);

			file.close();
		} catch (IOException e) {
			System.out.println("Error reading in File or writing into a file :" + e.getMessage());

		}
	}

}
