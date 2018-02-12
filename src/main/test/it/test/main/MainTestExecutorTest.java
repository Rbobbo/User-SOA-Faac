package it.test.main;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import it.faac.entity.dao.UserDAO;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {  
  "file:webapp/WEB-INF/spring-context.xml"
  })
public class MainTestExecutorTest {

	@Autowired
	UserDAO userDao;
	
	@Test
	public void testTotal_test()
	{
		
		if (userDao.getUserList() == null)
			assertFalse("Errore durante il get della lista utenti loggati",true);
		else
			assertTrue("Connessione e get lista utenti eseguita ",true);
		
	}

}
