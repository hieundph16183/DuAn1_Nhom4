/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.LoaiSanPham;
import Model.NhanVien;
import helper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Hai
 */
public class LoaiSanPhamDAO {
    public LoaiSanPham readFromResultSet(ResultSet rs) throws SQLException{
        LoaiSanPham entity=new LoaiSanPham();
         entity.setID_LoaiSP(rs.getString("ID_LoaiSP"));
         entity.setTenLoaiSanPham(rs.getString("TenLoaiSanPham"));
         return entity;
    }
    
    //thực hiện truy vấn lấy về 1 tập ResultSet rồi điền tập ResultSet đó vào 1 List
    public List<LoaiSanPham> select(String sql,Object...args){
        List<LoaiSanPham> list=new ArrayList<>();
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
    public void insert(LoaiSanPham entity) {
        String sql="INSERT INTO LoaiSanPham (ID_LoaiSP,LoaiSanPham VALUES(?,?)";
        jdbcHelper.executeUpdate(sql,
               entity.getID_LoaiSP(),
               entity.getTenLoaiSanPham());
    }

    /*
     * Cập nhật thực thể vào CSDL
     * @param model
     */
    public void update(LoaiSanPham entity) {
        String sql="UPDATE LoaiSanPham SET TenLoaiSanPham WHERE ID_LoaiSP=?";
        jdbcHelper.executeUpdate(sql,
               entity.getTenLoaiSanPham(),
              entity.getID_LoaiSP());
    }

    /*
     * Xóa bản ghi khỏi CSDL
     * @param MaKH
     */
     public void delete(Integer ID_LoaiSP){
     String sql="DELETE FROM LoaiSanPham WHERE ID_LoaiSP=?";
     jdbcHelper.executeUpdate(sql, ID_LoaiSP);
     }

    /*
     * Truy vấn tất cả các các thực thể
     * @return danh sách các thực thể
     */
    public List<LoaiSanPham> select() {
        String sql="SELECT * FROM LoaiSanPham";
        return select(sql);             //trong 1 class có thể có 2 method trùng tên (nhưng param khác nhau)
    }

     public LoaiSanPham findById(Integer makh){
     String sql="SELECT * FROM LoaiSanPham WHERE ID_LoaiSanPham=?";
     List<LoaiSanPham> list = select(sql, makh);
     return list.size() > 0 ? list.get(0) : null;
     } 
     
     public void hienThi(JTable tbl, LoaiSanPham nv, int q) {
        nv.setID_LoaiSP(String.valueOf(tbl.getValueAt(q, 1)));
        nv.setTenLoaiSanPham(String.valueOf(tbl.getValueAt(q, 2)));
    }
}
