package ExerciseGestãoEscolar;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa{
    private Double salario;
    private List<String> disciplinasMinistradas;

    public Professor(){super();};
    public Professor(String nome, String email, Long cpf, Double salario){
        super(nome, email, cpf);
        this.salario = salario;
        this.disciplinasMinistradas = new ArrayList<>();
    }

    public Double getSalario(){
        return this.salario;
    }
    public List<String> getDisciplinasMinistradas(){
        return this.disciplinasMinistradas;
    }
    public void addDisciplinas(String materia){
       if (disciplinasMinistradas == null) {
        disciplinasMinistradas = new ArrayList<>();
    }
        disciplinasMinistradas.add(materia);
    }

    @Override
    public String toString(){
        return "Nome: " + super.getNome() + ", Email: " + super.getEmail() + ", CPF: " + super.getCpf() + ", Salário: " + getSalario() + ", Disciplinas: " + getDisciplinasMinistradas() + " || ";
    }
}
