package ExerciseGestãoEscolar;

public class Pessoa {
    private String nome;
    private String email;
    private Integer cpf;

    public Pessoa(){};

    public Pessoa(String nome, String email, Integer cpf){
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNome(){
        return this.nome;
    }
    public String getEmail(){
        return this.email;
    }
    public Integer getCpf(){
        return this.cpf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
