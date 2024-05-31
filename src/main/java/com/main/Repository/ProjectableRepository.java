package com.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.Projecttable;

@Repository
public interface ProjectableRepository extends JpaRepository<Projecttable, Long>{
	

}
