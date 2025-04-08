package ExerciseProdutos2;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    private List<Produto> listaDeProdutos = new ArrayList<>();

    public void adicionarProduto(String nome, double preco) {
        Produto novoProduto = new Produto(nome, preco);
        listaDeProdutos.add(novoProduto);
    }

    public List<Produto> listarProdutos() {
        return listaDeProdutos;
    }

    public Produto buscarProdutoPorNome(String nome) {
        for (Produto produto : listaDeProdutos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }
}
