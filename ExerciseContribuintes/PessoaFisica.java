package ExerciseContribuintes;

public class PessoaFisica extends Pessoa{
    private Double gastosSaude;

    public PessoaFisica(){super();}

    public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude){
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    public Double getGastosSaude(){
        return this.gastosSaude;
    }
    public void setGastosSaude(Double gastosSaude){
        this.gastosSaude = gastosSaude;
    }

    @Override
    public Double valorImposto(){
        Double imposto = 0.0;
        if(rendaAnual < 20000){
            imposto = rendaAnual * 0.15;
        }else if(rendaAnual > 20000){
            imposto = rendaAnual * 0.25;
        }
        if(gastosSaude != 0){
            imposto -= (gastosSaude * 0.5);
        }
        return imposto;
    }
}
