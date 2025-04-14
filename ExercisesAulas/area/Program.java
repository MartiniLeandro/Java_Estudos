package ExercisesAulas.area;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Shape> myShapes = new ArrayList<>();
        myShapes.add(new Retangulo(3.0, 2.0));
        myShapes.add(new Circulo(2.0));
        List<Circulo> myCircles = new ArrayList<>();
        myCircles.add(new Circulo(4.0));
        myCircles.add(new Circulo(5.0));

        System.out.println("TOTAL AREA:" + somaAreas(myShapes));
        System.out.println("TOTAL AREA:" + somaAreas(myCircles));


    }

    public static Double somaAreas(List<? extends Shape> shapes){
        Double soma = 0.0;
        for (Shape shape : shapes) {
            soma += shape.area();
        }
        return soma;
    }
}
