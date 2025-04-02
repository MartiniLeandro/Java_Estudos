package ExerciseGestãoEscolar;

import java.util.ArrayList;
import java.util.List;

public class Boletim {
    private List<Double> notas;

    public Boletim(){
        this.notas = new ArrayList<>();
    };

    public List<Double> getNotas(){
        return this.notas;
    }
    public void addNota(Double nota) throws ExcecaoSistemaEscolar{
        if(nota < 0 || nota > 10){
            throw new ExcecaoSistemaEscolar("A nota deve ser entre 0 e 10");
        }
        if(notas == null){
            notas = new ArrayList<>();
        }
        notas.add(nota);
    }

    public Double mediaBoletim(){
        Double soma = 0.0;
        for (Double nota : notas) {
            soma += nota;
        }
         Double media = soma / notas.size();
         return media;
    }

    public String AprovadoOuReprovado(){
        return mediaBoletim() >= 7 ? "APROVADO!!!" : "REPROVADO!!!";
    }

    public void consultaBoletim(){

    }
    
}
