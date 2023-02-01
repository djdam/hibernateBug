package org.hibernate.bugs.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class AnotherParent {
    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL)
    private final List<Grandchild> grandchildren = new ArrayList<>();

    protected AnotherParent() {
        this(Collections.emptyList());
    }

    public AnotherParent(Collection<Grandchild> grandchildren) {
        this.grandchildren.addAll(grandchildren);
    }

    public List<Grandchild> getGrandchildren() {
        return Collections.unmodifiableList(grandchildren);
    }
}
