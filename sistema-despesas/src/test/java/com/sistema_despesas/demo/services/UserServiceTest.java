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

    @BeforeEach
    void setup(){
        user = new User("user@email.com", "user123", Roles.USER);
        Mockito.when(tokenService.validateToken(Mockito.anyString())).thenReturn(user.getEmail());
        Mockito.when(userRepository.findUserByEmail(Mockito.anyString())).thenReturn(user);

        Categorias categoriaReceita = new Categorias("salario", TipoCategoria.RECEITA);
        Categorias categoriaDespesa = new Categorias("faculdade", TipoCategoria.DESPESA);
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
        Mockito.when(launchRepository.save(Mockito.any())).thenReturn(newLaunch);
        user.getLaunches().add(newLaunch);
        Mockito.when(launchRepository.findAllByUserId(user.getId())).thenReturn(user.getLaunches());

        List<LaunchDTO> launches = userService.createLaunch(newLaunchDTO,"qualquerToken");

        Mockito.verify(launchRepository).save(Mockito.any(Launch.class));
        Assertions.assertEquals(3,launches.size());
    }
}
