package ExerciseFigurasGeometricas.services;

import java.util.ArrayList;
import java.util.List;

import ExerciseFigurasGeometricas.Circulo;
import ExerciseFigurasGeometricas.Cores;
import ExerciseFigurasGeometricas.Formato;
import ExerciseFigurasGeometricas.Retangulo;

public class FormatoService {
    private List<Formato> formasGeometricas = new ArrayList<>();
    
    public void CadastroCirculo(Double raio, Cores cor){
        Formato circulo = new Circulo(cor, raio);
        formasGeometricas.add(circulo);
    }
    public void CadastroRetangulo(Double altura, Double largura, Cores cor){
        Formato retangulo = new Retangulo(cor, altura, largura);
        formasGeometricas.add(retangulo);
    }
    public void AreaFormasGeometricas(){
        for (Formato formato : formasGeometricas) {
            System.out.printf("%.2f%n", formato.area());
        }
    }
}
