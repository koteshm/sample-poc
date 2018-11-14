package com.examples.kotesh;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegisteredUserTest {
	private SessionFactory sessionFactory;
	private Session session;

	
	
	@Before
	public void setUp() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	@Test
	public void testSave() {
		RegisteredUser expectedRegisteredUser = new RegisteredUser();
		expectedRegisteredUser.setRegisteredUserId("reg-1");
		expectedRegisteredUser.setUserName("kotesh");
		RegisteredVehicle registeredVehicle = new RegisteredVehicle();
		registeredVehicle.setVehicleName("RangeRover");
		registeredVehicle.setVehicleId("Veh-1");
		expectedRegisteredUser.getRegisteredVehicle().add(registeredVehicle);

		
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(expectedRegisteredUser);
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		RegisteredUser actualRegisteredUser = session.get(RegisteredUser.class, "reg-1");
		assertEquals(expectedRegisteredUser.getRegisteredUserId(), actualRegisteredUser.getRegisteredUserId());
		session.close();

	}
	
	@After
	public void tearDown() {
		sessionFactory.close();
	}
}
