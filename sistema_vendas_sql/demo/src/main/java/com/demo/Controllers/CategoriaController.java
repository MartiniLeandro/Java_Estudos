package com.demo.Controllers;

import com.demo.entities.DTOS.CategoriaRequestDTO;
import com.demo.entities.DTOS.CategoriaResponseDTO;
import com.demo.services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> findAllCategorias(){
        return ResponseEntity.ok().body(categoriaService.findAllCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> findCategoriaById(@PathVariable Long id){
        return ResponseEntity.ok().body(categoriaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<CategoriaResponseDTO> findByNome(@RequestParam String nome){
        return ResponseEntity.ok().body(categoriaService.findByNome(nome));
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> saveCategoria(@RequestBody CategoriaRequestDTO categoriaRequestDTO){
        return ResponseEntity.ok().body(categoriaService.createCategoria(categoriaRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> updateCategoria(@PathVariable Long id, @RequestBody CategoriaRequestDTO categoriaRequestDTO){
        return ResponseEntity.ok().body(categoriaService.updateCategoria(id,categoriaRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id){
        categoriaService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }

}
