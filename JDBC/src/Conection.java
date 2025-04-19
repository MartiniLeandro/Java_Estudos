import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class Conection {
    public static Connection conectar() {
        try {
            Dotenv dotenv = Dotenv.load();

            String url = dotenv.get("DB_URL"); 
            String usuario = dotenv.get("DB_USER");
            String senha = dotenv.get("DB_PASS");

            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
