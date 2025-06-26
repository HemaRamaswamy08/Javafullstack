package day3.filehandling;

import java.io.File;

public class DeleteFile {
	
	public static void main(String[] args) {
		
		File myFile = new File("filename.txt");
		if(myFile.delete()) {
			System.out.println("Sucessfully deleted : "+myFile.getName());
		}else {
			System.out.println("Failed to delete");
		}
	}

}
