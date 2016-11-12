package com.mkr.entities;

import javax.faces.bean.RequestScoped;
import javax.persistence.*;

/**
 * Created by Tanya Ohotnik on 06.11.2016.
 */
@RequestScoped
@Entity
@Table(name = "specialization")
@NamedQuery(name = "Specialization.getAll", query = "SELECT i FROM Specialization i")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spec_id")
    private int id;
    @Column(name = "spec_name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}