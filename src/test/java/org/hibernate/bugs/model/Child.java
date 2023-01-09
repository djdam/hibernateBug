package org.hibernate.bugs.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Embeddable
public class Child {
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Grandchild> grandchildren = new ArrayList<>();

    protected Child() {
        this(Collections.emptyList());
    }

    public Child(Collection<Grandchild> grandchildren) {
        this.grandchildren.addAll(grandchildren);
    }

    public List<Grandchild> getGrandchildren() {
        return Collections.unmodifiableList(grandchildren);
    }
}
