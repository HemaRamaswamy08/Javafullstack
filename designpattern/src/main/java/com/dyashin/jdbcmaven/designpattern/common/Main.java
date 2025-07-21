package com.dyashin.jdbcmaven.designpattern.common;

import com.dyashin.jdbcmaven.designpattern.dao.EmployeeDAO;
import com.dyashin.jdbcmaven.designpattern.factory.EmployeeDAOFactory;
import com.dyashin.jdbcmaven.designpattern.util.ConnectionPool;

public class Main {

	public static void main(String[] args) {

		//EmployeeDAO db = new EmployeeDAOImpl();
		EmployeeDAO dao = EmployeeDAOFactory.getInstance("oracle");
		
		System.out.println("Initial Connection:" + ConnectionPool.availableConnection());
		dao.getAllUser();
		System.out.println();
		System.out.println("Available connection after using 1 for AllUser :"+ ConnectionPool.availableConnection());
		
		System.out.println();
		dao.getUserOne();
		System.out.println("Available Connection after Using OneUser:" + ConnectionPool.availableConnection());
		System.out.println();
		
		dao.getUserOne();
		System.out.println("Available Connection:" + ConnectionPool.availableConnection());

	}

}
