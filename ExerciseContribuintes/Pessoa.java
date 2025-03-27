package ExerciseContribuintes;

public abstract class Pessoa {
    private String nome;
    protected Double rendaAnual;

    public Pessoa(){};

    public Pessoa(String nome, Double rendaAnual){
        this.nome = nome;
        this.rendaAnual = rendaAnual;
    }

    public String getNome(){
        return this.nome;
    }
    public Double getRendaAnual(){
        return this.rendaAnual;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setRendaAnual(Double rendaAnual){
        this.rendaAnual = rendaAnual;
    }

    public abstract Double valorImposto();
}
