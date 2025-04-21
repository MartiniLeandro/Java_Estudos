import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = DB.conectar();
            st = conn.prepareStatement("DELETE FROM departament where Id = ?");
            st.setInt(1, 2);
            

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! rows affected: " + rowsAffected);
        }catch(SQLException e){
            throw new DbIntegrityException(e.getMessage());
        }finally{
            DB.closeConnection();
            DB.closePreparedStatement(st);
        }

    }
}
