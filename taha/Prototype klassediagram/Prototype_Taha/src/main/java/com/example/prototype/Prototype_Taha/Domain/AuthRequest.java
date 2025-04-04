package com.example.prototype.Prototype_Taha.Domain;

public class AuthRequest {
    private String username;
    private String password;

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String toJson() {
        return "{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}";
    }
}