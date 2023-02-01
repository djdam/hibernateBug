package org.hibernate.bugs.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Parent {
    @Id
    @GeneratedValue
    @Column
    private UUID id;
    @Embedded
    private final Child child;

    protected Parent() {
        this(null);
    }

    public Parent(Child child) {
        this.child = child;
    }

    public UUID getId() {
        return id;
    }

    public Child getChild() {
        return child;
    }
}
