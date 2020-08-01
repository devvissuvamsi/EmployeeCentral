package com.simplilearn.model.hibernate;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;

import com.simplilearn.model.hibernate.Department;
import com.simplilearn.utils.HibernateUtil;

@Entity
@Table(name="DEPARTMENT")
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DEPARTMENT_ID")
	private Long departmentId;
	
	@Column(name="DEPT_NAME")
	private String departmentName;
	
	@OneToMany(mappedBy="department",fetch = FetchType.LAZY)
	private Set<Employee> employees;
	
	public Department() {
		super();
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", employees="
				+ employees + "]";
	}

	public Department(String departmentName) {
		super();
		this.departmentName = departmentName;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public static List<Department> getAllDepartments() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Department> departmentList = session.createQuery("FROM Department").list();
		session.getTransaction().commit();
		session.close();
		return departmentList;
	}
	
	public static int insertDepartment(Department department) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (Integer) session.save(department);
		session.getTransaction().commit();
		session.close();
		return id;		
	}
	
	public static void updateDepartment(int id, Department department) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Department modDepartment = session.get(Department.class, department.getDepartmentId());
		modDepartment.setDepartmentName(department.getDepartmentName());
		session.update(modDepartment);
		session.getTransaction().commit();
		session.close();
	}

	public static void deleteDepartment(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Department modDepartment = session.get(Department.class, id);
		session.delete(modDepartment);
		session.getTransaction().commit();
		session.close();
	}	

}