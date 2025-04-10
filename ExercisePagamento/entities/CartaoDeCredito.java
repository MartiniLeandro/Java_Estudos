package ExercisePagamento.entities;

import ExercisePagamento.interfaces.MetodoPagamento;

public class CartaoDeCredito implements MetodoPagamento {

    private double saldo;
    
    public CartaoDeCredito(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo(){
        return this.saldo;
    };
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void pagamento(double valor) {
        double taxa = 1.02;
        double pagamento = valor * taxa;
        System.out.println("Verificando saldo para R$" + valor + "... saldo sempre disponível.");
        System.out.println("Pagamento autorizado. Valor com taxa: R$" + pagamento);

    }

 
}
