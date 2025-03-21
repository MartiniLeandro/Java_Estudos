package POO;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import POO.classes.Departament;
import POO.classes.HourContract;
import POO.classes.WorkLevel;
import POO.classes.Worker;



public class WorkerProgram {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter departament\'s name: ");
        Departament departament = new Departament(sc.next());
        System.out.println("ENTER WORKER DATA");
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Level: ");
        String level = sc.next().toUpperCase();
        WorkLevel workLevel = WorkLevel.valueOf(level);
        System.out.print("Base Salary: ");
        Double baseSalary = sc.nextDouble();
        System.out.print("How many contracts to this worker: ");
        Worker worker = new Worker(name, workLevel, baseSalary, departament);
        Integer contractsNumber = sc.nextInt();
        for(int i = 0; i < contractsNumber; i++){
            System.out.println("Enter contract #" + (i+1) + " data:");
            System.out.print("Date (DD/MM/YYYY)");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int duration = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, duration);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY)");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Departament: " + worker.getDepartament().getDepartament());
        System.out.println("Incame for " + monthAndYear + ": " + worker.income(year, month));
        
        sc.close();
    }   
}
