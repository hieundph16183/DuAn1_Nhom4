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
    private int STT;
    private String maHoaDon;
    private int soLuong;
    private String maKhachHang;
    private Date thoiGianLap;
    private String maNhanVien;
    private float tongTien;

    public HoaDon() {
    }

    public HoaDon(int STT, String maHoaDon, int soLuong, String maKhachHang, Date thoiGianLap, String maNhanVien, float tongTien) {
        this.STT = STT;
        this.maHoaDon = maHoaDon;
        this.soLuong = soLuong;
        this.maKhachHang = maKhachHang;
        this.thoiGianLap = thoiGianLap;
        this.maNhanVien = maNhanVien;
        this.tongTien = tongTien;
    }

    
    
    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

 

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
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

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

   

    
    
    
            
}
