package com.org.dyashin.tasks;

public class MainMethod {
	
	public static void main(String[] args) {
		
		String dburl = "A";
		
		Connection conn = DriverManager.getConnrction(dburl);
		Statement stmt = conn.createStatement();
		stmt.doStuff();
		
		
	}

}
