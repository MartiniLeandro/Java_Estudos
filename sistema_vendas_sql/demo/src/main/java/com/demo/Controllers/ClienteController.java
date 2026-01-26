package com.demo.Controllers;

import com.demo.entities.DTOS.ClienteRequestDTO;
import com.demo.entities.DTOS.ClienteResponseDTO;
import com.demo.entities.ENUMS.Status;
import com.demo.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> getAllClientes(){
        return ResponseEntity.ok().body(clienteService.getAllClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> getClienteById(@PathVariable Long id){
        return ResponseEntity.ok().body(clienteService.getClienteById(id));
    }

    @GetMapping("/status")
    public ResponseEntity<List<ClienteResponseDTO>> getAllClientesStatus(@RequestParam Status status){
        return ResponseEntity.ok().body(clienteService.getClienteByStatus(status));
    }

    /*@PostMapping
    public ResponseEntity<ClienteResponseDTO> createCliente(@RequestBody ClienteRequestDTO clienteRequestDTO){
        return ResponseEntity.ok().body(clienteService.createCliente(clienteRequestDTO));
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO clienteRequestDTO){
        return ResponseEntity.ok().body(clienteService.updateCliente(id, clienteRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

}
