package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.SellerDao;
import db.DB;
import db.DbException;
import entities.Department;
import entities.Seller;

public class SellerDaoJDBC implements SellerDao{

    private Connection conn;

    public SellerDaoJDBC() {}

    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }
    
    @Override
    public void insert(Seller obj) {
        // TODO Auto-generated method stub
         
    }

    @Override
    public void update(Seller obj) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT seller.*,departament.name as DepName From seller inner join departament on seller.department_id = departament.id where seller.id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                Department dep = new Department();
                dep.setId(rs.getInt("department_id"));
                dep.setName(rs.getString("DepName"));
                Seller seller = new Seller();
                seller.setId(rs.getInt("id"));
                seller.setName(rs.getString("name"));
                seller.setEmail(rs.getString("email"));
                seller.setBaseSalary(rs.getDouble("base_salary"));
                seller.setBirthDate(rs.getDate("birth_date"));
                seller.setDepartment(dep);
                return seller;
            }
            return null;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Seller> findAll() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
