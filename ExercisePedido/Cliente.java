package ExercisePedido;


public class Cliente {
    private String nome;
    private String email;

    public Cliente(){};

    public Cliente(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    public String getNome(){
        return this.nome;
    }
    public String getEmail(){
        return this.email;
    }



}
