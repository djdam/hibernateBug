package org.hibernate.bugs;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.hibernate.bugs.model.Child;
import org.hibernate.bugs.model.Grandchild;
import org.hibernate.bugs.model.Parent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	@Test
	public void hhh16007Test() throws Exception {
		var entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		var parent = new Parent("123", new Child(List.of(new Grandchild("xyz"))));
		entityManager.persist(parent);
		entityManager.flush();
		entityManager.clear();

		entityManager.remove(entityManager.getReference(Parent.class, "123"));
		entityManager.flush();


		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
