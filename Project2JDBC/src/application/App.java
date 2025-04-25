package application;

//import java.util.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.BookDao;
import dao.DaoFactory;
import entities.Book;

public class App {
    public static void main(String[] args) throws Exception {
        BookDao bookDao = DaoFactory.createBookDao();
        
        System.out.println("\n==== test 1: find BookById ====");
        Book book = bookDao.findById(1);
        System.out.println(book);
        book = bookDao.findById(2);
        System.out.println(book);

        System.out.println("\n==== test 2: find AllBoks ====");
        List<Book> allBooks = new ArrayList<>();
        allBooks = bookDao.findAllBooks();
        allBooks.forEach(System.out::println);

        //System.out.println("\n==== test 3: Insert Book ====");
        //Book addBook = new Book(null, "Shingeki", new Date(), 2);
        //bookDao.insertBook(addBook);
        //System.out.println("insered book");

        System.out.println("\n==== test 3: update book ====");
        Book newBook = new Book(1, "Avatar", new Date(), 1);
        bookDao.updateBook(newBook);
        System.out.println("Updated book");

        //System.out.println("\n==== test 4: delete book ====");
        //bookDao.deleteBook(5);
        //System.out.println("Deleted book");

        System.out.println("\n==== test 5: search book ====");
        book = bookDao.searchBook(7);
        System.out.println(book);

    }
}
