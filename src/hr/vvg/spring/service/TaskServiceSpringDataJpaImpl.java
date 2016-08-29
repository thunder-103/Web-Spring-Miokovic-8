package hr.vvg.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hr.vvg.spring.entitet.Project;
import hr.vvg.spring.entitet.Task;
import hr.vvg.spring.entitet.User;
import hr.vvg.spring.repository.ProjectRepository;
import hr.vvg.spring.repository.TaskRepository;
import hr.vvg.spring.repository.UserRepository;

public class TaskServiceSpringDataJpaImpl implements TaskService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	

	@Override
	public List<User> fetchAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public User fetchUserById(Integer id) {
		
		return userRepository.findOne(id);
	}

	@Override
	public List<Project> fetchAllProjects() {

		return projectRepository.findAll();
	}

	@Override
	public Project fetchProjectById(Integer id) {

		return projectRepository.findOne(id);
	}

	@Override
	public void saveTask(Task task) {

		taskRepository.save(task);
		
	}

	@Override
	public List<Integer> fetchHoursOptions() {
		
		List<Integer> hoursList = new ArrayList<Integer>();
		
		for(int i = 1; i<9; i++) {
			
			hoursList.add(i);
			
		}

		return hoursList;
	}

	@Override
	public List<Task> fetchAllTasks() {

		return taskRepository.findAll();
	}

	@Override
	public Task fetchTaskById(Integer id) {

		return taskRepository.findOne(id);
	}

	@Override
	public void updateTask(Task task) {

		taskRepository.save(task);
		
	}
	
	//dodatni za 8 labos ali preko hibernate a ne jpa

	@Override
	public List<Integer> fetchMaxProjectHours(Integer projectId) {

		return null;
	}

}
