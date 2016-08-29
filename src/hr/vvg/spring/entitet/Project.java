package hr.vvg.spring.entitet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TASK.PROJECT")
public class Project {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer projectId;
	
	@Column(name = "NAME")
	private String projectName;
	
	@Column(name = "COMPANYNAME")
	private String projectCompany;
	
	public Project(Integer projectId, String projectName, String projectCompany) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectCompany = projectCompany;
	}
	
	public Project() {}
	
	
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projectCompany == null) ? 0 : projectCompany.hashCode());
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
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
		Project other = (Project) obj;
		if (projectCompany == null) {
			if (other.projectCompany != null)
				return false;
		} else if (!projectCompany.equals(other.projectCompany))
			return false;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		return true;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectCompany() {
		return projectCompany;
	}

	public void setProjectCompany(String projectCompany) {
		this.projectCompany = projectCompany;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

}
