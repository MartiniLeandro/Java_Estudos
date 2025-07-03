package com.mockito.demo;

import com.mockito.demo.service.CourseService;

import java.util.ArrayList;
import java.util.List;

public class CourseBusiness {

    private final CourseService courseService;

    public CourseBusiness(CourseService courseService) {
        this.courseService = courseService;
    }

    public List<String> cursosAlunoRelacionadosSpring(String aluno){

        List<String> filtroCursos = new ArrayList<String>();
        List<String> todosCursos = courseService.todosCursos(aluno);

        for (String curso : todosCursos){
            if(curso.contains("Spring")){
                filtroCursos.add(curso);
            }
        }

        return filtroCursos;
    }
}
