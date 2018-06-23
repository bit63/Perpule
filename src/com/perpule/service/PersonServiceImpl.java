package com.perpule.service;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.perpule.userInfo;
import com.perpule.Response;

@Path("/person")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class PersonServiceImpl implements PersonService {

	private static Map<Integer,userInfo> persons = new HashMap<Integer,userInfo>();
	
	@POST
        @Path("/add")
	public Response addPerson(userInfo personValue) {
		Response response = new Response();
		if(persons.get(personValue.getId()) != null){
			response.setStatus(false);
			response.setMessage("Person record already exists");
			return response;
		}
		persons.put(personValue.getId(), personValue);
		response.setStatus(true);
		response.setMessage("Person record created successfully");
		return response;
	}


	@GET
	@Path("/{id}/get")
	public userInfo getPerson(@PathParam("id") int id) {
		return persons.get(id);
	}	
}

