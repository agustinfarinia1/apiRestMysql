package com.farinia.springoot_api_rest.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Where;

@Entity
@Table(name= "user")
@Where(clause = "status = true")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int priority;
    private boolean status = true;

    public User() {
    }

    public User(Long id, String name, String email, int priority) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.priority = priority;
        this.status = true;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }
}
