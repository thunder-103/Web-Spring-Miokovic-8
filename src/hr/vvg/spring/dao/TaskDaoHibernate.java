package hr.vvg.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hr.vvg.spring.entitet.Project;
import hr.vvg.spring.entitet.Task;
import hr.vvg.spring.entitet.User;

@Repository
public class TaskDaoHibernate implements TaskDao {
	
	public TaskDaoHibernate() {}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}

	
	private Session getCurrentSession() {
		
		return sessionFactory.getCurrentSession();
	    }

	@SuppressWarnings("unchecked")
	@Override
	public List<User> fetchAllUsers() {
		
		return getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User fetchUserById(Integer userId) {
		
		return (User) getCurrentSession().get(User.class, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> fetchAllProjects() {

		return getCurrentSession().createQuery("from Project").list();
	}

	@Override
	public Project fetchProjectById(Integer projectId) {

		return (Project) getCurrentSession().get(Project.class, projectId);
	}

	@Override
	public void saveTask(Task task) {
		
		getCurrentSession().save(task);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> fetchAllTasks() {

		return getCurrentSession().createQuery("from Task").list();
	}

	@Override
	public Task fetchTaskById(Integer taskId) {

		return (Task) getCurrentSession().get(Task.class, taskId);
	}

	@Override
	public void updateTask(Task task) {

		getCurrentSession().update(task);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> fetchMaxProjectHours(Integer projectId) {

		Query query = getCurrentSession().createQuery("select count (*)"
				+ "from Task as task where task.project = :projectId");
		
		query.setInteger("projectId", projectId);
        return query.list();
	}




}
