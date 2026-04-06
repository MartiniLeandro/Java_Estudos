package dev.matheuslf.desafio.inscritos.controllers;

import dev.matheuslf.desafio.inscritos.entities.DTOS.UploadFileDTO;
import dev.matheuslf.desafio.inscritos.services.FilesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FilesController {

    private final FilesService filesService;

    public FilesController(FilesService filesService) {
        this.filesService = filesService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@ModelAttribute UploadFileDTO file) {
        String nomeArquivoSalvo = filesService.salvarArquivo(file);
        return ResponseEntity.ok().body("Sucesso! Imagem salva como: " + nomeArquivoSalvo);
    }
}
