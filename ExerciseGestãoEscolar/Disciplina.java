package ExerciseGestãoEscolar;

import java.util.List;

public class Disciplina {
    private String nome;
    private Integer codigo;
    private List<Double> notas;

    public Disciplina(){};
    public Disciplina(String nome, Integer codigo){
        this.nome = nome;
        this.codigo = codigo;
        this.notas = null;
    }

    public String getNome(){
        return this.nome;
    }
    public Integer getCodigo(){
        return this.codigo;
    }
    public List<Double> getNotas(){
        return this.notas;
    }
}
