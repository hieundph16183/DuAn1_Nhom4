/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.TaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import helper.jdbcHelper;

/**
 *
 * @author Hai
 */
public class TaiKhoanDAO {
     String INSERT = "INSERT INTO TaiKhoan (TenTaiKhoan,MatKhau,VaiTro,MaNV) VALUES (?,?,?,?)";
    String UPDATE = "UPDATE TaiKhoan SET MatKhau=?,VaiTro=?,MaNV=? WHERE TenTaiKhoan=?";
    String SELECT_BY_ID = "SELECT*FROM TaiKhoan WHERE TenTaiKhoan=?";
    
    public void insert(TaiKhoan tk) {
        helper.jdbcHelper.executeUpdate(INSERT, tk.getTenTaiKhoan(), tk.getMatKhau(), tk.getVaiTro(), tk.getMaNV());

    }

    public void update(TaiKhoan tk) {
        helper.jdbcHelper.executeUpdate(UPDATE, tk.getMatKhau(), tk.getVaiTro(),tk.getMaNV(), tk.getTenTaiKhoan());
    }

    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void doiMK(TaiKhoan nv) {
        String UPDATE = "UPDATE Tai_Khoan SET MatKhau =? WHERE TenTaiKhoan=?";
        try {
           jdbcHelper.executeUpdate(UPDATE, nv.getMatKhau(), nv.getTenTaiKhoan());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

    public ArrayList<TaiKhoan> selectALL() {
        String SELECT = "SELECT * FROM TaiKhoan";
        return this.selectBySql(SELECT);
    }

    public ArrayList<TaiKhoan> selectFrom(String sql, Object... args) {
        ArrayList<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    list.add(readFromResultSet(rs));
                }
            } finally {
                rs.getStatement().getConnection().close();      //đóng kết nối từ resultSet
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return list;
    }

    public TaiKhoan selectById(String key) {
        ArrayList<TaiKhoan> list = selectBySql(SELECT_BY_ID, key);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    protected ArrayList<TaiKhoan> selectBySql(String sql, Object... args) {

        ArrayList<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tk.setMaNV(rs.getString("MaNV"));
                list.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    private TaiKhoan readFromResultSet(ResultSet rs) throws SQLException {
        TaiKhoan model = new TaiKhoan();
        model.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setVaiTro(rs.getString("VaiTro"));
         model.setMaNV(rs.getString("MaNV"));
        return model;
    }
}
