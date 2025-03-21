package ExerciseWorker;


public class Contracts {
    private double valuePerHour;
    private int duration;

    public Contracts(double valuePerHour, int duration){
        this.valuePerHour = valuePerHour;
        this.duration = duration;
    }

    public double getValuePerHour(){
        return this.valuePerHour;
    }
    public int getDuration(){
        return this.duration;
    }


    public void setValuePerHour(double valuePerHour){
        this.valuePerHour = valuePerHour;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }
    public double SalaryAdd(){
        return valuePerHour * duration;
    }
}   
