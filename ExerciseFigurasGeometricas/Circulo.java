package ExerciseFigurasGeometricas;

public class Circulo extends Formato{
    private Double raio;

    public Circulo(){super();};

    public Circulo(Cores cor, Double raio){
        super(cor);
        this.raio = raio;
    }

    public Double getRaio(){
        return this.raio;
    }
    public void setRaio(Double raio){
        this.raio = raio;
    }

    @Override
    public Double area() {
        return Math.PI * raio * raio;
    }
    
}
