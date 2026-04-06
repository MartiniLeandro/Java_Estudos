package dev.matheuslf.desafio.inscritos.services;

import dev.matheuslf.desafio.inscritos.entities.DTOS.UploadFileDTO;
import dev.matheuslf.desafio.inscritos.entities.Post;
import dev.matheuslf.desafio.inscritos.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FilesService {

    @Value("${app.upload.diretorio}")
    private String diretorioFiles;

    private final PostRepository postRepository;


    public FilesService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public String salvarArquivo(UploadFileDTO file){
        Path diretorioPath = Paths.get(diretorioFiles);

        try{
            if(!Files.exists(diretorioPath)){
                Files.createDirectories(diretorioPath);
            }

            String nomeArquivo = UUID.randomUUID().toString() + "-" + file.file().getOriginalFilename();
            Path destino = diretorioPath.resolve(nomeArquivo);
            Files.copy(file.file().getInputStream(), destino);

            Post post = new Post();
            post.setDescricao(file.descricao());
            post.setUrlImagem(nomeArquivo);
            postRepository.save(post);

            return nomeArquivo;


        }catch (IOException e){
            throw new RuntimeException("Erro ao salvar arquivo: ", e);
        }

    }
}
