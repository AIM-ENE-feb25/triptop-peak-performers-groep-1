package com.triptop.triptop.strategies.AuthenticateStrategie;

import com.triptop.triptop.domains.Credentials;
import com.triptop.triptop.domains.Token;

import java.util.Date;

public class SecretAuthentication implements IAuthenticateStrategie {
    private final String CORRECTSECRET = "JohmaSalade";

    @Override
    public Token authenticate(String endpoint, String httpMethod, Credentials credentials) {
        if (credentials.getSecret().equals(CORRECTSECRET)) {
            return generateToken();
        } else {
            throw new IllegalArgumentException("Authentication with secret failed");
        }
    }

    private Token generateToken() {
        String tokenString = "Secret2008BMW";
        Date expirationDate = new Date();
        Token token = new Token(tokenString, expirationDate);
        return token;
    }
}
