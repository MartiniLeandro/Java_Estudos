package POO.classes;

public class PedidoRestaurante {
    private int numeroPedido;
    private String cliente;
    private double valorTotal;

    public PedidoRestaurante(int numeroPedido, String cliente, double valorTotal){
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
    }
    public PedidoRestaurante(int numeroPedido, String cliente){
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.valorTotal = 0;
    }

    public int getNumeroPedido(){
        return this.numeroPedido;
    }
    public String getcliente(){
        return this.cliente;
    }
    public void setCliente(String cliente){
        this.cliente = cliente;
    }
    public double getValorTotal(){
        return this.valorTotal;
    }
    public void adicionarItem(double valor){
        this.valorTotal += valor;
    }
    public void aplicarDesconto(double percentual){
        this.valorTotal *= (1 - percentual * 0.01 );
    }
}
