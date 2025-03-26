package ExerciseProdutos;

public class Produto {
    private String nome;
    private Double valor;

    public Produto(){};

    public Produto(String nome, Double valor){
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome(){
        return this.nome;
    }
    public Double getValor(){
        return this.valor;
    }

    public String etiqueta(){
        return getNome() + " $ " + getValor();
    }



}
