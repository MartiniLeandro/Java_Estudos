package com.martiniLeandro.dockerTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    @RequestMapping("/getStudents")
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

}
