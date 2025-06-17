package com.sistema_barbearia.controllers;

import com.sistema_barbearia.entities.Barbeiro;
import com.sistema_barbearia.entities.Cliente;
import com.sistema_barbearia.entities.DTOS.agendamentosBarbeiro.AddAgendamentoBarbeiroDTO;
import com.sistema_barbearia.entities.DTOS.agendamentosBarbeiro.DeleteAgendamentoBarbeiroDTO;
import com.sistema_barbearia.entities.DTOS.agendamentosBarbeiro.UpdateAgendamentoBarbeiroDTO;
import com.sistema_barbearia.entities.User;
import com.sistema_barbearia.services.AdminService;
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

    @PostMapping("/add/agendamentosBarbeiros")
    public ResponseEntity<String> addAgendamentoBarbeiro(@RequestBody AddAgendamentoBarbeiroDTO data){
        adminService.addAgendamentoBarbeiro(data.agendamento(), data.idBarbeiro());
        return ResponseEntity.ok().body("Agendamento adicionado ao barbeiro com ID: " + data.idBarbeiro());
    }

    @DeleteMapping("/delete/agendamentosBarbeiros")
    public ResponseEntity<String> deleteAgendamentoBarbeiro(@RequestBody DeleteAgendamentoBarbeiroDTO data){
        adminService.deleteAgendamentoBarbeiro(data.index(), data.idBarbeiro());
        return ResponseEntity.ok().body("Agendamento deletado ao barbeiro com ID: " + data.idBarbeiro());
    }

    @PutMapping("/update/agendamentosBarbeiros")
    public ResponseEntity<String> updateAgendamentoBarbeiro(@RequestBody UpdateAgendamentoBarbeiroDTO data){
        adminService.updateAgendamentoBarbeiro(data.index(), data.agendamento(), data.idBarbeiro());
        return ResponseEntity.ok().body("Agendamento atualizado ao barbeiro com ID: " + data.idBarbeiro());
    }

    @GetMapping("/allBarbeiros")
    public ResponseEntity<List<Barbeiro>> findAllBarbeiros(){
        List<Barbeiro> allBarbeiros = adminService.listAllBarbeiro();
        return ResponseEntity.ok().body(allBarbeiros);
    }

    @DeleteMapping("/deleteBarbeiros/{id}")
    public ResponseEntity<String> deleteBarbeiro(@PathVariable Long id){
        adminService.deleteBarbeiro(id);
        return ResponseEntity.ok().body("barbeiro deletado");
    }

    @PutMapping("/updateBarbeiros/{id}")
    public ResponseEntity<Barbeiro> updateBarbeiro(@PathVariable  Long id, @RequestBody Barbeiro barbeiro){
        Barbeiro barbeiroUpdate = adminService.updateBarbeiro(id, barbeiro);
        return ResponseEntity.ok().body(barbeiroUpdate);
    }

    @GetMapping("/allClientes")
    public ResponseEntity<List<Cliente>> findAllClientes(){
        List<Cliente> allClientes = adminService.listAllCliente();
        return ResponseEntity.ok().body(allClientes);
    }

    @DeleteMapping("/deleteClientes/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id){
        adminService.deleteCliente(id);
        return ResponseEntity.ok().body("cliente Deletado");
    }

    @PutMapping("/updateClientes/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable  Long id,@RequestBody Cliente cliente){
        Cliente updateCliente = adminService.updateCliente(id, cliente);
        return ResponseEntity.ok().body(updateCliente);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> allUsers = adminService.listAllUsers();
        return ResponseEntity.ok().body(allUsers);
    }

    @DeleteMapping("/deleteUsers/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        adminService.deleteUser(id);
        return ResponseEntity.ok().body("User deletado");
    }

    @PutMapping("/updateUsers/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        User updateUser = adminService.updateUser(id, user);
        return ResponseEntity.ok().body(updateUser);
    }

}
