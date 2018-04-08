package com.timesheets.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "roles", catalog = "timesheets", uniqueConstraints = {@UniqueConstraint(columnNames = "ROLES_ID")})
public class Roles implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer rolesId;
	private String roleName;
	@ManyToMany(mappedBy = "roles")
	private Set<Employee> employees;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLES_ID", unique = true, nullable = false)
	public Integer getRolesId() {
		return rolesId;
	}
	
	public void setRolesId(Integer rolesId) {
		this.rolesId = rolesId;
	}
	
	@Column(name = "ROLES_NAME", unique = true, nullable = false)
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
