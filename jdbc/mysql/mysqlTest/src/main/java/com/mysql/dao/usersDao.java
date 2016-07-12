package com.mysql.dao;

import java.sql.SQLException;
import java.util.List;

import com.mysql.model.Employee;

public interface usersDao {
	List<Employee> query() throws SQLException;
	Employee queryById(Integer id) throws SQLException;
	void addEmployee(Employee employee) throws SQLException;
	void updateEmployee(Employee employee) throws SQLException;
	void deleteEmployee(Integer id) throws SQLException;
}
