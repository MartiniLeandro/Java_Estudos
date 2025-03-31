package ExerciseIdadeExcecoes;

public class Usuario {
    private String nome;
    private Integer idade;

    public Usuario(){};

    public Usuario(String nome, Integer idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome(){
        return this.nome;
    }
    public Integer getIdade(){
        return this.idade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Usuario cadastrarUsuario() throws ExcecaoIdade{
        if(idade < 18){
            throw new ExcecaoIdade("Idade minima para cadastro é 18 anos!");
        }
        Usuario usuario = new Usuario(nome, idade);
        return usuario;
    }
}
