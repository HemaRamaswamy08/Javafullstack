package day3.filehandling;

import java.io.File;

public class FileInfo {
	
	public static void main(String[] args) {
		
		File myFile = new File("trial.txt");
		if(myFile.exists()) {
			System.out.println("File Name : " + myFile.getName());
			System.out.println("Path of File: "+ myFile.getAbsolutePath());
			System.out.println("Can Read ?? :"+myFile.canRead());
			System.out.println("Can Write ?? " +myFile.canWrite());
			System.out.println("Size of File "+ myFile.length());
		}
	}

}
