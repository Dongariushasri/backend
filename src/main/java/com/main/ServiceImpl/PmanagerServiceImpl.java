package com.main.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.Repository.PmanagerRepository;
import com.main.Service.Pmanagerservice;
import com.main.entity.Pmanager;
@Service
public class PmanagerServiceImpl implements Pmanagerservice{
	@Autowired
	private PmanagerRepository prepo;

	//updated Manager
	@Override
	public Pmanager updatePmanager(Pmanager updatedPmanager) {
		if (! prepo.existsById(updatedPmanager.getId())) {
			throw new RuntimeException("Team Manager not found");
		}
		return prepo.save(updatedPmanager);
	}

	@Override
	public void deleteProjectManager(Integer id) {
		prepo.deleteById(id);
	}
	@Override
	public Pmanager getById(Integer Pmanager) {
		return prepo.findById(Pmanager).orElse(null);
	}

	@Override
	public Pmanager registerPmanager(Pmanager pm) {
		 if (prepo.findByEmail(pm.getEmail()) != null) {
	            throw new RuntimeException("User with this email already exists");
	        }
	        return prepo.save(pm);
	}


	@Override
	public Pmanager loginPmanager(String email, String password) {
        return prepo.findByEmailAndPassword(email, password);

	}

	public List<Pmanager> getallPmanagers() {
		
		return prepo.findAll();
	}
	
	

}
