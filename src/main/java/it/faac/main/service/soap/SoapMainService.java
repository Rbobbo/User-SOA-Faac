package it.faac.main.service.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import it.faac.entity.UserEntity;

/**
 * Create a WebService soap handler with standard Java Prototype "WebService"
 * @author ricca
 *
 */
@WebService
public interface SoapMainService {

	/**
	 * This method no need paramenters, return a simple list of <b>UserEntity</b> 
	 * @return <b>Users</b> = a user's list stored
	 */
	@WebMethod
	List<UserEntity> getUsersLoggedIn();
}
