package com.timesheets.dao;

import java.util.List;

import com.timesheets.model.Project;

public interface IProjectDAO {

	public void save(Project project);
	
	public void update(Project project);
	
	public Project findByProjectCode(String projectCode);
	
	public List<Project> findAllProjects();
	
	public void deleteProjectByProjectcode(String projectCode);
}
