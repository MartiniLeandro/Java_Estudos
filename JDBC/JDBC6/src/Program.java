import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try{
            conn = DB.conectar();
            st = conn.createStatement();

            conn.setAutoCommit(false);

            int row1 = st.executeUpdate("update seller set base_salary = 2090 where department_id = 1");

            //int x = 1;
            //if(x < 2){
            //    throw new SQLException("Fake Error");
            //}

            int row2 = st.executeUpdate("update seller set base_salary = 3090 where department_id = 2");

            conn.commit();

            System.out.println("rows1 = " + row1);
            System.out.println("rows2 = " + row2);

        }catch(SQLException e){
            try {
                conn.rollback();
                throw new DbException("Transation rolled back! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
               throw new DbException("Error trying to rollback! Caused by " + e1.getMessage());
            }
        }finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
