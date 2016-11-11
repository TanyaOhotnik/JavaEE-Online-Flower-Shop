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

    @ManyToOne(targetEntity = Profile.class)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToOne(targetEntity = Order.class)
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bucket bucket = (Bucket) o;

        if (id != bucket.id) return false;
        if (profile != null ? !profile.equals(bucket.profile) : bucket.profile != null) return false;
        return order != null ? order.equals(bucket.order) : bucket.order == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }
}
