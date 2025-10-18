package com.mockito.demo.service;

import java.util.List;

public interface CourseService {
    public List<String> todosCursos(String student);
    public void deleteCourse(String course);
}
