package com.perpule.service;

import com.perpule.userInfo;
import com.perpule.Response;

public interface PersonService {

	public Response addPerson(userInfo personInfo);
	public userInfo getPerson(int id);
	
}
