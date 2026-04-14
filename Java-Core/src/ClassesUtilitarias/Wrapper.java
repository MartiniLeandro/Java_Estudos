package ClassesUtilitarias;

//Utilizar as classes em vez dos tipos primitivos, para conseguir desfrutar de mais funcionalidades
public class Wrapper {
    public static void main(String[] args) {
        byte byteP = 1;
        short shortP = 2;
        int intP = 3;
        long longP = 4;
        float floatP = 5;
        double doubleP = 6;
        char charP = 'W';
        boolean booleanP = true;

        Byte byteW = 1;
        Short shortW = 2;
        Integer intW = 3; // autoboxing
        Long longW = 4L;
        Float floatW = 5F;
        Double doubleW = 6D;
        Character charW = 'W';
        Boolean booleanW = true;

        int i = intW; //unboxing
        Integer intW2 = Integer.parseInt("24");
    }
}
