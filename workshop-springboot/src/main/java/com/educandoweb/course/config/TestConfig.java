package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.models.Order;
import com.educandoweb.course.models.User;
import com.educandoweb.course.models.enums.OrderStatus;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    
    @Autowired
    private UserRepository userRepository;
    private OrderRepository orderRepository;

    public TestConfig(UserRepository userRepository, OrderRepository orderRepository){
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("Maria Brown", "maria@gmail.com", "98888888", "123456");
        User u2 = new User("Alex Green", "alex@gmail.com","97777777", "1234567");

        Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.SHIPPED, u2);
        Order o3 = new Order(Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, u1);


        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }


}
