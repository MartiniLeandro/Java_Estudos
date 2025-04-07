package ExercisePedido;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Pedido {
    private LocalDateTime momento;
    private StatusPedido status;

    private List<ItemPedido> itemPedidos = new ArrayList<>();

    public Pedido(){};

    public Pedido(LocalDateTime momento, StatusPedido status){
        this.momento = momento;
        this.status = status;
    }

    public LocalDateTime getMomento(){
        return this.momento;
    }
    public StatusPedido getStatus(){
        return this.status;

    }
    public List<ItemPedido> getItemPedidos(){
        return this.itemPedidos;
    }
    public void removeItem(ItemPedido pedido){
        itemPedidos.remove(pedido);
    }
    public Double total(){
        Double total = 0.0;
        for (ItemPedido itemPedido : itemPedidos) {
            total += itemPedido.subTotal();
        }
        return total;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
		for (ItemPedido item : itemPedidos) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
