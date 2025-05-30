package dao;

import java.util.List;

import entities.Department;

public interface DepartamentDao {

    void insert(Department obj);
    void update(Department obj);
    void deleteById (Integer id);
    Department findById(Integer id);
    List<Department> findAll();
}

