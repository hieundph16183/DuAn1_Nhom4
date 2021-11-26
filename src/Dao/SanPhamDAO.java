/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

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
    
    public SanPham readFromResultSet(ResultSet rs) throws SQLException{
        SanPham model=new SanPham();
         model.setMaSanPham(rs.getString("MaSanPham"));
         model.setTenSanPham(rs.getString("TenSanPham"));
         model.setGiaSanPham(rs.getInt("GiaSanPham"));
         model.setHinh(rs.getString("Hinh"));
         model.setID_LoaiSP(rs.getString("ID_LoaiSP"));
         return model;
    }
    
    //thực hiện truy vấn lấy về 1 tập ResultSet rồi điền tập ResultSet đó vào 1 List
    public List<SanPham> select(String sql,Object...args){
        List<SanPham> list=new ArrayList<>();
        try {
            ResultSet rs=null;
            try{
                rs=jdbcHelper.executeQuery(sql, args);
                while(rs.next()){
                    list.add(readFromResultSet(rs));
                }
            }finally{
                rs.getStatement().getConnection().close();      //đóng kết nối từ resultSet
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return list;
    }
    
    /*
     * Thêm mới thực thể vào CSDL
     * @param model
     */
    public void insert(SanPham model) {
        String sql="INSERT INTO SanPham (MaSanPham,TenSanPham,GiaSanPham,Hinh,ID_LoaiSP VALUES(?,?,?,?,?)";
        jdbcHelper.executeUpdate(sql,
               model.getMaSanPham(),
               model.getTenSanPham(),
               model.getGiaSanPham(),
               model.getHinh(),
               model.getID_LoaiSP());
    }

    /**
     * Cập nhật thực thể vào CSDL
     * @param model
     */
    public void update(SanPham model) {
        String sql="UPDATE SanPham SET TenSanPham=?, GiaSanPham=?, Hinh=?, ID_LoaiSP=? WHERE MaSanPham=?";
        jdbcHelper.executeUpdate(sql,
               model.getTenSanPham(),
               model.getGiaSanPham(),
               model.getHinh(),
               model.getID_LoaiSP(),
               model.getMaSanPham());
    }

    /*
     * Xóa bản ghi khỏi CSDL
     * @param MaKH
     */
     public void delete(Integer MaSanPham){
     String sql="DELETE FROM SanPham WHERE MaSanPham=?";
     jdbcHelper.executeUpdate(sql, MaSanPham);
     }

    /*
     * Truy vấn tất cả các các thực thể
     * @return danh sách các thực thể
     */
    public List<SanPham> select() {
        String sql="SELECT * FROM SanPham";
        return select(sql);             //trong 1 class có thể có 2 method trùng tên (nhưng param khác nhau)
    }
    

     public SanPham findById(Integer makh){
     String sql="SELECT * FROM MaSanPham WHERE ID_LoaiSanPham=?";
     List<SanPham> list = select(sql, makh);
     return list.size() > 0 ? list.get(0) : null;
     }    
}
