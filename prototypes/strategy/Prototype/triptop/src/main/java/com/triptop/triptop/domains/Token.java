package com.triptop.triptop.domains;

import java.util.Date;

public class Token {
    private String token;
    private Date expireDate;

    public Token(String token, Date expireDate) {
        setToken(token);
        setExpireDate(expireDate);
    }

    public String toString() {
        return "Token: " + getToken() + " Expire Date: " + getExpireDate();
    }

    private void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    private void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }
}
