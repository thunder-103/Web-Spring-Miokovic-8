package hr.vvg.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hr.vvg.spring.dao.TaskDao;
import hr.vvg.spring.entitet.Project;
import hr.vvg.spring.entitet.Task;
import hr.vvg.spring.entitet.User;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskDao taskDao;
	
	@Transactional
	@Override
	public List<User> fetchAllUsers() {
		
		return taskDao.fetchAllUsers();
	}
	
	@Transactional
	@Override
	public List<Project> fetchAllProjects() {
		
		return taskDao.fetchAllProjects();
	}

	@Transactional
	@Override
	public User fetchUserById(Integer id) {

		return taskDao.fetchUserById(id);
	}

	@Transactional
	@Override
	public Project fetchProjectById(Integer id) {

		return taskDao.fetchProjectById(id);
	}

	@Transactional
	@Override
	public void saveTask(Task task) {

		taskDao.saveTask(task);
	}

	@Transactional
	@Override
	public List<Integer> fetchHoursOptions() {
		
		List<Integer> hoursList = new ArrayList<Integer>();
		
		for(int i = 1; i<9; i++) {
			
			hoursList.add(i);
			
		}

		return hoursList;
	}

	@Transactional
	@Override
	public List<Task> fetchAllTasks() {

		return taskDao.fetchAllTasks();
	}
	
	//dodatni za 6. labos

//	@Override
//	public int totalTaskCount(Integer id) {
//		
//		return taskDao.totalTaskCount(id);
//	}

	@Transactional
	@Override
	public Task fetchTaskById(Integer id) {

		return taskDao.fetchTaskById(id);
	}

	@Transactional
	@Override
	public void updateTask(Task task) {
		
		taskDao.updateTask(task);
		
	}
	
	@Transactional
	@Override
	public List<Integer> fetchMaxProjectHours(Integer projectId) {

		return taskDao.fetchMaxProjectHours(projectId);
	}

}
