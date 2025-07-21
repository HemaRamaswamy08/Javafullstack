package com.dyashin.jdbcmaven.designpattern.util;

import java.io.IOException;
import java.util.Properties;

public class GetPropertyDetails {
	static Properties prop = new Properties();
	static private int poolSize;
	static {
		try {
			prop.load(GetPropertyDetails.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int getPoolSize(String str) {
		return Integer.parseInt(prop.getProperty(str));

	}
	
	public static String getDBUrl(String str) {
		return prop.getProperty(str);
	}
	
	public static String getDBUser(String str) {
		return prop.getProperty(str);
	}
	
	public static String getDBPassword(String str) {
		return prop.getProperty(str);
	}
	public static String getQueryAllUser(String str) {
		return prop.getProperty(str);
	}
	public static String getQueryOneUser(String str) {
		return prop.getProperty(str);
	}

}
