package org.techhub.SpringMVCCRUD.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techhub.SpringMVCCRUD.model.Color;
import org.techhub.SpringMVCCRUD.model.Department;
import org.techhub.SpringMVCCRUD.model.Employee;
import org.techhub.SpringMVCCRUD.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	//save
	public boolean isAddEmployee(Employee model) {
		boolean b=employeeRepo.isAddEmployee(model);
		return b;
	}
	
	public List<Color> getAllColor() throws SQLException{
		return employeeRepo.getAllColor();
	}
	
	//view employee
	public List<Employee> getAllRecord(){
		return employeeRepo.getAllRecords();
	}
	
	//delete
	public boolean deleteRecord(int id) {
		return employeeRepo.deleteRecord(id);
	}
	
	//update
	public boolean Update(Employee emp) {
		return employeeRepo.update(emp);
	}
	
	//search
	public List<Employee> getAllRecordByName(String name) {
		return employeeRepo.getAllRecordByName(name);
	}
	
	
	//save dept
	public boolean isAddDepartment(Department dept) {
		return employeeRepo.isAddDepartment(dept);
	}
	
	//view deptartment
	public List<Department> getAllDepartment(){
		return employeeRepo.getAllDepartment();
	}
	
	//delete department
	public boolean deleteDepartment(int did) {
		return employeeRepo.deleteDepartment(did);
	}
		
	//update department
	public boolean updateDepartment(Department dept) {
		return employeeRepo.updateDepartment(dept);
	}
	
	//search department
	public List<Department> getAllDepartment(String dname){
		return employeeRepo.getAllDepartment(dname);
	}
	
	public Employee getSpecificEmployee(Integer id) {
		return employeeRepo.getSpecificEmployee(id);
	}
	
}