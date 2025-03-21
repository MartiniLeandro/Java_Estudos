package ExerciseWorker;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String name;
    private Levels level;
    private double baseSalary;
    private Departament departament;
    private List<Contracts> contracts = new ArrayList<>();

    public Worker(String name, Levels level, double baseSalary, Departament departament){
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }

    public String getName(){
        return this.name;
    }
    public Levels getLevel(){
        return this.level;
    }
    public double getBaseSalary(){
        return this.baseSalary;
    }
    public List<Contracts> getContracts(){
        return this.contracts;
    }
    public Departament getDepartament(){
        return this.departament;
    }

    public String toString(){
        return "Name: " + name + " | Level: " + level + " | BaseSalary: " + baseSalary + " | Departament: " + departament;
    }

    public void AddContract(Contracts contract){
        contracts.add(contract);
    }

    public double Salary(){
        double salaryAdd = 0;
        for (Contracts c : contracts) {
            salaryAdd += c.getValuePerHour() * c.getDuration();
        }
        return baseSalary + salaryAdd ;
    }

}
