package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("insert into seller (id,name,email,birth_date,base_salary,department_id) values (?,?,?,?,?,?)");
            st.setInt(1, obj.getId());
            st.setString(2, obj.getName());
            st.setString(3, obj.getEmail());
            st.setDate(4, new java.sql.Date(obj.getBirthDate().getTime()));
            st.setDouble(5, obj.getBaseSalary());
            st.setInt(6, obj.getDepartment().getId());

            int rowsAffected = st.executeUpdate();
            if(rowsAffected == 0){
                throw new DbException("Unexpected error! No rows affected");
            }

        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(st);
        }
         
    }

    @Override
    public void update(Seller obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("update seller set name = ?, email = ?,birth_date = ?,base_salary = ?,department_id = ? where id = ?");
            st.setString(1, obj.getName());
            st.setString(2, obj.getEmail());
            st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
            st.setDouble(4, obj.getBaseSalary());
            st.setInt(5, obj.getDepartment().getId());
            st.setInt(6, obj.getId());
            st.executeUpdate();
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(st);
        }
        
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
                Department dep = instantiateDepartment(rs);
                Seller seller = instantiateSeller(rs,dep);
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
        List<Seller> allSellers = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT seller.*, departament.name AS DepName FROM seller INNER JOIN departament ON seller.department_id = departament.id;");
            rs = st.executeQuery();
            Map<Integer, Department> map = new HashMap<>();
            while(rs.next() != false){

                Department dep = map.get(rs.getInt("department_id"));
                if(dep == null){
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("department_id"), dep);
                }
                Seller seller = instantiateSeller(rs, dep);
                allSellers.add(seller);
                
            }
            return allSellers;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
    
    @Override
    public List<Seller> findByDepartment(Department dep) {
        List<Seller> sellersByDepartment = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT seller.*, departament.name AS DepName FROM seller INNER JOIN departament ON seller.department_id = departament.id WHERE seller.department_id = ? ORDER BY seller.name;");
            st.setInt(1, dep.getId());
            rs = st.executeQuery();
            while(rs.next() != false){
                Seller seller = instantiateSeller(rs, dep);
                sellersByDepartment.add(seller);
                
            }
            return sellersByDepartment;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    private Seller instantiateSeller(ResultSet rs,Department dep) throws SQLException {
        Seller seller = new Seller();
        seller.setId(rs.getInt("id"));
        seller.setName(rs.getString("name"));
        seller.setEmail(rs.getString("email"));
        seller.setBaseSalary(rs.getDouble("base_salary"));
        seller.setBirthDate(rs.getDate("birth_date"));
        seller.setDepartment(dep);
        return seller;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("department_id"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }

    
}
