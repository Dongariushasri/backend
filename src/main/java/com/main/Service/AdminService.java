package com.main.Service;

import org.springframework.stereotype.Service;

import com.main.entity.Admin;
@Service
public interface AdminService {
	 Admin registerAdmin(Admin admin);
	  Admin loginAdmin(String email, String password);
}
