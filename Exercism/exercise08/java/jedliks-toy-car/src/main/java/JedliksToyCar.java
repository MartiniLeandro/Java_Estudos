public class JedliksToyCar {

    public int distanceDriven = 0;
    public int batteryPercentage = 100;
    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + distanceDriven + " meters";
    }

    public String batteryDisplay() {
        if(batteryPercentage == 0){
            return "Battery empty";
        }
        return "Battery at " + batteryPercentage + "%";
    }

    public void drive() {
        if(batteryPercentage == 0) return;
        distanceDriven += 20;
        batteryPercentage -= 1;
    }
}
