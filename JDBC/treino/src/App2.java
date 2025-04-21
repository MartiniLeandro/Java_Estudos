import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App2{
    public static void main(String[] args) {
        Connection conexao = null;
        PreparedStatement st = null;
        try{
            conexao = DB.connectDB();
            st = conexao.prepareStatement("insert into users_test (Id, Name, Email, Age) values (?, ?, ?, ?)");
            st.setInt(1, 2);
            st.setString(2, "Gabriel");
            st.setString(3, "gabriel@gmail.com");
            st.setInt(4, 22);

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DB.closeConnectionDB();
            DB.closeStatement(st);
        }
    
    }

}
    

