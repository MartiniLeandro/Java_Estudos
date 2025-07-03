package com.mockito.demo;

import com.mockito.demo.service.CourseService;
import com.mockito.demo.service.stubs.CourseServiceStubs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class CourseBusinessTest {

    CourseService service;
    CourseBusiness courses;

    @BeforeEach
    void setup(){
        service = Mockito.mock(CourseService.class);
        courses = new CourseBusiness(service);
    }

    @Test
    void testFiltroCursosSpring(){

        List<String> allCourses = Arrays.asList(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
        );

        Mockito.when(service.todosCursos("Leandro"))
                .thenReturn(allCourses);

        List<String> cursosFiltrados = courses.cursosAlunoRelacionadosSpring("Leandro");

    }
}
