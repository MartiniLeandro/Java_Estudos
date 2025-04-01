package ExerciseGestãoEscolar;

public class Aluno extends Pessoa{
    private Integer matricula;
    private Boletim boletim;

    public Aluno(){super();};

    public Aluno(String nome, String email, Long cpf, Integer matricula){
        super(nome, email, cpf);
        this.matricula = matricula;
        boletim = null;
    }

    public Integer getMatricula(){
        return this.matricula;
    }
    public Boletim getBoletim(){
        return this.boletim;
    }

    public void setBoletim(Boletim Boletim){
        this.boletim = Boletim;
    }
    

    @Override
    public String toString(){
        return "Nome: " + super.getNome() + ", Email: " + super.getEmail() + ", CPF: " + super.getCpf() + ", Matrícula: " + getMatricula() + ", Média boletim: " + getBoletim().mediaBoletim() +  ", Aprovado ou Reprovado: " +  getBoletim().AprovadoOuReprovado() +  " || ";
    }
}
