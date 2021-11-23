/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.HoaDon;
import helper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hai
 */
public class HoaDonDAO {
    private HoaDon readFromResultSet(ResultSet rs) throws SQLException{
	HoaDon hd =new HoaDon();
         hd.setMaHoaDon(rs.getString("MaHD"));
         hd.setThoiGianLap(rs.getDate("ThoiGianLap"));
         hd.setMaNhanVien(rs.getString("MaNV"));
         hd.setMaKhachHang(rs.getString("MaKH"));
         return hd;
    }
    private List<HoaDon> select(String sql, Object...args){
        List<HoaDon> list=new ArrayList<>();
        try {
            ResultSet rs=null;
            try{
                rs=jdbcHelper.executeQuery(sql, args);
                while(rs.next()){
                    list.add(readFromResultSet(rs));
                }
            }finally{
                rs.getStatement().getConnection().close();
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
    public void insert(HoaDon hd) {
        String sql="insert into HoaDon(MaHD,ThoiGianLap,MaNV,MaKH) VALUES (?, ?, ?, ?)";
         jdbcHelper.executeUpdate(sql,
           hd.getMaHoaDon(),
           hd.getThoiGianLap(),
           hd.getMaNhanVien(),
           hd.getMaKhachHang());
    }

    
    public void update(HoaDon hd) {
        String sql="UPDATE NguoiHoc SET MaHD=?, ThoiGianLap=?, MaNV=?, MaKH=?";
        jdbcHelper.executeUpdate(sql,            
                hd.getMaHoaDon(),
                hd.getThoiGianLap(),
                hd.getMaNhanVien(),
                hd.getMaKhachHang());
    }

    
    public void delete(String id) {
        String sql="DELETE FROM HoaDon WHERE MaHD=?";
        jdbcHelper.executeUpdate(sql, id);
    }

    public List<HoaDon> select() {
        String sql="SELECT * FROM HoaDon";
        return select(sql);
    }

    
     
     //truy xuất khách hàng theo manv
     public HoaDon findById(String manh){
     String sql="SELECT * FROM HoaDon WHERE MaNV=?";
     List<HoaDon> list = select(sql, manh);
     return list.size() > 0 ? list.get(0) : null;
     }
    
}
