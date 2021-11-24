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
import java.util.List;

/**
 *
 * @author Hai
 */
public class TaiKhoanDAO {
    public TaiKhoan readFromResultSet(ResultSet rs) throws SQLException{
        TaiKhoan model=new TaiKhoan();
        model.setMaNV(rs.getString("MaNV"));
        model.setTenNhanVien(rs.getString("TenNV"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setVaiTro(rs.getBoolean("VaiTro"));   
        return model;
    }
    
    //thực hiện truy vấn lấy về 1 tập ResultSet rồi điền tập ResultSet đó vào 1 List
    public List<TaiKhoan> select(String sql,Object...args){
        List<TaiKhoan> list=new ArrayList<>();
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
     * @param entity là thực thể chứa thông tin bản ghi mới
     */
    public void insert(TaiKhoan entity) {
        String sql="INSERT INTO TaiKhoan (MaNV,TenNV, MatKhau, VaiTro) VALUES (?, ?, ?, ?)";
        jdbcHelper.executeUpdate(sql,
                entity.getMaNV(),
                entity.getTenNhanVien(),
                entity.getMatKhau(),
                entity.isVaiTro());
    }

    /*
     * Cập nhật thực thể vào CSDL
     * @param entity là thực thể chứa thông tin bản ghi cần cập nhật
     */
    
    
     public void update(TaiKhoan entity) {
        String sql="UPDATE NhanVien SET  TenNV=?, MatKhau=?, VaiTro=? WHERE MaNV=?";
        jdbcHelper.executeUpdate(sql,
                entity.getTenNhanVien(),
                entity.getMatKhau(),
                entity.isVaiTro(),
                entity.getMaNV());
    }
     
     public void updatepass(TaiKhoan tk){
         String sql ="update TaiKhoan set MatKhau = ? where MaNV=?";
         jdbcHelper.executeUpdate(sql, 
                 tk.getMatKhau(),
                 tk.getMaNV()
            );
     }

    /*
     * Xóa bản ghi khỏi CSDL
     * @param maNV là mã của bản ghi cần xóa
     */
    public void delete(String maNV) {
        String sql="DELETE FROM TaiKhoan WHERE MaNV=?";
        jdbcHelper.executeUpdate(sql, maNV);
    }

    /*
     * Truy vấn tất cả các các thực thể
     * @return danh sách các thực thể
     */
    public List<TaiKhoan> select() {
        String sql="SELECT * FROM TaiKhoan";
        return select(sql);             //trong 1 class có thể có 2 method trùng tên (nhưng param khác nhau)
    }

    /*
     * Truy vấn thực thể theo mã id
     * @param id là mã của bản ghi được truy vấn
     * @return thực thể chứa thông tin của bản ghi
     */
    public TaiKhoan findById(String id) {
        String sql="SELECT * FROM TaiKhoan WHERE MaNV=?";
        List<TaiKhoan> list=select(sql, id);
        return list.size()>0?list.get(0):null;               //có thể trả về là null
    }
}
