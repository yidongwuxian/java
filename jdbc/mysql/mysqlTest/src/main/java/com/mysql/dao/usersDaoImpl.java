package com.mysql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.model.Employee;
import com.mysql.utils.DBUtil;

public class usersDaoImpl implements usersDao {
	/**
	   * 查询全部
	   * 
	   * @return
	   * @throws SQLException
	   */
	  public List<Employee> query() throws SQLException{
		  
	    List<Employee> employeeList = new ArrayList<Employee>();
	 
	    // 获得数据库连接
	    Connection conn = DBUtil.getConnection();
	 
	    StringBuilder sb = new StringBuilder();
	    sb.append("select id,name,joining_date,salary,ssn from employee");
	 
	    // 通过数据库的连接操作数据库，实现增删改查
	    PreparedStatement ptmt = conn.prepareStatement(sb.toString());
	 
	    ResultSet rs = ptmt.executeQuery();
	 
	    Employee employee = null;
	 
	    while (rs.next())
	    {
	      employee = new Employee();
	      employee.setId(rs.getInt("id"));
	      employee.setName(rs.getString("name"));
	      employee.setJoiningDate(rs.getDate("joining_date"));
	      employee.setSalary(rs.getDouble("salary"));
	      employee.setSsn(rs.getString("ssn"));
	 
	      employeeList.add(employee);
	    }
	    return employeeList;
	  }
	 
	  /**
	   * 查询单个
	   * 
	   * @return
	   * @throws SQLException
	   */
	  public Employee queryById(Integer id) throws SQLException{
		Employee g = null;
	 
	    Connection conn = DBUtil.getConnection();
	 
	    String sql = "" + " select * from employee " + " where id=? ";
	 
	    PreparedStatement ptmt = conn.prepareStatement(sql);
	 
	    ptmt.setInt(1, id);
	 
	    ResultSet rs = ptmt.executeQuery();
	 
	    while (rs.next())
	    {
	      g = new Employee();
	      g.setId(rs.getInt("id"));
	      g.setName(rs.getString("name"));
	      g.setJoiningDate(rs.getDate("joining_date"));
	      g.setSalary(rs.getDouble("salary"));
	      g.setSsn(rs.getString("ssn"));
	    }
	 
	    return g;
	  }
	 
	  /**
	   * 添加
	   * 
	   * @throws SQLException
	   */
	  public void addEmployee(Employee employee) throws SQLException{
	    // 获得数据库连接
	    Connection conn = DBUtil.getConnection();
	 
	    String sql = "insert into employee(name,joining_date,salary,ssn) values(?,?,?,?)";
	 
	    PreparedStatement ptmt = conn.prepareStatement(sql);
	 
	    ptmt.setString(1, employee.getName());
	    ptmt.setDate(2, employee.getJoiningDate());
	    ptmt.setDouble(3, employee.getSalary());
	    ptmt.setString(4, employee.getSsn());
	 
	    ptmt.execute();
	  }
	 
	  /**
	   * 修改资料
	   * 
	   * @throws SQLException
	   */
	  public void updateEmployee(Employee employee) throws SQLException{
		  
	    Connection conn = DBUtil.getConnection();
	 
	    String sql = "update employee set name=?,joining_date=?,salary=?,ssn=? where id=?";
	 
	    PreparedStatement ptmt = conn.prepareStatement(sql);
	 
	    ptmt.setString(1, employee.getName());
	    ptmt.setDate(2, employee.getJoiningDate());
	    ptmt.setDouble(3, employee.getSalary());
	    ptmt.setString(4, employee.getSsn());
	 
	    ptmt.execute();
	  }
	 
	  /**
	   * 删除
	   * 
	   * @throws SQLException
	   */
	  public void deleteEmployee(Integer id) throws SQLException{
		  
	    Connection conn = DBUtil.getConnection();
	 
	    String sql = "delete from employee where id=?";
	 
	    PreparedStatement ptmt = conn.prepareStatement(sql);
	 
	    ptmt.setInt(1, id);
	 
	    ptmt.execute();
	  }
}
