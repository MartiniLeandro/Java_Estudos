class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar>{

    public int distanceTravelled = 0;
    public int numbersOfVictory = 0;

    public void drive() {
        distanceTravelled += 10;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public int getNumberOfVictories() {
        return numbersOfVictory;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        numbersOfVictory = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar otherCar) {
        return Integer.compare(otherCar.getNumberOfVictories(), this.numbersOfVictory);
    }
}
