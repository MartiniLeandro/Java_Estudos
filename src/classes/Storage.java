package src.classes;

public class Storage {
    private String name;
    private double price;
    private int quantity;

    public Storage(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Storage(String name, double price){
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double TotalValueInStock(){
        return price * quantity;
    }

    public void addProducts(int quantity){
        this.quantity += quantity;
    }
    public void removeProducts(int quantity){
        this.quantity -= quantity;
    }

    public String toString(){
        return name + ", R$ " + price + ", " + quantity + " units, Total: R$ " + TotalValueInStock();
    }
}
