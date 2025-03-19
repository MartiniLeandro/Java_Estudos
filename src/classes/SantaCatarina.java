package src.classes;


public class SantaCatarina {

    public String Name;
    public double GrossSalary;
    public double Tax;


    public double NetSalary(){
        return GrossSalary - Tax;
    }

    public void IncreaseSalary(double percentage){
        double newIncrease = (percentage * 0.01) * GrossSalary;
        double newSalary = (newIncrease + GrossSalary) - Tax;
        System.out.printf("Updated data: %S, $ %.2f %n", Name, newSalary);
    }
}
