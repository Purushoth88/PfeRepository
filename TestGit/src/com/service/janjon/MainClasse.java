package com.service.janjon;



public class MainClasse {

	public static void main(String[] args) {
		
		
		GitConfigManager CM=new GitConfigManager("/home/lazher/git/Repository/.git/TestCloneRepository/.git");
		
		//CM.checkIn("gfhfhsfg");
		System.out.println(CM.getRepository().getRepositoryState());
		
		//CM.checkOut();
		//CM.createRepository("/home/lazher/git/.git/newRepo");
		//CM.cloneRemoteRepository("https://github.com/chemakh/TestRepository.git", "TestCloneRepository","chemakh", "taraji0000");
		//CM.checkIn("haremna");
		CM.fetchRepository(CM.getRepository(), "https://github.com/chemakh/TestRepository.git","chemakh", "taraji0000");
	}}
