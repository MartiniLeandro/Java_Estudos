package ExerciseListarTarefas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Tarefas> tarefas = new ArrayList<>();

        System.out.print("Quantas tarefas você quer adicionar: ");
        Integer numeroTarefas = sc.nextInt();

        for(int i = 0; i < numeroTarefas; i++){
            System.out.println("Titulo tarefa #" + (i+1) + ": ");
            String titulo = sc.nextLine();
            System.out.println("Descrição: ");
            String descricao = sc.nextLine();
            System.out.println("Prioridade tarefa: ");
            String prioridade = sc.next();
            System.out.print("Id da tarefa: ");
            Integer id = sc.nextInt();
            tarefas.add(new Tarefas(titulo, descricao, Prioridades.valueOf(prioridade), id));
        }

        for (Tarefas tarefas2 : tarefas) {
            if(tarefas2.getPrioridade() == Prioridades.ALTA){

            }
        }
        
        sc.close();
    }
}
