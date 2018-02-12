package it.faac;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.stereotype.Component;

@WebListener
@Component
public class ApplicationContextConfig implements ServletContextListener
{
	private static final Logger logger = Logger.getLogger("it.faac.ApplicationContextConfig");

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("Context inizializzato");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("Context distrutto");
	}

}
