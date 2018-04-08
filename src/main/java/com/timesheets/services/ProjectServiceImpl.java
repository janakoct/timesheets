package com.timesheets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timesheets.dao.ProjectDAOImpl;
import com.timesheets.model.Project;

@Service("projectService")
@Transactional
public class ProjectServiceImpl implements IProjectService {
	
	@Autowired
	private ProjectDAOImpl projectDao;

	public void save(Project project) {
		projectDao.save(project);
	}

	public void update(Project project) {
		projectDao.update(project);
	}

	public Project findByProjectCode(String projectCode) {
		return projectDao.findByProjectCode(projectCode);
	}

	public List<Project> findAllProjects() {
		return projectDao.findAllProjects();
	}

	public void deleteProjectByProjectcode(String projectCode) {
		projectDao.deleteProjectByProjectcode(projectCode);
	}

}
