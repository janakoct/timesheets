package com.timesheets.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.timesheets.model.Employee;

@Repository("employeeDao")
public class EmployeeDAOImpl extends AbstractDAO implements IEmployeeDAO {

	public void save(Employee employee) {
		getSession().persist(employee);
	}

	public void update(Employee employee) {
		getSession().update(employee);
	}

	@SuppressWarnings("deprecation")
	public Employee findByEmployeeId(Integer employeeId) {
		Criteria criteria = getSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("employeeId", employeeId));
		return (Employee)criteria.uniqueResult();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Employee> findAllEmployee() {
		Criteria criteria = getSession().createCriteria(Employee.class);
		return (List<Employee>)criteria.list();
	}

	public void deleteemployeeByEmployeeId(Integer employeeId) {
		Query<Employee> query = getSession().createQuery("DELETE FROM Employee WHERE employeeId = :employeeId", Employee.class);
		query.setParameter("employeeId", employeeId);
		query.executeUpdate();
	}

}
