/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Hai
 */
public class KhachHang {
    private String maKhachHang;
    private String tenKhachHang;
    private String DiaChi;
    private String soDT;

    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String tenKhachHang, String DiaChi, String soDT) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.DiaChi = DiaChi;
        this.soDT = soDT;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
    
    
}
