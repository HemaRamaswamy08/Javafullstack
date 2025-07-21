package com.dyashin.basic;

import com.dyashin.basic.dbutil.DbUtil;

public class Main {

	public static void main(String[] args) {

		for (Employee emp : DbUtil.getAllEmployee()) {
			System.out.println(emp);

		}
	}

}
