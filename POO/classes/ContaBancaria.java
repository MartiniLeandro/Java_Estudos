package POO.classes;

public class ContaBancaria{
    private int numeroConta;
    private String titularConta;
    private double saldoConta;

    public ContaBancaria(int numeroConta, String titularConta, double saldoConta){
        this.numeroConta = numeroConta;
        this.titularConta = titularConta;
        this.saldoConta = saldoConta;
    }
    public ContaBancaria(int numeroConta, String titularConta){
        this.numeroConta = numeroConta;
        this.titularConta = titularConta;
        this.saldoConta = 0;
    }

    public int getNumeroConta(){
        return this.numeroConta;
    }
    public String geTitularConta(){
        return this.titularConta;
    }
    public void setTitularConta(String titularConta){
        this.titularConta = titularConta;
    }
    public double getSaldoConta(){
        return this.saldoConta;
    }

    public void deposito(double deposito){
         this.saldoConta += deposito;
    }
    public void saque(double saque){
         this.saldoConta -= (saque + 5);
    }
    public String toString(){
        return "Conta: " + numeroConta + ", Titular: " + titularConta + ", Saldo " + saldoConta;
    }




}