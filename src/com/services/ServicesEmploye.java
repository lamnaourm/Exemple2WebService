package com.services;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.models.Employe;

@Path("/employes")
public class ServicesEmploye {
	
	List<Employe> employes;
	
	public ServicesEmploye() {
		init_data();
	}
	
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
	
	
	
	public void init_data() {
		employes = new ArrayList<>();
		employes.add(new Employe(1,"Zaid",2300));
		employes.add(new Employe(2,"Riad",4300));
		employes.add(new Employe(3,"ISabelle",3300));
	}	

}
