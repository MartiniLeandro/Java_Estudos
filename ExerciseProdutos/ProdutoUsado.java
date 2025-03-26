package ExerciseProdutos;

import java.time.LocalDate;


public class ProdutoUsado extends Produto {
    private LocalDate dataFabricacao;

    public ProdutoUsado(){super();}

    public ProdutoUsado(String nome, Double valor, LocalDate dataFabricacao){
        super(nome, valor);
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataFabricacao(){
        return this.dataFabricacao;
    }

    public void setDataFabricacao(LocalDate data){
        this.dataFabricacao = data;
    }

    @Override
    public String etiqueta(){
        return super.etiqueta() + " (Data de fabricação: " + getDataFabricacao() + ")";
    }
}
