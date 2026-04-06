package dev.matheuslf.desafio.inscritos.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "entities")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urlImagem;

    private String descricao;

    public Post(){}
    public Post(Long id, String urlImagem, String descricao) {
        this.id = id;
        this.urlImagem = urlImagem;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
