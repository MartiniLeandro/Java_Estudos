package ExerciseFuncionarios;

public class Funcionario {
    private String nome;
    private Integer horas;
    private Double valorPorHora;

    public Funcionario(){};

    public Funcionario(String nome, Integer horas, Double valorHora){
        this.nome = nome;
        this.horas = horas;
        this.valorPorHora = valorHora;
    }

    public String getNome(){
        return this.nome;
    }
    public Integer getHoras(){
        return this.horas;
    }
    public Double getValorPorHora(){
        return this.valorPorHora;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setHoras(Integer horas){
        this.horas = horas;
    }
    public void setValorPorHora(Double valorHora){
        this.valorPorHora = valorHora;
    }

    public Double pagamento(){
        return horas * valorPorHora;
    }
}
