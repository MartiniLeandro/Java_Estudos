package ExercisePedido;

public class ItemPedido {
    private Integer quantidade;
    private Double preco;

    private Produto produto;

    public ItemPedido(){};

    public ItemPedido(Integer quantidade, Double preco, Produto produto){
        this.quantidade = quantidade;
        this.preco = preco;
        this.produto = produto;
    }

    public Integer getQuantidade(){
        return this.quantidade;
    }
    public Double getPreco(){
        return this.preco;
    }
    public Produto getProduto(){
        return this.produto;
    }

    public void setQuantidade(Integer quantidade){
        this.quantidade = quantidade;
    }
    public void setPreco(Double preco){
        this.preco = preco;
    }
    public Double subTotal(){
        Double soma = 0.0;
        return soma += quantidade * preco;
    }
    public String toString() {
		return produto.getNome()
				+ ", $" 
				+ String.format("%.2f", preco) 
				+ ", Quantity: " 
				+ quantidade + 
				", Subtotal: $" 
				+ String.format("%.2f", subTotal());
	}
    
}
