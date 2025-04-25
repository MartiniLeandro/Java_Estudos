package dao;

import dao.impl.AuthorDaoJDBC;
import dao.impl.BookDaoJDBC;
import db.DB;

public class DaoFactory {
    public static BookDao createBookDao(){
        return new BookDaoJDBC(DB.connectDB());
    }

    public static AuthorDao createAuthorDao(){
        return new AuthorDaoJDBC(DB.connectDB());
    }
}
