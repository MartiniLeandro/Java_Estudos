package POO.classes;

public class AluguelClass {
    private String nome;
    private String email;
    private int numeroQuarto;

    public AluguelClass(String nome, String email, int numeroQuarto){
        this.nome = nome;
        this.email = email;
        this.numeroQuarto = numeroQuarto;
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public int getNumeroQuarto(){
        return this.numeroQuarto;
    }
    public void setNumeroQuarto(int numeroQuarto){
        this.numeroQuarto = numeroQuarto;
    }

    public String toString(){
        return numeroQuarto + ": " + nome +  ", " + email;
    
    }

}
