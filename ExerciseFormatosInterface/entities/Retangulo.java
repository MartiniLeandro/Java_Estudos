package ExerciseFormatosInterface.entities;

import ExerciseFormatosInterface.interfaces.FormatoAbstract;

public class Retangulo extends FormatoAbstract{
    private double largura;
    private double altura;

    public Retangulo(Cores cor, double largura, Double altura) {
        super(cor);
        this.largura = largura;
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public double area(){
        double area = altura * largura; 
        return area;
    }
    
}
