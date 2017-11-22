package com.bima.silat.persistence.domain;

import java.sql.Timestamp;

public class User {
    private long id;
    private String name;
    private String password;
    private String role;
    private String email;
    private String phoneNumber;
    private Timestamp dateCreated;
    private Timestamp dateUpdated;
    private boolean isActive;

    public User(long id, String name, String password, String role, String email, String phoneNumber,
                Timestamp dateCreated, Timestamp dateUpdated, boolean isActive) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.isActive = isActive;
    }

    public User(String name, String password, String role, String email, String phoneNumber,
                Timestamp dateCreated, Timestamp dateUpdated, boolean isActive) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.isActive = isActive;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public Timestamp getDateUpdated() {
        return dateUpdated;
    }

    public boolean getIsActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                ", isActive=" + isActive +
                '}';
    }
}
