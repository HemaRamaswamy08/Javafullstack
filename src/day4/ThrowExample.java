package day4;

import java.io.File;
import java.io.IOException;

public class ThrowExample {
	
	public static void main(String[] args) throws IOException {
		
		File myObj = new File("");
		if(myObj.createNewFile()) {
			System.out.println("created sucessfully");
		}else {
			throw new IOException();
		}
	}

}
