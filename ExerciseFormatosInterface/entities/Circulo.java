package ExerciseFormatosInterface.entities;

import ExerciseFormatosInterface.interfaces.FormatoAbstract;

public class Circulo extends FormatoAbstract {
    private double raio;

    public Circulo(Cores cor, double raio) {
        super(cor);
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
    }

    public double area(){
        double area =  2 * 3.14 * raio;
        return area;
    }

    
}
