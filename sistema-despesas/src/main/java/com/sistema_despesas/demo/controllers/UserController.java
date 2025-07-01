package com.sistema_despesas.demo.controllers;

import com.sistema_despesas.demo.entities.Categorias;
import com.sistema_despesas.demo.entities.DTOS.LaunchDTO;
import com.sistema_despesas.demo.entities.Launch;
import com.sistema_despesas.demo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<LaunchDTO>> allLaunches(@RequestHeader("Authorization") String authHeader){
        String token = authHeader.replace("Bearer ", "");
        return ResponseEntity.ok().body(userService.getLaunch(token));
    }

    @GetMapping("/totalConta")
    public ResponseEntity<Double> totalConta(@RequestHeader("Authorization") String authHeader){
        String token = authHeader.replace("Bearer ", "");
        return ResponseEntity.ok().body(userService.totalConta(token));
    }

    @GetMapping("/filtroCategoria")
    public ResponseEntity<List<LaunchDTO>> filtroCategoria(@RequestHeader("Authorization") String authHeader, @RequestParam String categoria){
        String token = authHeader.replace("Bearer ","");
        return ResponseEntity.ok().body(userService.filtroCategoria(token,categoria));
    }

    @GetMapping("/filtroData")
    public ResponseEntity<List<LaunchDTO>> filtroData(@RequestHeader("Authorization") String authHeader, @RequestParam LocalDate dataInicial, @RequestParam LocalDate dataFinal){
        String token = authHeader.replace("Bearer ","");
        return ResponseEntity.ok().body(userService.filtroData(token,dataInicial,dataFinal));
    }

    @PostMapping("/createLaunch")
    public ResponseEntity<List<LaunchDTO>> createLaunch(@RequestHeader("Authorization") String authHeader, @RequestBody LaunchDTO launch){
        String token = authHeader.replace("Bearer ", "");
        return ResponseEntity.ok().body(userService.createLaunch(launch, token));
    }

    @DeleteMapping("/deleteLaunch/{id}")
    public ResponseEntity<List<LaunchDTO>> DeleteLaunch(@RequestHeader("Authorization") String authHeader, @PathVariable Long id){
        String token = authHeader.replace("Bearer ", "");
        return ResponseEntity.ok().body(userService.deleteLaunch(token, id));
    }

    @PutMapping("/updateLaunch/{id}")
    public ResponseEntity<List<LaunchDTO>> UpdateLaunch(@RequestHeader("Authorization") String authHeader, @RequestBody LaunchDTO launch, @PathVariable Long id){
        String token = authHeader.replace("Bearer ", "");
        return ResponseEntity.ok().body(userService.updateLaunch(launch,token,id));
    }
}
