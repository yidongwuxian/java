package com.mysql.controller;

import java.sql.SQLException;
import java.util.List;

import com.mysql.dao.usersDaoImpl;
import com.mysql.model.Employee;

public class usersController {
	public void add(Employee employee) throws Exception{
		usersDaoImpl dao = new usersDaoImpl();
		  employee.setName("xy");
	      employee.setSalary(20000.00);
	      employee.setSsn("3");
	      dao.addEmployee(employee);
	}
	
	public Employee get(Integer id) throws SQLException{
		usersDaoImpl dao = new usersDaoImpl();
	    return dao.queryById(id);
	}
	
	public void edit(Employee employee) throws Exception{
		usersDaoImpl dao = new usersDaoImpl();
	    dao.updateEmployee(employee);
	}
	
	public void del(Integer id) throws SQLException{
		usersDaoImpl dao = new usersDaoImpl();
	    dao.deleteEmployee(id);
	}
	
	public List<Employee> query() throws Exception{
		usersDaoImpl dao = new usersDaoImpl();
	    return dao.query();
	}
	
	public static void main(String[] args) throws SQLException{
		
		usersDaoImpl usersDao = new usersDaoImpl();
	 
	    List<Employee> employeeList = usersDao.query();
	 
	    for (Employee employee : employeeList){
	      System.out.println(employee.getName() + "," + employee.getJoiningDate() + "," + employee.getSalary() + "," + employee.getSsn());
	    }
	}
}
