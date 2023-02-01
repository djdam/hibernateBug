package org.hibernate.bugs.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Embeddable
public class Child {

    @JoinColumn(name = "child_id", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
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
