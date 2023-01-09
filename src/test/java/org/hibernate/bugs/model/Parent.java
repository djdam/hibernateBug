package org.hibernate.bugs.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Parent {
    @Id
    private final String id;
    @Embedded
    private final Child child;

    protected Parent() {
        this(null, null);
    }

    public Parent(String id, Child child) {
        this.id = id;
        this.child = child;
    }

    public String getId() {
        return id;
    }

    public Child getChild() {
        return child;
    }
}
