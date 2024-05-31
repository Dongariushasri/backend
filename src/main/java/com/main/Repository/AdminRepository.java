
package com.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	Admin findByEmail(String email);
    Admin findByEmailAndPassword(String email,String password);
}
