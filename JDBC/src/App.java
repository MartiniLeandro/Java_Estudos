import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        Connection conexao = Conection.conectar();
        if (conexao != null) {
            System.out.println("Tudo certo! Já pode usar a conexão.");
        } else {
            System.out.println("Falha na conexão.");
        }
        Conection.closeConnection();
        
    }
}
