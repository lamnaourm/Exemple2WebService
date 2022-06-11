package com.services;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.models.Employe;

@Path("/employes")
public class ServicesEmploye {
	
	static List<Employe> employes;
	

	
	@GET
	@Path("/allemps")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employe> getAllEmploye(){
		return employes;
	}
	
	@GET
	@Path("/onemp")
	@Produces(MediaType.APPLICATION_JSON)
	public Employe getEmploye(@QueryParam("id") int ident){
		for(Employe e : employes)
			if(e.getId() == ident)
				return e;
		return null;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void AddEmploye(Employe e) {
		employes.add(e);
	}
	
	
	
	static {
		employes = new ArrayList<>();
		employes.add(new Employe(1,"Zaid",2300));
		employes.add(new Employe(2,"Riad",4300));
		employes.add(new Employe(3,"ISabelle",3300));
	}	

}
