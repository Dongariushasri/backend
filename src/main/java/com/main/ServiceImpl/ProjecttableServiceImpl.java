package com.main.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.Repository.ProjectableRepository;
import com.main.Service.ProjecttableService;
import com.main.entity.Projecttable;
@Service
public class ProjecttableServiceImpl implements ProjecttableService{
	@Autowired
	private ProjectableRepository ptrepo;

	
	public Projecttable projecttableCreation(Projecttable prr) {
		// TODO Auto-generated method stub
		return ptrepo.save(prr);
	}


	@Override
	public List<Projecttable> getlistprojects() {
		// TODO Auto-generated method stub
		return ptrepo.findAll();
	}


	


	


	@Override
	public Projecttable getProjectById(Long id) {
		// TODO Auto-generated method stub
		return ptrepo.findById(id).orElse(null);
	}


	

	

}
