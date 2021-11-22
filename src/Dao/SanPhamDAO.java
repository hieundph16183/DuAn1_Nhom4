/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.NhanVien;
import Model.SanPham;
import helper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author 
 */
public class SanPhamDAO {
    public SanPham readFromResultSet(ResultSet rs) throws SQLException {
        SanPham SP = new SanPham();
        SP.setMaLoaiSanPham(rs.getString("MaLoaSanPham"));
        SP.setMaSanPham(rs.getString("MaSanPham"));
        SP.setTenSanPham(rs.getString("TenSanPham"));
        SP.setGiaSanPham(Integer.parseInt(rs.getString("GiaSanPham")));
        SP.setHinhSanPham(rs.getString("HinhSanPham"));
        return SP;
    }
    
    public List<SanPham> Select(String sql, Object...args){
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs=jdbcHelper.executeQuery(sql, args);
                while(rs.next()){
                    list.add(readFromResultSet(rs));
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return list;
    }
    
    public void insert(SanPham entity){
        String sql="insert into SanPham values(?,?,?,?,?)";
        jdbcHelper.executeUpdate(sql,
                entity.getMaSanPham(),
                entity.getMaLoaiSanPham(),
                entity.getTenSanPham(),
                entity.getHinhSanPham(),
                entity.getGiaSanPham());
    }
    
    public void update(SanPham entity){
        String sql = "Update SanPham SET TenSanPham = ?, Hinh = ?, GiaSanPham = ? WHERE MaSanPham = ?";
        jdbcHelper.executeUpdate(sql,
                entity.getTenSanPham(),
                entity.getHinhSanPham(),
                entity.getGiaSanPham(),
                entity.getMaSanPham());
    }
    
    public void delete(String id){
        String sql = "Delete  from SanPham where MaSanPham = ?";
        jdbcHelper.executeUpdate(sql, id);
    }
    
    public List<SanPham> select(){
        String sql = "Select * From SanPham";
        return select();
    }
    
}
