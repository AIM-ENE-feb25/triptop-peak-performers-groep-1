package com.triptop.triptop.controllers;

import com.triptop.triptop.domains.AuthenticationMethods;
import com.triptop.triptop.domains.Credentials;
import com.triptop.triptop.domains.Token;
import com.triptop.triptop.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {
    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Autowired
    private AuthenticationService authenticationService;
    private final AuthenticationMethods AUTHENTICATIONMETHOD = AuthenticationMethods.SECRET;
    private Token token;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestParam String endpoint, @RequestParam String httpMethod, @RequestBody Credentials credentials) {
        try {
            authenticationService.setAuthenticationMethod(AUTHENTICATIONMETHOD);
            token = authenticationService.authenticate(endpoint, httpMethod, credentials);
            if (token != null) {
                return new ResponseEntity<>(token.toString(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Er is iets fout gegaan", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Er is iets fout gegaan: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/authorize")
    public ResponseEntity<String> authorize(@RequestParam String endpoint, @RequestParam String httpMethod) {
        try {
            if (token == null) {
                return new ResponseEntity<>("Er is nog niet geauthenticeerd", HttpStatus.BAD_REQUEST);
            }
            Boolean authorized = authenticationService.authorize(endpoint, httpMethod, token);
            if (authorized) {
                return new ResponseEntity<>("Geautoriseerd", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Niet geautoriseerd", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Er is iets fout gegaan: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
