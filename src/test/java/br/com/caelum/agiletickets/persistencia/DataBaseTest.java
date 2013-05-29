package br.com.caelum.agiletickets.persistencia;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataBaseTest {
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
	
	@Test
	public void testName() throws Exception {
		
	}
}
