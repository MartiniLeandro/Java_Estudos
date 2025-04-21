import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.github.cdimascio.dotenv.Dotenv;

public class DB {
    private static Connection connection = null;
    public static Connection connectDB(){
        try{
            Dotenv dotenv = Dotenv.load();

            String url = dotenv.get("DB_URL");
            String usuario = dotenv.get("DB_USER");
            String senha = dotenv.get("DB_PASS");

            connection = DriverManager.getConnection(url, usuario, senha);
            return connection;
        }catch(SQLException e){
            e.printStackTrace();
            return null;

        }
    }

    public static void closeConnectionDB(){
        if(connection != null){
            try{
                connection.close();
                connection = null;
                System.out.println("Conexão encerrada");
            }catch(SQLException e){
                System.out.println("Erro ao encerrar conexão");
                e.printStackTrace();
            }

        }
    }

    public static void closeStatement(Statement st){
        if(st != null){
            try {
                st.close();
                System.out.println("Statement fechado");
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
                System.out.println("ResultSet fechado");
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
    
    
}
