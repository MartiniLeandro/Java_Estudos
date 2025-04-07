package ExerciseListarTarefas;

import java.util.Scanner;

import ExerciseListarTarefas.services.TarefaService;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       TarefaService service = new TarefaService();

       service.addTarefa(sc);
        
        sc.close();
    }
}
