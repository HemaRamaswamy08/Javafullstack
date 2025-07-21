package com.dyashin.jdbcmaven.designpattern.factory;

import com.dyashin.jdbcmaven.designpattern.dao.EmployeeDAO;
import com.dyashin.jdbcmaven.designpattern.dao.EmployeeDAOImpl;
import com.dyashin.jdbcmaven.designpattern.dao.EmployeeDAOOracleImpl;

public class EmployeeDAOFactory {

	private EmployeeDAOFactory() {

	}

	public static EmployeeDAO getInstance(String db) {
		if (db.equals("mysql")) {
			EmployeeDAO empsql = new EmployeeDAOImpl();
			return empsql;
		}
		EmployeeDAO empOracle = new EmployeeDAOOracleImpl();
		return empOracle;


	}

}
