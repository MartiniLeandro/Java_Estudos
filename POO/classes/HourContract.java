package POO.classes;

import java.util.Date;

public class HourContract {
    private Date date;
    private Double valuePerHour;
    private Integer hours;

    public HourContract(Date date, Double valuePerHour, Integer hours){
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public Date getDate(){
        return this.date;
    }
    public Double getValuePerHour(){
        return this.valuePerHour;
    }
    public Integer getHours(){
        return this.hours;
    }

    public void setDate(Date date){
        this.date = date;
    }
    public void setValuePerHour(Double valuePerHour){
        this.valuePerHour = valuePerHour;
    }
    public void setHours(Integer hours){
        this.hours = hours;
    }

    public double totalValue(){
        return valuePerHour * hours;
    }
}
