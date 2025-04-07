package Interfaces.entities;

import java.time.LocalDateTime;

public class CarRental {
    private LocalDateTime start;
    private LocalDateTime finish;

    private Vehicle vehicle;
    private Invoice invoice;

    public CarRental(){};
    public CarRental(LocalDateTime start, LocalDateTime finish, Vehicle vehicle){
        this.start = start;
        this.finish = finish;
        this.vehicle = vehicle;
    }

    public LocalDateTime getStart(){
        return this.start;
    }
    public LocalDateTime getFinish(){
        return this.finish;
    }
    public Vehicle getVehicle(){
        return this.vehicle;
    }
    public Invoice getInvoice(){
        return this.invoice;
    }

    public void setStart(LocalDateTime start){
        this.start = start;
    }
    public void setFinish(LocalDateTime finish){
        this.finish = finish;
    }
    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }
    public void setInvoice(Invoice invoice){
        this.invoice = invoice;
    }
}
