package com.projectWithTest.demo.controllers;

import com.projectWithTest.demo.entities.User;
import com.projectWithTest.demo.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(description = "Deve retornar todos os Users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todos usuários encontrados"),
            @ApiResponse(responseCode = "400", description = "Falha ao encontrar Usuários")
    })
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @Operation(description = "Deve retornar o User pelo ID informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User encontrado"),
            @ApiResponse(responseCode = "400", description = "Não existe User com este Id")
    })
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        try{
            return ResponseEntity.ok().body(userService.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(description = "Deve criar um novo usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "usuário criado"),
            @ApiResponse(responseCode = "400", description = "Erro ao criar usuário")
    })
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        return ResponseEntity.ok().body(userService.create(user));
    }

    @Operation(description = "Deve atualizar um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "usuário atualizado"),
            @ApiResponse(responseCode = "400", description = "Erro ao atualizar usuário")
    })
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id){
        try{
            return ResponseEntity.ok().body(userService.update(user,id));
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(description = "Deve excluir um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "usuário excluído"),
            @ApiResponse(responseCode = "400", description = "Erro ao excluir usuário")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
