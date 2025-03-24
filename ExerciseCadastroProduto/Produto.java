package ExerciseCadastroProduto;

public class Produto {
    private Integer id;
    private String nome;
    private Double preco;

    public Produto(){};

    public Produto(Integer id, String nome, Double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public Double getPreco(){
        return this.preco;
    }
}
