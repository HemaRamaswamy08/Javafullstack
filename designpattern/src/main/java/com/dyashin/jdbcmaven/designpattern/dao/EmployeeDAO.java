package com.dyashin.jdbcmaven.designpattern.dao;

import com.dyashin.jdbcmaven.designpattern.dto.User;

public interface EmployeeDAO {

	void getAllUser();

	User getUserOne();
}
