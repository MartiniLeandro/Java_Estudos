package ExerciseCadastroProduto.services;

import ExerciseCadastroProduto.Loja;
import ExerciseCadastroProduto.Produto;

public class ProductService {
    private Loja loja;

    public ProductService(Loja loja){
        this.loja = loja;
    }

    public void cadastrarProduto(Integer id, String nome, Double preco) {
        Produto produto = new Produto(id,nome,preco);
        loja.adicionarProdutos(produto);
    }

    public void exibirProdutos(){
        loja.listarProdutos();
    }
}
