package ExerciseFuncionarios;

public class FuncionarioTerceirizado extends Funcionario{

    public Double valorAdicional;
    
    public FuncionarioTerceirizado(){super();};

    public FuncionarioTerceirizado(String nome, Integer horas, Double valorHora, Double valorAdicional){
        super(nome, horas, valorHora);
        this.valorAdicional = valorAdicional;
    }

    public Double getValorAdicional(){
        return this.valorAdicional;
    }

    public void setValorAdicional(Double valor){
        this.valorAdicional = valor;
    }

    @Override
    public Double pagamento() {
        return super.pagamento() + (valorAdicional * 1.1);
    }
    
}
