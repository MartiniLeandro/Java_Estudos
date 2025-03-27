package ExerciseContribuintes;

public class PessoaJuridica extends Pessoa {
    private Integer numeroFuncionarios;

    public PessoaJuridica(){super();}

    public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios){
        super(nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public Integer getNumeroFuncionarios(){
        return this.numeroFuncionarios;
    }
    public void setNumeroFuncionarios(Integer nFuncionarios){
        this.numeroFuncionarios = nFuncionarios;
    }

    @Override
    public Double valorImposto(){
        Double imposto = 0.0;
        if(numeroFuncionarios > 10){
            imposto = rendaAnual * 0.14;
        }else {
            imposto = rendaAnual * 0.16;
        }
        return imposto;
    }
}
