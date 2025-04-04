package com.example.prototype.Prototype_Taha.Controller;

import com.example.prototype.Prototype_Taha.Facade.AuthFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthFacade authFacade;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return authFacade.login(username, password);
    }

    @PostMapping("/checkAccess")
    public String checkAppAccess(@RequestParam String token, @RequestParam String username, @RequestParam String application) {
        return authFacade.checkAppAccess(token, username, application);
    }
}
