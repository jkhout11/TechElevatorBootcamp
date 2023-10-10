package com.techelevator.model;

import java.util.Objects;

/**
 * User
 */
public class User {

    private int userId;
    private String username;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the id to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username);
    }
}
