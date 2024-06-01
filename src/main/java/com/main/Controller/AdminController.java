package com.main.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.main.Dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.Service.AdminService;
import com.main.Service.Pmanagerservice;
import com.main.Service.ProjectService;
import com.main.Service.ProjecttableService;
import com.main.Service.RoleService;
import com.main.Service.TaskService;
import com.main.Service.TeamService;
import com.main.entity.Admin;
import com.main.entity.Pmanager;
import com.main.entity.Project;
import com.main.entity.Projecttable;
import com.main.entity.Task;
import com.main.entity.TeamMemb;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AdminController {
	@Autowired
    private AdminService adminService;
	@Autowired
	private Pmanagerservice pservice;
	@Autowired
	private TeamService tservice;
	@Autowired
	private ProjectService prservice;
	@Autowired
	private RoleService rservice;
	@Autowired
	private TaskService taskservice;
	
	@Autowired
	private ProjecttableService ptservice;


//Editing Project Manager
    @PutMapping("/admin/editPmanager/{id}")
    public ResponseEntity<Pmanager> updateProjectManager(@PathVariable Integer id, @RequestBody Pmanager updatedPmanager) {
        // Make sure the ID in the path matches the ID in the request body
        if (!id.equals(updatedPmanager.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Pmanager result = pservice.updatePmanager(updatedPmanager);
        return ResponseEntity.ok(result);
}
	
	
	@PostMapping("/admin/alogin")
	public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> loginRequest) {
	    String email = loginRequest.get("email");
	    String password = loginRequest.get("password");

	    // Assuming you have a method to retrieve the user's role and ID
	    String role = rservice.getRoleByEmailAndPassword(email, password);
	    Integer id = rservice.getIdByEmailAndPassword(email, password);

	    if (role != null && id != null) {
	        Map<String, Object> response = new HashMap<>();
	        response.put("role", role);
	        response.put("id", id);
	        return ResponseEntity.ok(response);
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	    }
	}



    @GetMapping("admin/PManager/{id}")
    public Pmanager getPmanagerById(@PathVariable Integer id) {
        return pservice.getById(id);
}
    @PostMapping("/admin/register")
    public Admin registerUser(@RequestBody Admin admin) {
        return adminService.registerAdmin(admin);
    }

    @PostMapping("/admin/login")
    public ResponseEntity<Admin> loginUser(@RequestBody Admin admin) {
        Admin loggedInAdmin = adminService.loginAdmin(admin.getEmail(), admin.getPassword());
        if (loggedInAdmin != null) {
            return ResponseEntity.ok(loggedInAdmin); // Return logged in admin
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // Return unauthorized status
        }
    }
//Tasks
@GetMapping("teammember/updatetasks/{id}")
public Task getTaskById(@PathVariable Long id) {
    return taskservice.getTaskId(id);
}


    @GetMapping("/teammember/teammembertasks/{teamMemberId}")
    public List<Task> getTasksForTeamMember(@PathVariable Long teamMemberId) {
        return taskservice.getTasksForTeamMember(teamMemberId);

    }

//        @PutMapping("/teammeber/uptasks/{id}")
//        public ResponseEntity<Task> updateTaskMember(@PathVariable Long id, @RequestBody Task updatedTask) {
//            if (!id.equals(updatedTask.getId())) {
//                return ResponseEntity.badRequest().build();
//            }
//            Task result = taskservice.updatedTask(updatedTask);
//            return ResponseEntity.ok(result);
//        }

    @PutMapping("/teammember/uptasks/{id}")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        Task updatedTask = taskservice.updateTaskStatus(id, taskDTO.getStatus());
        return ResponseEntity.ok(updatedTask);
    }


    @DeleteMapping("/admin/deletePmanager/{id}")
    public void deleteProjectManager(@PathVariable Integer id) {
        pservice.deleteProjectManager(id);
    }

    @PostMapping("/admin/paccount")
    public Pmanager regsiterProjectManager(@RequestBody Pmanager pm) {
        return pservice.registerPmanager(pm);
    }
    
    
    
    @PostMapping("/admin/tmember")
    public TeamMemb regsiterTeammember(@RequestBody TeamMemb tm) {
        return tservice.registerTeammemb(tm);
    }
    
    
    
    
    @GetMapping("/admin/listpmanagers")
    public List<Pmanager> getAllPmanagers() {
        return pservice.getallPmanagers();
    }
    
    @GetMapping("/admin/listteam")
    public List<TeamMemb> getAllteamMemebrs() {
        return tservice.getallTeamembers();
    }
    
    
    @GetMapping("admin/teammember/{id}")
    public TeamMemb getTeammemberById(@PathVariable Integer id) {
        return tservice.getById(id);
    }
    
    @PutMapping("/admin/editteam/{id}")
    public ResponseEntity<TeamMemb> updateTeamMember(@PathVariable Integer id, @RequestBody TeamMemb updatedTeamMember) {
        // Make sure the ID in the path matches the ID in the request body
        if (!id.equals(updatedTeamMember.getId())) {
            return ResponseEntity.badRequest().build();
        }
        TeamMemb result = tservice.updateTeamMember(updatedTeamMember);
        return ResponseEntity.ok(result);
    }
    
    
    @DeleteMapping("/admin/team/{id}")
    public void deleteTeammember(@PathVariable Integer id) {
        tservice.deleteteamMember(id);
    }
    
    
    
    
    
    
    
    @PostMapping("/admin/projectcreate")
    public Project createProject(@RequestBody Project pr) {
        return prservice.createProjects(pr);
    }
    
    
    
    
    @GetMapping("/admin/listprojects")
    public List<Project> getAllProjects() {
        return prservice.getallprojects();
    }
    
    @PostMapping("/projectmanager/projectcreate")
    public  Projecttable projectablecreation(@RequestBody Projecttable pt) {
    	return ptservice.projecttableCreation(pt);
    }
    
    
    @GetMapping("/projectmanager/projectslist")
    public List<Projecttable> getallProjectslist()
    {
    	return ptservice.getlistprojects();
    }
    
    
    
//    to get the particular projectId
    @GetMapping("projectmanager/projects/{id}")
    public ResponseEntity<Projecttable> getProjectById(@PathVariable Long id) {
        Projecttable project = ptservice.getProjectById(id);
        if (project != null) {
            return new ResponseEntity<>(project, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PostMapping("projectmanager/{teamMemberId}/tasks")
    public Task createTask(@PathVariable Integer teamMemberId, @RequestBody Task task) {
    	
    	return taskservice.saveTask(task);
    }
    
    @GetMapping("/projectmanager/tasklist")
    public List<Task> getAllTasks() {
        return taskservice.getAllTasks();
    }

    @DeleteMapping("/projectmanager/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskservice.deleteTask(id);
    }
    
    
    
    
    
    
    
    
   }
