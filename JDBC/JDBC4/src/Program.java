import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = DB.conectar();
            st = conn.prepareStatement("update seller set base_salary = base_salary + ? where (department_id = ?)");
            st.setDouble(1, 200);
            st.setInt(2, 2);

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! rows affected: " + rowsAffected);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DB.closeConnection();
            DB.closePreparedStatement(st);
        }

    }
}
