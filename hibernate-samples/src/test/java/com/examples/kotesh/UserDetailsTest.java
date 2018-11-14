package com.examples.kotesh;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserDetailsTest {
	private SessionFactory sessionFactory;
	private Session session;

	
	
	@Before
	public void setUp() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	@Test
	public void testSave() {
		UserDetails expectedUserDetails = new UserDetails();
		expectedUserDetails.setUserId(5);
		expectedUserDetails.setUserName("kotesh");
		Address address = new Address();
		address.setCity("phoenix");
		address.setState("AZ");
		expectedUserDetails.setAdress(address);
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(expectedUserDetails);
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		UserDetails actualUserDetails = session.get(UserDetails.class, 5);
		assertEquals(expectedUserDetails, actualUserDetails);
		session.close();
	}
	
	@After
	public void tearDown() {
		sessionFactory.close();
	}

}
