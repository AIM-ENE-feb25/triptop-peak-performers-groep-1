package com.example.prototype.Prototype_Taha.Facade;

import com.example.prototype.Prototype_Taha.Service.LoggerService;
import com.example.prototype.Prototype_Taha.Service.TokenService;
import com.example.prototype.Prototype_Taha.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthFacade {
    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private LoggerService loggerService;

    public String login(String username, String password) {
        loggerService.log("Attempting login for user: " + username);
        String token = userService.login(username, password);
        if (token != null) {
            loggerService.log("Login successful for user: " + username);
        } else {
            loggerService.log("Login failed for user: " + username);
        }
        return token;
    }

    public String checkAppAccess(String token, String username, String application) {
        loggerService.log("Checking app access for user: " + username);
        return tokenService.checkAppAccess(token, username, application);
    }
}
