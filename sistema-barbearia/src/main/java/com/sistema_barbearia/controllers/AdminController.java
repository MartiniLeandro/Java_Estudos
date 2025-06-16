package com.sistema_barbearia.controllers;

import com.sistema_barbearia.entities.DTOS.agendamentosBarbeiro.AddAgendamentoBarbeiroDTO;
import com.sistema_barbearia.entities.DTOS.agendamentosBarbeiro.DeleteAgendamentoBarbeiroDTO;
import com.sistema_barbearia.entities.DTOS.agendamentosBarbeiro.UpdateAgendamentoBarbeiroDTO;
import com.sistema_barbearia.services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/add/agendamentos-barbeiro")
    public ResponseEntity<String> addAgendamentoBarbeiro(@RequestBody AddAgendamentoBarbeiroDTO data){
        adminService.addAgendamentoBarbeiro(data.agendamento(), data.idBarbeiro());
        return ResponseEntity.ok().body("Agendamento adicionado ao barbeiro com ID: " + data.idBarbeiro());
    }

    @DeleteMapping("/delete/agendamentos-barbeiro")
    public ResponseEntity<String> deleteAgendamentoBarbeiro(@RequestBody DeleteAgendamentoBarbeiroDTO data){
        adminService.deleteAgendamentoBarbeiro(data.index(), data.idBarbeiro());
        return ResponseEntity.ok().body("Agendamento deletado ao barbeiro com ID: " + data.idBarbeiro());
    }

    @PutMapping("/update/agendamentos-barbeiro")
    public ResponseEntity<String> updateAgendamentoBarbeiro(@RequestBody UpdateAgendamentoBarbeiroDTO data){
        adminService.updateAgendamentoBarbeiro(data.index(), data.agendamento(), data.idBarbeiro());
        return ResponseEntity.ok().body("Agendamento atualizado ao barbeiro com ID: " + data.idBarbeiro());
    }
}
