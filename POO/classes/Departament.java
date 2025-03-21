package POO.classes;

public class Departament {
    private String departament;

    public Departament(String departamento){
        this.departament = departamento;
    }

    public String getDepartament(){
        return this.departament;
    }
    public void setDepartament(String newDepartament){
        this.departament = newDepartament;
    }

    public String toString(){
        return departament;
    }
}
