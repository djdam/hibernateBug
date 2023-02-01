package org.hibernate.bugs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.bugs.model.AnotherParent;
import org.hibernate.bugs.model.Child;
import org.hibernate.bugs.model.Grandchild;
import org.hibernate.bugs.model.Parent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

    private EntityManagerFactory entityManagerFactory;

    @Before
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("templatePU");
    }

    @After
    public void destroy() {
        entityManagerFactory.close();
    }

    @Test
    public void hhh16007Test() {

        assertThatCode(() ->
                doInTransaction(entityManager -> {
                    var parent1 = new Parent(null);
                    var anotherParent1 = new AnotherParent(Collections.emptyList());
                    var parent2 = new Parent(new Child(List.of(new Grandchild("xyz"))));
//                    entityManager.persist(anotherParent1);
                    entityManager.persist(parent1);
                    entityManager.persist(parent2);
                })).doesNotThrowAnyException();
    }

    private void doInTransaction(Consumer<EntityManager> action) {
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            action.accept(entityManager);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
}
