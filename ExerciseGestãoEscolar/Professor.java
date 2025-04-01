package ExerciseGestãoEscolar;

import java.util.List;

public class Professor extends Pessoa{
    private Double salario;
    private List<String> disciplinasMinistradas;

    public Professor(){super();};
    public Professor(String nome, String email, Integer cpf, Double salario){
        super(nome, email, cpf);
        this.salario = salario;
        this.disciplinasMinistradas = null;
    }

    public Double getSalario(){
        return this.salario;
    }
    public List<String> getDisciplinasMinistradas(){
        return this.disciplinasMinistradas;
    }
}
