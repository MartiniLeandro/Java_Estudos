package com.treinoSecurity.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinoSecurity.Models.User;
import com.treinoSecurity.Services.UserService;

@Controller
@RestController("/users")
public class UserController {
    
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }
}
