package com.av.psytest.server.jwt;

public class UsernameAndPassAuthRequest {
    private String username;
    private String password;

    public UsernameAndPassAuthRequest() {
    }

    public UsernameAndPassAuthRequest(String password) {
        this.password = password;
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
}