package com.service.janjon1;

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
	
	public abstract String cloneRemoteRepository(String path,String name,String username,String password);
	
	public abstract boolean addFile(String Path,String name);
	
	public abstract boolean createRepository (String path);
	
	public abstract Object listRepositoryContent();	
	
	public abstract boolean pushRepository(String repoPath,String url,String userName,String password);

	public abstract boolean pullRepository(String repoPath, String url, String userName,
			String password) ;
	
	

}
