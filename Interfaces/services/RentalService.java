package Interfaces.services;

import java.time.Duration;

import Interfaces.entities.CarRental;
import Interfaces.entities.Invoice;

public class RentalService {
    
    private double pricePerHour;
    private double pricePerDay;

    private TaxService taxService;

    public RentalService(){};
    public RentalService(double pricePerHour, double pricePerDay, TaxService taxService){
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental){

        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60;

        double basicPayment;
        if(hours <= 12){
            basicPayment = pricePerHour * Math.ceil(hours);
        }else{
            basicPayment = pricePerDay * Math.ceil(hours / 24);
        }

        double tax = taxService.tax(basicPayment);


        carRental.setInvoice(new Invoice(basicPayment,tax));
    }

}
