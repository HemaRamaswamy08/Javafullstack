package day3.filehandling;

import java.io.File;
import java.io.IOException;

public class FileCreation {

	public static void main(String[] args) {

		File myFile = new File("D:\\JAVA-New\\JavaAdvancedByRahul\\NOTES");
		try {
			if (myFile.createNewFile()) {
				System.out.println("File created " + myFile.getName());
			} else {
				System.out.println("File already exist");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
