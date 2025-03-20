package POO.classes;


import java.util.Date;


import POO.enums.OrderStatus;

public class Order {
    private Integer id;
    private Date moment;
    private OrderStatus status;

    public Order(){};
    public Order(Integer id, Date moment, OrderStatus status){
        this.id = id;
        this.moment = moment;
        this.status = status;
    }

    public Integer getId(){
        return this.id;
    }
    public Date getMoment(){
        return this.moment;
    }
    public OrderStatus getOrder(){
        return this.status;
    }

    public void SetId(Integer id){
        this.id = id;
    }

    public void SetMoment(Date moment){
        this.moment = moment;
    }

    public void SetOrder(OrderStatus order){
        this.status = order;
    }
    
    public String toString(){
        return "ID: " + this.id + ", Moment: " + this.moment + ", status: " + this.status; 
    }
}
