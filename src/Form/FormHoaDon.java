/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Dao.HoaDonDAO;
import Model.HoaDon;
import helper.dialogHelper;
import helper.shareHelper;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import helper.Auth;
import helper.dateHelper;
import Validate.Validate;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import javax.swing.JTextField;
/**
 *
 * @author Hai
 */
public class FormHoaDon extends javax.swing.JFrame {
    /**
     * Creates new form FormHoaDonBanHang
     */
    public FormHoaDon() {
        initComponents();
        setLocationRelativeTo(null);
        init();
    }
    void init(){
        load();
    }
    int index = 0;   //vị trí chuyenDe đang được chọn
    HoaDonDAO dao = new HoaDonDAO();
    //xóa bảng, đổ toàn bộ khoaHoc từ CSDL vào bảng
    void load() {
        DefaultTableModel model = (DefaultTableModel) tb_bang.getModel();
        model.setRowCount(0);
        try {
            List<HoaDon> list = dao.select();
            for (HoaDon hd : list) {
                Object[] row = {
                    hd.getSTT(),
                    hd.getMaHoaDon(),
                    hd.getSoLuong(),
                    hd.getMaKhachHang(),
                    hd.getThoiGianLap(),
                    hd.getMaNhanVien(),
                    hd.getTongTien(),
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    
    void insert() {
        HoaDon model = getModel();   //lấy thông tin trên form gán cho đt nguoiHoc
        try {
            dao.insert(model);    //thêm bản ghi mới vào CSDL theo tt từ nguoiHoc
            this.load();            //đổ thông tin mới vào bảng
            dialogHelper.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            dialogHelper.alert(this, "Thêm mới thất bại!");
        }
    }

    //lấy thông tin trên form
    //để chỉnh sửa nguoiHoc trong CSDL theo maNH
    void update() {
        HoaDon model = getModel(); //lấy thông tin form gán cho đt nguoiHoc
        try {
            dao.update(model);   //chỉnh sửa bản ghi theo tt từ nguoiHoc 
            this.load();         //đổ tt mới từ CSDL vào bảng
            dialogHelper.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            dialogHelper.alert(this, "Cập nhật thất bại!");
            e.printStackTrace();
        }
    }

    //xóa bản ghi khỏi CSDL theo maNH lấy trên form
    //xóa trằng form và chuyển sang insertable
    void delete() {
        if (dialogHelper.confirm(this, "Bạn thực sự muốn xóa người học này?")) {
            String manh = txt_maHD.getText();
            try {
                dao.delete(manh);
                this.load();
            
                dialogHelper.alert(this, "Xóa thành công!");
            } catch (HeadlessException e) {
                dialogHelper.alert(this, "Xóa thất bại!");
            }
        }
    }
    
    HoaDon getModel() {
        HoaDon model = new HoaDon();
        model.setMaHoaDon(txt_maHD.getText());
        model.setSoLuong(Integer.parseInt(txt_soLuong.getText()));
        model.setMaNhanVien(txt_maNV.getText());
        model.setThoiGianLap(dateHelper.now());     //ngày đăng kí luôn là ngày hôm nay dù có sửa trên form
        model.setMaKhachHang(txt_maKhachHang.getText());
        model.setMaNhanVien(Auth.user.getMaNV());
        return model;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_capnhat = new javax.swing.JButton();
        btn_lammoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_bang = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_maHD = new javax.swing.JTextField();
        txt_maKhachHang = new javax.swing.JTextField();
        txt_ngayLapHoaDon = new javax.swing.JTextField();
        txt_maNV = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        txt_soLuong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_tongTien = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/Create.png"))); // NOI18N
        jButton3.setText("Thêm");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HÓA ĐƠN MUA HÀNG");

        btn_them.setBackground(new java.awt.Color(0, 153, 153));
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/Create.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_xoa.setBackground(new java.awt.Color(0, 153, 153));
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/Delete.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_capnhat.setBackground(new java.awt.Color(0, 153, 153));
        btn_capnhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/Save.png"))); // NOI18N
        btn_capnhat.setText("Cập Nhật");
        btn_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatActionPerformed(evt);
            }
        });

        btn_lammoi.setBackground(new java.awt.Color(0, 153, 153));
        btn_lammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/Refresh.png"))); // NOI18N
        btn_lammoi.setText("Làm Mới");
        btn_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoiActionPerformed(evt);
            }
        });

        tb_bang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tb_bang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Hóa Đơn", "SoLuong", "MaKH", "ThoiGianLap", "MaNV", "TongTien"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_bang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_bangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_bang);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mã hóa đơn:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Ngày lập hóa đơn:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mã nhân viên:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Mã Khách hàng:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Tim Kiem Hoa Don");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Số Lượng:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Tổng Tiền");

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/Zoom.png"))); // NOI18N
        jButton5.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btn_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_lammoi)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jButton5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_maHD, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_maKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ngayLapHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_maHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_maKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ngayLapHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them)
                    .addComponent(btn_xoa)
                    .addComponent(btn_capnhat)
                    .addComponent(btn_lammoi))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        if (Auth.user.isVaiTro()) {
            delete();
        } else {
            dialogHelper.alert(this, "Chỉ quản lý mới được phép xóa");
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        if (Validate.checkNullText(txt_maHD)
                && Validate.checkNullText(txt_maKhachHang)
                && Validate.checkNullText(txt_maNV)) {
            
                if (checkTrungMa(txt_maHD)) {
                    insert();
                }
            
        }
    }//GEN-LAST:event_btn_themActionPerformed
    
    public boolean checkTrungMa(JTextField txt) {
        if (dao.findById(txt.getText()) == null) {
            return true;
        } else {
            txt.setBackground(pink);
            dialogHelper.alert(this,"Mã đã bị tồn tại.");
            return false;
        }
    }
    
    void setModel(HoaDon model) {
        txt_maHD.setText(model.getMaHoaDon());
        txt_soLuong.setText(String.valueOf(model.getSoLuong()));
        txt_maKhachHang.setText(model.getMaKhachHang());
        txt_ngayLapHoaDon.setText(String.valueOf(model.getThoiGianLap()));
        txt_maNV.setText(model.getMaNhanVien());
        txt_tongTien.setText(String.valueOf(model.getTongTien()));
    }
    
    void clear() {
        txt_maHD.setText("");
        txt_soLuong.setText("");
        txt_maNV.setText("");
        txt_ngayLapHoaDon.setText("");
          //ngày đăng kí luôn là ngày hôm nay dù có sửa trên form
        txt_maKhachHang.setText("");
      txt_tongTien.setText("");
    }
    
     void edit() {
        try {
            String macd = (String) tb_bang.getValueAt(this.index, 0);
            HoaDon model = dao.findById(macd);
            if (model != null) {
                this.setModel(model);
            }
        } catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    private void btn_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatActionPerformed
        // TODO add your handling code here:
            if(Validate.checkNullText(txt_soLuong)
                    &&Validate.checkNullText(txt_maKhachHang)
                    &&Validate.checkNullText(txt_soLuong)
                    &&Validate.checkNullText(txt_tongTien)
                    &&Validate.checkNullText(txt_ngayLapHoaDon)){
                update();
            }
    }//GEN-LAST:event_btn_capnhatActionPerformed

    private void tb_bangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bangMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tb_bangMouseClicked

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btn_lammoiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_capnhat;
    private javax.swing.JButton btn_lammoi;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_bang;
    private javax.swing.JTextField txt_maHD;
    private javax.swing.JTextField txt_maKhachHang;
    private javax.swing.JTextField txt_maNV;
    private javax.swing.JTextField txt_ngayLapHoaDon;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_timKiem;
    private javax.swing.JTextField txt_tongTien;
    // End of variables declaration//GEN-END:variables
}
