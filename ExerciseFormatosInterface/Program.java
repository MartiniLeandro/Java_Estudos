package ExerciseFormatosInterface;


import ExerciseFormatosInterface.entities.Circulo;
import ExerciseFormatosInterface.entities.Cores;
import ExerciseFormatosInterface.entities.Retangulo;
import ExerciseFormatosInterface.interfaces.FormatoAbstract;

public class Program {
    public static void main(String[] args) {
        
		FormatoAbstract s1 = new Circulo(Cores.PRETO, 2.0);
		FormatoAbstract s2 = new Retangulo(Cores.BRANCO, 3.0, 4.0);
		
		System.out.println("Circle color: " + s1.getCor());
		System.out.println("Circle area: " + String.format("%.3f", s1.area()));
		System.out.println("Rectangle color: " + s2.getCor());
		System.out.println("Rectangle area: " + String.format("%.3f", s2.area()));
    }    

}
