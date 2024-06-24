package org.techhub.SpringMVCCRUD.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.techhub.SpringMVCCRUD.model.Color;
import org.techhub.SpringMVCCRUD.model.Department;
import org.techhub.SpringMVCCRUD.model.Employee;
import org.techhub.SpringMVCCRUD.service.EmployeeService;

@Controller
public class HomeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/")
	public String test(HttpServletResponse response) throws IOException {
		return "home";
	}

	// add empployee
	@RequestMapping(value = "/addemployee", method = RequestMethod.GET)
	public String addnewemployee(Map map) throws SQLException {
		List<Department> list = employeeService.getAllDepartment();
		List<Color> color=employeeService.getAllColor();
		map.put("dms", list);
		map.put("color", color);
		return "addnewrecord"; // addnewrecord.jsp
	}

	// save employee
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveRecord(Employee model, Map map) {
		boolean b = employeeService.isAddEmployee(model);
		if (b)
		{
	
			  List<Employee> list = employeeService.getAllRecord(); map.put("emp", list);
			  map.put("msg", "Record Saved Succesfully...........");
			 
			/*return "redirect:/view"; */  //for page redirect
		} 
		else 
		{
			map.put("msg", "Some problem is there...");
		}
		return "addnewrecord"; // addnewrecord.jsp
	}

	// view all employee
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewallrecord(Map<String, List<Employee>> map) {
		List<Employee> list = employeeService.getAllRecord();
		map.put("emp", list);
		return "viewallrecord";
	}

	// delete employee
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteRecord(@RequestParam("userId") Integer id, Map map) {
		employeeService.deleteRecord(id);
		List<Employee> list = employeeService.getAllRecord();
		map.put("emp", list);
		return "viewallrecord";
	}

	// update employee
	@RequestMapping(value = "/upd", method = RequestMethod.GET)
	public String update(@RequestParam("id") Integer id, Map map) throws SQLException {	
		Employee emp = employeeService.getSpecificEmployee(id);
		List<Department> department=employeeService.getAllDepartment();
		List<Color> color=employeeService.getAllColor();
		map.put("emp", emp);
		map.put("department", department);
		map.put("color", color);

		return "update";
	}

	@RequestMapping(value = "/xupdate", method = RequestMethod.POST)
	public String xUpdate(Employee emp, Map<String, List<Employee>> map) {
		boolean b = employeeService.Update(emp);
		if (b) {
			List<Employee> list = employeeService.getAllRecord();
			map.put("emp", list);
			return "viewallrecord";
		} 
		else
		{
			return "viewallrecord";
		}
	}

	// search employee
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchStudent() {
		return "search";
	}

	@RequestMapping(value = "/viewName", method = RequestMethod.GET)
	public String viewallrecordByName(Map<String, List<Employee>> map, @RequestParam("name") String name) {
		List<Employee> list = employeeService.getAllRecordByName(name);
		map.put("emp", list);
		return "viewallrecord";
	}

	// add dept
	@RequestMapping(value = "/adddept", method = RequestMethod.GET)
	public String addnewdept() {
		return "addnewdept"; // addnewrecord.jsp
	}

	// save dept
	@RequestMapping(value = "/savedept", method = RequestMethod.POST)
	public String saveDept(Department dept, Map map) {
		boolean b = employeeService.isAddDepartment(dept);
		if (b) {
			map.put("m", "Dpartment saved succesfully.......");
		} else {
			map.put("m", "Not saved department......");
		}
		return "addnewdept";
	}

	// view department
	@RequestMapping(value = "/viewdept", method = RequestMethod.GET)
	public String viewalldept(Map map) {
		List<Department> list = employeeService.getAllDepartment();
		map.put("map", list);
		return "viewalldept";
	}

	// delete department
	@RequestMapping(value = "/deleteDept", method = RequestMethod.GET)
	public String deleteDepartment(@RequestParam("did") int did, Map map) {
		employeeService.deleteDepartment(did);
		List<Department> list = employeeService.getAllDepartment();
		map.put("map", list);
		return "viewalldept";
	}

	// update department
	@RequestMapping(value = "/updept", method = RequestMethod.GET)
	public String updateDepartment(@RequestParam("did") Integer did, @RequestParam("dname") String n, Map map) {
		map.put("did", did);
		map.put("dname", n);
		return "updatedept";
	}

	@RequestMapping(value = "/xupdept", method = RequestMethod.POST)
	public String xupdateDepartment(Department dept, Map<String, List<Department>> map) {
		boolean b = employeeService.updateDepartment(dept);
		if (b)
		{
			List<Department> list = employeeService.getAllDepartment();
			map.put("map", list);
			return "viewalldept";
		} else 
		{
			return "viewalldept";
		}
	}

	// search department
	@RequestMapping(value = "/searchDept", method = RequestMethod.GET)
	public String searchDept() {
		return "searchdept";
	}

	@RequestMapping(value = "/deptname", method = RequestMethod.GET)
	public String searchDepartment(Map<String, List<Department>> map, @RequestParam("dname") String dname) {
		List<Department> list = employeeService.getAllDepartment(dname);
		map.put("map", list);
		return "viewalldept";
	}
}