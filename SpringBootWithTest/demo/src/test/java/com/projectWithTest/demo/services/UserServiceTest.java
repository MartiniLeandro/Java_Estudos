package com.projectWithTest.demo.services;

import com.projectWithTest.demo.entities.User;
import com.projectWithTest.demo.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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

    @DisplayName("test save user SUCCESS")
    @Test
    void testSaveUserSuccess(){

        Mockito.when(userRepository.existsByEmail(user.getEmail())).thenReturn(false);
        Mockito.when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.create(user);
        Assertions.assertEquals(savedUser,user);
    }

    @DisplayName("test save user FAILED")
    @Test
    void testSaveUserFailed(){

        Mockito.when(userRepository.existsByEmail(user.getEmail())).thenReturn(true);

        Assertions.assertThrows(RuntimeException.class, () -> userService.create(user));
        Mockito.verify(userRepository, Mockito.never()).save(Mockito.any());
    }

    @DisplayName("test find all SUCCESS")
    @Test
    void testFindAllSuccess(){

        Mockito.when(userRepository.findAll()).thenReturn(List.of(user));
        List<User> allUsers = userService.findAll();

        Assertions.assertNotNull(allUsers);
        Assertions.assertEquals(1, allUsers.size());
    }

    @DisplayName("test find all FAILED")
    @Test
    void testFindAllFailed(){

        Mockito.when(userRepository.findAll()).thenReturn(Collections.emptyList());
        List<User> allUsers = userService.findAll();

        Assertions.assertTrue(allUsers.isEmpty());
        Assertions.assertEquals(0, allUsers.size());
    }

    @DisplayName("test find by id SUCCESS")
    @Test
    void testFindByIdSuccess(){

        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        User userFindId = userService.findById(1L);

        Assertions.assertNotNull(userFindId);
        Assertions.assertEquals(userFindId,user);
    }

    @DisplayName("test find by id FAILED")
    @Test
    void testFindByIdFailed(){

        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());



        RuntimeException exception = Assertions.assertThrows(RuntimeException.class,() -> userService.findById(1L));
        Assertions.assertEquals("Não existe user com este ID", exception.getMessage());
    }

    @DisplayName("test update User SUCCESS")
    @Test
    void testUpdateUserSuccess(){

        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        user.setFirstName("Leonardo");
        user.setEmail("leonardo@email.com");
        user.setLastName("Martini");
        Mockito.when(userRepository.save(user)).thenReturn(user);

        User updateUser = userService.update(user,1L);

        Assertions.assertNotNull(updateUser);
        Assertions.assertEquals("leonardo@email.com", updateUser.getEmail());
        Assertions.assertEquals(updateUser, user);
    }

    @DisplayName("test update User FAILED")
    @Test
    void testUpdateUserFailed(){

        Mockito.when(userRepository.findById(Mockito.any())).thenReturn(Optional.empty());

        RuntimeException exception =
                Assertions.assertThrows(RuntimeException.class, () -> userService.update(user, 1L));
                Assertions.assertEquals("Não existe user com este ID", exception.getMessage());
    }

    @DisplayName("test delete User SUCCESS")
    @Test
    void testDeleteUserSuccess(){

        userService.delete(1L);
        Mockito.verify(userRepository).deleteById(1L);
    }

    @DisplayName("test delete User FAILED")
    @Test
    void testDeleteUserFailed(){

        Mockito.doThrow(new RuntimeException("Erro ao deletar")).when(userRepository).deleteById(1L);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {userService.delete(1L);
        });

        Assertions.assertEquals("Erro ao deletar", exception.getMessage());
    }



}
