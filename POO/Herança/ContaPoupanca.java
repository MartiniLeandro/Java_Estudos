package POO.Herança;

public final class ContaPoupanca extends Conta {
    private Double taxaJuros;

    public ContaPoupanca(){ super();};

    public ContaPoupanca(Integer numero, String titular, Double saldo, Double taxaJuros){
        super(numero, titular, saldo);
        this.taxaJuros = taxaJuros;
    }

    public Double getTaxaJuros(){
        return this.taxaJuros;
    }
    public void setTaxaJuros(Double taxaJuros){
        this.taxaJuros = taxaJuros;
    }

    public void SaldoAtualizado(){
        saldo += saldo * taxaJuros;
    }

    @Override
    public void saque(Double valor){
        saldo -= valor;
    }
}
