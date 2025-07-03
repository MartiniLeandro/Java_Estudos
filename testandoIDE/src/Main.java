import entities.Products;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Products prod1 = new Products("Teste", 500.0);

        System.out.print("Hello world");
        System.out.println(prod1.getProducts());
    }
}