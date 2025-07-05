package com.projectWithTest.demo;

import com.projectWithTest.demo.entities.User;
import com.projectWithTest.demo.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @DisplayName("Save User to DataBase")
    @Test
    void testSaveUser(){
        User user = new User("Leandro", "Martini","SC","Male","leandro@email.com");
        User savedUser = userRepository.save(user);

        Assertions.assertNotNull(savedUser);
        Assertions.assertTrue(savedUser.getId() > 0);
    }

    @DisplayName("Test List All Users")
    @Test
    void testGetListUser(){
        User user = new User("Leandro", "Martini","SC","Male","leandro@email.com");
        User user2 = new User("Leonardo", "Martini","SC","Male","leandro@email.com");

        userRepository.save(user);
        userRepository.save(user2);

        List<User> allUsers = userRepository.findAll();

        Assertions.assertNotNull(allUsers);
        Assertions.assertEquals(2, allUsers.size(), () -> "Tamanho da lista não condiz com o esperado");
    }

    @DisplayName("Test Find User By Id")
    @Test
    void testGetUserId(){
        User user = new User("Leandro", "Martini","SC","Male","leandro@email.com");
        userRepository.save(user);

        User userId = userRepository.findById(user.getId()).get();

        Assertions.assertNotNull(userId);
        Assertions.assertEquals(user, userId);
    }

    @DisplayName("Test find User by Email")
    @Test
    void testGetUserById(){
        User user = new User("Leandro", "Martini","SC","Male","leandro@email.com");
        userRepository.save(user);
        User userEmail = userRepository.findByEmail(user.getEmail());

        Assertions.assertNotNull(userEmail);
        Assertions.assertEquals(userEmail, user);
    }

    @DisplayName("Test Update User")
    @Test
    void testUpdateUser(){
        User user = new User("Leandro", "Martini","SC","Male","leandro@email.com");
        userRepository.save(user);

        user.setEmail("leonardo@email.com");
        user.setFirstName("Leonardo");
        User updatedUser = userRepository.save(user);

        Assertions.assertNotNull(updatedUser);
        Assertions.assertEquals(updatedUser.getEmail(), user.getEmail());
    }

    @DisplayName("Test Delete User")
    @Test
    void testDeleteUser(){
        User user = new User("Leandro", "Martini","SC","Male","leandro@email.com");
        userRepository.save(user);
        userRepository.deleteById(user.getId());
        Optional<User> userDeleted = userRepository.findById(user.getId());

        Assertions.assertTrue(userDeleted.isEmpty());
    }

}
