package com.mkr.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Tanya Ohotnik on 09.11.2016.
 */
@Entity
@Table(name = "profile")
public class Profile implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @ManyToOne(targetEntity = Role.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_name")
    private Role role;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profile profile = (Profile) o;

        if (id != profile.id) return false;
        if (name != null ? !name.equals(profile.name) : profile.name != null) return false;
        if (password != null ? !password.equals(profile.password) : profile.password != null) return false;
        if (email != null ? !email.equals(profile.email) : profile.email != null) return false;
        return role != null ? role.equals(profile.role) : profile.role == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
