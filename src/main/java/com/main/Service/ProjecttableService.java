package com.main.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.main.entity.Projecttable;
@Service
public interface ProjecttableService {
	
	Projecttable projecttableCreation(Projecttable pr);
	
	public List<Projecttable> getlistprojects();




	Projecttable getProjectById(Long projectId);

	

}
