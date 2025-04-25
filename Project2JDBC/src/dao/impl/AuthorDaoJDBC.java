package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.AuthorDao;
import db.DB;
import db.DBexception;
import entities.Author;

public class AuthorDaoJDBC implements AuthorDao{
    private Connection conn;

    public AuthorDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertAuthor(Author author) {
        PreparedStatement st = null;
       try{
        st = conn.prepareStatement("insert into author (Name) values (?)",Statement.RETURN_GENERATED_KEYS);
        st.setString(1, author.getName());
        
        int rowsAffected = st.executeUpdate();
        if(rowsAffected == 0){
            throw new DBexception("Error to insert new author");
        }
       }catch(SQLException e){
        throw new DBexception(e.getMessage());
       }finally{
        DB.closeStatement(st);
       }
    }

    @Override
    public void updateAuthor(Author author) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("update author set Name = ? where Id = ?");
            st.setString(1, author.getName());
            st.setInt(2, author.getId());

            int rowsAffected = st.executeUpdate();
            if(rowsAffected == 0){
                throw new DBexception("Error to update author");
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
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("delete from author where id = ?");
            st.setInt(1, id);

            int rowsAffected = st.executeUpdate();
            if(rowsAffected == 0){
                throw new DBexception("Error to delete author");
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
    public Author findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT * FROM author WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                Author author = new Author();
                author.setId(rs.getInt("Id"));
                author.setName(rs.getString("Name"));
                return author;
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
    public List<Author> listAllAuthors() {
        List<Author> allAuthors = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT * FROM author");
            rs = st.executeQuery();
            while(rs.next() != false){
                Author author = new Author();
                author.setId(rs.getInt("Id"));
                author.setName(rs.getString("Name"));
                allAuthors.add(author);
            }
            return allAuthors;
        }catch(SQLException e){
            throw new DBexception(e.getMessage());
        }
    }
    
}
