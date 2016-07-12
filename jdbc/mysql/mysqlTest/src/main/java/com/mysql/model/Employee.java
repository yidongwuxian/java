package com.mysql.model;

import java.io.Serializable;
import java.sql.Date;


import javax.persistence.*;

@Entity
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="joining_date")
	private Date joiningDate;

	private String name;

	private Double salary;

	private String ssn;

	public Employee() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getJoiningDate() {
		return this.joiningDate;
	}

	public void setJoiningDate(Date date) {
		this.joiningDate = date;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double Double) {
		this.salary = Double;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

}