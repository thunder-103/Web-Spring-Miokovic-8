package hr.vvg.spring.entitet;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TASK.PROJECT_TASK")
public class Task {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer taskId;
	
	@ManyToOne
	@JoinColumn(name="USERID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="PROJECTID")
	private Project project;
	
	@Column(name = "DESCRIPTION")
	private String taskDescription;
	
	@Column(name = "ESTIMATEDDURATIONHOURS")
	private Integer estimatedTime;
	
	@Column(name = "EXPIRYDATE")
	private Date expiryDate;
	
	public Task(Integer taskId, User user, Project project, String taskDescription, 
			Integer estimatedTime, Date expiryDate) {
		super();
		this.taskId = taskId;
		this.user = user;
		this.project = project;
		this.taskDescription = taskDescription;
		this.estimatedTime = estimatedTime;
		this.expiryDate = expiryDate;
	}

	public Task() {}
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + ((estimatedTime == null) ? 0 : estimatedTime.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((taskDescription == null) ? 0 : taskDescription.hashCode());
		result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (estimatedTime == null) {
			if (other.estimatedTime != null)
				return false;
		} else if (!estimatedTime.equals(other.estimatedTime))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (taskDescription == null) {
			if (other.taskDescription != null)
				return false;
		} else if (!taskDescription.equals(other.taskDescription))
			return false;
		if (taskId == null) {
			if (other.taskId != null)
				return false;
		} else if (!taskId.equals(other.taskId))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Integer getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(Integer estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	

}
