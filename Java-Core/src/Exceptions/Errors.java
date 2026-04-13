package Exceptions;

//Errors ocorre quando a JVM (Java Virtual Machine) não consegue resolver o problema do código, e a aplicação deve ser parada
public class Errors {
    public static void main(String[] args) {
        recursividade();
    }

    public static void recursividade(){
        recursividade();
    }
}
