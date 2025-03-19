package src.application;

import java.util.Scanner;

import src.classes.SantaCatarina;

public class EmployeePoo {
    public static void main(String[] args) {
        Scanner florianopolis = new Scanner(System.in);
        SantaCatarina employee;
        employee = new SantaCatarina();
        System.out.print("Nome: ");
        employee.Name = florianopolis.nextLine();
        System.out.print("Gross Salary: ");
        employee.GrossSalary = florianopolis.nextDouble();
        System.out.print("Tax: ");
        employee.Tax = florianopolis.nextDouble();

        System.out.printf("Employee: %S, $ %.2f %n", employee.Name, employee.NetSalary());
        System.out.print("Which percentage to increase salary? ");
        double percentage = florianopolis.nextDouble();
        employee.IncreaseSalary(percentage);
        

    
    
        florianopolis.close();
    }
}
