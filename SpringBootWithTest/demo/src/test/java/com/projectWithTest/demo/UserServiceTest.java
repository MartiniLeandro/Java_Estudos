package com.projectWithTest.demo;

import com.projectWithTest.demo.entities.User;
import com.projectWithTest.demo.repositories.UserRepository;
import com.projectWithTest.demo.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setup(){
        user = new User("Leandro", "Martini","SC","Male","leandro@email.com");
    }

    @DisplayName("test save user to db SUCCESS")
    @Test
    void testSaveUserSuccess(){

        Mockito.when(userRepository.existsByEmail(user.getEmail())).thenReturn(false);
        Mockito.when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.create(user);
        Assertions.assertEquals(savedUser,user);
    }

    @DisplayName("test save user to db FAILED")
    @Test
    void testSaveUserFailed(){

        Mockito.when(userRepository.existsByEmail(user.getEmail())).thenReturn(true);

        Assertions.assertThrows(RuntimeException.class, () -> userService.create(user));
        Mockito.verify(userRepository, Mockito.never()).save(Mockito.any());
    }

    @DisplayName("test find all to db SUCCESS")
    @Test
    void testFindAllSuccess(){

        Mockito.when(userRepository.findAll()).thenReturn(List.of(user));
        List<User> allUsers = userService.findAll();

        Assertions.assertNotNull(allUsers);
        Assertions.assertEquals(1, allUsers.size());
    }

    @DisplayName("test find all to db FAILED")
    @Test
    void testFindAllFailed(){

        Mockito.when(userRepository.findAll()).thenReturn(Collections.emptyList());
        List<User> allUsers = userService.findAll();

        Assertions.assertTrue(allUsers.isEmpty());
        Assertions.assertEquals(0, allUsers.size());
    }

    @DisplayName("test find by id to db")
    @Test
    void testFindById(){

        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        User userFindId = userService.findById(1L);

        Assertions.assertNotNull(userFindId);
        Assertions.assertEquals(userFindId,user);
    }



}
