package ExerciseGestãoEscolar;

public class Aluno extends Pessoa{
    private Integer matricula;
    private Disciplina disciplina;

    public Aluno(){super();};

    public Aluno(String nome, String email, Integer cpf, Integer matricula){
        super(nome, email, cpf);
        this.matricula = matricula;
    }

    public Integer getMatricula(){
        return this.matricula;
    }
    public Disciplina disciplina(){
        return this.disciplina;
    }
}
