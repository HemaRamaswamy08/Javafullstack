package day3.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	
	public static void main(String[] args) {
		
		File myFile = new File("D:\\JAVA-New\\JavaAdvancedByRahul\\NOTES\\File Handling.txt");
		try {
			Scanner myReader =  new Scanner(myFile);
			while(myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
		
	}

}
