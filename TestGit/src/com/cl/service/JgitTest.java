package com.cl.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.jgit.api.*;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.lib.*;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;


public class JgitTest {
	
	private static final String REMOTE_URL = "https://github.com/sahat/hackathon-starter";
	public static void main (String []args ) throws GitAPIException, IOException 
	{
		
		//BaseRepositoryBuilder<BaseRepositoryBuilder, Repository> builder=new BaseRepositoryBuilder<>();
		//System.out.println(builder.getGitDir());
		/*Repository repository = FileRepositoryBuilder.create(new File("/tmp/repo/.git"));
		//System.out.println(repository.set);	
		Git git=new Git(repository);		
		
		StoredConfig config = git.getRepository().getConfig();
		config.setString("remote", "origin", "url", "https://github.com/ymnk/jsch-agent-proxy");
		config.save();
		//System.out.println(repository.toString());
		FetchCommand fetch = git.fetch();
		fetch.setRemote("https://github.com/ymnk/jsch-agent-proxy");
		System.out.println(fetch.call().getMessages());
		Repository repository = FileRepositoryBuilder.create(new File("./tmp/repo/.git"));
		Git git=new Git(repository);
		gitClone(git);
		git.fetch();
		System.out.println(git.getRepository().getBranch());*/
		
		
		    File gitWorkDir = new File("home/lazher/git");
		    
		    Git git = Git.open(gitWorkDir);		    		
		    String oldHash = "d7db296cc2730ca562f91cfa539d6955a21284b6";
		 
		    ObjectId headId = git.getRepository().resolve("HEAD^{tree}");
		    ObjectId oldId = git.getRepository().resolve(oldHash + "^{tree}");
		 
		    ObjectReader reader = git.getRepository().newObjectReader();
		     
		    CanonicalTreeParser oldTreeIter = new CanonicalTreeParser();
		    oldTreeIter.reset(reader, oldId);
		    CanonicalTreeParser newTreeIter = new CanonicalTreeParser();
		    newTreeIter.reset(reader, headId);
		 
		    List<DiffEntry> diffs= git.diff()
		            .setNewTree(newTreeIter)
		            .setOldTree(oldTreeIter)
		            .call();
		     
		    ByteArrayOutputStream out = new ByteArrayOutputStream();
		    DiffFormatter df = new DiffFormatter(out);
		    df.setRepository(git.getRepository());
		 
		    for(DiffEntry diff : diffs)
		    {
		      df.format(diff);
		      diff.getOldId();
		      String diffText = out.toString("UTF-8");
		      System.out.println(diffText);
		      out.reset();
		    }
		  }
		
	public static void gitClone(Git git) throws GitAPIException {
	    final File localPath = new File("./TestRepo");
	    git.cloneRepository()
	        .setURI(REMOTE_URL)
	        .setDirectory(localPath).call();
	        //.setCredentialsProvider(new UsernamePasswordCredentialsProvider("***", "***"))
	   
	      
	}
	

}
