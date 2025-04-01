package ExerciseGestãoEscolar;

public class Pessoa {
    private String nome;
    private String email;
    private Long cpf;

    public Pessoa(){};

    public Pessoa(String nome, String email, Long cpf){
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
    public Long getCpf(){
        return this.cpf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
