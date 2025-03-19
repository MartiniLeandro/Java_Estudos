package src.classes;

public class Estudante {
    public String nome;
    public double nota1;
    public double nota2;
    public double nota3;

    public void passOrFailed(){
        double notaFinal = nota1 + nota2 + nota3;
        if(notaFinal >= 60){
            System.out.println("Final grade: " + notaFinal);
            System.out.println("PASS");

        }else {
            double miss = 60 - notaFinal;
            System.out.println("Final grade: " + notaFinal);
            System.out.println("Failed");
            System.out.printf("Missing %.2f points", miss);
        }
    }
}
