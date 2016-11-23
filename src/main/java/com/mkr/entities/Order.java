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

    @Column(name = "addressee_name")
    private String addresseeName;

    @Column(name = "is_done")
    private boolean done;

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

    public String getAddresseeName() {
        return addresseeName;
    }

    public void setAddresseeName(String addressee_name) {
        this.addresseeName = addressee_name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (done != order.done) return false;
        if (profile != null ? !profile.equals(order.profile) : order.profile != null) return false;
        if (product != null ? !product.equals(order.product) : order.product != null) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;
        if (address != null ? !address.equals(order.address) : order.address != null) return false;
        return addresseeName != null ? addresseeName.equals(order.addresseeName) : order.addresseeName == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (addresseeName != null ? addresseeName.hashCode() : 0);
        result = 31 * result + (done ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", profile=" + profile +
                ", product=" + product +
                ", date='" + date + '\'' +
                ", address='" + address + '\'' +
                ", addresseeName='" + addresseeName + '\'' +
                ", done=" + done +
                '}';
    }
}
