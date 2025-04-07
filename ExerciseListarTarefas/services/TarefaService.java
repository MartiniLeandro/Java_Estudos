package ExerciseListarTarefas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ExerciseListarTarefas.Tarefas;

public class TarefaService {
    private List<Tarefas> tarefas = new ArrayList<>();

    public void addTarefa(Scanner sc){
         System.out.print("Quantas tarefas você quer adicionar: ");
        Integer numeroTarefas = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < numeroTarefas; i++){
            System.out.print("Titulo tarefa #" + (i+1) + ": ");
            String titulo = sc.nextLine();
            System.out.print("Descrição: ");
            String descricao = sc.nextLine();
            System.out.print("Id da tarefa: ");
            Integer id = sc.nextInt();
            sc.nextLine();
            tarefas.add(new Tarefas(titulo, descricao, id));

            for (Tarefas tarefas2 : tarefas) {
                System.out.println(tarefas2.getTitulo() + " " + tarefas2.getDescricao() + " " + tarefas2.getId());
            }
        }
    }
}
