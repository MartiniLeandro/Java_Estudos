public class CarsAssemble {

    static final int carsProducedInHour = 221;

    public double productionRatePerHour(int speed) {
        if(speed >= 1 && speed <= 4){
            return carsProducedInHour * speed;
        }else if(speed >= 5 && speed <= 8){
            return (carsProducedInHour * speed) * 0.9;
        }else if(speed == 9){
            return (carsProducedInHour * speed) * 0.8;
        }else if(speed == 10){
            return (carsProducedInHour * speed) * 0.77;
        } else return 0.0;
    }

    public int workingItemsPerMinute(int speed) {
        return (int)productionRatePerHour(speed) / 60;
    }
}
