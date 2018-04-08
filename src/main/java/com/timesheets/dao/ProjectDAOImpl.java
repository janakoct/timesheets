package com.timesheets.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.timesheets.model.Project;

@Repository("projectDao")
public class ProjectDAOImpl extends AbstractDAO implements IProjectDAO {

	public void save(Project project) {
		persist(project);
	}

	public void update(Project project) {
		getSession().update(project);
	}

	@SuppressWarnings("deprecation")
	public Project findByProjectCode(String projectCode) {
		Criteria criteria = getSession().createCriteria(Project.class);
		criteria.add(Restrictions.eq("projectCode", projectCode));
		return (Project)criteria.uniqueResult();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Project> findAllProjects() {
		Criteria criteria = getSession().createCriteria(Project.class);
		return (List<Project>)criteria.list();
	}
	
	public void deleteProjectByProjectcode(String projectCode) {
		Query<Project> query = getSession().createQuery("DELETE FROM Project WHERE projectCode = :projectcode", Project.class);
		query.setParameter("projectCode", projectCode);
		query.executeUpdate();
	}
}
