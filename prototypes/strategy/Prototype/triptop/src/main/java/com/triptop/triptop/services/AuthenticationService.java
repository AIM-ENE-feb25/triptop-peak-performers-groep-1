package com.triptop.triptop.services;

import com.triptop.triptop.domains.AuthenticationMethods;
import com.triptop.triptop.domains.Credentials;
import com.triptop.triptop.domains.Token;
import com.triptop.triptop.strategies.AuthenticateStrategie.IAuthenticateStrategie;
import com.triptop.triptop.strategies.AuthenticateStrategie.KeyAuthentication;
import com.triptop.triptop.strategies.AuthenticateStrategie.SecretAuthentication;
import com.triptop.triptop.strategies.AuthenticateStrategie.UsernameAuthentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private IAuthenticateStrategie authenticateStrategie;

    public void setAuthenticationMethod(AuthenticationMethods method) {
        switch (method) {
            case USERNAME_PASSWORD:
                this.authenticateStrategie = new UsernameAuthentication();
                break;
            case SECRET:
                this.authenticateStrategie = new SecretAuthentication();
                break;
            case KEY:
                this.authenticateStrategie = new KeyAuthentication();
                break;
        }
    }

    public Token authenticate(String endpoint, String httpMethod, Credentials credentials) {
        if (this.authenticateStrategie == null) {
            throw new IllegalArgumentException("No authentication method set");
        }
        return authenticateStrategie.authenticate(endpoint, httpMethod, credentials);
    }

    public Boolean authorize(String endpoint, String httpMethod, Token token) {
        return true;
    }
}
