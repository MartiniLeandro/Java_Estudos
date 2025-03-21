package ExercisePost;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDateTime agora = LocalDateTime.now();

        System.out.print("Quantos posts você quer criar: ");
        int n = sc.nextInt();
        sc.nextLine();

        Post novoPost = null;
        for (int i = 0; i < n; i++) {
            System.out.print("Título do Post: ");
            String titulo = sc.nextLine();

            System.out.print("Conteúdo do Post: ");
            String conteudo = sc.nextLine();

            System.out.print("Quantos likes: ");
            int likes = sc.nextInt();
            sc.nextLine(); 

            LocalDateTime momentoAgora = agora;
            novoPost = new Post(momentoAgora, titulo, conteudo, likes);

            System.out.print("Quantos comentários você quer ter neste post: ");
            int comentarios = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < comentarios; j++) {
                System.out.print("Conteúdo comentário #" + (j + 1) + ": ");
                String comentario = sc.nextLine();
                Comment newComentario = new Comment(comentario);

                novoPost.addComent(newComentario);
            }
        }
        System.out.println(novoPost);

        sc.close();
    }
}
