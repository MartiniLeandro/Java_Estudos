package com.demo.Controllers;

import com.demo.entities.DTOS.PedidoCreateDTO;
import com.demo.entities.DTOS.PedidoResponseDTO;
import com.demo.entities.DTOS.PedidoUpdateDTO;
import com.demo.entities.ENUMS.StatusPedido;
import com.demo.services.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> findAll(){
        return ResponseEntity.ok().body(pedidoService.getAllPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(pedidoService.getPedidoById(id));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<PedidoResponseDTO>> findAllByCliente(@PathVariable Long clienteId){
        return ResponseEntity.ok().body(pedidoService.getPedidosByCliente(clienteId));
    }

    @GetMapping("/status")
    public ResponseEntity<List<PedidoResponseDTO>> findAllByStatus(@RequestParam StatusPedido status){
        return ResponseEntity.ok().body(pedidoService.getPedidosByStatus(status));
    }

    @GetMapping("/dates")
    public ResponseEntity<List<PedidoResponseDTO>> findAllByDates(@RequestParam LocalDateTime start, @RequestParam LocalDateTime end){
        return ResponseEntity.ok().body(pedidoService.gePedidosBetweenDates(start,end));
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> createPedido(@RequestBody PedidoCreateDTO pedidoCreateDTO){
        return ResponseEntity.ok().body(pedidoService.createPedido(pedidoCreateDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> updatePedido(@PathVariable Long id, @RequestBody PedidoUpdateDTO pedidoUpdateDTO){
        return ResponseEntity.ok().body(pedidoService.updatePedido(pedidoUpdateDTO,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id){
        pedidoService.deletePedido(id);
        return ResponseEntity.noContent().build();
    }

}
