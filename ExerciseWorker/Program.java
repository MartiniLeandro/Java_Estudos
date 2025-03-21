package ExerciseWorker;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter departament's name: ");
        Departament departament = new Departament(sc.next());
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Level: ");
        Levels level = Levels.valueOf(sc.next());
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();
        Worker worker = new Worker(name,level,baseSalary,departament);
        System.out.print("Quantidade de contratos neste mês: ");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println("ENTER CONTRACT #" + (i+1) + " DATA");
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.println("Duration: ");
            int duration = sc.nextInt();
            Contracts contracts = new Contracts(valuePerHour, duration);
            worker.AddContract(contracts);
        }

        System.out.println("Name: " + worker.getName());
        System.out.println("Departament: " + worker.getDepartament().getDepartament());
        System.out.println("Salary: " + worker.Salary());
        
        sc.close();
    }
}
