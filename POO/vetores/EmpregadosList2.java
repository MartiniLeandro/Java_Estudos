package POO.vetores;

import POO.classes.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpregadosList2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos empregados terão: ");
        int qntEmpregados = sc.nextInt();
        List<Employee> lista = new ArrayList<>();
        for(int i = 0; i < qntEmpregados; i++){
            System.out.println("Empregado " + (i+1));
            System.out.print("ID: ");
            int id = sc.nextInt();
            while(hasId(lista, id)){
                System.out.println("Ja existe alguem com este ID, tente de novo");
                System.out.print("Novo ID: ");
                id = sc.nextInt();
            }
            System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			lista.add(new Employee(id, name, salary));

            
        }

        System.out.println("Qual ID do empregado que irá receber um aumento");
        int id = sc.nextInt();
        Employee emp = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if(emp == null){
            System.out.println("Não existe ninguem registrado com este ID");
        }else{
            System.out.println("Qual porcentagem que você deseja incrementar: ");
            double porcentagem = sc.nextDouble();
            emp.increaseSalary(porcentagem);
        }

		
		System.out.println();
		System.out.println("List of employees:");
		for (Employee obj : lista) {
			System.out.println(obj);
		}
				
        
        sc.close();
    }
    public static boolean hasId(List<Employee> list, int id){
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}
