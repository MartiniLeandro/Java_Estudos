package com.demo.Controllers;

import com.demo.entities.DTOS.ProdutoCreateDTO;
import com.demo.entities.DTOS.ProdutoResponseDTO;
import com.demo.entities.DTOS.ProdutoUpdateDTO;
import com.demo.entities.ENUMS.Status;
import com.demo.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> findAll(){
        return ResponseEntity.ok().body(produtoService.findAllProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(produtoService.findById(id));
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<ProdutoResponseDTO>> findByCategoria(@PathVariable Long id){
        return ResponseEntity.ok().body(produtoService.findAllByIdCategoria(id));
    }

    @GetMapping("/preco")
    public ResponseEntity<List<ProdutoResponseDTO>> findByPreco(@RequestParam Double preco){
        return ResponseEntity.ok().body(produtoService.findAllByPreco(preco));
    }

    @GetMapping("/precos")
    public ResponseEntity<List<ProdutoResponseDTO>> findBetweenPrecos(@RequestParam Double preco_min, @RequestParam Double preco_max){
        return ResponseEntity.ok().body(produtoService.findAllBetweenPreco(preco_min, preco_max));
    }

    @GetMapping("/precos/{id}")
    public ResponseEntity<List<ProdutoResponseDTO>> findBetweenPrecosByCategoria(@RequestParam Double preco_min, @RequestParam Double preco_max, @PathVariable Long id){
        return ResponseEntity.ok().body(produtoService.findAllBetweenPrecoByCategoria(preco_min, preco_max, id));
    }

    @GetMapping("/status")
    public ResponseEntity<List<ProdutoResponseDTO>> findByStatus(@RequestParam Status status){
        return ResponseEntity.ok().body(produtoService.findAllByStatus(status));
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> createProduto(@RequestBody ProdutoCreateDTO data){
        return ResponseEntity.ok().body(produtoService.createProduto(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> updateProduto(@PathVariable Long id, @RequestBody ProdutoUpdateDTO data){
        return ResponseEntity.ok().body(produtoService.updateProduto(data, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id){
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }
}
