package org.hibernate.bugs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Grandchild {
    @Id
    private final String id;

    protected Grandchild() {
        this(null);
    }

    public Grandchild(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
