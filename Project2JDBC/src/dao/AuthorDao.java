package dao;

import java.util.List;

import entities.Author;

public interface AuthorDao {
    void insertAuthor(Author author);
    void updateAuthor(Author author);
    void deleteById(Integer id);
    Author findById(Integer id);
    List<Author> listAllAuthors();
}
