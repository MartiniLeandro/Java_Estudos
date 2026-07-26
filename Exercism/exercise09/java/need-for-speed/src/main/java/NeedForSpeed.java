class NeedForSpeed {

    private int speed;
    private int batteryDrain;
    private int batteryPercentage = 100;
    private int distanceDriven = 0;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return batteryPercentage < batteryDrain;
    }

    public int distanceDriven() {
        return distanceDriven;
    }

    public void drive() {
        if(batteryPercentage < batteryDrain) return;
        distanceDriven += speed;
        batteryPercentage -= batteryDrain;
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50,4);
    }
}

class RaceTrack {

    private int distance;
    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
       while(!car.batteryDrained()) car.drive();
       return car.distanceDriven() >= distance;
    }
}
