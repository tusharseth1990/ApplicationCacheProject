package cache.model;

public class User {
	int id;
	String name;
	String emailId;
	String userType;
	
	 public User(int id, String name, String emailId, String userType) {
			super();
			this.id = id;
			this.name = name;
			this.emailId = emailId;
			this.userType = userType;
		}
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
}
