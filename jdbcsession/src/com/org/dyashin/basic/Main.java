package com.org.dyashin.basic;

import com.org.dyashin.basic.dbutil.DBUtil;

public class Main {

	public static void main(String[] args) {

		for (Employee emp : DBUtil.getAllEmployee()) {
			System.out.println(emp);

		}
		System.out.println();
		DBUtil.getInformatation(10);
		
		
	}

}

