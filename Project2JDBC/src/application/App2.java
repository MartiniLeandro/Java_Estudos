package application;

import java.util.List;
import dao.AuthorDao;
import dao.DaoFactory;
import entities.Author;

public class App2 {
    public static void main(String[] args) {
        AuthorDao authorDao = DaoFactory.createAuthorDao();
        
        System.out.println("\n==== test 1: find AuthorById ====");
        Author author = authorDao.findById(4);
        System.out.println(author);

        System.out.println("\n==== test 2: find allAuthors ====");
        List<Author> allAuthors = authorDao.listAllAuthors();
        allAuthors.forEach(System.out::println);

        System.out.println("\n==== test 3: insert Author ====");
        Author addAuthor = new Author(null, "Hirowuki");
        authorDao.insertAuthor(addAuthor);
        System.out.println("Insered Author");

        System.out.println("\n==== test 4: update author ====");
        Author newAuthor = new Author(7, "Sawano");
        authorDao.updateAuthor(newAuthor);
        System.out.println("Updated author");

        System.out.println("\n==== test 5: delete author ====");
        authorDao.deleteById(8);
        System.out.println("Deleted author");
    }
}
