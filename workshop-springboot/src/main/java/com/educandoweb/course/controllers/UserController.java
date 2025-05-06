package com.educandoweb.course.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.models.User;
import com.educandoweb.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
   private UserService userService;
   public UserController(UserService userService) {
    this.userService = userService;
   }

   @GetMapping
   public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
   }

   @GetMapping(value = "/{id}")
   public ResponseEntity<User> findById(@PathVariable Long id){
      User obj = userService.findById(id);
      return ResponseEntity.ok().body(obj);
   }
}
