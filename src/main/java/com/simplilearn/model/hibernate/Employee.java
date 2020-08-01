package com.simplilearn.model.hibernate;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;

import com.simplilearn.model.User;
import com.simplilearn.utils.HibernateUtil;


@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="FirstName")
	private String FirstName;
	
	@Column(name="LastName")
	private String LastName;
	
	@Column(name="join_date")
	private Date joinDate;
	
	@Column(name="phone")
	private String phone;

	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	public Employee() {
		super();
	}

	public Employee(Long employeeId) {
		super();
		this.employeeId = employeeId;
	}
	
	public Employee(String FirstName, String LastName, String phone) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.joinDate = new Date(System.currentTimeMillis());
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", joinDate=" + joinDate + ", phone=" + phone + ", department=" + department + "]";
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


	public static List<Employee> getAllEmployees() throws ParseException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Employee> empList = null;
		Date date1 = null;
		
		// SQLQuery query = session.createSQLQuery("select emp_id, emp_name, emp_salary from Employee");
		List<Object[]> rows = session.createSQLQuery("select employee_id,FirstName,LastName,join_date,phone,dept_name,e.department_id from employee e inner join department d on e.department_id = d.DEPARTMENT_ID;").list();
		
		if(!rows.isEmpty()) {
			empList = new ArrayList<Employee>();
			for(Object[] row : rows){
				Employee emp = new Employee();
				Department dept = new Department();
				
				emp.setEmployeeId(Long.parseLong(row[0].toString()));
				emp.setFirstName(row[1].toString());
				emp.setLastName(row[2].toString());
				
				if(row[3] !=null) {
					date1= (Date)row[3]; 
				}
				
				emp.setJoinDate(date1);;
				emp.setPhone(row[4].toString());
				
				dept.setDepartmentName(row[5].toString());
				dept.setDepartmentId(Integer.parseInt(row[6].toString()) );
				
				emp.setDepartment(dept);
				empList.add(emp);
				
				System.out.println(emp);
			}
		}
		session.getTransaction().commit();
		session.close();
		return empList;
	}

}
