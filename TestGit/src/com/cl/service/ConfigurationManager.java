package com.cl.service;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.lib.Repository;

public abstract class ConfigurationManager {
	
	public abstract void checkOut (Repository repo);
	public abstract void chekcIn(Repository repo);
	public abstract void getAllVersion(Repository repo);
	public abstract Repository getRepositoryFromURL(String url,String login,String mdp) throws InvalidRemoteException, TransportException, GitAPIException;
	public abstract void changebranch (Repository repo);
	public abstract void getAllProject(Repository repo);
	public abstract void getLocalRepository(String path);
	
	
	

}
