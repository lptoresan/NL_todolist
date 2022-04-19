package br.com.listatarefa.dao;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ConnectionFactory {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("ListaPU");
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
