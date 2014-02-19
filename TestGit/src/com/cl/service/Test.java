package com.cl.service;


import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.eclipse.jgit.util.StringUtils;

public class Test {
	public static void cloneRepository(String localRepositoryPath, String remoteRepositoryURI, String branch, String username, String password) 
			throws IOException, InvalidRemoteException, GitAPIException 
	{// File workDir =createFolder(localRepositoryPath); 
	CloneCommand clone = Git.cloneRepository(); 
	clone.setBare(false);
	clone.setCloneAllBranches(false);
	clone.setBranch(branch); 
	//clone.setDirectory(workDir).setURI(remoteRepositoryURI);
	/*if (StringUtils.isNotEmpty(username)) 
	{ UsernamePasswordCredentialsProvider credentials = new UsernamePasswordCredentialsProvider(username, password); 
	clone.setCredentialsProvider(credentials); }*/
	Git git = clone.call(); }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
