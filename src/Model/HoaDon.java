/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
/**
 *
 * @author Hai
 */
public class HoaDon {
    private String maHoaDon;
    private Date thoiGianLap;
    private String maNhanVien;
    private String maKhachHang;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, Date thoiGianLap, String maNhanVien, String maKhachHang) {
        this.maHoaDon = maHoaDon;
        this.thoiGianLap = thoiGianLap;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getThoiGianLap() {
        return thoiGianLap;
    }

    public void setThoiGianLap(Date thoiGianLap) {
        this.thoiGianLap = thoiGianLap;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    
    
            
}
