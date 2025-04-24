package application;

import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import dao.DepartamentDao;
import entities.Department;

public class Program2 {
    public static void main(String[] args) {
         DepartamentDao departmentDao = DaoFactory.createDepartmentDao();
         System.out.println();

         System.out.println("=== TEST 1: Department findById ===");
         Department department = departmentDao.findById(2);
         System.out.println(department);

         System.out.println("=== TEST 2: findAllDepartments ===");
         List<Department> allDepartments = new ArrayList<>();
         allDepartments = departmentDao.findAll();
         allDepartments.forEach(System.out::println);

         //System.out.println("=== TEST 3: insert department ===");
         //Department dep = new Department(7, "Clothes");
         //departmentDao.insert(dep);
         //System.out.println("Department inserido!");

         System.out.println("=== TEST 4: update department ===");
         Department dep = new Department(6, "Cars");
         departmentDao.update(dep);
         System.out.println("Department atualizado!");

         System.out.println("=== TEST 5: delete department ===");
         departmentDao.deleteById(7);
         System.out.println("Department deletado!");
         


    }
}
