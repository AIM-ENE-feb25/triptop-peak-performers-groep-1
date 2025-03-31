package com.triptop.triptop.strategies.AuthenticateStrategie;

import com.triptop.triptop.domains.Credentials;
import com.triptop.triptop.domains.Token;

public interface IAuthenticateStrategie {
    public Token authenticate(String endpoint, String httpMethod, Credentials credentials);
}
