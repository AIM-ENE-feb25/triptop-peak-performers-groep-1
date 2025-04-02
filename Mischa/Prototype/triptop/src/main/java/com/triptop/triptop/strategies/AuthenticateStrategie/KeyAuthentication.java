package com.triptop.triptop.strategies.AuthenticateStrategie;

import com.triptop.triptop.domains.Credentials;
import com.triptop.triptop.domains.Token;

import java.util.Date;

public class KeyAuthentication implements IAuthenticateStrategie {
    private final String CORRECTKEY = "12345";

    @Override
    public Token authenticate(String endpoint, String httpMethod, Credentials credentials) {
        if (credentials.getKey().equals(CORRECTKEY)) {
            return generateToken();
        } else {
            throw new IllegalArgumentException("Authentication with key failed");
        }
    }

    private Token generateToken() {
        String tokenString = "Key2008BMW";
        Date expirationDate = new Date();
        Token token = new Token(tokenString, expirationDate);
        return token;
    }
}
