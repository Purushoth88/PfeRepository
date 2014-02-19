package com.service.janjon;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.FetchCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.CreateBranchCommand.SetupUpstreamMode;
import org.eclipse.jgit.api.errors.CheckoutConflictException;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class GitConfigManager extends ConfigManagerAbstract {

	private Repository repository;
	private Git git;

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
		
	}

	public Git getGit() {
		return git;
	}

	public void setGit(Git git) {
		this.git = git;
	}

	public GitConfigManager(Repository repo) {
		
		setType("GIT");
		repository = repo;
		git = new Git(repository);
		System.out.println("GitConfigManager created");
	}

	public GitConfigManager(String chemin) {
		setType("GIT");
		FileRepositoryBuilder builder = new FileRepositoryBuilder();
		try {
			repository = builder.setGitDir(new File(chemin))
			// scan up the file system tree
					.build();
			git = new Git(repository);
			System.out.println("GitConfigManager created");

		} catch (IOException e) {
			System.out.println("wrong Repository Path");
			e.printStackTrace();
		}

	}

	// commit a repository
	@Override
	public boolean checkIn(String message) {
		try {
			CommitCommand commit = git.commit();
			commit.setAuthor("", "");
			commit.setMessage(message);
			commit.call();
			System.out.println(repository.getDirectory().getName()+" Commited");
			return true;
		} catch (NoHeadException e) {
			System.out.println("NoHeadException");
			e.printStackTrace();
			return false;
		} catch (NoMessageException e) {
			System.out.println("NoMessageException");
			e.printStackTrace();
			return false;
		} catch (UnmergedPathsException e) {
			System.out.println("UnmergedPathsException");
			e.printStackTrace();
			return false;
		} catch (ConcurrentRefUpdateException e) {
			System.out.println("ConcurrentRefUpdateException");
			e.printStackTrace();
			return false;
		} catch (WrongRepositoryStateException e) {
			System.out.println("WrongRepositoryStateException");
			e.printStackTrace();
			return false;
		} catch (GitAPIException e) {
			System.out.println("GitAPIException");
			e.printStackTrace();
			return false;
		}

	}

	// mettre à jour une repository par rapport au head
	@Override
	public boolean checkOut() {
		try {
			CheckoutCommand checkOutCommand = git.checkout();
			checkOutCommand.setAllPaths(true);
			checkOutCommand.call();
			System.out.println(repository.getDirectory().getName()+" checkedOut");
			return true;
		} catch (RefAlreadyExistsException e) {
			System.out.println("RefAlreadyExistsException");
			e.printStackTrace();
			return false;
		} catch (RefNotFoundException e) {
			System.out.println("RefNotFoundException");
			e.printStackTrace();
			return false;
		} catch (InvalidRefNameException e) {
			System.out.println("InvalidRefNameException");
			e.printStackTrace();
			return false;
		} catch (CheckoutConflictException e) {
			System.out.println("CheckoutConflictException");
			e.printStackTrace();
			return false;
		} catch (GitAPIException e) {
			System.out.println("GitAPIException");
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Object getAllFiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean commitFile(File file) {
		return false;
	}

	@Override
	public boolean createRepository(String path) {

		try {
			Repository newRepo = new FileRepository(path + ".git");
			newRepo.create();
			System.out.println(repository.getDirectory().getName()+" Created");
			return true;
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Object listRepositoryContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Repository cloneRemoteRepository(String url, String name,
			String username, String password) {
			CloneCommand cloneCommand = Git.cloneRepository();
			File file = new File(repository.getDirectory().getPath() + "/" + name);
			cloneCommand.setDirectory(file);
			cloneCommand.setURI(url);
			
			cloneCommand.setBare(false);
			
		if (username!=null) {
			cloneCommand
					.setCredentialsProvider(new UsernamePasswordCredentialsProvider(
							username, password));
		}
		try {
			cloneCommand.call();
			System.out.println("cloneRemoteRepository getted");
			FileRepositoryBuilder builder = new FileRepositoryBuilder();
			Repository repo;
			try {
				repo = builder.setGitDir(file)
						// scan up the file system tree
								.build();
				System.out.println("repository getted");
				return repo;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
		} catch (InvalidRemoteException e) {
			System.out.println("InvalidRemoteException getted");
			e.printStackTrace();
			return null;
		} catch (TransportException e) {
			System.out.println("TransportException getted");
			e.printStackTrace();
			return null;
		} catch (GitAPIException e) {
			System.out.println("GitAPIException getted");
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean pushRepository(Object repo, String url, String userName,
			String password) {
		Repository rep=(Repository) repo;
		Git git=new Git((Repository)rep);	
		
		
		PushCommand pushCommand=git.push();
		pushCommand.setRemote(url);
		pushCommand.setDryRun(true);
		pushCommand.setPushAll();
		
		pushCommand.setForce(true);
		//pushCommand.
		
		if(userName!=null)
		pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(userName, password));
		try {
			
			pushCommand.call();
			System.out.println("push called");
			return true;
		} catch (InvalidRemoteException e) {
			System.out.println("InvalidRemoteException");
			e.printStackTrace();
			return false;
		} catch (TransportException e) {
			System.out.println("TransportException");
			e.printStackTrace();
			return false;
		} catch (GitAPIException e) {
			System.out.println("GitAPIException");
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean fetchRepository(Object repo, String url, String userName,
			String password) {
		Repository rep=(Repository)repo;
		Git git=new Git((Repository)rep);
		FetchCommand fetchCommand=git.fetch();
		if(userName!=null)
			fetchCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(userName, password));
		fetchCommand.setRemote(url)	;
		try {
			System.out.println(rep.getDirectory().getName()+" fetched");
			fetchCommand.call();
			return true;
		} catch (InvalidRemoteException e) {
			System.out.println("InvalidRemoteException");
			e.printStackTrace();
			return false;
		} catch (TransportException e) {
			System.out.println("TransportException");
			e.printStackTrace();
			return false;
		} catch (GitAPIException e) {
			System.out.println("GitAPIException");
			e.printStackTrace();
			return false;
		}
		
	}

}
