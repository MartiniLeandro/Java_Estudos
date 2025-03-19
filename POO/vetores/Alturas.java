package POO.vetores;

import java.util.Scanner;

public class Alturas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantas pessoas serao digitadas: ");
        int numeroPessoas = sc.nextInt();
        String[] nomes = new String[numeroPessoas];
        int[] idades = new int[numeroPessoas];
        double[] alturas = new double[numeroPessoas];
        for(int i = 0; i < numeroPessoas; i++){
            System.out.println("Dados da " + (i+1) + "a pessoa");
            System.out.print("Nome: ");
            nomes[i] = sc.next();
            sc.nextLine();
            System.out.print("Idade: ");
            idades[i] = sc.nextInt();
            System.out.print("Altura: ");
            alturas[i] = sc.nextDouble();
        }
        double somaAlturas = 0;
        for(int i = 0; i < numeroPessoas; i++){
            somaAlturas += alturas[i];
        }
        double mediaAltura = somaAlturas / numeroPessoas; 
                int PessoasMenos16 = 0;
                for(int i = 0; i < numeroPessoas; i++){
                    if(idades[i] < 16){
                        PessoasMenos16++;
                    }
                }
        double porcentagemMenos16 = (PessoasMenos16 * 100) / numeroPessoas;
        
        System.out.printf("Altura média: %.2f%n", mediaAltura);
        System.out.println("Pessoas com menos de 16 anos: " + porcentagemMenos16 + "%");

        System.out.println("Nome das pessoas com menos de 16 anos: ");

        for(int i = 0; i < numeroPessoas; i++){
            if(idades[i] < 16){
               System.out.println(nomes[i]);
            }
        }
        sc.close();
    }
}
