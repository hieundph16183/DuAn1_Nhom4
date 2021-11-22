/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import helper.jdbcHelper;
import Model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hai
 */
public class NhanVienDAO {

    public NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNhanVien(rs.getString("MaNhanVien"));
        model.setTenNhanVien(rs.getString("TenNhanVien"));
        model.setSoDT(rs.getString("SoDienThoai"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setVaiTro(rs.getString("VaiTro"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setHinh(rs.getString("Hinh"));
        return model;
    }

    public List<NhanVien> select(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    list.add(readFromResultSet(rs));
                }
            } finally {
                rs.getStatement().getConnection().close();      //Ä‘Ã³ng káº¿t ná»‘i tá»« resultSet
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return list;
    }

    public void insert(NhanVien entity) {
        String sql = "INSERT INTO NhanVien (MaNV, MatKhau, TenNV, VaiTro) VALUES (?, ?, ?, ?)";
        jdbcHelper.executeUpdate(sql,
                entity.getMaNhanVien(),
                entity.getMatKhau(),
                entity.getTenNhanVien(),
                entity.getVaiTro());
    }

    public void update(NhanVien entity) {
        String sql = "UPDATE NhanVien SET MatKhau=?, TenNV=?, VaiTro=? WHERE MaNV=?";
        jdbcHelper.executeUpdate(sql,
                entity.getMaNhanVien(),
                entity.getMatKhau(),
                entity.getTenNhanVien(),
                entity.getVaiTro());
    }

    public void delete(String maNV) {
        String sql = "DELETE FROM NhanVien WHERE MaNV=?";
        jdbcHelper.executeUpdate(sql, maNV);
    }

    public List<NhanVien> select() {
        String sql = "SELECT * FROM NhanVien";
        return select(sql);
    }

    public NhanVien findById(String id) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV=?";
        List<NhanVien> list = select(sql, id);
        return list.size() > 0 ? list.get(0) : null;           
    }
}
