  package org.techhub.SpringMVCCRUD.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.techhub.SpringMVCCRUD.model.Color;
import org.techhub.SpringMVCCRUD.model.Department;
import org.techhub.SpringMVCCRUD.model.Employee;

@Repository("employeeRepo")
public class EmployeeRepository {
	private Connection conn;
	private PreparedStatement stmt;

	public EmployeeRepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "root");

		} catch (Exception ex) {
			System.out.println("Error is" + ex);
		}
	}

	//add employee
	public boolean isAddEmployee(Employee model) {
		try {
			stmt = conn.prepareStatement("insert into employee values('0',?,?,?,?,?)",stmt.RETURN_GENERATED_KEYS);
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getEmail());
			stmt.setString(3, model.getContact());
			stmt.setString(4, model.getGender());
			stmt.setInt(5, model.getDid());
			List<Integer> getColorid=model.getColid();
			System.out.println(getColorid);
			int value = stmt.executeUpdate();
			if (value > 0)
			{
				ResultSet rs=stmt.getGeneratedKeys();
				rs.next();
				int auto_id=rs.getInt(1);
				addColor(auto_id, getColorid);
				return true;
			} 
			else{
				return false;
			}	    	 
		  }catch (Exception ex){
			System.out.println("Error is" + ex);
		}  
		return false;
	}
	
	public void addColor(int auto_id, List<Integer> getColorid) throws SQLException {
		int i=0;
		int size=0;
		if(getColorid !=null) 
		{
			size= getColorid.size();
		}
		for(int j=0;j<size;j++)
		{
			stmt=conn.prepareStatement("insert into ecmaster values(?,?)");
			stmt.setInt(1, auto_id);
			stmt.setInt(2, getColorid.get(i++));
			stmt.executeUpdate();
		}
	}
	
	//view colors
	public List<Color> getAllColor() throws SQLException{
		ResultSet rs=null;
		List<Color> color=new ArrayList<Color>();
		stmt=conn.prepareStatement("select *from color");
		rs=stmt.executeQuery();
		while(rs.next()) {
			Color c=new Color();
			c.setCid(rs.getInt(1));
			c.setCname(rs.getString(2));
		color.add(c);
		}
		return color;		
	}
	
	
	// view employee 
	public List<Employee> getAllRecords(){
		try {
			ResultSet rs=null;
			List<Employee> list=new ArrayList<Employee>();
			stmt=conn.prepareStatement("select e.*,d.dname from employee e left join dept d on e.did=d.did");
			rs=stmt.executeQuery();
			while(rs.next()) {
				Employee employee=new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setEmail(rs.getString(3));
				employee.setContact(rs.getString(4));
				employee.setGender(rs.getString(5));                           
				employee.setDeptname(rs.getString(7));    
				employee.setColname(getEmployeeWithColor(rs.getInt(1))); 
				list.add(employee);
			}
			return list;
		}catch(Exception ex) 
		{
			System.out.println("Error is"+ex);
		}
		return null;
	}
	
	public String getDeptName(int id) throws SQLException{
		String name=null;
		ResultSet rs=null;
		stmt=conn.prepareStatement("select *from dept where did=?");
		stmt.setInt(1, id);
		rs=stmt.executeQuery();
		if(rs.next())
		{
			name=rs.getString("dname");
		}
		rs.close();
		stmt.close();
		return name;
	}
	
	public List<String> getEmployeeWithColor(int id) throws SQLException  {
		List<String> l1=new ArrayList<String>();
		ResultSet rs=null;
		stmt=conn.prepareStatement("select ec.cid,c.cname from ecmaster as ec,color as c where id=? and ec.cid=c.cid");
		stmt.setInt(1, id);
		rs=stmt.executeQuery();
		while(rs.next())
		{
			l1.add(rs.getString("cname"));
		}
		rs.close();
		stmt.close();
		return l1;
	}

	//delete employee
	public boolean deleteRecord(int userId) {
		try {
			stmt=conn.prepareStatement("delete from employee where id=?");
			stmt.setInt(1, userId);
			int val=stmt.executeUpdate();
			if(val>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return false;
	}
	
	
	
	//update employee
	public boolean update(Employee emp) {
		try {
			stmt=conn.prepareStatement("update employee set Name=?,Email=?,Contact=?,Gender=? where id=?");
			stmt.setString(1, emp.getName());
			stmt.setString(2, emp.getEmail());
			stmt.setString(3, emp.getContact());
			stmt.setString(4, emp.getGender());
//			stmt.setInt(5, emp.getDid());
			stmt.setInt(5, emp.getId());
			int val=stmt.executeUpdate();
			if(val>0)
			{
				int id=emp.getId();
				List<Integer> colID=emp.getColid();				 
				return true;
			}
			else
			{
				return false;
			}
		}catch(Exception ex) {
			System.out.println("Error is"+ex);
			return false;
		}
	}

	
	public void updateColor(int auto_id, List<Integer> getColorId) throws SQLException {
		ResultSet rs=null;
		Connection conn=null;
		conn=EmployeeRepository.getconnection();
		int i=0;
		int size=0;
		if(getColorId !=null)
		{
			size=getColorId.size();
		}
		stmt=conn.prepareStatement("select cid from ecmaster where sid=?");
		stmt.setInt(1, auto_id);
		int cid=0;
		if(rs.next()) {
			cid=rs.getInt(1);
			for(int j=0;j<size;j++)
			{
				stmt=conn.prepareStatement("update ecmaster set id=?,cid=?");
				stmt.setInt(1, auto_id);
				stmt.setInt(2, getColorId.get(i++));
				stmt.executeUpdate();
			}
		}
	}
	
	
	private static Connection getconnection() {
		// TODO Auto-generated method stub
		return null;
	}

	//search by name
	public List<Employee> getAllRecordByName(String name){ 
		try {
			ResultSet rs=null;
			List<Employee> list=new ArrayList<Employee>();
			stmt=conn.prepareStatement("select e.id,e.name,e.email,e.contact,e.gender,d.dname from employee e inner join dept d on e.did=d.did where name like ?");
			stmt.setString(1, name+"%");
			rs=stmt.executeQuery();
			while(rs.next()) {
				Employee employee=new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setEmail(rs.getString(3));
				employee.setContact(rs.getString(4));
				employee.setGender(rs.getString(5));				
				employee.setDeptname(rs.getString(6));
				employee.setColname(getEmployeeWithColor(rs.getInt(1))); 
				list.add(employee);
			}
			return list;
		}catch(Exception ex) {
			System.out.println("Error is"+ex);
		}
		return null;
	}
	
	
	//save department
	public boolean isAddDepartment(Department dept) {
		try {
			stmt=conn.prepareStatement("insert into dept values('0',?)");
			stmt.setString(1, dept.getDname());
			int value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return false;
	}
	
	//view all department
	public List<Department> getAllDepartment() {
		try {
			ResultSet rs=null;
			List<Department> list=new ArrayList<Department>();
			 stmt=conn.prepareStatement("select *from dept");
			 rs=stmt.executeQuery();
			 while(rs.next())
			 {
				 Department dept=new Department();
				 dept.setDid(rs.getInt(1));
				 dept.setDname(rs.getString(2));
				 list.add(dept);
			 }
			 return list;
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return null;	
	}

	
	//delete department
	public boolean deleteDepartment(int did) {
		try {
			stmt=conn.prepareStatement("delete from dept where did=?");
			stmt.setInt(1, did);
			int value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return false;
	}
	
	
	//update department
	public boolean updateDepartment(Department dept) {
		try {
			stmt=conn.prepareStatement("update dept set dname=? where did=?");
			stmt.setString(1, dept.getDname());
			stmt.setInt(2, dept.getDid());
			int value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return false;
	}
	
	//search Department
	public List<Department> getAllDepartment(String dname){
		try {
			ResultSet rs=null; 
			List<Department> list=new ArrayList<Department>();
			stmt=conn.prepareStatement("select *from dept where dname=?");
			stmt.setString(1, dname);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				Department d=new Department();
				d.setDid(rs.getInt(1));
				d.setDname(rs.getString(2));
				list.add(d);
			}
			return list;
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return null;
	}
	
	
	public Employee getSpecificEmployee(Integer id) {
		Employee employee=new Employee();
		try {
			ResultSet rs = null;
			stmt=conn.prepareStatement("select *from employee where id = ?");
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			while(rs.next()) {
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setEmail(rs.getString(3));
				employee.setContact(rs.getString(4));
				employee.setGender(rs.getString(5));				
				employee.setDeptname(getDeptName(rs.getInt(6)));
				employee.setColname(getEmployeeWithColor(rs.getInt(1))); 
			}
		}
		catch(Exception ex) {
			System.out.println("Error is"+ex);
		}
		return employee;
	}
}