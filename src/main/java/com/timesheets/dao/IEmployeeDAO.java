package com.timesheets.dao;

import java.util.List;

import com.timesheets.model.Employee;

public interface IEmployeeDAO {

	public void save(Employee employee);

	public void update(Employee employee);

	public Employee findByEmployeeId(Integer employeeId);

	public List<Employee> findAllEmployee();

	public void deleteemployeeByEmployeeId(Integer employeeId);
}
