package com.relembrando_springboot.demo.services;

import com.relembrando_springboot.demo.entities.User;
import com.relembrando_springboot.demo.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User u1,u2;

    @BeforeEach
    void setup(){
        u1 = new User(1L,"teste1","teste1@email.com","026.343.330-72","senha1");
        u2 = new User(2L,"teste2","teste2@email.com","314.362.870-73","senha2");
    }

    @Test
    void testFindAllUsers(){
        when(userRepository.findAll()).thenReturn(List.of(u1,u2));
        List<User> allUsers = userService.allUsers();

        Assertions.assertEquals(2,allUsers.size());
        Assertions.assertEquals("teste1@email.com",allUsers.getFirst().getEmail());
        Assertions.assertEquals("teste2@email.com",allUsers.getLast().getEmail());
    }

    @Test
    void testFindById(){
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(u1));
        User user = userService.userById(1L);

        Assertions.assertNotNull(user);
        Assertions.assertEquals("teste1@email.com", user.getEmail());
    }

    @Test
    void testCreateUser(){
        when(userRepository.save(u2)).thenReturn(u2);
        User user = userService.createUser(u2);

        Assertions.assertNotNull(user);
        Assertions.assertEquals("teste2@email.com",user.getEmail());
    }

    @Test
    void testUpdateUser(){
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(u1));
        when(userRepository.save(u1)).thenReturn(u1);
        User user = userService.updateUser(u2,1L);

        Assertions.assertNotNull(user);
        Assertions.assertEquals("teste2@email.com",user.getEmail());
    }

    @Test
    void testDeleteUser(){
        userService.deleteUser(1L);

        verify(userRepository).deleteById(1L);
    }
}
