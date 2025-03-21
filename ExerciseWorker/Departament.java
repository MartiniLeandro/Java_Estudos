package ExerciseWorker;

public class Departament {
    private String nameDepartament;

    public Departament(String departament){
        this.nameDepartament = departament;
    }

    public String getDepartament(){
        return this.nameDepartament;
    }

    public void setDepartament(String departament){
        this.nameDepartament = departament;
    }

    public String toString(){
        return nameDepartament;
    }
}
