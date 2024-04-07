/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import bus.SanPham_BUS;
import connectDB.ConnectDB;
import entities.SanPham;
import entities.TacGia;
import java.awt.Color;
import java.awt.Image;
import java.awt.MediaTracker;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import utilities.CurrentSession;

/**
 *
 * @author ASUS
 */
public class TAB_ChiTietSanPham_Sach extends javax.swing.JPanel {
    SanPham x = new SanPham();
    /**
     * Creates new form ChiTietSanPham
     */
    public TAB_ChiTietSanPham_Sach() {
        initComponents();
    }
    
    public TAB_ChiTietSanPham_Sach(SanPham x) {
        this.x = x;
        initComponents();
        SanPham_BUS sanPham_BUS = new SanPham_BUS();
        
   
        if (CurrentSession.checkQuyenTruyCap() != CurrentSession.EnumQuyenHan.NHAN_VIEN_QUAN_LY){
            jButton_NgungBan.setEnabled(false);
            jButton_Sua.setEnabled(false);
        }
   

        this.jLabel_TenSanPham.setText(x.getTenSanPham());
        this.jLabel_TacGia.setText(sanPham_BUS.getNameTacGiaByID(x.getTacGia().getTacGiaID()));
        this.jLabel_DanhMuc.setText(sanPham_BUS.getNameDanhMucByID(x.getDanhMuc().getDanhMucID()));
        this.jLabel_NhaXuatBan.setText(sanPham_BUS.getNameNhaXuatBanByID(x.getNhaXuatBan().getNhaXuatBanID()));
        this.jLabel_SoLuong.setText(x.getSoLuongTon() + "");
        if(x.getSoLuongTon() <= 10)
        {
            this.jLabel_SoLuong.setForeground(Color.red);
        }
        
        if(x.getTinhTrang().equals("NGUNG_KINH_DOANH"))
        {
           jButton_NgungBan.setBackground(new Color(204,204,204));
           jButton_NgungBan.setText("Bán lại");
        }
        
       

        ImageIcon imageIcon = new ImageIcon("src/" + x.getImgPath()); // load the image to a imageIcon
        if (imageIcon.getImageLoadStatus() != MediaTracker.COMPLETE && imageIcon.getImageLoadStatus() != MediaTracker.LOADING){
            jLabel_Img.setText("No image");
            return;
        }
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(150, 210,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg); 
        this.jLabel_Img.setIcon(imageIcon);
        

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler16 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jPanel_Component_SanPham = new javax.swing.JPanel();
        jPanel_Box_Left = new javax.swing.JPanel();
        jLabel_Img = new javax.swing.JLabel();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(0, 0));
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(5, 10), new java.awt.Dimension(0, 0));
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(5, 7), new java.awt.Dimension(0, 0));
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(10, 5), new java.awt.Dimension(0, 0));
        jPanel_Info_SanPham1 = new javax.swing.JPanel();
        jPanel159 = new javax.swing.JPanel();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jPanel_TenSanPham1 = new javax.swing.JPanel();
        jLabel_TenSanPham = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jPanel160 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        jLabel_TacGia = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jPanel161 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jLabel_NhaXuatBan = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jPanel162 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jLabel_DanhMuc = new javax.swing.JLabel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jPanel163 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jLabel_SoLuong = new javax.swing.JLabel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jPanel164 = new javax.swing.JPanel();
        jButton_Sua = new javax.swing.JButton();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 30), new java.awt.Dimension(10, 10));
        jButton_NgungBan = new javax.swing.JButton();
        filler18 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(2, 2), new java.awt.Dimension(10, 10));
        filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(0, 0));

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(412, 235));
        setMinimumSize(new java.awt.Dimension(410, 235));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(410, 235));
        setLayout(new java.awt.BorderLayout());
        add(filler16, java.awt.BorderLayout.PAGE_START);

        jPanel_Component_SanPham.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel_Component_SanPham.setMaximumSize(new java.awt.Dimension(405, 250));
        jPanel_Component_SanPham.setMinimumSize(new java.awt.Dimension(405, 250));
        jPanel_Component_SanPham.setPreferredSize(new java.awt.Dimension(405, 250));
        jPanel_Component_SanPham.setLayout(new javax.swing.BoxLayout(jPanel_Component_SanPham, javax.swing.BoxLayout.LINE_AXIS));

        jPanel_Box_Left.setMaximumSize(new java.awt.Dimension(175, 225));
        jPanel_Box_Left.setMinimumSize(new java.awt.Dimension(175, 225));
        jPanel_Box_Left.setPreferredSize(new java.awt.Dimension(175, 225));
        jPanel_Box_Left.setLayout(new java.awt.BorderLayout());

        jLabel_Img.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_Img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Img.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel_Img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_Img.setPreferredSize(new java.awt.Dimension(150, 305));
        jPanel_Box_Left.add(jLabel_Img, java.awt.BorderLayout.CENTER);
        jPanel_Box_Left.add(filler11, java.awt.BorderLayout.LINE_END);
        jPanel_Box_Left.add(filler12, java.awt.BorderLayout.PAGE_START);
        jPanel_Box_Left.add(filler13, java.awt.BorderLayout.PAGE_END);
        jPanel_Box_Left.add(filler14, java.awt.BorderLayout.LINE_START);

        jPanel_Component_SanPham.add(jPanel_Box_Left);

        jPanel_Info_SanPham1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel_Info_SanPham1.setMaximumSize(new java.awt.Dimension(230, 214));
        jPanel_Info_SanPham1.setMinimumSize(new java.awt.Dimension(230, 214));
        jPanel_Info_SanPham1.setPreferredSize(new java.awt.Dimension(230, 210));
        jPanel_Info_SanPham1.setLayout(new javax.swing.BoxLayout(jPanel_Info_SanPham1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel159.setMaximumSize(new java.awt.Dimension(230, 205));
        jPanel159.setMinimumSize(new java.awt.Dimension(230, 205));
        jPanel159.setPreferredSize(new java.awt.Dimension(230, 205));
        jPanel159.setLayout(new javax.swing.BoxLayout(jPanel159, javax.swing.BoxLayout.Y_AXIS));
        jPanel159.add(filler10);

        jPanel_TenSanPham1.setAlignmentX(0.0F);
        jPanel_TenSanPham1.setLayout(new javax.swing.BoxLayout(jPanel_TenSanPham1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel_TenSanPham.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel_TenSanPham.setText("Field_TenSanPham");
        jLabel_TenSanPham.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_TenSanPham.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jLabel_TenSanPham.setMaximumSize(new java.awt.Dimension(215, 21));
        jLabel_TenSanPham.setMinimumSize(new java.awt.Dimension(215, 21));
        jLabel_TenSanPham.setPreferredSize(new java.awt.Dimension(215, 21));
        jPanel_TenSanPham1.add(jLabel_TenSanPham);

        jPanel159.add(jPanel_TenSanPham1);
        jPanel159.add(filler1);

        jPanel160.setAlignmentX(0.0F);
        jPanel160.setLayout(new javax.swing.BoxLayout(jPanel160, javax.swing.BoxLayout.LINE_AXIS));

        jLabel124.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel124.setText("Tác giả: ");
        jPanel160.add(jLabel124);

        jLabel_TacGia.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_TacGia.setText("Field_TacGia");
        jPanel160.add(jLabel_TacGia);

        jPanel159.add(jPanel160);
        jPanel159.add(filler2);

        jPanel161.setAlignmentX(0.0F);
        jPanel161.setLayout(new javax.swing.BoxLayout(jPanel161, javax.swing.BoxLayout.LINE_AXIS));

        jLabel126.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel126.setText("Nhà xuất bản: ");
        jPanel161.add(jLabel126);

        jLabel_NhaXuatBan.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_NhaXuatBan.setText("Field_NhaXuatBan");
        jPanel161.add(jLabel_NhaXuatBan);

        jPanel159.add(jPanel161);
        jPanel159.add(filler3);

        jPanel162.setAlignmentX(0.0F);
        jPanel162.setLayout(new javax.swing.BoxLayout(jPanel162, javax.swing.BoxLayout.LINE_AXIS));

        jLabel128.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel128.setText("Danh mục: ");
        jPanel162.add(jLabel128);

        jLabel_DanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_DanhMuc.setText("Field_DanhMuc");
        jPanel162.add(jLabel_DanhMuc);

        jPanel159.add(jPanel162);
        jPanel159.add(filler4);

        jPanel163.setAlignmentX(0.0F);
        jPanel163.setLayout(new javax.swing.BoxLayout(jPanel163, javax.swing.BoxLayout.LINE_AXIS));

        jLabel130.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel130.setText("Số lượng: ");
        jPanel163.add(jLabel130);

        jLabel_SoLuong.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel_SoLuong.setText("Field_SoLuong");
        jPanel163.add(jLabel_SoLuong);

        jPanel159.add(jPanel163);
        jPanel159.add(filler5);
        jPanel159.add(filler7);

        jPanel164.setAlignmentX(0.0F);
        jPanel164.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel164.setLayout(new javax.swing.BoxLayout(jPanel164, javax.swing.BoxLayout.LINE_AXIS));

        jButton_Sua.setBackground(new java.awt.Color(85, 182, 83));
        jButton_Sua.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jButton_Sua.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Sua.setText("Sửa");
        jButton_Sua.setAutoscrolls(true);
        jButton_Sua.setMaximumSize(new java.awt.Dimension(80, 30));
        jButton_Sua.setMinimumSize(new java.awt.Dimension(80, 30));
        jButton_Sua.setPreferredSize(new java.awt.Dimension(72, 30));
        jButton_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel164.add(jButton_Sua);
        jPanel164.add(filler9);

        jButton_NgungBan.setBackground(new java.awt.Color(219, 79, 78));
        jButton_NgungBan.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jButton_NgungBan.setForeground(new java.awt.Color(255, 255, 255));
        jButton_NgungBan.setText("Ngừng bán");
        jButton_NgungBan.setMaximumSize(new java.awt.Dimension(120, 30));
        jButton_NgungBan.setMinimumSize(new java.awt.Dimension(120, 30));
        jButton_NgungBan.setPreferredSize(new java.awt.Dimension(105, 30));
        jButton_NgungBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgungKDActionPerformed(evt);
            }
        });
        jPanel164.add(jButton_NgungBan);

        jPanel159.add(jPanel164);
        jPanel159.add(filler18);

        jPanel_Info_SanPham1.add(jPanel159);

        jPanel_Component_SanPham.add(jPanel_Info_SanPham1);
        jPanel_Component_SanPham.add(filler19);

        add(jPanel_Component_SanPham, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        TAB_ThemSanPham tAB_ThemSanPham = new TAB_ThemSanPham();
        tAB_ThemSanPham.setVisible(true);
        tAB_ThemSanPham.setLocationRelativeTo(null);
        
        tAB_ThemSanPham.setSanPhamSach(x);
        tAB_ThemSanPham.disVisibleForSua();
        
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnNgungKDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgungKDActionPerformed
        // TODO add your handling code here:
        SanPham_BUS sanPham_BUS = new SanPham_BUS();
        int result = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn đổi trạng thái bán hàng không?");
        if(jButton_NgungBan.getText().equals("Ngừng bán"))
        {
            if(result == 0)
            {
                jButton_NgungBan.setBackground(new Color(204,204,204));
                jButton_NgungBan.setText("Bán lại");
            }
                
            x.setTinhTrang("NGUNG_KINH_DOANH");
            sanPham_BUS.editTrangThaiSanPham(x);
            return;
        }
        
        if(jButton_NgungBan.getText().equals("Bán lại"))
        {
            if(result == 0)
            {
                jButton_NgungBan.setBackground(new Color(219,79,78));
                jButton_NgungBan.setText("Ngừng bán");
            }
           
            x.setTinhTrang("CON_HANG");
            sanPham_BUS.editTrangThaiSanPham(x);
        }
       
    }//GEN-LAST:event_btnNgungKDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler14;
    private javax.swing.Box.Filler filler16;
    private javax.swing.Box.Filler filler18;
    private javax.swing.Box.Filler filler19;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JButton jButton_NgungBan;
    private javax.swing.JButton jButton_Sua;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel_DanhMuc;
    private javax.swing.JLabel jLabel_Img;
    private javax.swing.JLabel jLabel_NhaXuatBan;
    private javax.swing.JLabel jLabel_SoLuong;
    private javax.swing.JLabel jLabel_TacGia;
    private javax.swing.JLabel jLabel_TenSanPham;
    private javax.swing.JPanel jPanel159;
    private javax.swing.JPanel jPanel160;
    private javax.swing.JPanel jPanel161;
    private javax.swing.JPanel jPanel162;
    private javax.swing.JPanel jPanel163;
    private javax.swing.JPanel jPanel164;
    private javax.swing.JPanel jPanel_Box_Left;
    private javax.swing.JPanel jPanel_Component_SanPham;
    private javax.swing.JPanel jPanel_Info_SanPham1;
    private javax.swing.JPanel jPanel_TenSanPham1;
    // End of variables declaration//GEN-END:variables
}
