package ExercisePedido;

public class Produto {
    private String nome;
    private Double preco;

    public Produto(){};

    public Produto(String nome, Double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome(){
        return this.nome;
    }
    public Double getPreco(){
        return this.preco;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setPreco(Double preco){
        this.preco = preco;
    }
}
