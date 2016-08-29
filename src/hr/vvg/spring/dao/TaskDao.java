package hr.vvg.spring.dao;

import java.util.List;
import hr.vvg.spring.entitet.Project;
import hr.vvg.spring.entitet.Task;
import hr.vvg.spring.entitet.User;

public interface TaskDao {
	
	List<User> fetchAllUsers();
	User fetchUserById(Integer userId);
	List<Project> fetchAllProjects();
	Project fetchProjectById(Integer projectId);
	void saveTask(Task task);
	List<Task> fetchAllTasks();
	Task fetchTaskById(Integer taskId);
	
	void updateTask(Task task);
	
	//dodatni za 6. labos
	
	//int totalTaskCount(Integer userId);
	
	//dodatni za 8. a
	
	List<Integer> fetchMaxProjectHours(Integer projectId);

}
