package com.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String description;
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "team_member_id")
    private TeamMemb teamMember;
    
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Projecttable project;
    
    // Getters and setters
}
