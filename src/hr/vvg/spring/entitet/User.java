package hr.vvg.spring.entitet;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TASK.APP_USER")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4433586855033456753L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer userId;
	
	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "FIRSTNAME")
	private String userFirstName;
	
	@Column(name = "LASTNAME")
	private String userLastName;
	
	
	public User(Integer userId, String userName, String userFirstName, String userLastName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
	}
	
	public User() {}
	
	//overridati equals i hashCode metodu!!!!!!
	
	
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userFirstName == null) ? 0 : userFirstName.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userLastName == null) ? 0 : userLastName.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		User other = (User) obj;
		if (userFirstName == null) {
			if (other.userFirstName != null)
				return false;
		} else if (!userFirstName.equals(other.userFirstName))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userLastName == null) {
			if (other.userLastName != null)
				return false;
		} else if (!userLastName.equals(other.userLastName))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserFirstName() {
		return userFirstName;
	}


	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public String getUserLastName() {
		return userLastName;
	}


	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	
	public String getDisplayName() {
	    return userFirstName + " " + userLastName;
	}
	

}
