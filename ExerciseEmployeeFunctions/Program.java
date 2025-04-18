package ExerciseEmployeeFunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        
        System.out.print("Enter full file path: ");
        String path = sc.next();
        System.err.println();
        System.out.print("Enter Salary: ");
        Double entrySalary = sc.nextDouble();

        try(BufferedReader bf = new BufferedReader(new FileReader(path))){
            String line = bf.readLine();
            while(line != null){
                String[] files = line.split(",");
                employees.add(new Employee(files[0], files[1], Double.parseDouble(files[2])));
                line = bf.readLine();
            }
        }catch(IOException e){
            System.out.println("EROOR: " + e.getMessage());
        }

        List<String> bigSalary = employees.stream().filter(e -> e.getSalary() > entrySalary).map(e -> e.getEmail()).collect(Collectors.toList());
        Double SalaryStartsM = employees.stream().filter(e -> e.getName().charAt(0) == 'M').map(e -> e.getSalary()).reduce(0.0, (x,y) -> x + y);



        System.out.println("EMAIL OF PEOPLE WHOSE SALARY IS MORE THAN " + entrySalary +":");
        bigSalary.forEach(System.out::println);
        System.out.println("SUM OF SALARY OF PEOPLE WHOSE NAME STARTS WITH 'M': " + SalaryStartsM);


        sc.close();
    }
}
