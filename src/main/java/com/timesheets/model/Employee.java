package com.timesheets.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;;

@Entity
@Table(name = "employee", catalog = "timesheets", uniqueConstraints = {@UniqueConstraint(columnNames = "EMPLOYEE_ID")})
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String userId;
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "employee_project",
			joinColumns = {@JoinColumn(name = "EMPLOYEE_ID")},
			inverseJoinColumns = {@JoinColumn(name = "PROJECT_CODE")})
	private Set<Project> projects;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "employee_roles",
			joinColumns = {@JoinColumn(name = "EMPLOYEE_ID")},
			inverseJoinColumns = {@JoinColumn(name = "ROLES_ID")})
	private Set<Roles> roles;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "EMPLOYEE_ID", unique = true, nullable = false)
	public Integer getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "USER_ID", unique = true, nullable = false)
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
}
