package org.techhub.SpringMVCCRUD.model;

import java.util.List;

public class Employee extends Department{

	private int id;
	private String name;
	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	private String email;
	private String contact;
	private String gender;
	private int cid;
	private String cname;
	private List<String> colname;
	private List<Integer> colid;
	
	
	public void setColid(List<Integer> colid) {
		this.colid = colid;
	}

	private String deptname;

	public List<Integer> getColid() {
		return colid;
	}
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}
	
	public List<String> getColname() {
		return colname;
	}

	public void setColname(List<String> colname) {
		this.colname = colname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
