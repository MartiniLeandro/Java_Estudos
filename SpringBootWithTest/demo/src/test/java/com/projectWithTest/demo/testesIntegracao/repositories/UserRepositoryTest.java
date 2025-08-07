package com.projectWithTest.demo.testesIntegracao.repositories;

import com.projectWithTest.demo.config.AbstractIntegrationTest;
import com.projectWithTest.demo.entities.User;
import com.projectWithTest.demo.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("testeUnitario")
public class UserRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    User user,user2,savedUser;

    @BeforeEach
    void setup(){
        user = new User("Leandro", "Martini","SC","Male","leandro@email.com");
        user2 = new User("Leonardo", "Martini","SC","Male","leonardo@email.com");
        savedUser = userRepository.save(user);
        userRepository.save(user2);
    }

    @DisplayName("Save User to DataBase")
    @Test
    void testSaveUser(){
        Assertions.assertNotNull(savedUser);
        Assertions.assertTrue(savedUser.getId() > 0);
    }

    @DisplayName("Test List All Users")
    @Test
    void testGetListUser(){
        List<User> allUsers = userRepository.findAll();

        Assertions.assertNotNull(allUsers);
        Assertions.assertEquals(2, allUsers.size(), () -> "Tamanho da lista não condiz com o esperado");
    }

    @DisplayName("Test Find User By Id")
    @Test
    void testGetUserId(){
        User userId = userRepository.findById(user.getId()).get();

        Assertions.assertNotNull(userId);
        Assertions.assertEquals(user, userId);
    }

    @DisplayName("Test find User by Email")
    @Test
    void testGetUserByEmail(){
        User userEmail = userRepository.findByEmail(user.getEmail());

        Assertions.assertNotNull(userEmail);
        Assertions.assertEquals(userEmail, user);
    }

    @DisplayName("Test Update User")
    @Test
    void testUpdateUser(){
        user.setEmail("leonardo@email.com");
        user.setFirstName("Leonardo");
        User updatedUser = userRepository.save(user);

        Assertions.assertNotNull(updatedUser);
        Assertions.assertEquals(updatedUser.getEmail(), user.getEmail());
    }

    @DisplayName("Test Delete User")
    @Test
    void testDeleteUser(){
        userRepository.deleteById(user.getId());
        Optional<User> userDeleted = userRepository.findById(user.getId());

        Assertions.assertTrue(userDeleted.isEmpty());
    }

    @DisplayName("Test find User By JPQL")
    @Test
    void testFindUserByJPQL(){
        User userJPQL = userRepository.findByJPQL("Leandro", "Martini");
        Assertions.assertNotNull(userJPQL);
        Assertions.assertEquals("Leandro",userJPQL.getFirstName());
        Assertions.assertEquals("Martini",userJPQL.getLastName());
    }

    @DisplayName("Test find User By JPQL NamedParams")
    @Test
    void testFindUserByJPQLNamedParams(){
        User userJPQLNamedParams = userRepository.findByJPQLNamedParams("Leandro", "Martini");
        Assertions.assertNotNull(userJPQLNamedParams);
        Assertions.assertEquals("Leandro",userJPQLNamedParams.getFirstName());
        Assertions.assertEquals("Martini",userJPQLNamedParams.getLastName());
    }

    @DisplayName("Test find User By SQL")
    @Test
    void testFindUserBySQL(){
        User userSQL = userRepository.findBySQL("Leandro", "Martini");
        Assertions.assertNotNull(userSQL);
        Assertions.assertEquals("Leandro",userSQL.getFirstName());
        Assertions.assertEquals("Martini",userSQL.getLastName());
    }

    @DisplayName("Test find User By SQLNamedParams")
    @Test
    void testFindUserBySQLNamedParams(){
        User userSQLNamedParams = userRepository.findBySQLNamedParams("Leandro", "Martini");
        Assertions.assertNotNull(userSQLNamedParams);
        Assertions.assertEquals("Leandro",userSQLNamedParams.getFirstName());
        Assertions.assertEquals("Martini",userSQLNamedParams.getLastName());
    }

}
