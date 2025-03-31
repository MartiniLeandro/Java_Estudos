package ExerciseIdadeExcecoes;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("Idade: ");
        Integer idade = sc.nextInt();
        Usuario usuario = new Usuario(nome, idade);
        
        try{
            usuario.cadastrarUsuario();
            System.out.println("Usuário cadastrado");
        }catch(ExcecaoIdade e){
            System.out.println(e.getMessage());
        }


        sc.close();
    }
}
