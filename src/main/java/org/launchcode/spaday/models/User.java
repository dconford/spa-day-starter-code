package org.launchcode.spaday.models;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class User {
    // java.util.Date
    java.util.Date currentDate = Calendar.getInstance().getTime();
    //bonus mission
    private int id;
    private static int nextId = 1;
    //Your User class should have a few private fields with getters and setters: username, email, password.
    private String username;
    private String email;
    private String password;
    private Date creationdate;

    public User() {
        this.creationdate = currentDate;
        this.id = nextId;
        nextId++;
    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return  username;
    }
}
