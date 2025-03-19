package src.application;

import java.util.Scanner;

import src.classes.Storage;

public class StoragePoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter product data:");
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        Storage product = new Storage(name, price);
        System.out.println(product);

        product.setName("Computer");
        System.out.println(product.getName());

        System.out.println(product.toString());

        System.out.println();
        System.out.print("Enter the number of products to be added in stock: ");
        int quantity = sc.nextInt();
        product.addProducts(quantity);
        System.out.println(product.toString());

        System.out.print("Enter the number of products to be removed in stock: ");
        quantity = sc.nextInt();
        product.removeProducts(quantity);
        System.out.println(product.toString());

        sc.close();
    }
}
