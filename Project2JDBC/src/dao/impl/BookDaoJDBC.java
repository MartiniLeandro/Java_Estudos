package dao.impl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import db.DB;
import db.DBexception;
import entities.Book;

public class BookDaoJDBC implements BookDao{
    private Connection conn;

    public BookDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertBook(Book book) {
       PreparedStatement st = null;
       try{
        st = conn.prepareStatement("insert into book (Ttitle,Publish_date, Author_id) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
        st.setString(1, book.getTitle());
        st.setDate(2, new java.sql.Date(book.getPublishDate().getTime()));
        st.setInt(3, book.getAuthor());

        int rowsAffected = st.executeUpdate();
        if(rowsAffected == 0){
            throw new DBexception("Error to insert new book");
        }
       }catch(SQLException e){
        throw new DBexception(e.getMessage());
       }finally{
        DB.closeStatement(st);
       }
    }

    @Override
    public void updateBook(Book book) {

        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("update book set Ttitle = ?, Publish_date = ?, Author_id = ? where Id = ?");
            st.setString(1, book.getTitle());
            st.setDate(2, new java.sql.Date(book.getPublishDate().getTime()));
            st.setInt(3, book.getAuthor());
            st.setInt(4, book.getId());

            int rowsAffected = st.executeUpdate();
            if(rowsAffected == 0){
                throw new DBexception("Error to update book");
            }
           }catch(SQLException e){
            throw new DBexception(e.getMessage());
           }finally{
            DB.closeStatement(st);
           }
           {
        }
        
    }

    @Override
    public void deleteBook(Integer id) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("delete from book where id = ?");
            st.setInt(1, id);

            int rowsAffected = st.executeUpdate();
            if(rowsAffected == 0){
                throw new DBexception("Error to delete book");
            }
           }catch(SQLException e){
            throw new DBexception(e.getMessage());
           }finally{
            DB.closeStatement(st);
           }
           {
        }
    }

    @Override
    public Book searchBook(Integer id) {
       PreparedStatement st = null;
       ResultSet rs = null;
       try{
        st = conn.prepareStatement("select * from book where id = ?");
        st.setInt(1, id);
        rs = st.executeQuery();
        if(rs.next()){
            Book book = new Book();
                book.setId(rs.getInt("Id"));
                book.setTitle(rs.getString("Ttitle"));
                book.setPublishDate(rs.getDate("Publish_date"));
                book.setAuthor(rs.getInt("Author_id"));
                return book;
        }
        return null;
       }catch(SQLException e){
        throw new DBexception(e.getMessage());
       }finally{
        DB.closeResultSet(rs);
        DB.closeStatement(st);
       }
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> allBooks = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT * FROM book");
            rs = st.executeQuery();
            while(rs.next() != false){
                Book book = new Book();
                book.setId(rs.getInt("Id"));
                book.setTitle(rs.getString("Ttitle"));
                book.setPublishDate(rs.getDate("Publish_date"));
                book.setAuthor(rs.getInt("Author_id"));
                allBooks.add(book);
            }
            return allBooks;
        }catch(SQLException e){
            throw new DBexception(e.getMessage());
        }finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public Book findById(Integer id) {
       PreparedStatement st = null;
       ResultSet rs = null;
       try{
        st = conn.prepareStatement("SELECT * FROM book WHERE id = ?");
        st.setInt(1, id);
        rs = st.executeQuery();
        if(rs.next()){
            Book book = new Book(rs.getInt("Id"),rs.getString("Ttitle"), rs.getDate("Publish_date"), rs.getInt("Author_id"));
            return book;
        }
        return null;
       }catch(SQLException e){
        throw new DBexception(e.getMessage());
       }finally{
        DB.closeStatement(st);
        DB.closeResultSet(rs);
       }
       
    }
    
}
