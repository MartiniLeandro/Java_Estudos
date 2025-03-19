package src.classes;
public class Circuference {
    public static double PI = 3.14;
    public double radius;
    public double circumference;
    public double volume;

    public  static double circumference(double radius){
        return 2 * PI * radius;
    }
    public static double volume(double radius){
        return 4 * PI * radius * radius * radius / 3;
    }
}
