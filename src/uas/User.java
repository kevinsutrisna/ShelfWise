package uas;

abstract public class User {
	private String userId, name, phoneNumber;
	public User(String userId, String name, String phoneNumber) {
		this.userId = userId;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public String getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
