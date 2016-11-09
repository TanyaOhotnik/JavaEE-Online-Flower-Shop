package com.mkr.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Tanya Ohotnik on 09.11.2016.
 */
@Entity
@Table(name = "ordered")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @ManyToOne(targetEntity = Profile.class)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "delivery_date")
    private String date;

    @Column(name = "delivery_address")
    private String address;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (profile != null ? !profile.equals(order.profile) : order.profile != null) return false;
        if (product != null ? !product.equals(order.product) : order.product != null) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;
        return address != null ? address.equals(order.address) : order.address == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
