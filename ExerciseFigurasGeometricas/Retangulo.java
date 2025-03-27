package ExerciseFigurasGeometricas;

public class Retangulo extends Formato{
    private Double altura;
    private Double largura;

    public Retangulo(){super();};

    public Retangulo(Cores cor, Double altura, Double largura){
        super(cor);
        this.altura = altura;
        this.largura = largura;
    }

    public Double getAltura(){
        return this.altura;
    }
    public Double getLargura(){
        return this.largura;
    }

    public void setAltura(Double altura){
        this.altura = altura;
    }
    public void setLargura(Double largura){
        this.largura = largura;
    }


    @Override
    public Double area() {
        return altura * largura;
    }
    
}
