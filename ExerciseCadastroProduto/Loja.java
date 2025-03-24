package ExerciseCadastroProduto;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<Produto> produtos = new ArrayList<>();

    public Loja(){};

    public List<Produto> getProdutos(){
        return this.produtos;
    }

    public void adicionarProdutos(Produto produto){
        produtos.add(produto);
    }

    public void listarProdutos(){
        for (Produto produto : produtos) {
            System.out.println("ID: " + produto.getId() + " - Nome: " + produto.getNome() + " - Preço: R$" + produto.getPreco());
        }
    }
}
