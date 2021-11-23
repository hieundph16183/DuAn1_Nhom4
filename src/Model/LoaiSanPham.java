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
public class LoaiSanPham {
   private String ID_LoaiSP;
   private String tenLoaiSanPham;

    public LoaiSanPham() {
    }

    public LoaiSanPham(String ID_LoaiSP, String tenLoaiSanPham) {
        this.ID_LoaiSP = ID_LoaiSP;
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    public String getID_LoaiSP() {
        return ID_LoaiSP;
    }

    public void setID_LoaiSP(String ID_LoaiSP) {
        this.ID_LoaiSP = ID_LoaiSP;
    }

    public String getTenLoaiSanPham() {
        return tenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String tenLoaiSanPham) {
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    
        
    
}
