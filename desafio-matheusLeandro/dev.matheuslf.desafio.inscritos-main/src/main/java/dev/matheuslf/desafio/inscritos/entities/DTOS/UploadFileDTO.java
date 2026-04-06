package dev.matheuslf.desafio.inscritos.entities.DTOS;

import org.springframework.web.multipart.MultipartFile;

public record UploadFileDTO(MultipartFile file, String descricao) {
}
