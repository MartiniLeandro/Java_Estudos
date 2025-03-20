package POO;

import java.util.Date;


import POO.classes.Order;
import POO.enums.OrderStatus;

public class ProcessosEnum {
    public static void main(String[] args) {
        Order order = new Order(1080, new Date(), OrderStatus.PAGAMENTO_PENDENTE);

        System.out.println(order);

        OrderStatus os1 = OrderStatus.ENTREGUE;
        OrderStatus os2 = OrderStatus.valueOf("ENTREGUE");
        System.out.println(os1);
        System.out.println(os2);
    }
}
