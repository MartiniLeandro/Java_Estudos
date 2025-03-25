package ExerciseFuncionarios;

public class FuncionarioTerceirizado extends Funcionario{

    public Double valorAdicional;
    
    public FuncionarioTerceirizado(){super();};

    public FuncionarioTerceirizado(String nome, Integer horas, Double valorHora, Double valorAdicional){
        super(nome, horas, valorHora);
        this.valorAdicional = valorAdicional;
    }

    @Override
    public Double pagamento() {
        return super.pagamento() + (valorAdicional * 1.1);
    }
    
}
