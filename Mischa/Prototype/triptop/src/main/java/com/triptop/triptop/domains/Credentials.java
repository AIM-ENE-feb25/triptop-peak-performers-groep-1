package com.triptop.triptop.domains;

public class Credentials {
    private String username;
    private String password;
    private String key;
    private String secret;

    public Credentials(String username, String password, String key, String secret) {
        setUsername(username);
        setPassword(password);
        setKey(key);
        setSecret(secret);
    }

    public String toString() {
        return "Credentials{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", key='" + key + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    private void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    private void setSecret(String secret) {
        this.secret = secret;
    }

    public String getSecret() {
        return secret;
    }
}
