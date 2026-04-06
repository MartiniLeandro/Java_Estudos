package dev.matheuslf.desafio.inscritos.controllers;

import dev.matheuslf.desafio.inscritos.entities.DTOS.UploadFileDTO;
import dev.matheuslf.desafio.inscritos.services.FilesService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/download/{nomeArquivo}")
    public ResponseEntity<Resource> download(@PathVariable String nomeArquivo) {
        Resource file = filesService.downloadArquivo(nomeArquivo);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + nomeArquivo).body(file);
    }
}
