package com.sistema_despesas.demo.repositories;

import com.sistema_despesas.demo.entities.User;
import com.sistema_despesas.demo.entities.utils.Roles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    private User user,admin,createdUser,createdAdmin;
    @BeforeEach
    void setup(){
        user = new User("user@email.com","user123", Roles.USER);
        admin = new User("admin@email.com","admin123", Roles.ADMIN);
        createdUser = userRepository.save(user);
        createdAdmin = userRepository.save(admin);

    }

    @DisplayName("test create User")
    @Test
    void createUser(){
        Assertions.assertNotNull(createdUser);
        Assertions.assertNotNull(createdAdmin);
        Assertions.assertEquals( "admin@email.com",createdAdmin.getEmail(), () -> "Os emails não são os mesmos");
        Assertions.assertEquals( "user@email.com",createdUser.getEmail(), () -> "Os emails não são os mesmos");

    }

    @DisplayName("test findAll Users")
    @Test
    void testFindAll(){
        List<User> allUsers = userRepository.findAll();

        Assertions.assertNotNull(allUsers);
        Assertions.assertEquals(2, allUsers.size());
    }

    @DisplayName("test findById User")
    @Test
    void testFindById(){
        User userId = userRepository.findById(user.getId()).get();
        User adminId = userRepository.findById(admin.getId()).get();

        Assertions.assertEquals("user@email.com", userId.getEmail());
        Assertions.assertEquals("admin@email.com", adminId.getEmail());
    }

    @DisplayName("test update user")
    @Test
    void testUpdateUser(){
        user.setEmail("user123@email.com");
        admin.setEmail("admin123@email.com");
        User updatedUser = userRepository.save(user);
        User updatedAdmin = userRepository.save(admin);

        Assertions.assertEquals("admin123@email.com", admin.getEmail());
        Assertions.assertEquals("user123@email.com", user.getEmail());

    }

    @DisplayName("test deleteById User")
    @Test
    void testDeleteById(){
        userRepository.deleteById(user.getId());
        userRepository.deleteById(admin.getId());

        List<User> allUsers = userRepository.findAll();

        Assertions.assertTrue(allUsers.isEmpty());
    }

    @DisplayName("test findByEmail user")
    @Test
    void testFindByEmail(){
        UserDetails userEmail = userRepository.findByEmail("user@email.com");
        UserDetails adminEmail = userRepository.findByEmail("admin@email.com");

        Assertions.assertEquals("user@email.com", userEmail.getUsername());
        Assertions.assertEquals("admin@email.com", adminEmail.getUsername());


    }

    @DisplayName("test existsByEmail user")
    @Test
    void testExistsByEmail(){
        Boolean userEmail = userRepository.existsByEmail(user.getEmail());
        Boolean adminEmail = userRepository.existsByEmail(admin.getEmail());

        Assertions.assertTrue(userEmail);
        Assertions.assertTrue(adminEmail);
    }

    @DisplayName("test findUserByEmail user")
    @Test
    void testFindUserByEmail(){
        User userByEmail = userRepository.findUserByEmail("user@email.com");
        User adminByEmail = userRepository.findUserByEmail("admin@email.com");

        Assertions.assertEquals(user, userByEmail);
        Assertions.assertEquals(admin, adminByEmail);
    }



}
