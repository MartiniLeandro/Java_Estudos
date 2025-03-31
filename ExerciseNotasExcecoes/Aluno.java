package ExerciseNotasExcecoes;

public class Aluno {
    private String nome;
    private Double nota;

    public Aluno(){};

    public Aluno(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }
    public Double getNota(){
        return this.nota;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setNota(Double nota) throws ExcecaoNota{
        if(nota < 0 || nota > 10){
            throw new ExcecaoNota("NOTA INVÁLIDA!!!");
        }
        this.nota = nota;
    }

}
