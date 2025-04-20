import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = DB.conectar();
            st = conn.prepareStatement("INSERT INTO seller (id, name, email, birth_date, base_salary, department_id) values (?, ?, ?, ?, ?, ?)");
            st.setInt(1, 7);
            st.setString(2, "Carl Purple");
            st.setString(3, "carl@gmail.com");
            st.setDate(4, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(5, 3000.00);
            st.setInt(6, 4);

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! Rows Affected: " + rowsAffected);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ParseException e){
            e.printStackTrace();
        }finally {
            DB.closePreparedStatement(st);
            DB.closeConnection();
        }
    }
}
