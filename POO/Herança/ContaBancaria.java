package POO.Herança;

public class ContaBancaria extends Conta {
    
    private Double limiteEmprestimo;

    public ContaBancaria(){};

    public ContaBancaria(Integer numero,String titular,Double saldo,Double limiteEmprestimo){
        super(numero,titular,saldo);
    }

    public Double getLimiteEmprestimo(){
        return this.limiteEmprestimo;
    }
    public void setLimiteEmprestimo(Double limiteEmprestimo){
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public void emprestimo(Double valor){
        if(valor <=limiteEmprestimo){
            saldo += valor - 10;
        }
    }

    
}
