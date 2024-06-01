package com.main.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.main.entity.Task;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByTeamMemberId(Long teamMemberId);

	@Modifying
	@Transactional
	@Query("UPDATE Task t SET t.status = :status WHERE t.id = :id")
	int updateTaskStatus(@Param("id") Long id, @Param("status") String status);


}
