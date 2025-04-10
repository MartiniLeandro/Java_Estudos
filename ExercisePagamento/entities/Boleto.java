package ExercisePagamento.entities;

import ExercisePagamento.interfaces.MetodoPagamento;

public class Boleto implements MetodoPagamento{
    
    private Double saldo;

    public Boleto(Double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void pagamento(double valor){
        System.out.println("Verificando saldo para R$" + valor + "... Boleto sempre pode ser gerado.");
        System.out.println("Boleto gerado!!!");
    }

    

}
