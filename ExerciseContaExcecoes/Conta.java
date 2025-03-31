package ExerciseContaExcecoes;

public class Conta {
    private Integer number;
    private String titular;
    private Double saldo;
    private Double limiteSaque;

    public Conta(){};

    public Conta(Integer number, String titular, Double saldo, Double limiteSaque ){
        this.number = number;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public Integer getNumber(){
        return this.number;
    }
    public String getTitular(){
        return this.titular;
    }
    public Double getSaldo(){
        return this.saldo;
    }
    public Double getLimiteSaque(){
        return this.limiteSaque;
    }

    public void setTitular(String titular){
        this.titular = titular;
    }

    public void deposito(Double valor){
        this.saldo += valor;
    }
    public void saque(Double valor) throws ExcecaoConta{
        if(valor > limiteSaque){
            throw new ExcecaoConta("O valor de saque deve ser menor que o limite de saque");
        }if(valor > saldo){
            throw new ExcecaoConta("O valor de saque deve ser menor que o saldo atual");
        }
        this.saldo -= valor;
    }
}
