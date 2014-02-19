package com.service.janjon;

import java.io.File;

public abstract class ConfigManagerAbstract {
	
	private String type;	
	
	private String userName;
	
	private String userPassword;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public abstract boolean checkIn(String message);
	
	public abstract boolean checkOut();
	
	public abstract Object cloneRemoteRepository(String path,String name,String username,String password);
	
	public abstract Object getAllFiles();
	
	public abstract boolean commitFile(File file);
	
	public abstract boolean createRepository (String path);
	
	public abstract Object listRepositoryContent();	
	
	public abstract boolean pushRepository(Object repo,String url,String userName,String password);
	public abstract boolean fetchRepository(Object repo,String url,String userName,String password);
	
	

}
