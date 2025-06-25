package com.sistema_despesas.demo.controllers;

import com.sistema_despesas.demo.entities.DTOS.UserDTO;
import com.sistema_despesas.demo.entities.User;
import com.sistema_despesas.demo.services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> allUsers(){
        return ResponseEntity.ok().body(adminService.allUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> userId(@PathVariable Long id){
        return ResponseEntity.ok().body(adminService.findById(id));
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody User user){
        return ResponseEntity.ok().body(adminService.updateUser(id,user));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable   Long id){
        adminService.deleteUser(id);
        return ResponseEntity.ok().body("Usuário deletado");
    }
}
