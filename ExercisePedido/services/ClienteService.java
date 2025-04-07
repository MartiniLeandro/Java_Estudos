package ExercisePedido.services;

import ExercisePedido.Cliente;

public class ClienteService {
    private Cliente cliente;

    public ClienteService(){};
    public ClienteService(Cliente cliente){this.cliente = cliente;};

    public Cliente getCliente(){
        return this.cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente addCliente(String nome, String email){
        Cliente cliente = new Cliente(nome, email);
        return cliente;
    }

}
