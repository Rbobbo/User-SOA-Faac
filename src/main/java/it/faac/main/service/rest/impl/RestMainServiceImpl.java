package it.faac.main.service.rest.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.faac.dto.UserDAOResponse;
import it.faac.dto.UserLoginRequestDTO;
import it.faac.entity.dao.UserDAO;

/**
 * Created webservice REST using Jaxws, the complete path is
 * http://localhost:8080/UsersSOA/rest/users/getlogin
 * http://localhost:port/ProjectName/ConfIntoweb.xml/Class@Path/Method@Path
 * @author ricca
 *
 */
@Path("/users")
@Produces( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Component
public class RestMainServiceImpl  extends SpringBeanAutowiringSupport
{
	@Autowired
	UserDAO userDao;
	
	/**
	 * This method call DAO for insert the param username sent via POST
	 * 
	 * @param UserLoginRequestDTO request.username
	 * @return <b>responseIsLogged</b> = a message with error or insert's confirm, with text media type  
	 */
	@POST
	@Path("/getlogin")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getLogin(UserLoginRequestDTO request)
	{
		UserDAOResponse userLoggedIn = userDao.addUserLogin(request.getUsername());
		
		String responseIsLogged = "";
		if(userLoggedIn.isOkInsert())
		{
			responseIsLogged = "User "+request.getUsername()+" registrato";
		}
		else
		{
			responseIsLogged = "Errore : "+userLoggedIn.getError();
		}
		
		return Response.status(200).entity(responseIsLogged).build();
	}
	

}
