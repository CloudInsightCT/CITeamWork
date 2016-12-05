package ict.monitor.bean;

public class Security {
	String username;
	String token;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Security(String username, String token) {
		super();
		this.username = username;
		this.token = token;
	}
	
	
	
	

}
