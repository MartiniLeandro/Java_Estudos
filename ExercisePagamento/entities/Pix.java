package ExercisePagamento.entities;

import ExercisePagamento.interfaces.MetodoPagamento;

public class Pix implements MetodoPagamento {
    
    private double saldo;

    public Pix(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void pagamento(double valor){
        if(valor > getSaldo()){
            System.out.println("Verificando saldo para R$" + valor + "... Saldo insuficiente");
            System.out.println("Pagamento não autorizado por PIX");
        }else{
            System.out.println("Verificando saldo para R$" + valor + "... Saldo disponível para pagamento");
            double saldoNovo = saldo - valor;
            System.out.println("Pagamento realizado. O seu saldo atual é de R$" + saldoNovo); 
        }
    }
}
