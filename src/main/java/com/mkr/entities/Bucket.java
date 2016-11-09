package com.mkr.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 09.11.2016.
 */
@Entity
@Table(name = "bucket")
public class Bucket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bucket_id")
    private int id;

    @OneToOne(targetEntity = Profile.class)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToMany(targetEntity = Order.class)
    @JoinColumn(name = "order_id", nullable = true)
    private List<Order> orders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bucket bucket = (Bucket) o;

        if (id != bucket.id) return false;
        if (profile != null ? !profile.equals(bucket.profile) : bucket.profile != null) return false;
        return orders != null ? orders.equals(bucket.orders) : bucket.orders == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        return result;
    }
}
