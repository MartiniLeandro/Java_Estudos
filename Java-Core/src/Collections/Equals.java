package Collections;

//Equals vem da classe Object e compara o valor/estado de dois dados
public class Equals {
    public static void main(String[] args) {
        SmartPhone s1 = new SmartPhone("A1BC1", "iPhone");
        // SmartPhone s2 = new SmartPhone("A1BC1", "iPhone"); VAI DAR FALSE;
        SmartPhone s2 = s1; // VAI DAR VERDADEIRO;
        System.out.println(s1.equals(s2));
    }
}

class SmartPhone {
    String serial;
    String model;

    public SmartPhone(String serial, String model) {
        this.serial = serial;
        this.model = model;
    }
}


