package es.indra.academiamvc.configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Inicializador implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent sce) {

		// DOMConfigurator.configure("log4j.xml");
		System.out.println("LISTENER DE PRUEBA");

	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}