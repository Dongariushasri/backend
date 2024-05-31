package com.main.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.Repository.TaskRepository;
import com.main.Service.TaskService;
import com.main.entity.Task;

@Service
public class TaskServiceImpl implements TaskService{
	@Autowired
	private TaskRepository trepo;

	@Override
	public Task saveTask(Task task) {
		
		return trepo.save(task);
	}

	
	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return trepo.findAll();
	}


	@Override
	public List<Task> getTasksForTeamMember(Long teamMemberId) {
		return trepo.findByTeamMemberId(teamMemberId);
	}

	@Override
	public Task getTaskId(Long id) {
		return trepo.findById(id).orElse(null);
	}

	@Override
	public Task updatedTask(Task updatedTask) {
		if (!trepo.existsById(updatedTask.getId())) {
			throw new RuntimeException("Team member not found");
		}
		return trepo.save(updatedTask);
	}

	@Override
	public void deleteTask(Long id) {
		trepo.deleteById(id);
	}


}
