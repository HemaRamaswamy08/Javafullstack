package day3.filehandling;

import java.io.FileWriter;
import java.io.IOException;

public class WritingToFile {
	public static void main(String[] args) {
		
		try {
			FileWriter file = new FileWriter("D:\\JAVA-New\\JavaAdvancedByRahul\\NOTES\\files.txt");
			file.write("Java is a Trichy language but once we learnt it It is the biggest easy language");
			file.close();// this is must after opening any file
			System.out.println("Successfullt written to a file");
		} catch (IOException e) {
			System.out.println("An error Occured");
			e.printStackTrace();
		}
		
		
	}

}
