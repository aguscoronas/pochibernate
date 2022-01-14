package ar.com.dcc.pochibernate;

import java.sql.Timestamp;
import java.util.Set;

public class User {
	private int userId;
	private String login;
	private String password;
	private Timestamp lastLogin;
	private Group defaultGroup;
	

	public User() {};
	public User(String login, String password, Group defaultGroup) {
		super();
		this.login = login;
		this.password = password;
		this.defaultGroup = defaultGroup;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Group getDefaultGroup() {
		return defaultGroup;
	}
	public void setDefaultGroup(Group defaultGroup) {
		this.defaultGroup = defaultGroup;
	}
	
}
