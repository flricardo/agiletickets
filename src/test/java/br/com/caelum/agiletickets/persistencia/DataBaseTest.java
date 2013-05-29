package br.com.caelum.agiletickets.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

public abstract class DataBaseTest {
	private EntityManagerFactory factory;
	protected EntityManager manager;
	
//	@Before
//	public void comeco(){
//		factory = Persistence.createEntityManagerFactory("test");
//		manager = factory.createEntityManager();
//		manager.getTransaction().begin();
//	}
//	
//	@After
//	public void fim(){
//		manager.getTransaction().rollback();
//	}
}
