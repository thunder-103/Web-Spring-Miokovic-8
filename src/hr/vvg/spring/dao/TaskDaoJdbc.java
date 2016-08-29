package hr.vvg.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import hr.vvg.spring.entitet.Project;
import hr.vvg.spring.entitet.Task;
import hr.vvg.spring.entitet.User;

@Repository
public class TaskDaoJdbc extends JdbcDaoSupport implements TaskDao{
	
	
	
	@Override
	public List<User> fetchAllUsers() {
		
		String usersSql = "SELECT * FROM TASK.APP_USER";
		List<User> userList = getJdbcTemplate().query(usersSql, new UserRowMapper());
		
		return userList;
	}
	
	class UserRowMapper implements RowMapper<User> {
		
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			int userId = (Integer) rs.getInt("id");
			String username = (String) rs.getString("username");
			String firstName = (String) rs.getString("firstname");
			String lastName = (String) rs.getString("lastname");
			User user = new User(userId, username, firstName, lastName);
			
			return user;
			}
		}
	
	@Override
	public User fetchUserById(Integer userId) {
		
		String userSql = "SELECT * FROM TASK.APP_USER WHERE ID = ?";
		
		Object[] param = new Object[] {userId};
		User user = getJdbcTemplate().queryForObject(userSql, param, new UserRowMapper());
		
		return user;
	}
	
	@Override
	public List<Project> fetchAllProjects() {
		
		String projectsSql = "SELECT * FROM TASK.PROJECT";
		List<Project> projectList = getJdbcTemplate().query(projectsSql, new ProjectRowMapper());
		
		return projectList;
	}
	
	class ProjectRowMapper implements RowMapper<Project> {
		
		public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			int projectId = (Integer) rs.getInt("id");
			String projectName = (String) rs.getString("name");
			String projectCompany = (String) rs.getString("companyname");
			Project project = new Project(projectId, projectName, projectCompany);
			
			return project;
			}
		}
	
	@Override
	public Project fetchProjectById(Integer projectId) {
		
		String projectSql = "SELECT * FROM TASK.PROJECT WHERE ID = ?";
		
		Object[] param = new Object[] {projectId};
		Project project = getJdbcTemplate().queryForObject(projectSql, param, new ProjectRowMapper());
		
		return project;
	}
	
	@Override
	public List<Task> fetchAllTasks() {
		
		String tasksSql = "SELECT * FROM TASK.PROJECT_TASK ORDER BY ID ASC";
		List<Task> taskList = getJdbcTemplate().query(tasksSql, new TaskRowMapper());
		
		return taskList;
	}
	
	class TaskRowMapper implements RowMapper<Task> {
		
		public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			int taskId = (Integer) rs.getInt("id");
			Project project = (Project) fetchProjectById(rs.getInt("projectid"));
			User user = (User) fetchUserById(rs.getInt("userid"));
			String taskDescription = (String) rs.getString("description");
			int estimatedHours = (Integer) rs.getInt("estimateddurationhours");
			Date expiryDate = (Date) rs.getDate("expirydate");
			Task task = new Task(taskId, user, project, taskDescription, estimatedHours, expiryDate);
			
			return task;
			}
		}
	
	@Override
	public void saveTask(Task task) {
		
		String saveTaskSql = "INSERT INTO TASK.PROJECT_TASK(PROJECTID, USERID, DESCRIPTION"
		+ ", ESTIMATEDDURATIONHOURS) VALUES(?, ?, ?, ?)";
		
		Object[] params = new Object[4];
		params[0] = task.getProject().getProjectId();
		params[1] = task.getUser().getUserId();
		params[2] = task.getTaskDescription();
		params[3] = task.getEstimatedTime();
		getJdbcTemplate().update(saveTaskSql, params);
	}

	
	//dodatni za 6. labos

//	@Override
//	public int totalTaskCount(Integer userId) {
//		
//		String sql = "SELECT count(TASK.PROJECT_TASK.PROJECTID) NUMBERTASK "
//				+ "FROM TASK.APP_USER ,TASK.PROJECT_TASK "
//				+ "WHERE TASK.PROJECT_TASK.USERID = ?";
//		
//		int total = getJdbcTemplate().queryForObject(sql, new Object[] { userId }, Integer.class);
//		
//		return total;
//	}

	@Override
	public Task fetchTaskById(Integer taskId) {
		
		String taskSql = "SELECT * FROM TASK.PROJECT_TASK WHERE ID = ?";
		
		Object[] param = new Object[] {taskId};
		Task task = getJdbcTemplate().queryForObject(taskSql, param, new TaskRowMapper());
	
		return task;
	}

	@Override
	public void updateTask(Task task) {

		String updateTaskSql = "UPDATE TASK.PROJECT_TASK SET PROJECTID=?, USERID=?, DESCRIPTION=?"
		+ ", ESTIMATEDDURATIONHOURS=? WHERE ID=?";
		
		Object[] params = new Object[5];
		params[0] = task.getProject().getProjectId();
		params[1] = task.getUser().getUserId();
		params[2] = task.getTaskDescription();
		params[3] = task.getEstimatedTime();
		params[4] = task.getTaskId();
		getJdbcTemplate().update(updateTaskSql, params);
		
	}

	
	//dodatni za 8 labos, da se ne crveni
	@Override
	public List<Integer> fetchMaxProjectHours(Integer projectId) {
		String sql = "SELECT sum(TASK.PROJECT_TASK.ESTIMATEDDURATIONHOURS) HOURPROJECT "
				+ "FROM TASK.PROJECT_TASK WHERE TASK.PROJECT_TASK.PROJECTID = ?";
		
		int total = getJdbcTemplate().queryForObject(sql, new Object[] { projectId }, Integer.class);
		
		List<Integer> hourList = new ArrayList<>();
		
		hourList.add(total);
		
		return hourList;
	}
	
//	SELECT sum(TASK.PROJECT_TASK.ESTIMATEDDURATIONHOURS) HOURPROJECT FROM TASK.PROJECT_TASK WHERE TASK.PROJECT_TASK.PROJECTID = 3


}
