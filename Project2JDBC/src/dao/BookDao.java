package dao;

import java.util.List;

import entities.Book;

public interface BookDao {
    void insertBook(Book book);
    void updateBook(Book book);
    void deleteBook(Integer id);
    Book searchBook(Integer id);
    Book findById(Integer id);
    List<Book> findAllBooks();
}