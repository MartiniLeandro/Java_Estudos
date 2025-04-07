package Interfaces.entities;

public class Invoice {
    private Double basicPayment;
    private Double tax;
    
    public Invoice(){};
    public Invoice(Double basicPayment, Double tax){
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    public Double getBasicPayment(){
        return this.basicPayment;
    }
    public Double getTax(){
        return this.tax;
    }
    
    public void setBasicPayment(Double basicPayment){
        this.basicPayment = basicPayment;
    }
    public void setTax(Double tax){
        this.tax = tax;
    }

    public Double getTotalPayment(){
        return getBasicPayment() + getTax();
    }
}
