package com.dyashin.jdbcmaven.mavenpractice;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBConnection {

	private static BasicDataSource dataSource;

	static {
		dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/java");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		dataSource.setMinIdle(5);
		dataSource.setMaxIdle(10);

		dataSource.setMaxOpenPreparedStatements(100);

	}

	public static BasicDataSource getCon() {
		return dataSource;
	}

}
