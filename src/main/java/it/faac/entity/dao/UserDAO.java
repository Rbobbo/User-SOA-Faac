package it.faac.entity.dao;

import java.util.List;

import it.faac.dto.UserDAOResponse;
import it.faac.entity.UserEntity;


public interface UserDAO
{
	/**
	 * Get all the user registered from the db
	 * @return
	 */
	public List<UserEntity> getUserList();
	
	/**
	 * Login
	 * @param username, password
	 * @return user loggedin or null
	 */
	public UserDAOResponse addUserLogin(String username);
	

}
