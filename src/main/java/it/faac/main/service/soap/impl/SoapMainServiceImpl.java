package it.faac.main.service.soap.impl;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.faac.entity.UserEntity;
import it.faac.entity.dao.UserDAO;
import it.faac.main.service.soap.SoapMainService;

@WebService(serviceName = "getUsersWS")
public class SoapMainServiceImpl extends SpringBeanAutowiringSupport implements SoapMainService
{

	private UserDAO userDao;


	@WebMethod
	@Override
	public List<UserEntity> getUsersLoggedIn()
	{
		List<UserEntity> usList = userDao.getUserList();
		
		return usList;
	}

	@WebMethod(exclude = true)
	public UserDAO getUserDao() {
		return userDao;
	}

	@WebMethod(exclude = true)
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

}
