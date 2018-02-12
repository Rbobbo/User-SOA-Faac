package it.faac.entity.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.faac.dto.UserDAOResponse;
import it.faac.entity.UserEntity;
import it.faac.entity.dao.DaoAbstract;
import it.faac.entity.dao.UserDAO;

public class UserDAOImpl extends DaoAbstract implements UserDAO
{
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	public List<UserEntity> getUserList()
	{
		logger.info("Entered in getUserList without parameters");
		List<UserEntity> userList = new ArrayList<UserEntity>();
		Session session = getSessionLocal(); 
				
		userList = session.createQuery("from UserEntity").list();
		logger.info("Return getUserList {}", userList);
		
		return userList;
	}

	public UserDAOResponse addUserLogin(String username)
	{
		logger.info("Entered in addUserLogin {}",username);
		UserDAOResponse response = new UserDAOResponse();
		
		UserEntity userToWrite = new UserEntity();
		userToWrite.setUsername(username);
		
		try
		{
			Transaction tx = getSessionLocal().beginTransaction();
			getSessionLocal().save(userToWrite);
			if(!tx.wasCommitted())
			{
				tx.commit();
			}
			response.setOkInsert(true);
		}
		catch(ConstraintViolationException cv)
		{
			response.setOkInsert(false);
			response.setError("Utente già registrato");
			cv.printStackTrace();
		}
		catch(HibernateException he)
		{
			response.setOkInsert(false);
			response.setError("Errore : "+he.getMessage());
			he.printStackTrace();
		}
		
		return response;
	}




}
