package com.projectWithTest.demo.testesIntegracao.services;

import com.projectWithTest.demo.config.AbstractIntegrationTest;
import com.projectWithTest.demo.entities.User;
import com.projectWithTest.demo.repositories.UserRepository;
import com.projectWithTest.demo.services.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
public class UserServiceTest extends AbstractIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private User user1,user2,user3;

    @BeforeEach
    void setup(){
        user1 = new User("Leandro","Oliveira","SC","Male","leandro@email.com");
        user2 = new User("Gabriel","Oliveira","SC","Male","gabriel@email.com");
        user3 = new User("Thiago","Oliveira","SC","Male","thiago@email.com");
        userRepository.saveAll(List.of(user1,user2,user3));
    }

    @Test
    void testFindUsers(){
        List<User> allUsers = userService.findAll();

        Assertions.assertFalse(allUsers.isEmpty());
        Assertions.assertEquals(3,allUsers.size());
    }

    @Test
    void testFindUserById(){
        User user = userService.findById(user1.getId());

        Assertions.assertEquals("Leandro", user.getFirstName());
    }

    @Test
    void testCreateUser(){
        User user4 = new User("Pedro","Oliveira","SC","Male","pedro@email.com");
        User newUser = userService.create(user4);

        Assertions.assertEquals("Pedro",newUser.getFirstName());
    }

    @Test
    void testUpdateUser(){
        User user4 = new User("Pedro","Oliveira","SC","Male","pedro@email.com");
        User updatedUser = userService.update(user4,user1.getId());

        Assertions.assertEquals("Pedro", updatedUser.getFirstName());
    }

    @Test
    void testDeleteUser(){
        userService.delete(user1.getId());

        Assertions.assertEquals(2,userRepository.count());

    }

}
