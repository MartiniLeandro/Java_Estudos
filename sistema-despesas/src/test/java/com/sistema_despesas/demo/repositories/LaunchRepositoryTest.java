package com.sistema_despesas.demo.repositories;

import com.sistema_despesas.demo.entities.Categorias;
import com.sistema_despesas.demo.entities.Launch;
import com.sistema_despesas.demo.entities.User;
import com.sistema_despesas.demo.entities.utils.Roles;
import com.sistema_despesas.demo.entities.utils.TipoCategoria;
import org.hibernate.sql.Update;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
public class LaunchRepositoryTest {

    @Autowired
    LaunchRepository launchRepository;

    @Autowired
    CategoriasRepository categoriasRepository;

    @Autowired
    UserRepository userRepository;

    Categorias categoriaReceita;
    User user;
    private Launch launch,createdLaunch;
    @BeforeEach
    void setup(){
        user = new User("user@email.com","user123", Roles.USER);
        categoriaReceita = new Categorias("salary", TipoCategoria.RECEITA);
        userRepository.save(user);
        categoriasRepository.save(categoriaReceita);
        launch = new Launch("description",categoriaReceita,1450.0,user, LocalDate.of(2025,3,12));
        createdLaunch = launchRepository.save(launch);
    }

    @DisplayName("test create launch")
    @Test
    void testCreateLaunch(){
        Assertions.assertNotNull(createdLaunch);
        Assertions.assertEquals( "description",launch.getDescription(), () -> "As descrições não são as mesmas");
    }

    @DisplayName("test findAll launch")
    @Test
    void testFindAll(){
        Launch launch2 = new Launch("description2",categoriaReceita,2050.0,user, LocalDate.of(2025,7,8));
        launchRepository.save(launch2);
        List<Launch> allLaunches = launchRepository.findAll();
        Assertions.assertNotNull(allLaunches);
        Assertions.assertEquals(2, allLaunches.size());
    }

    @DisplayName("test findById Launch")
    @Test
    void testFindById(){
        Launch launchId = launchRepository.findById(launch.getId()).get();

        Assertions.assertEquals(categoriaReceita, launch.getCategoria());
    }

    @DisplayName("test update launch")
    @Test
    void testUpdate(){
        User user2 = new User("user2@email.com","user123", Roles.USER);
        Categorias categoriaDespesa = new Categorias("school", TipoCategoria.DESPESA);
        launch.setDescription("description2");
        launch.setCategoria(categoriaDespesa);
        launch.setUser(user2);
        launch.setValor(50.0);
        launch.setDataHora(LocalDate.of(2025,7,8));
        Launch updatedLaunch = launchRepository.save(launch);

        Assertions.assertNotNull(updatedLaunch);
        Assertions.assertEquals("user2@email.com",updatedLaunch.getUser().getEmail());
    }

    @DisplayName("test delete launch")
    @Test
    void testDelete(){
        launchRepository.deleteById(launch.getId());
        List<Launch> allLaunches = launchRepository.findAll();

        Assertions.assertTrue(allLaunches.isEmpty());
    }

    @DisplayName("test findAllByUserId")
    @Test
    void testFindAllByUserId(){
        List<Launch> allLaunches = launchRepository.findAllByUserId(user.getId());

        Assertions.assertNotNull(allLaunches);
    }

    @DisplayName("test findByUserAndDataBetween")
    @Test
    void testFindByUserAndDataBetween(){
        List<Launch> allLaunches = launchRepository.findByUserAndDataBetween(user,LocalDate.of(2025,1,1),LocalDate.of(2025,3,30));

        Assertions.assertNotNull(allLaunches);

    }

}
