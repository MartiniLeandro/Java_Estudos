package src.classes;

public class RealDolar {
    public static double IOF = 0.06;

    public static double valorGasto(double dolar, double dolarComprado){
        return dolar * dolarComprado + (dolarComprado * dolar * IOF);
    } 

}
