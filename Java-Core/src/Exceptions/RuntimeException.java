package Exceptions;

//Exceções CHECKED são aquelas em que o código nem irá compilar quando ocorrer o erro, já as UNCHECKED são filhas das exceções CHECKED, todas filhas do RuntimeException, normalmente erro do programador
public class RuntimeException {
    public static void main(String[] args) {
        try{
            divisao(1,0);
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        System.out.println("Código finalizado"); //Linha de código aparecendo, por conta dos dois tratamentos de erro
    }

    private static int divisao(int num1, int num2) {
        if(num2 == 0){
            throw new IllegalArgumentException("Argumento ilegal, não pode ser 0");
        }
        return num1 / num2;
    }
}

