package ExercisePedido.services;

import ExercisePedido.Produto;

public class ProdutoService {
    private String nomeProduto;
    private Double precoProduto;

    public String getNome(){
        return this.nomeProduto;
    }
    public Double getPreco(){
        return this.precoProduto;
    }

    public Produto addProduto(String nomeProduto, Double precoProduto){
        Produto produto = new Produto(nomeProduto, precoProduto);
        return produto;
    }
}
