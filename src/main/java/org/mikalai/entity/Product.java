package org.mikalai.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue
    private int id;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    @JoinTable(name="orders",
        joinColumns = {@JoinColumn(name="product_id", nullable = false, updatable = false)},
        inverseJoinColumns = {@JoinColumn(name="person_id", nullable = false, updatable = false)})
    private List<Person> buyers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Person> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<Person> buyers) {
        this.buyers = buyers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;

        Product product = (Product) o;

        return id == product.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
