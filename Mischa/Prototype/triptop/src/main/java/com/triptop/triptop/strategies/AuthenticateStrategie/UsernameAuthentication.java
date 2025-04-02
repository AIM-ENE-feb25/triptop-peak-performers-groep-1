package com.triptop.triptop.strategies.AuthenticateStrategie;

import com.triptop.triptop.domains.Credentials;
import com.triptop.triptop.domains.Token;

import java.util.Date;

public class UsernameAuthentication implements IAuthenticateStrategie {
    private final String CORRECTUSERNAME = "Mischa";
    private final String CORRECTPASSWORD = "Lippmann";

    @Override
    public Token authenticate(String endpoint, String httpMethod, Credentials credentials) {
        if (credentials.getUsername().equals(CORRECTUSERNAME) && credentials.getPassword().equals(CORRECTPASSWORD)) {
            return generateToken();
        } else {
           throw new IllegalArgumentException("Authentication with username failed");
        }
    }

    private Token generateToken() {
        String tokenString = "Username2008BMW";
        Date expirationDate = new Date();
        Token token = new Token(tokenString, expirationDate);
        return token;
    }
}
