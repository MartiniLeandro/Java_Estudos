package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class DB {
    private static Connection conn = null;

    public static Connection connectDB(){
        try{
            Dotenv dotenv = Dotenv.load();
            String url = dotenv.get("DB_URL");
            String user = dotenv.get("DB_USER");
            String senha = dotenv.get("DB_PASS");

            conn = DriverManager.getConnection(url, user, senha);
            System.out.println("DB conectado com sucesso");
            return conn;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void CloseConnection(){
        try{
            if(conn != null){
                conn.close();
                conn = null;
                System.out.println("Conexão encerrada");

            }
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao fechar conexão!");
        }
    }

    public static void closeStatement(Statement st){
        try{
            if(st != null){
                st.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }

        }
    }

    
}
