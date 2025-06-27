package com.sistema_despesas.demo.controllers;

import com.sistema_despesas.demo.entities.Launch;
import com.sistema_despesas.demo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Launch>> allLaunches(@RequestHeader("Authorization") String authHeader){
        String token = authHeader.replace("Bearer ", "");
        return ResponseEntity.ok().body(userService.getLaunch(token));
    }

    @PostMapping("/createLaunch")
    public ResponseEntity<List<Launch>> createLaunch(@RequestHeader("Authorization") String authHeader, @RequestBody Launch launch){
        String token = authHeader.replace("Bearer ", "");
        return ResponseEntity.ok().body(userService.createLaunch(launch, token));
    }

    @DeleteMapping("/deleteLaunch/{id}")
    public ResponseEntity<List<Launch>> DeleteLaunch(@RequestHeader("Authorization") String authHeader, @PathVariable Long id){
        String token = authHeader.replace("Bearer ", "");
        return ResponseEntity.ok().body(userService.deleteLaunch(token, id));
    }

    @PutMapping("/updateLaunch/{id}")
    public ResponseEntity<List<Launch>> UpdateLaunch(@RequestHeader("Authorization") String authHeader, @RequestBody Launch launch, @PathVariable Long id){
        String token = authHeader.replace("Bearer ", "");
        return ResponseEntity.ok().body(userService.updateLaunch(launch,token,id));
    }
}
