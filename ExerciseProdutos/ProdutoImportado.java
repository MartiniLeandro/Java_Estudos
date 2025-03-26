package ExerciseProdutos;


public class ProdutoImportado extends Produto {
    private Double taxaAlfandega;

    public ProdutoImportado(){super();}

    public ProdutoImportado(String nome, Double valor, Double taxaAlfandega){
        super(nome, valor);
        this.taxaAlfandega = taxaAlfandega;
    }

    public Double valorTotal(){
        return this.getValor() + taxaAlfandega;
    }

    @Override
    public String etiqueta(){
        return super.etiqueta() + " (Taxa de alfândega: " + taxaAlfandega + ")";
    }

}
