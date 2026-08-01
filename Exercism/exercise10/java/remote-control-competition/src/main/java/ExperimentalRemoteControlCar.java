public class ExperimentalRemoteControlCar implements RemoteControlCar{

    public int distanceTravelled = 0;

    public void drive() {
        distanceTravelled += 20;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }
}
