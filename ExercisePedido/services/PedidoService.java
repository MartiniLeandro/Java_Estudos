package ExercisePedido.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ExercisePedido.ItemPedido;
import ExercisePedido.Pedido;
import ExercisePedido.StatusPedido;

public class PedidoService {
    private LocalDateTime momento;
    private StatusPedido status;

    private List<ItemPedido> itemPedidos = new ArrayList<>();

    public LocalDateTime getMomento(){
        return this.momento;
    }
    public StatusPedido getStatus(){
        return this.status;
    }
    public List<ItemPedido> getItemPedido(){
        return this.itemPedidos;
    }   
     public void addItem(ItemPedido pedido){
        itemPedidos.add(pedido);
    }

    public Pedido addPedido(LocalDateTime momento, StatusPedido status){
        Pedido pedido = new Pedido(momento, status);
        return pedido;
    }
}
