package com.example.prototype.Prototype_Taha.Service;

import org.springframework.stereotype.Service;

@Service
public class LoggerService {
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
