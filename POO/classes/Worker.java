package POO.classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    private String name;
    private WorkLevel level;
    private Double baseSalary;

    private Departament departament;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(){};

    public Worker(String name, WorkLevel level, Double baseSalary, Departament departament){
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }

    public String getName(){
        return this.name;
    }
    public WorkLevel getLevel(){
        return this.level;
    }
    public Double getBaseSalary(){
        return this.baseSalary;
    }
    public Departament getDepartament(){
        return this.departament;
    }
    public List<HourContract> getContracts(){
        return this.contracts;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public void setLevel(WorkLevel level){
        this.level = level;
    }
    public void setBaseSalary(Double baseSalary){
        this.baseSalary = baseSalary;
    }
    public void setDepartament(Departament departament){
        this.departament = departament;
    }


    public void addContract(HourContract contract){
        this.contracts.add(contract);
    }
    public void removeContract(HourContract contract){
        this.contracts.remove(contract);
    }

	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}

    public String toString(){
        return "Nome: " + name + " Level: " + level + " Base salary: " + baseSalary + " Departament: " + departament;
    }


}
