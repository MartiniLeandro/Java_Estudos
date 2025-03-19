package src.classes;

public class ContaBancaria {
    public String titular;
    public double saldo;

    public double depositar(double deposito){
        return saldo += deposito;
    }
    public void sacar(double saque){
        if(saldo > saque){
            saldo -= saque;
            System.out.println("Saque realizado");
        }else {
            System.out.println("Saque Não realizado");
        }
    }
    public void exibirSaldo(){
        System.out.println("Saldo da conta: " + saldo);
    }
}
