package hr.vvg.spring.service;

import java.util.List;
import hr.vvg.spring.entitet.Project;
import hr.vvg.spring.entitet.Task;
import hr.vvg.spring.entitet.User;

public interface TaskService {
	
	List<User> fetchAllUsers();
	User fetchUserById(Integer id);
	List<Project> fetchAllProjects();
	Project fetchProjectById(Integer id);
	void saveTask(Task task);
	List<Integer> fetchHoursOptions();
	List<Task> fetchAllTasks();
	Task fetchTaskById(Integer id);
	
	void updateTask(Task task);
	
	//dodatni za 6. labos
	
	//public int totalTaskCount(Integer id);
	
	//dodatni za 8 labos
	
	List<Integer> fetchMaxProjectHours(Integer projectId);

}
