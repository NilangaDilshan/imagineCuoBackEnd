package com.excelResearchers.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.excelResearchers.domain.Project;
import com.excelResearchers.utils.MongoResourceUtil;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;

@Path("/project")
public class ProjectController {
	private final static Logger logger = Logger.getLogger(ProjectController.class);
	
	public ProjectController()
	{
		
	}
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Project insertProject(Project project)
	{
		System.out.println("Object: "+project.toString());
		Datastore dataStore=MongoResourceUtil.INSTANCE.getDatastore();
		Key<Project> savedActItem = dataStore.save(project);
		return project;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getActionItemPath()
	{
		return "{\"test\":\"Test Property\"}";
	}
}
