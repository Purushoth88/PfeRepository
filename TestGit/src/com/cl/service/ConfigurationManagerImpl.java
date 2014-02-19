package com.cl.service;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class ConfigurationManagerImpl extends ConfigurationManager {

	@Override
	public Repository getRepositoryFromURL(String url, String login, String mdp) 
			throws InvalidRemoteException, TransportException, GitAPIException {
		
		File localPath = null;
		Repository repo=null;
		if (login !=null)
		{repo=Git.cloneRepository()
        .setURI(url).setCredentialsProvider(new UsernamePasswordCredentialsProvider(login, mdp))
        .setDirectory(localPath).getRepository();}
		else 
		{repo=Git.cloneRepository()
	        .setURI(url)
	        .setDirectory(localPath).getRepository();
		}
		return repo;
	}
	@Override
	public void checkOut(Repository repo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void chekcIn(Repository repo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getAllVersion(Repository repo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void changebranch(Repository repo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getAllProject(Repository repo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getLocalRepository(String path) {
		// TODO Auto-generated method stub
		
	}

}
