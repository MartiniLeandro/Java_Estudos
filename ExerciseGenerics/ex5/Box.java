package ExerciseGenerics.ex5;

public class Box<T> {
    public T valor;
    public void guardarValor(T valor){
        this.valor = valor;
    }
    public T pegar(){
        return this.valor;
    }
    
    public static void main(String[] args) {
        Box<String> box1 = new Box<>();
        Box<Integer> box2 = new Box<>();
        Box<Double> box3 = new Box<>();

        box1.guardarValor("teste");
        System.out.println(box1.pegar());

        box2.guardarValor(123);
        System.out.println(box2.pegar());

        box3.guardarValor(456.50);
        System.out.println(box3.pegar());

    }
}
