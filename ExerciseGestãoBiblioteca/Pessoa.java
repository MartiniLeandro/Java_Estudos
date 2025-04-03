package ExerciseGestãoBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private Integer id;
    private Integer limiteLivros;
    private String alunoOuProfessor;
    private List<String> livrosAlugados;

    public Pessoa(){};
    public Pessoa(String nome, Integer id, Integer limiteLivros, String alunoOuProfessor){
        this.nome = nome;
        this.id = id;
        this.limiteLivros = limiteLivros;
        this.alunoOuProfessor = alunoOuProfessor;
        this.livrosAlugados = new ArrayList<>(limiteLivros);
    }

    public String getNome(){
        return this.nome;
    }
    public String getAlunoOuProfessor(){
        return this.alunoOuProfessor;
    }
    public Integer getId(){
        return this.id;
    }
    public List<String> getLivrosAlugados(){
        return this.livrosAlugados;
    }
    public Integer getLimiteLivros(){
        return this.limiteLivros;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "Nome: " + getNome() + ", ID: " + getId() + ", Limite de livros: " + getLimiteLivros() + ", Aluno ou Professor: " + getAlunoOuProfessor() + ", Livros alugados: " + getLivrosAlugados() +  " || ";
    }
}
