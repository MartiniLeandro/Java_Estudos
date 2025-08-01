package com.sistema_despesas.demo.services;

import com.sistema_despesas.demo.entities.Categorias;
import com.sistema_despesas.demo.entities.DTOS.LaunchDTO;
import com.sistema_despesas.demo.entities.Launch;
import com.sistema_despesas.demo.entities.User;
import com.sistema_despesas.demo.entities.utils.Roles;
import com.sistema_despesas.demo.entities.utils.TipoCategoria;
import com.sistema_despesas.demo.repositories.CategoriasRepository;
import com.sistema_despesas.demo.repositories.LaunchRepository;
import com.sistema_despesas.demo.repositories.UserRepository;
import com.sistema_despesas.demo.security.TokenService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private TokenService tokenService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private LaunchRepository launchRepository;

    @Mock
    private CategoriasRepository categoriasRepository;

    private User user;
    private Launch launch1,launch2;
    private Categorias categoriaReceita,categoriaDespesa;

    @BeforeEach
    void setup(){
        user = new User(1L,"user@email.com", "user123", Roles.USER);
        Mockito.when(tokenService.validateToken(Mockito.anyString())).thenReturn(user.getEmail());
        Mockito.when(userRepository.findUserByEmail(Mockito.anyString())).thenReturn(user);

        categoriaReceita = new Categorias("salario", TipoCategoria.RECEITA);
        categoriaDespesa = new Categorias("faculdade", TipoCategoria.DESPESA);
        launch1 = new Launch("recebimento salario",categoriaReceita,1500.00,user, LocalDate.of(2025,7,1));
        launch2 = new Launch(" pagando faculdade",categoriaDespesa,500.00,user, LocalDate.of(2025,7,9));
        user.getLaunches().add(launch1);
        user.getLaunches().add(launch2);

    }

    @DisplayName("test getLaunches")
    @Test
    void testGetLaunch(){
        Mockito.when(launchRepository.findAllByUserId(user.getId())).thenReturn(user.getLaunches());

        List<LaunchDTO> launches = userService.getLaunch("qualquerToken");

        Assertions.assertNotNull(launches);
        Assertions.assertEquals(2, launches.size());
    }

    @DisplayName("test create launch")
    @Test
    void testCreateLaunch(){

        Categorias categorias = new Categorias("academia", TipoCategoria.DESPESA);
        Launch newLaunch = new Launch("pagando academia",categorias,200.0,user,LocalDate.of(2025,7,9));
        LaunchDTO newLaunchDTO = new LaunchDTO(newLaunch);

        Mockito.when(categoriasRepository.findByNome(Mockito.anyString())).thenReturn(categorias);
        Mockito.when(launchRepository.save(any())).thenReturn(newLaunch);
        Mockito.when(launchRepository.findAllByUserId(user.getId())).thenReturn(user.getLaunches());

        userService.createLaunch(newLaunchDTO,"qualquerToken");

        Mockito.verify(launchRepository).save(any(Launch.class));
    }

    @DisplayName("test update launch")
    @Test
    void testeUpdateLaunch(){

        LaunchDTO newLaunch = new LaunchDTO(1L,"launchTeste","salario",150.0,LocalDate.of(2025,5,14));

        Mockito.when(launchRepository.findById(1L)).thenReturn(Optional.ofNullable(launch1));
        Mockito.when(categoriasRepository.findByNome(any())).thenReturn(categoriaReceita);
        Mockito.when(launchRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));
        Mockito.when(launchRepository.findAllByUserId(any())).thenReturn(user.getLaunches());
        userService.updateLaunch(newLaunch,"qualquer-token",1L);

        Assertions.assertEquals(150.0, launch1.getValor());
        Assertions.assertEquals("salario", launch1.getCategoria().getNome());
        Mockito.verify(launchRepository).save(launch1);

    }

    @DisplayName("teste delete launch")
    @Test
    void testDeleteLaunch(){
        Mockito.when(launchRepository.findById(any())).thenReturn(Optional.ofNullable(launch1));

        List<LaunchDTO> allLaunches = userService.deleteLaunch("qualquerToken", 1L);
        Mockito.verify(launchRepository).delete(launch1);

    }
}
