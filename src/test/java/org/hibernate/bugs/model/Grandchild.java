package org.hibernate.bugs.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Grandchild {
    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @Column
    private String aField;

    public Grandchild() {
        this(null);
    }

    public Grandchild(String aField) {
        this.aField = aField;
    }

    public UUID getId() {
        return id;
    }
}
