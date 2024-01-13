package com.app.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeDao;
import com.app.dao.ProjectDao;
import com.app.pojos.Employee;
import com.app.pojos.Project;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private EmployeeDao empDao;
	

}
