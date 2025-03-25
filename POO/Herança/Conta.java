package POO.Herança;

public class Conta {
    private Integer numero;
    private String titular;
    protected Double saldo;

    public Conta(){};

    public Conta(Integer numero, String titular, Double saldo){
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    
    public Integer getNumero(){
        return this.numero;
    }
    public String  getTitular(){
        return this.titular;
    }
    public Double getSaldo(){
        return this.saldo;
    }
    
    public void setNumero(Integer numero){
        this.numero = numero;
    }
    public void setTitular(String titular){
        this.titular = titular;
    }

    public void saque(Double valor){
        this.saldo -= valor + 5;
    }
    public void deposito(Double valor){
        this.saldo += valor;
    }
}
