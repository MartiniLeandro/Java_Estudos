package ExercisesAulas.area;

public class Circulo implements Shape{
    private Double raio;

    public Circulo(Double raio) {
        this.raio = raio;
    }

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
    }

    @Override
    public double area(){
        return (2 * 3.14) * raio;
    }
}
