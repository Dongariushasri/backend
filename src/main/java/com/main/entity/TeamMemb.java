package com.main.entity;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;
@Data
@Entity
public class TeamMemb {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	 @Value("${TeamMemb.default.role:TeamMember}") // Using a fallback default value
	    private String role;
	 
	 @PrePersist
	    public void prePersist() {
	        if (role == null || role.isEmpty()) {
	            role = "TeamMember";
	        }
	    }


    public Integer getId() {
		 return id;
    }
}
