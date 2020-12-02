package org.jxgm.health.entity;

import java.util.Objects;

/**
 * @author luo
 * @date 2020/11/9 18:03
 * @description
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String role;
    private boolean state;

    public User(Integer id, String username, String password, String email, String role, boolean state) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.state = state;
    }

    public User(String username, String password, String email, String role, boolean state) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.state = state;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", state=" + state +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(role, user.role) &&
                Objects.equals(state, user.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, role, state);
    }
}
