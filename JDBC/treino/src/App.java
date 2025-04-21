import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        Connection conexao = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conexao = DB.connectDB();
            st = conexao.createStatement();
            rs = st.executeQuery("select * from users_test");
            while(rs.next()){
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name") + ", "  + rs.getString("Email") + ", " + rs.getInt("Age"));
        
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DB.closeConnectionDB();
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}
