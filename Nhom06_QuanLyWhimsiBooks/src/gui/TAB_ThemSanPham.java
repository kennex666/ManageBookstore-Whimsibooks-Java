/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import bus.DanhMuc_BUS;
import bus.NhaCungCap_BUS;
import bus.NhaXuatBan_BUS;
import bus.SanPham_BUS;
import bus.TacGia_BUS;
import bus.TheLoai_BUS;
import bus.ThuongHieu_BUS;
import connectDB.ConnectDB;
import dao.SanPham_DAO;
import entities.DanhMuc;
import entities.NhaCungCap;
import entities.NhaXuatBan;
import entities.SanPham;
import entities.TacGia;
import entities.TheLoai;
import entities.ThuongHieu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import utilities.ImageProcessing;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author ASUS
 */
public class TAB_ThemSanPham extends javax.swing.JFrame {

    /**
     * Creates new form TAB_ThemSanPham
     */
    ArrayList<String> nxb_name;
    ArrayList<String> ncc_name;
    ArrayList<String> dm_name;
    ArrayList<String> tg_name;
    ArrayList<String> tl_name;

    public TAB_ThemSanPham() {
        initComponents();
        ConnectDB.getInstance().connect();
        
        this.txtNgay.setDate(java.util.Calendar.getInstance().getTime());
        
        nxb_name = new ArrayList<String>();
        ncc_name = new ArrayList<String>();
        dm_name = new ArrayList<String>();
        tg_name = new ArrayList<String>();
        tl_name = new ArrayList<String>();
        
        NhaCungCap_BUS nhaCungCap_BUS = new NhaCungCap_BUS();
        ArrayList<NhaCungCap> list_NCC = nhaCungCap_BUS.getAllNhaCungCap();
        for(NhaCungCap ncc : list_NCC)
        {
            ncc_name.add(ncc.getTenNhaCungCap());
        }
      
        
        NhaXuatBan_BUS nhaXuatBan_BUS = new NhaXuatBan_BUS();
        ArrayList<NhaXuatBan> list_NXB = nhaXuatBan_BUS.getAllNhaXuatBan();
        for(NhaXuatBan nxb : list_NXB)
        {
            nxb_name.add( nxb.getTenNhaXuatBan());
        }

        
        DanhMuc_BUS danhMuc_BUS = new DanhMuc_BUS();
        ArrayList<DanhMuc> list_DM = danhMuc_BUS.getAllDanhMuc();
        for(DanhMuc dm : list_DM)
        {
            dm_name.add(dm.getTenDanhMuc());
        }
        
        TacGia_BUS tacGia_BUS = new TacGia_BUS();
        ArrayList<TacGia> list_TG = tacGia_BUS.getAllTacGia();
        for(TacGia tg : list_TG)
        {
            tg_name.add(tg.getTenTacGia());
        }
        
        TheLoai_BUS theLoai_BUS = new TheLoai_BUS();
        ArrayList<TheLoai> list_TL = theLoai_BUS.getAllTheLoai();
        for(TheLoai tl : list_TL)
        {
            tl_name.add(tl.getTenTheLoai());
        }
       
        
        

        comboBox_NCC = new JComboBox<String>();
        this.jPanel_CBB_NhaCungCap.removeAll();
        this.jPanel_CBB_NhaCungCap.add(comboBox_NCC);
        comboBox_NCC.setVisible(false);
        this.jTextField_NhaCungCap.addCaretListener(new TextFieldCaretListener_NCC());
        comboBox_NCC.removeAll();
        comboBox_NCC.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
        try {
            jTextField_NhaCungCap.setText(comboBox_NCC.getSelectedItem().toString());
            comboBox_NCC.removeAllItems();
//               comboBox.hidePopup();
            jPanel_CBB_NhaCungCap.removeAll();
        } catch (Exception e) {
                    }
                }
        });
        
        
        comboBox_NXB = new JComboBox<String>();
        this.jPanel_CBB_NhaXuatBan.removeAll();
        this.jPanel_CBB_NhaXuatBan.add(comboBox_NXB);
        comboBox_NXB.setVisible(false);
        this.jTextField_NhaXuatBan.addCaretListener(new TextFieldCaretListener_NXB());
        comboBox_NXB.removeAll();
        comboBox_NXB.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
        try {
            jTextField_NhaXuatBan.setText(comboBox_NXB.getSelectedItem().toString());
            comboBox_NXB.removeAllItems();
//            comboBox.hidePopup();
            jPanel_CBB_NhaXuatBan.removeAll();
            } catch (Exception e) {
            }
        }
        });
        
        comboBox_DM = new JComboBox<String>();
        this.jPanel_CBB_DanhMuc.removeAll();
        this.jPanel_CBB_DanhMuc.add(comboBox_DM);
        comboBox_DM.setVisible(false);
        this.jTextField_DanhMuc.addCaretListener(new TextFieldCaretListener_DM());
        comboBox_DM.removeAll();
        comboBox_DM.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
        try {
            jTextField_DanhMuc.setText(comboBox_DM.getSelectedItem().toString());
            comboBox_DM.removeAllItems();
//            comboBox.hidePopup();
            jPanel_CBB_DanhMuc.removeAll();
            } catch (Exception e) {
            }
        }
        });
        
        comboBox_TL = new JComboBox<String>();
        this.jPanel_CBB_TheLoai.removeAll();
        this.jPanel_CBB_TheLoai.add(comboBox_TL);
        comboBox_TL.setVisible(false);
        this.jTextField_TheLoai.addCaretListener(new TextFieldCaretListener_TL());
        comboBox_TL.removeAll();
        comboBox_TL.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
        try {
            jTextField_TheLoai.setText(comboBox_TL.getSelectedItem().toString());
            comboBox_TL.removeAllItems();
//            comboBox.hidePopup();
            jPanel_CBB_TheLoai.removeAll();
            } catch (Exception e) {
            }
        }
        });
        
        comboBox_TG = new JComboBox<String>();
        this.jPanel_CBB_TacGia.removeAll();
        this.jPanel_CBB_TacGia.add(comboBox_TG);
        comboBox_TG.setVisible(false);
        this.jTextField_TacGia.addCaretListener(new TextFieldCaretListener_TG());
        comboBox_TG.removeAll();
        comboBox_TG.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
        try {
            jTextField_TacGia.setText(comboBox_TG.getSelectedItem().toString());
            comboBox_TG.removeAllItems();
//            comboBox.hidePopup();
            jPanel_CBB_TacGia.removeAll();
            } catch (Exception e) {
            }
        }
        });
        
        
        
            

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        filler37 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 50), new java.awt.Dimension(10, 10));
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        filler25 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(30, 60), new java.awt.Dimension(10, 10));
        jPanel17 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        filler43 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(20, 20), new java.awt.Dimension(10, 10));
        filler45 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(20, 10), new java.awt.Dimension(10, 10));
        jLabel_ImgChooser = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jButton_Chon = new javax.swing.JButton();
        filler30 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 50), new java.awt.Dimension(10, 10));
        filler46 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 5), new java.awt.Dimension(10, 10));
        jPanel44 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextField_TenSanPham = new javax.swing.JTextField();
        jPanel_CBB_TenSanPham = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel_Barcode = new javax.swing.JLabel();
        jTextField_Barcode = new javax.swing.JTextField();
        jPanel_CBB_Barcode = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jLabel_SoLuongTon = new javax.swing.JLabel();
        jTextField_SoLuongTon = new javax.swing.JTextField();
        jPanel_CBB_SoLuongTon = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel_Thue1 = new javax.swing.JLabel();
        jTextField_Thue = new javax.swing.JTextField();
        filler31 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(30, 60), new java.awt.Dimension(10, 10));
        jPanel22 = new javax.swing.JPanel();
        jPanel_Title = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel_NhaCungCap = new javax.swing.JLabel();
        jTextField_NhaCungCap = new javax.swing.JTextField();
        jPanel_CBB_NhaCungCap = new javax.swing.JPanel();
        jPanel_NhaXuatban = new javax.swing.JPanel();
        jLabel_SoLuongTon3 = new javax.swing.JLabel();
        jTextField_NhaXuatBan = new javax.swing.JTextField();
        jPanel_CBB_NhaXuatBan = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jLabel_TacGia = new javax.swing.JLabel();
        jTextField_TacGia = new javax.swing.JTextField();
        jPanel_CBB_TacGia = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jLabel_SoLuongTon2 = new javax.swing.JLabel();
        jTextField_TheLoai = new javax.swing.JTextField();
        jPanel_CBB_TheLoai = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jLabel_SoLuongTon5 = new javax.swing.JLabel();
        jTextField_DanhMuc = new javax.swing.JTextField();
        jPanel_CBB_DanhMuc = new javax.swing.JPanel();
        jPanel_GiaNhap = new javax.swing.JPanel();
        jLabel_GiaNhap = new javax.swing.JLabel();
        jTextField_GiaNhap = new javax.swing.JTextField();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(40, 0), new java.awt.Dimension(0, 0));
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(40, 0), new java.awt.Dimension(0, 0));
        jPanel23 = new javax.swing.JPanel();
        jPanel_Title1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel_NamSanXuat = new javax.swing.JLabel();
        jTextField1_NamSanXuat = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jLabel_KichThuoc = new javax.swing.JLabel();
        jTextField_KichThuoc = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jLabel_XuatXu = new javax.swing.JLabel();
        jTextField_XuatXu = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jLabel_NgonNgu = new javax.swing.JLabel();
        jTextField_NgonNgu = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel_NgayNhap = new javax.swing.JLabel();
        txtNgay = new com.toedter.calendar.JDateChooser();
        filler24 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 30), new java.awt.Dimension(10, 10));
        jPanel54 = new javax.swing.JPanel();
        jLabel_SoTrang1 = new javax.swing.JLabel();
        jComboBox_LoaiDoiTra = new javax.swing.JComboBox<>();
        filler36 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(30, 50), new java.awt.Dimension(10, 10));
        jPanel25 = new javax.swing.JPanel();
        jPanel_Title2 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jLabel_SoTrang = new javax.swing.JLabel();
        jTextField_SoTrang = new javax.swing.JTextField();
        filler38 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 25), new java.awt.Dimension(10, 10));
        jPanel53 = new javax.swing.JPanel();
        jLabel_LoaiBia = new javax.swing.JLabel();
        jTextField_LoaiBia = new javax.swing.JTextField();
        filler44 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 25), new java.awt.Dimension(10, 10));
        jPanel60 = new javax.swing.JPanel();
        jLabel_DonViDoLuong1 = new javax.swing.JLabel();
        jTextField_DonViDoLuong = new javax.swing.JTextField();
        filler26 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 15), new java.awt.Dimension(10, 10));
        jPanel8 = new javax.swing.JPanel();
        filler35 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 45), new java.awt.Dimension(10, 10));
        jButton_Luu = new javax.swing.JButton();
        filler41 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jButton_Sua = new javax.swing.JButton();
        filler42 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jButton_Huy = new javax.swing.JButton();
        filler33 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 50), new java.awt.Dimension(10, 10));
        filler34 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(30, 60), new java.awt.Dimension(10, 10));
        jPanel3 = new javax.swing.JPanel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(0, 0));
        jLabel_Warning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1119, 100));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));
        jPanel2.add(filler37);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 145, 239));
        jLabel1.setText("Thông tin sản phẩm");
        jPanel2.add(jLabel1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5);

        getContentPane().add(jPanel2);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.X_AXIS));
        jPanel9.add(filler25);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setPreferredSize(new java.awt.Dimension(300, 780));
        jPanel17.setLayout(new javax.swing.BoxLayout(jPanel17, javax.swing.BoxLayout.Y_AXIS));

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setMaximumSize(new java.awt.Dimension(300, 300));
        jPanel28.setMinimumSize(new java.awt.Dimension(82, 200));
        jPanel28.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel28.setRequestFocusEnabled(false);
        jPanel28.setLayout(new javax.swing.BoxLayout(jPanel28, javax.swing.BoxLayout.Y_AXIS));

        jLabel4.setText("Hình ảnh");
        jLabel4.setPreferredSize(new java.awt.Dimension(200, 22));
        jPanel28.add(jLabel4);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setMaximumSize(new java.awt.Dimension(350, 300));
        jPanel12.setMinimumSize(new java.awt.Dimension(70, 140));
        jPanel12.setPreferredSize(new java.awt.Dimension(140, 140));
        jPanel12.setRequestFocusEnabled(false);
        jPanel12.setLayout(new java.awt.BorderLayout());
        jPanel12.add(filler43, java.awt.BorderLayout.LINE_END);
        jPanel12.add(filler45, java.awt.BorderLayout.LINE_START);

        jLabel_ImgChooser.setBackground(new java.awt.Color(255, 204, 204));
        jLabel_ImgChooser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_ImgChooser.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel_ImgChooser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_ImgChooser.setMaximumSize(new java.awt.Dimension(50, 190));
        jLabel_ImgChooser.setMinimumSize(new java.awt.Dimension(50, 140));
        jLabel_ImgChooser.setPreferredSize(new java.awt.Dimension(40, 140));
        jPanel12.add(jLabel_ImgChooser, java.awt.BorderLayout.CENTER);

        jPanel28.add(jPanel12);

        jPanel17.add(jPanel28);

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setMinimumSize(new java.awt.Dimension(82, 20));
        jPanel29.setPreferredSize(new java.awt.Dimension(304, 40));
        jPanel29.setLayout(new javax.swing.BoxLayout(jPanel29, javax.swing.BoxLayout.X_AXIS));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(135, 30));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 81, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel29.add(jPanel13);

        jButton_Chon.setBackground(new java.awt.Color(15, 145, 239));
        jButton_Chon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_Chon.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Chon.setText("Chọn");
        jButton_Chon.setMaximumSize(new java.awt.Dimension(72, 30));
        jButton_Chon.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton_Chon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ChonActionPerformed(evt);
            }
        });
        jPanel29.add(jButton_Chon);
        jPanel29.add(filler30);

        jPanel17.add(jPanel29);
        jPanel17.add(filler46);

        jPanel44.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel44.setLayout(new java.awt.BorderLayout());

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tên sản phẩm");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel11.setFocusCycleRoot(true);
        jLabel11.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel44.add(jLabel11, java.awt.BorderLayout.CENTER);

        jTextField_TenSanPham.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_TenSanPham.setPreferredSize(new java.awt.Dimension(71, 35));
        jTextField_TenSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_TenSanPhamMouseClicked(evt);
            }
        });
        jTextField_TenSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TenSanPhamActionPerformed(evt);
            }
        });
        jPanel44.add(jTextField_TenSanPham, java.awt.BorderLayout.PAGE_END);

        jPanel17.add(jPanel44);

        jPanel_CBB_TenSanPham.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_CBB_TenSanPham.setMinimumSize(new java.awt.Dimension(100, 25));
        jPanel_CBB_TenSanPham.setPreferredSize(new java.awt.Dimension(225, 25));
        jPanel_CBB_TenSanPham.setLayout(new javax.swing.BoxLayout(jPanel_CBB_TenSanPham, javax.swing.BoxLayout.LINE_AXIS));
        jPanel17.add(jPanel_CBB_TenSanPham);

        jPanel32.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel32.setLayout(new java.awt.BorderLayout());

        jLabel_Barcode.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Barcode.setText("Barcode");
        jLabel_Barcode.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_Barcode.setFocusCycleRoot(true);
        jLabel_Barcode.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel32.add(jLabel_Barcode, java.awt.BorderLayout.CENTER);

        jTextField_Barcode.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_Barcode.setPreferredSize(new java.awt.Dimension(71, 35));
        jTextField_Barcode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_BarcodeMouseClicked(evt);
            }
        });
        jTextField_Barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_BarcodeActionPerformed(evt);
            }
        });
        jPanel32.add(jTextField_Barcode, java.awt.BorderLayout.PAGE_END);

        jPanel17.add(jPanel32);

        jPanel_CBB_Barcode.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_CBB_Barcode.setMinimumSize(new java.awt.Dimension(100, 25));
        jPanel_CBB_Barcode.setPreferredSize(new java.awt.Dimension(225, 25));
        jPanel_CBB_Barcode.setLayout(new javax.swing.BoxLayout(jPanel_CBB_Barcode, javax.swing.BoxLayout.LINE_AXIS));
        jPanel17.add(jPanel_CBB_Barcode);

        jPanel45.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel45.setLayout(new java.awt.BorderLayout());

        jLabel_SoLuongTon.setText("Số lượng tồn");
        jLabel_SoLuongTon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_SoLuongTon.setFocusCycleRoot(true);
        jLabel_SoLuongTon.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel45.add(jLabel_SoLuongTon, java.awt.BorderLayout.CENTER);

        jTextField_SoLuongTon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_SoLuongTon.setPreferredSize(new java.awt.Dimension(71, 35));
        jTextField_SoLuongTon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_SoLuongTonMouseClicked(evt);
            }
        });
        jTextField_SoLuongTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_SoLuongTonActionPerformed(evt);
            }
        });
        jPanel45.add(jTextField_SoLuongTon, java.awt.BorderLayout.PAGE_END);

        jPanel17.add(jPanel45);

        jPanel_CBB_SoLuongTon.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_CBB_SoLuongTon.setMinimumSize(new java.awt.Dimension(100, 25));
        jPanel_CBB_SoLuongTon.setPreferredSize(new java.awt.Dimension(225, 25));
        jPanel_CBB_SoLuongTon.setLayout(new javax.swing.BoxLayout(jPanel_CBB_SoLuongTon, javax.swing.BoxLayout.LINE_AXIS));
        jPanel17.add(jPanel_CBB_SoLuongTon);

        jPanel38.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel38.setLayout(new java.awt.BorderLayout());

        jLabel_Thue1.setText("Thuế");
        jLabel_Thue1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_Thue1.setFocusCycleRoot(true);
        jLabel_Thue1.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel38.add(jLabel_Thue1, java.awt.BorderLayout.CENTER);

        jTextField_Thue.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_Thue.setPreferredSize(new java.awt.Dimension(71, 35));
        jTextField_Thue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_ThueMouseClicked(evt);
            }
        });
        jTextField_Thue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_ThueActionPerformed(evt);
            }
        });
        jPanel38.add(jTextField_Thue, java.awt.BorderLayout.PAGE_END);

        jPanel17.add(jPanel38);

        jPanel9.add(jPanel17);
        jPanel9.add(filler31);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setMaximumSize(new java.awt.Dimension(280, 780));
        jPanel22.setMinimumSize(new java.awt.Dimension(120, 341));
        jPanel22.setPreferredSize(new java.awt.Dimension(280, 780));
        jPanel22.setLayout(new javax.swing.BoxLayout(jPanel22, javax.swing.BoxLayout.Y_AXIS));

        jPanel_Title.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Title.setCursor(new java.awt.Cursor(java.awt.Cursor.W_RESIZE_CURSOR));
        jPanel_Title.setMaximumSize(new java.awt.Dimension(1000, 30));
        jPanel_Title.setMinimumSize(new java.awt.Dimension(80, 30));
        jPanel_Title.setPreferredSize(new java.awt.Dimension(200, 65));
        jPanel_Title.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(15, 145, 239));
        jLabel6.setText("Thông tin chung");
        jPanel_Title.add(jLabel6, java.awt.BorderLayout.CENTER);

        jPanel22.add(jPanel_Title);

        jPanel33.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel33.setLayout(new java.awt.BorderLayout());

        jLabel_NhaCungCap.setText("Nhà cung cấp");
        jLabel_NhaCungCap.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_NhaCungCap.setFocusCycleRoot(true);
        jLabel_NhaCungCap.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel33.add(jLabel_NhaCungCap, java.awt.BorderLayout.CENTER);

        jTextField_NhaCungCap.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_NhaCungCap.setPreferredSize(new java.awt.Dimension(71, 35));
        jTextField_NhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_NhaCungCapMouseClicked(evt);
            }
        });
        jTextField_NhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_NhaCungCapActionPerformed(evt);
            }
        });
        jPanel33.add(jTextField_NhaCungCap, java.awt.BorderLayout.PAGE_END);

        jPanel22.add(jPanel33);

        jPanel_CBB_NhaCungCap.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_CBB_NhaCungCap.setCursor(new java.awt.Cursor(java.awt.Cursor.W_RESIZE_CURSOR));
        jPanel_CBB_NhaCungCap.setMaximumSize(new java.awt.Dimension(1000, 25));
        jPanel_CBB_NhaCungCap.setMinimumSize(new java.awt.Dimension(80, 25));
        jPanel_CBB_NhaCungCap.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel_CBB_NhaCungCap.setLayout(new javax.swing.BoxLayout(jPanel_CBB_NhaCungCap, javax.swing.BoxLayout.Y_AXIS));
        jPanel22.add(jPanel_CBB_NhaCungCap);

        jPanel_NhaXuatban.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel_NhaXuatban.setLayout(new java.awt.BorderLayout());

        jLabel_SoLuongTon3.setText("Nhà xuất bản");
        jLabel_SoLuongTon3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_SoLuongTon3.setFocusCycleRoot(true);
        jLabel_SoLuongTon3.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel_NhaXuatban.add(jLabel_SoLuongTon3, java.awt.BorderLayout.CENTER);

        jTextField_NhaXuatBan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_NhaXuatBan.setPreferredSize(new java.awt.Dimension(71, 35));
        jTextField_NhaXuatBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_NhaXuatBanMouseClicked(evt);
            }
        });
        jTextField_NhaXuatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_NhaXuatBanActionPerformed(evt);
            }
        });
        jPanel_NhaXuatban.add(jTextField_NhaXuatBan, java.awt.BorderLayout.PAGE_END);

        jPanel22.add(jPanel_NhaXuatban);

        jPanel_CBB_NhaXuatBan.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_CBB_NhaXuatBan.setCursor(new java.awt.Cursor(java.awt.Cursor.W_RESIZE_CURSOR));
        jPanel_CBB_NhaXuatBan.setMaximumSize(new java.awt.Dimension(1000, 25));
        jPanel_CBB_NhaXuatBan.setMinimumSize(new java.awt.Dimension(80, 25));
        jPanel_CBB_NhaXuatBan.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel_CBB_NhaXuatBan.setLayout(new javax.swing.BoxLayout(jPanel_CBB_NhaXuatBan, javax.swing.BoxLayout.Y_AXIS));
        jPanel22.add(jPanel_CBB_NhaXuatBan);

        jPanel55.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel55.setLayout(new java.awt.BorderLayout());

        jLabel_TacGia.setText("Tác giả");
        jLabel_TacGia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_TacGia.setFocusCycleRoot(true);
        jLabel_TacGia.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel55.add(jLabel_TacGia, java.awt.BorderLayout.CENTER);

        jTextField_TacGia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_TacGia.setPreferredSize(new java.awt.Dimension(71, 35));
        jTextField_TacGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_TacGiaMouseClicked(evt);
            }
        });
        jPanel55.add(jTextField_TacGia, java.awt.BorderLayout.PAGE_END);

        jPanel22.add(jPanel55);

        jPanel_CBB_TacGia.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_CBB_TacGia.setCursor(new java.awt.Cursor(java.awt.Cursor.W_RESIZE_CURSOR));
        jPanel_CBB_TacGia.setMaximumSize(new java.awt.Dimension(1000, 25));
        jPanel_CBB_TacGia.setMinimumSize(new java.awt.Dimension(80, 25));
        jPanel_CBB_TacGia.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel_CBB_TacGia.setLayout(new javax.swing.BoxLayout(jPanel_CBB_TacGia, javax.swing.BoxLayout.Y_AXIS));
        jPanel22.add(jPanel_CBB_TacGia);

        jPanel56.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel56.setLayout(new java.awt.BorderLayout());

        jLabel_SoLuongTon2.setText("Thể loại");
        jLabel_SoLuongTon2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_SoLuongTon2.setFocusCycleRoot(true);
        jLabel_SoLuongTon2.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel56.add(jLabel_SoLuongTon2, java.awt.BorderLayout.CENTER);

        jTextField_TheLoai.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_TheLoai.setPreferredSize(new java.awt.Dimension(71, 35));
        jTextField_TheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_TheLoaiMouseClicked(evt);
            }
        });
        jTextField_TheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TheLoaiActionPerformed(evt);
            }
        });
        jPanel56.add(jTextField_TheLoai, java.awt.BorderLayout.PAGE_END);

        jPanel22.add(jPanel56);

        jPanel_CBB_TheLoai.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_CBB_TheLoai.setCursor(new java.awt.Cursor(java.awt.Cursor.W_RESIZE_CURSOR));
        jPanel_CBB_TheLoai.setMaximumSize(new java.awt.Dimension(1000, 25));
        jPanel_CBB_TheLoai.setMinimumSize(new java.awt.Dimension(80, 25));
        jPanel_CBB_TheLoai.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel_CBB_TheLoai.setLayout(new javax.swing.BoxLayout(jPanel_CBB_TheLoai, javax.swing.BoxLayout.Y_AXIS));
        jPanel22.add(jPanel_CBB_TheLoai);

        jPanel59.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel59.setLayout(new java.awt.BorderLayout());

        jLabel_SoLuongTon5.setText("Danh mục");
        jLabel_SoLuongTon5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_SoLuongTon5.setFocusCycleRoot(true);
        jLabel_SoLuongTon5.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel59.add(jLabel_SoLuongTon5, java.awt.BorderLayout.CENTER);

        jTextField_DanhMuc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_DanhMuc.setPreferredSize(new java.awt.Dimension(71, 35));
        jTextField_DanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_DanhMucMouseClicked(evt);
            }
        });
        jPanel59.add(jTextField_DanhMuc, java.awt.BorderLayout.PAGE_END);

        jPanel22.add(jPanel59);

        jPanel_CBB_DanhMuc.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_CBB_DanhMuc.setCursor(new java.awt.Cursor(java.awt.Cursor.W_RESIZE_CURSOR));
        jPanel_CBB_DanhMuc.setMaximumSize(new java.awt.Dimension(1000, 25));
        jPanel_CBB_DanhMuc.setMinimumSize(new java.awt.Dimension(80, 25));
        jPanel_CBB_DanhMuc.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel_CBB_DanhMuc.setLayout(new javax.swing.BoxLayout(jPanel_CBB_DanhMuc, javax.swing.BoxLayout.Y_AXIS));
        jPanel22.add(jPanel_CBB_DanhMuc);

        jPanel_GiaNhap.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel_GiaNhap.setLayout(new java.awt.BorderLayout());

        jLabel_GiaNhap.setText("Giá nhập");
        jLabel_GiaNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_GiaNhap.setFocusCycleRoot(true);
        jLabel_GiaNhap.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel_GiaNhap.add(jLabel_GiaNhap, java.awt.BorderLayout.CENTER);

        jTextField_GiaNhap.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_GiaNhap.setPreferredSize(new java.awt.Dimension(71, 35));
        jTextField_GiaNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_GiaNhapMouseClicked(evt);
            }
        });
        jTextField_GiaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_GiaNhapActionPerformed(evt);
            }
        });
        jPanel_GiaNhap.add(jTextField_GiaNhap, java.awt.BorderLayout.PAGE_END);

        jPanel22.add(jPanel_GiaNhap);

        jPanel9.add(jPanel22);
        jPanel9.add(filler3);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(3, 575));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(15, 145, 239));
        jPanel4.setPreferredSize(new java.awt.Dimension(1, 575));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel1);
        jPanel9.add(filler1);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setMaximumSize(new java.awt.Dimension(280, 780));
        jPanel23.setMinimumSize(new java.awt.Dimension(120, 318));
        jPanel23.setPreferredSize(new java.awt.Dimension(300, 780));
        jPanel23.setLayout(new javax.swing.BoxLayout(jPanel23, javax.swing.BoxLayout.Y_AXIS));

        jPanel_Title1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Title1.setCursor(new java.awt.Cursor(java.awt.Cursor.W_RESIZE_CURSOR));
        jPanel_Title1.setMaximumSize(new java.awt.Dimension(1000, 30));
        jPanel_Title1.setMinimumSize(new java.awt.Dimension(80, 30));
        jPanel_Title1.setPreferredSize(new java.awt.Dimension(200, 65));
        jPanel_Title1.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(15, 145, 239));
        jLabel5.setText("Thông tin khác");
        jPanel_Title1.add(jLabel5, java.awt.BorderLayout.CENTER);

        jPanel23.add(jPanel_Title1);

        jPanel46.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel46.setLayout(new java.awt.BorderLayout());

        jLabel_NamSanXuat.setText("Năm sản xuất");
        jLabel_NamSanXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_NamSanXuat.setFocusCycleRoot(true);
        jLabel_NamSanXuat.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel46.add(jLabel_NamSanXuat, java.awt.BorderLayout.CENTER);

        jTextField1_NamSanXuat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField1_NamSanXuat.setPreferredSize(new java.awt.Dimension(71, 35));
        jTextField1_NamSanXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1_NamSanXuatMouseClicked(evt);
            }
        });
        jTextField1_NamSanXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_NamSanXuatActionPerformed(evt);
            }
        });
        jPanel46.add(jTextField1_NamSanXuat, java.awt.BorderLayout.PAGE_END);

        jPanel23.add(jPanel46);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setMinimumSize(new java.awt.Dimension(100, 20));
        jPanel24.setPreferredSize(new java.awt.Dimension(225, 25));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel23.add(jPanel24);

        jPanel49.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel49.setLayout(new java.awt.BorderLayout());

        jLabel_KichThuoc.setText("Kích thước");
        jLabel_KichThuoc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_KichThuoc.setFocusCycleRoot(true);
        jLabel_KichThuoc.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel49.add(jLabel_KichThuoc, java.awt.BorderLayout.CENTER);

        jTextField_KichThuoc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_KichThuoc.setPreferredSize(new java.awt.Dimension(71, 35));
        jTextField_KichThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_KichThuocMouseClicked(evt);
            }
        });
        jTextField_KichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_KichThuocActionPerformed(evt);
            }
        });
        jPanel49.add(jTextField_KichThuoc, java.awt.BorderLayout.PAGE_END);

        jPanel23.add(jPanel49);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setMinimumSize(new java.awt.Dimension(100, 20));
        jPanel21.setPreferredSize(new java.awt.Dimension(225, 25));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel23.add(jPanel21);

        jPanel50.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel50.setLayout(new java.awt.BorderLayout());

        jLabel_XuatXu.setText("Xuất xứ");
        jLabel_XuatXu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_XuatXu.setFocusCycleRoot(true);
        jLabel_XuatXu.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel50.add(jLabel_XuatXu, java.awt.BorderLayout.CENTER);

        jTextField_XuatXu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_XuatXu.setPreferredSize(new java.awt.Dimension(71, 35));
        jTextField_XuatXu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_XuatXuMouseClicked(evt);
            }
        });
        jTextField_XuatXu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_XuatXuActionPerformed(evt);
            }
        });
        jPanel50.add(jTextField_XuatXu, java.awt.BorderLayout.PAGE_END);

        jPanel23.add(jPanel50);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setMinimumSize(new java.awt.Dimension(100, 20));
        jPanel20.setPreferredSize(new java.awt.Dimension(225, 25));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel23.add(jPanel20);

        jPanel51.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel51.setLayout(new java.awt.BorderLayout());

        jLabel_NgonNgu.setText("Ngôn ngữ");
        jLabel_NgonNgu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_NgonNgu.setFocusCycleRoot(true);
        jLabel_NgonNgu.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel51.add(jLabel_NgonNgu, java.awt.BorderLayout.CENTER);

        jTextField_NgonNgu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_NgonNgu.setPreferredSize(new java.awt.Dimension(71, 35));
        jTextField_NgonNgu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_NgonNguMouseClicked(evt);
            }
        });
        jTextField_NgonNgu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_NgonNguActionPerformed(evt);
            }
        });
        jPanel51.add(jTextField_NgonNgu, java.awt.BorderLayout.PAGE_END);

        jPanel23.add(jPanel51);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setMinimumSize(new java.awt.Dimension(100, 20));
        jPanel16.setPreferredSize(new java.awt.Dimension(225, 25));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel23.add(jPanel16);

        jPanel37.setMinimumSize(new java.awt.Dimension(64, 36));
        jPanel37.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel37.setLayout(new java.awt.BorderLayout());

        jLabel_NgayNhap.setText("Ngôn ngữ");
        jLabel_NgayNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_NgayNhap.setFocusCycleRoot(true);
        jLabel_NgayNhap.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel37.add(jLabel_NgayNhap, java.awt.BorderLayout.CENTER);
        jLabel_NgayNhap.getAccessibleContext().setAccessibleName("Ngày nhập");

        txtNgay.setPreferredSize(new java.awt.Dimension(88, 35));
        txtNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgayMouseClicked(evt);
            }
        });
        jPanel37.add(txtNgay, java.awt.BorderLayout.PAGE_END);

        jPanel23.add(jPanel37);
        jPanel23.add(filler24);

        jPanel54.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel54.setLayout(new java.awt.BorderLayout());

        jLabel_SoTrang1.setText("Loại đổi trả");
        jLabel_SoTrang1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_SoTrang1.setFocusCycleRoot(true);
        jLabel_SoTrang1.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel54.add(jLabel_SoTrang1, java.awt.BorderLayout.CENTER);

        jComboBox_LoaiDoiTra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Được đổi trả", "Không được đổi" }));
        jComboBox_LoaiDoiTra.setMinimumSize(new java.awt.Dimension(72, 35));
        jComboBox_LoaiDoiTra.setPreferredSize(new java.awt.Dimension(119, 35));
        jPanel54.add(jComboBox_LoaiDoiTra, java.awt.BorderLayout.PAGE_END);

        jPanel23.add(jPanel54);

        jPanel9.add(jPanel23);
        jPanel9.add(filler36);

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setMaximumSize(new java.awt.Dimension(280, 780));
        jPanel25.setMinimumSize(new java.awt.Dimension(120, 298));
        jPanel25.setPreferredSize(new java.awt.Dimension(280, 780));
        jPanel25.setLayout(new javax.swing.BoxLayout(jPanel25, javax.swing.BoxLayout.Y_AXIS));

        jPanel_Title2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Title2.setCursor(new java.awt.Cursor(java.awt.Cursor.W_RESIZE_CURSOR));
        jPanel_Title2.setMaximumSize(new java.awt.Dimension(1000, 30));
        jPanel_Title2.setMinimumSize(new java.awt.Dimension(80, 30));
        jPanel_Title2.setPreferredSize(new java.awt.Dimension(200, 65));
        jPanel_Title2.setLayout(new java.awt.BorderLayout());
        jPanel25.add(jPanel_Title2);

        jPanel52.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel52.setLayout(new java.awt.BorderLayout());

        jLabel_SoTrang.setText("Số trang");
        jLabel_SoTrang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_SoTrang.setFocusCycleRoot(true);
        jLabel_SoTrang.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel52.add(jLabel_SoTrang, java.awt.BorderLayout.CENTER);

        jTextField_SoTrang.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_SoTrang.setPreferredSize(new java.awt.Dimension(71, 35));
        jTextField_SoTrang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_SoTrangMouseClicked(evt);
            }
        });
        jTextField_SoTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_SoTrangActionPerformed(evt);
            }
        });
        jPanel52.add(jTextField_SoTrang, java.awt.BorderLayout.PAGE_END);

        jPanel25.add(jPanel52);
        jPanel25.add(filler38);

        jPanel53.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel53.setLayout(new java.awt.BorderLayout());

        jLabel_LoaiBia.setText("Loại bìa");
        jLabel_LoaiBia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_LoaiBia.setFocusCycleRoot(true);
        jLabel_LoaiBia.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel53.add(jLabel_LoaiBia, java.awt.BorderLayout.CENTER);

        jTextField_LoaiBia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_LoaiBia.setPreferredSize(new java.awt.Dimension(71, 35));
        jTextField_LoaiBia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_LoaiBiaMouseClicked(evt);
            }
        });
        jTextField_LoaiBia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_LoaiBiaActionPerformed(evt);
            }
        });
        jPanel53.add(jTextField_LoaiBia, java.awt.BorderLayout.PAGE_END);

        jPanel25.add(jPanel53);
        jPanel25.add(filler44);

        jPanel60.setPreferredSize(new java.awt.Dimension(0, 60));
        jPanel60.setLayout(new java.awt.BorderLayout());

        jLabel_DonViDoLuong1.setText("Đơn vị đo lường");
        jLabel_DonViDoLuong1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_DonViDoLuong1.setFocusCycleRoot(true);
        jLabel_DonViDoLuong1.setPreferredSize(new java.awt.Dimension(74, 10));
        jPanel60.add(jLabel_DonViDoLuong1, java.awt.BorderLayout.CENTER);

        jTextField_DonViDoLuong.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_DonViDoLuong.setPreferredSize(new java.awt.Dimension(71, 35));
        jTextField_DonViDoLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_DonViDoLuongMouseClicked(evt);
            }
        });
        jTextField_DonViDoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DonViDoLuongActionPerformed(evt);
            }
        });
        jPanel60.add(jTextField_DonViDoLuong, java.awt.BorderLayout.PAGE_END);

        jPanel25.add(jPanel60);
        jPanel25.add(filler26);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel8.setMinimumSize(new java.awt.Dimension(77, 250));
        jPanel8.setPreferredSize(new java.awt.Dimension(0, 250));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.Y_AXIS));
        jPanel8.add(filler35);

        jButton_Luu.setBackground(new java.awt.Color(15, 145, 239));
        jButton_Luu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_Luu.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Luu.setText("Lưu");
        jButton_Luu.setMaximumSize(new java.awt.Dimension(200, 23));
        jButton_Luu.setPreferredSize(new java.awt.Dimension(200, 50));
        jButton_Luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LuuActionPerformed(evt);
            }
        });
        jPanel8.add(jButton_Luu);
        jPanel8.add(filler41);

        jButton_Sua.setBackground(new java.awt.Color(15, 145, 239));
        jButton_Sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_Sua.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Sua.setText("Sửa");
        jButton_Sua.setMaximumSize(new java.awt.Dimension(200, 23));
        jButton_Sua.setPreferredSize(new java.awt.Dimension(200, 50));
        jButton_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SuaActionPerformed(evt);
            }
        });
        jPanel8.add(jButton_Sua);
        jPanel8.add(filler42);

        jButton_Huy.setBackground(new java.awt.Color(15, 145, 239));
        jButton_Huy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_Huy.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Huy.setText("Hủy");
        jButton_Huy.setMaximumSize(new java.awt.Dimension(200, 23));
        jButton_Huy.setPreferredSize(new java.awt.Dimension(200, 50));
        jButton_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HuyActionPerformed(evt);
            }
        });
        jPanel8.add(jButton_Huy);
        jPanel8.add(filler33);

        jPanel25.add(jPanel8);

        jPanel9.add(jPanel25);
        jPanel9.add(filler34);

        getContentPane().add(jPanel9);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel3.setPreferredSize(new java.awt.Dimension(1119, 100));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.X_AXIS));
        jPanel3.add(filler2);

        jLabel_Warning.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel_Warning.setForeground(java.awt.Color.red);
        jLabel_Warning.setMaximumSize(new java.awt.Dimension(10, 10));
        jLabel_Warning.setMinimumSize(new java.awt.Dimension(10, 10));
        jLabel_Warning.setPreferredSize(new java.awt.Dimension(200, 10));
        jPanel3.add(jLabel_Warning);

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1_NamSanXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_NamSanXuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_NamSanXuatActionPerformed

    private void jTextField_KichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_KichThuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_KichThuocActionPerformed

    private void jTextField_XuatXuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_XuatXuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_XuatXuActionPerformed

    private void jTextField_NgonNguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_NgonNguActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_NgonNguActionPerformed

    private void jTextField_SoTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_SoTrangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_SoTrangActionPerformed

    private void jTextField_LoaiBiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_LoaiBiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_LoaiBiaActionPerformed

    private void jButton_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HuyActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton_HuyActionPerformed

    private void jButton_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SuaActionPerformed
        // TODO add your handling code here:

        if(!check_empty())
        {
            return;
        }
        SanPham_BUS sanPham_BUS = new SanPham_BUS();
        try {
            ConnectDB.getInstance().connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int decided = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn thay đổi lại sản phẩm này không?");
        if(decided == 0)
        {
            SanPham sanPham = getNewSanPham();
            sanPham.setSanPhamID(ID);
            sanPham_BUS.editSanPham(sanPham);
            this.setVisible(false);
        }
        
        
    }//GEN-LAST:event_jButton_SuaActionPerformed
    
    
    
    public boolean check_empty()
    {

        if(this.jTextField_TenSanPham.getText().equals(""))
        {
            this.jLabel_Warning.setText("Hãy nhập tên của sản phẩm!");
            jTextField_TenSanPham.setBorder(BorderFactory.createLineBorder(Color.red));
            this.jTextField_TenSanPham.setToolTipText("Tên của sản phẩm");
            return false;
        }
        if(this.jTextField_Barcode.getText().equals(""))
        {
            this.jLabel_Warning.setText("Hãy nhập barcode của sản phẩm!");
            jTextField_Barcode.setBorder(BorderFactory.createLineBorder(Color.red));
            this.jTextField_Barcode.setToolTipText("Barcode của sản phẩm");
            return false;
        }
        if(this.jTextField_SoLuongTon.getText().equals(""))
        {
            this.jLabel_Warning.setText("Hãy nhập số lượng của sản phẩm!");
            jTextField_SoLuongTon.setBorder(BorderFactory.createLineBorder(Color.red));
            this.jTextField_SoLuongTon.setToolTipText("Số lượng tồn của sản phẩm");
            return false;
        }
        try {
            int soLuongTon = Integer.parseInt(this.jTextField_SoLuongTon.getText());
            if(soLuongTon < 0)
            {
                jTextField_SoLuongTon.setBorder(BorderFactory.createLineBorder(Color.red));
                this.jLabel_Warning.setText("Số lượng tồn của sản phẩm phải là số nguyên dương!");
                return false;
            }
        } catch (Exception e) {
            jTextField_SoLuongTon.setBorder(BorderFactory.createLineBorder(Color.red));
            this.jLabel_Warning.setText("Số lượng tồn của sản phẩm phải là số nguyên dương!");
            return false;
        }
        if(this.jTextField_NhaCungCap.getText().equals(""))
        {
            this.jLabel_Warning.setText("Hãy nhập tên nhà cung cấp!");
            jTextField_NhaCungCap.setBorder(BorderFactory.createLineBorder(Color.red));
            this.jTextField_NhaCungCap.setToolTipText("Tên của nhà cung cấp");
            return false;
        }
        if(this.jTextField_GiaNhap.getText().equals(""))
        {
            this.jLabel_Warning.setText("Hãy nhập giá nhập hàng của sản phẩm!");
            jTextField_GiaNhap.setBorder(BorderFactory.createLineBorder(Color.red));
            this.jTextField_GiaNhap.setToolTipText("Giá nhập của sản phẩm");
            return false;
        }
        try {
            double giaNhap = Double.parseDouble(this.jTextField_GiaNhap.getText());
            if(giaNhap < 0)
            {
                jTextField_GiaNhap.setBorder(BorderFactory.createLineBorder(Color.red));
                this.jLabel_Warning.setText("Giá nhập của sản phẩm phải là số thực > 0!");
                return false;
            }
        } catch (Exception e) {
            jTextField_GiaNhap.setBorder(BorderFactory.createLineBorder(Color.red));
            this.jLabel_Warning.setText("Giá nhập của sản phẩm phải là số thực > 0!");
            return false;
        }
        
        if(this.jTextField_TacGia.getText().equals(""))
        {
            this.jLabel_Warning.setText("Hãy thêm tên của tác giả!");
            jTextField_TacGia.setBorder(BorderFactory.createLineBorder(Color.red));
            this.jTextField_TacGia.setToolTipText("Tên của tác giả");
            return false;
        }
        if(this.jTextField_TheLoai.getText().equals(""))
        {
            this.jLabel_Warning.setText("Hãy nhập thêm tên thể loại!");
            jTextField_TheLoai.setBorder(BorderFactory.createLineBorder(Color.red));
            this.jTextField_TheLoai.setToolTipText("Tên thể loại của sản phẩm");
            return false;
        }
        if(this.jTextField_DanhMuc.getText().equals(""))
        {
            this.jLabel_Warning.setText("Hãy nhập tên danh mục!");
            jTextField_DanhMuc.setBorder(BorderFactory.createLineBorder(Color.red));
            this.jTextField_DanhMuc.setToolTipText("Tên của danh mục");
            return false;
        }
        if(this.jTextField_NhaXuatBan.getText().equals(""))
        {
            this.jLabel_Warning.setText("Hãy nhập tên nhà xuất bản!");
            jTextField_NhaXuatBan.setBorder(BorderFactory.createLineBorder(Color.red));
            this.jTextField_NhaXuatBan.setToolTipText("Tên của sản phẩm");
            return false;
        }
        if(this.jTextField_Thue.getText().equals(""))
        {
            this.jLabel_Warning.setText("Hãy nhập thêm thuế của sản phẩm!");
            jTextField_Thue.setBorder(BorderFactory.createLineBorder(Color.red));
            this.jTextField_Thue.setToolTipText("Thuế của sản phẩm");
            return false;
        }
         try {
            double thue = Double.parseDouble(this.jTextField_Thue.getText());
            if(thue < 0)
            {
                jTextField_Thue.setBorder(BorderFactory.createLineBorder(Color.red));
                this.jLabel_Warning.setText("Thuế của sản phẩm phải là số thực > 0!");
                return false;
            }
        } catch (Exception e) {
            jTextField_Thue.setBorder(BorderFactory.createLineBorder(Color.red));
            this.jLabel_Warning.setText("Thuế của sản phẩm phải là số thực > 0!");
            return false;
        }
        
        if(this.txtNgay.getDate().toString().equals(""))
        {
            this.jLabel_Warning.setText("Hãy bổ sung ngày nhập");
            txtNgay.setBorder(BorderFactory.createLineBorder(Color.red));
            this.txtNgay.setToolTipText("Tên của sản phẩm");
            return false;
        }         
        return true;
    }
    private void jButton_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LuuActionPerformed
        if(!check_empty())
        {
            return;
        }
        try {                                            
            
            SanPham sanPham = getNewSanPham();
            sanPham.setTinhTrang("CON_HANG");
            sanPham.setLoaiSanPham("SACH");
            sanPham.setThuongHieu(new ThuongHieu(1));
            SanPham_BUS sanPham_BUS = new SanPham_BUS();
  
            sanPham_BUS.addSanPham(sanPham);
            
            this.setVisible(false);
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
    }//GEN-LAST:event_jButton_LuuActionPerformed

    private void jTextField_DonViDoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DonViDoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DonViDoLuongActionPerformed

    private void jTextField1_NamSanXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1_NamSanXuatMouseClicked
        // TODO add your handling code here:
        this.jTextField1_NamSanXuat.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel_Warning.setText("");
    }//GEN-LAST:event_jTextField1_NamSanXuatMouseClicked

    private void jTextField_KichThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_KichThuocMouseClicked
        // TODO add your handling code here:
        this.jTextField_KichThuoc.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel_Warning.setText("");
    }//GEN-LAST:event_jTextField_KichThuocMouseClicked

    private void jTextField_XuatXuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_XuatXuMouseClicked
        // TODO add your handling code here:
        this.jTextField_XuatXu.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel_Warning.setText("");
    }//GEN-LAST:event_jTextField_XuatXuMouseClicked

    private void jTextField_NgonNguMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_NgonNguMouseClicked
        // TODO add your handling code here:
        this.jTextField_NgonNgu.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel_Warning.setText("");
    }//GEN-LAST:event_jTextField_NgonNguMouseClicked

    private void txtNgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgayMouseClicked
        // TODO add your handling code here:
        this.txtNgay.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel_Warning.setText("");
    }//GEN-LAST:event_txtNgayMouseClicked

    private void jTextField_SoTrangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_SoTrangMouseClicked
        // TODO add your handling code here:
        this.jTextField_SoTrang.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel_Warning.setText("");
    }//GEN-LAST:event_jTextField_SoTrangMouseClicked

    private void jTextField_DonViDoLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_DonViDoLuongMouseClicked
        // TODO add your handling code here:
        this.jTextField_DonViDoLuong.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel_Warning.setText("");
    }//GEN-LAST:event_jTextField_DonViDoLuongMouseClicked

    private void jTextField_LoaiBiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_LoaiBiaMouseClicked
        // TODO add your handling code here:
        this.jTextField_LoaiBia.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel_Warning.setText("");
    }//GEN-LAST:event_jTextField_LoaiBiaMouseClicked

    private void jTextField_GiaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_GiaNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_GiaNhapActionPerformed

    private void jTextField_GiaNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_GiaNhapMouseClicked
        // TODO add your handling code here:
        this.jTextField_GiaNhap.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel_Warning.setText("");

    }//GEN-LAST:event_jTextField_GiaNhapMouseClicked

    private void jTextField_DanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_DanhMucMouseClicked
        // TODO add your handling code here:
        this.jTextField_DanhMuc.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel_Warning.setText("");

        comboBox_DM = new JComboBox<String>();
        for(String string : dm_name)
        {
            comboBox_DM.addItem(string);
        }

        this.jPanel_CBB_DanhMuc.add(comboBox_DM);
        //comboBox_NCC.showPopup();
        comboBox_DM.setPopupVisible(true);
        comboBox_DM.removeAll();
        comboBox_DM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    jTextField_DanhMuc.setText(comboBox_DM.getSelectedItem().toString());
                    comboBox_DM.removeAllItems();
                    //            comboBox.hidePopup();
                    jPanel_CBB_DanhMuc.removeAll();
                } catch (Exception e) {
                }
            }
        });
    }//GEN-LAST:event_jTextField_DanhMucMouseClicked

    private void jTextField_TheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TheLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TheLoaiActionPerformed

    private void jTextField_TheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_TheLoaiMouseClicked
        // TODO add your handling code here:
        this.jTextField_TheLoai.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel_Warning.setText("");
        comboBox_TL = new JComboBox<String>();
        for(String string : tl_name)
        {
            comboBox_TL.addItem(string);
        }

        this.jPanel_CBB_TheLoai.add(comboBox_TL);
        //comboBox_NCC.showPopup();
        comboBox_TL.setPopupVisible(true);
        comboBox_TL.removeAll();
        comboBox_TL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    jTextField_TheLoai.setText(comboBox_TL.getSelectedItem().toString());
                    comboBox_TL.removeAllItems();
                    //            comboBox.hidePopup();
                    jPanel_CBB_TheLoai.removeAll();
                } catch (Exception e) {
                }
            }
        });
    }//GEN-LAST:event_jTextField_TheLoaiMouseClicked

    private void jTextField_TacGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_TacGiaMouseClicked
        this.jTextField_TacGia.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel_Warning.setText("");
        comboBox_TG = new JComboBox<String>();
        for(String string : tg_name)
        {
            comboBox_TG.addItem(string);
        }

        this.jPanel_CBB_TacGia.add(comboBox_TG);
        //comboBox_NCC.showPopup();
        comboBox_TG.setPopupVisible(true);
        comboBox_TG.removeAll();
        comboBox_TG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    jTextField_TacGia.setText(comboBox_TG.getSelectedItem().toString());
                    comboBox_TG.removeAllItems();
                    //            comboBox.hidePopup();
                    jPanel_CBB_TacGia.removeAll();
                } catch (Exception e) {
                }
            }
        });
    }//GEN-LAST:event_jTextField_TacGiaMouseClicked

    private void jTextField_NhaXuatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_NhaXuatBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_NhaXuatBanActionPerformed

    private void jTextField_NhaXuatBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_NhaXuatBanMouseClicked
        // TODO add your handling code here:
        this.jTextField_NhaXuatBan.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel_Warning.setText("");
        comboBox_NXB = new JComboBox<String>();
        for(String string : nxb_name)
        {
            comboBox_NXB.addItem(string);
        }

        this.jPanel_CBB_NhaXuatBan.add(comboBox_NXB);
        //comboBox_NCC.showPopup();
        comboBox_NXB.setPopupVisible(true);
        comboBox_NXB.removeAll();
        comboBox_NXB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    jTextField_NhaXuatBan.setText(comboBox_NXB.getSelectedItem().toString());
                    comboBox_NXB.removeAllItems();
                    //            comboBox.hidePopup();
                    jPanel_CBB_NhaXuatBan.removeAll();
                } catch (Exception e) {
                }
            }
        });
    }//GEN-LAST:event_jTextField_NhaXuatBanMouseClicked

    private void jTextField_NhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_NhaCungCapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_NhaCungCapActionPerformed

    private void jTextField_NhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_NhaCungCapMouseClicked
        // TODO add your handling code here:
        this.jTextField_NhaCungCap.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel_Warning.setText("");
        comboBox_NCC = new JComboBox<String>();
        for(String string : ncc_name)
        {
            comboBox_NCC.addItem(string);
        }

        this.jPanel_CBB_NhaCungCap.add(comboBox_NCC);
        //comboBox_NCC.showPopup();
        comboBox_NCC.setPopupVisible(true);
        comboBox_NCC.removeAll();
        comboBox_NCC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    jTextField_NhaCungCap.setText(comboBox_NCC.getSelectedItem().toString());
                    comboBox_NCC.removeAllItems();
                    //            comboBox.hidePopup();
                    jPanel_CBB_NhaCungCap.removeAll();
                } catch (Exception e) {
                }
            }
        });

    }//GEN-LAST:event_jTextField_NhaCungCapMouseClicked

    private void jTextField_ThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_ThueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_ThueActionPerformed

    private void jTextField_ThueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_ThueMouseClicked
        // TODO add your handling code here:
        this.jTextField_Thue.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel_Warning.setText("");
    }//GEN-LAST:event_jTextField_ThueMouseClicked

    private void jTextField_SoLuongTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_SoLuongTonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_SoLuongTonActionPerformed

    private void jTextField_SoLuongTonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_SoLuongTonMouseClicked
        // TODO add your handling code here:
        this.jTextField_SoLuongTon.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel_Warning.setText("");
    }//GEN-LAST:event_jTextField_SoLuongTonMouseClicked

    private void jTextField_BarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_BarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_BarcodeActionPerformed

    private void jTextField_BarcodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_BarcodeMouseClicked
        // TODO add your handling code here:
        this.jTextField_Barcode.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel_Warning.setText("");
    }//GEN-LAST:event_jTextField_BarcodeMouseClicked

    private void jTextField_TenSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TenSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TenSanPhamActionPerformed

    private void jTextField_TenSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_TenSanPhamMouseClicked
        // TODO add your handling code here:
        this.jTextField_TenSanPham.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel_Warning.setText("");
    }//GEN-LAST:event_jTextField_TenSanPhamMouseClicked

    private void jButton_ChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ChonActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser;
        BufferedImage img = null;
        chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        file = chooser.getSelectedFile();
        try {
            img = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Image newimg = img.getScaledInstance(140, 170,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        System.out.println(newimg.toString());
        ImageIcon icon = new ImageIcon(newimg);
        jLabel_ImgChooser.setIcon(icon);

    }//GEN-LAST:event_jButton_ChonActionPerformed
    
    public SanPham getNewSanPham()
    {
        String tenSanPham = jTextField_TenSanPham.getText();
        int soLuongTon = Integer.parseInt(jTextField_SoLuongTon.getText());
        String barcode = jTextField_Barcode.getText();
        double giaNhap = Double.parseDouble(jTextField_GiaNhap.getText());
        
        double thue = Double.parseDouble(jTextField_Thue.getText());
        int namSanXuat;
        try {
            namSanXuat = Integer.parseInt(jTextField1_NamSanXuat.getText());
        } catch (Exception e) {
            namSanXuat = 1;
        }
        String donViDoLuong;
        try {
            donViDoLuong = jTextField_DonViDoLuong.getText();
        } catch (Exception e) {
            donViDoLuong = "";
        }
        String kichThuoc;
        try {
            kichThuoc = jTextField_KichThuoc.getText();
        } catch (Exception e) {
            kichThuoc = "";
        }
        String xuatXu;
        try {
            xuatXu = jTextField_XuatXu.getText();
        } catch (Exception e) {
            xuatXu = "";
        }
        String ngonNgu;
        try {
            ngonNgu = jTextField_NgonNgu.getText();
        } catch (Exception e) {
            ngonNgu = "";
        }
        int soTrang;
        try {
            soTrang = Integer.parseInt(jTextField_SoTrang.getText());
        } catch (Exception e) {
            soTrang = 1;
        }
        String loaiBia;
        try {
            loaiBia = jTextField_LoaiBia.getText();
        } catch (Exception e) {
            loaiBia = "";
        }
        
        String loaiDoiTra = jComboBox_LoaiDoiTra.getSelectedItem().toString();
        
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
        String date = dcn.format(txtNgay.getDate());
        Date DATE = Date.valueOf(date);
       
        

        String partialPath;
         try {
            String filePath = this.file.getPath();
            partialPath = filePath.substring(filePath.indexOf("img\\products"));
        } catch (Exception e) {
            partialPath = "";
        }

        
        NhaCungCap ncc = new NhaCungCap();
        TheLoai tl = new TheLoai();
        NhaXuatBan nxb = new NhaXuatBan();
        DanhMuc dm = new DanhMuc();
        TacGia tg = new TacGia();
        ThuongHieu th = new ThuongHieu();
        
        String tenTacGia = jTextField_TacGia.getText();
        String tenNhaCungCap = jTextField_NhaCungCap.getText();
        String tenTheLoai = jTextField_TheLoai.getText();
        String tenNhaXuatBan = jTextField_NhaXuatBan.getText();
        String tenDanhMuc = jTextField_DanhMuc.getText();


       
        try {
            ncc.setTenNhaCungCap(tenNhaCungCap);
            tl.setTenTheLoai(tenTheLoai);
            nxb.setTenNhaXuatBan(tenNhaXuatBan);
            dm.setTenDanhMuc(tenDanhMuc);
            tg.setTenTacGia(tenTacGia);

        } catch (Exception e) {
           
            e.printStackTrace();
        }
        
        SanPham_BUS sanPham_BUS = new  SanPham_BUS();
        
        ncc.setNhaCungCapID(sanPham_BUS.getIdNhaCungCapByName(ncc.getTenNhaCungCap()));
        if (ncc.getNhaCungCapID().equals("")) {
            int check = JOptionPane.showConfirmDialog(null, "Nhà cung cấp này vốn chưa có sẳn. Tạo mới?");
            if (check == 0) {
                NhaCungCap_BUS nhaCungCap_BUS = new NhaCungCap_BUS();
                nhaCungCap_BUS.addNhaCungCap(ncc);
                ncc.setNhaCungCapID(sanPham_BUS.getIdNhaCungCapByName(ncc.getTenNhaCungCap()));
            }
        }
        
        tl.setTheLoaiID(sanPham_BUS.getIdTheloaiByName(tl.getTenTheLoai()));
        if (tl.getTheLoaiID() == -1) {
            int check = JOptionPane.showConfirmDialog(null, "Tên thể loại này vốn chưa có sẳn. Tạo mới?");
            if (check == 0) {
                TheLoai_BUS theLoai_BUS = new TheLoai_BUS();
                theLoai_BUS.addTheLoai(tl);
                tl.setTheLoaiID(sanPham_BUS.getIdTheloaiByName(tl.getTenTheLoai()));
            }
        }

        nxb.setNhaXuatBanID(sanPham_BUS.getIdNhaXuatBanByName(nxb.getTenNhaXuatBan()));
        if (nxb.getNhaXuatBanID() == -1) {
            int check = JOptionPane.showConfirmDialog(null, "Tên nhà xuất bản này vốn chưa có sẳn. Tạo mới?");
            if (check == 0) {
                NhaXuatBan_BUS nhaXuatBan_BUS = new NhaXuatBan_BUS();
                nhaXuatBan_BUS.addNhaXuatBan(nxb);
                nxb.setNhaXuatBanID(sanPham_BUS.getIdNhaXuatBanByName(nxb.getTenNhaXuatBan()));
            }
        }
        
        dm.setDanhMucID(sanPham_BUS.getIdDanhMucByName(dm.getTenDanhMuc()));
        if (dm.getDanhMucID() == -1) {
            int check = JOptionPane.showConfirmDialog(null, "Tên danh mục này vốn chưa có sẳn. Tạo mới?");
            if (check == 0) {
                DanhMuc_BUS DanhMuc_BUS = new DanhMuc_BUS();
                DanhMuc_BUS.addDanhMuc(dm);
                dm.setDanhMucID(sanPham_BUS.getIdDanhMucByName(dm.getTenDanhMuc()));
            }
        }

        tg.setTacGiaID(sanPham_BUS.getIdTacGiaByName(tg.getTenTacGia()));
        if (tg.getTacGiaID()== -1) {
            int check = JOptionPane.showConfirmDialog(null, "Tên tác giả này vốn chưa có sẳn. Tạo mới?");
            if (check == 0) {
                TacGia_BUS tacGia_BUS = new TacGia_BUS();
                tacGia_BUS.addTacGia(tg);
                tg.setTacGiaID(sanPham_BUS.getIdTacGiaByName(tg.getTenTacGia()));
            }
        }


        SanPham sanPham = new SanPham();
        try {
           sanPham.setTenSanPham(tenSanPham);
            sanPham.setSoLuongTon(soLuongTon);
            sanPham.setBarcode(barcode);
            sanPham.setGiaNhap(giaNhap);
//            if (tinhTrang.equalsIgnoreCase("Còn hàng")) {
//            	tinhTrang = "CON_HANG";
//            	
//            } else if (tinhTrang.equalsIgnoreCase("Hết hàng")) {
//            	tinhTrang = "HET_HANG";
//            }else {
//            	tinhTrang = "NGUNG_KINH_DOANH";
//            }
//            sanPham.setTinhTrang(tinhTrang);
            sanPham.setThue(thue);
            sanPham.setNamSanXuat(namSanXuat);
            sanPham.setDonViDoLuong(donViDoLuong);
            sanPham.setKichThuoc(kichThuoc);
            sanPham.setXuatXu(xuatXu);
            sanPham.setNgonNgu(ngonNgu);
            sanPham.setSoTrang(soTrang);
            sanPham.setLoaiBia(loaiBia);
            sanPham.setLoaiDoiTra(loaiDoiTra.equalsIgnoreCase("Được đổi trả") ? "DUOC_DOI_TRA" : "KHONG_DOI_TRA");
            sanPham.setNgayNhap(DATE);
            sanPham.setImgPath(partialPath);
            
            sanPham.setTacGia(tg);
            sanPham.setTheLoai(tl);
            sanPham.setNhaCungCap(ncc);
            sanPham.setDanhMuc(dm);
            sanPham.setNhaXuatBan(nxb);
            sanPham.setThuongHieu(th);
            
        } catch (Exception ex) {
           
            ex.printStackTrace();
        }
        return sanPham;
    }
    

    
    public void setSanPhamSach(SanPham x)
    {
 
        SanPham_BUS sanPham_BUS = new SanPham_BUS();
        ID = x.getSanPhamID();
        try {
            ImageIcon imageIcon = new ImageIcon("src/" + x.getImgPath()); // load the image to a imageIcon

            Image image = imageIcon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(140, 170,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            imageIcon = new ImageIcon(newimg); 
            this.jLabel_ImgChooser.setIcon(imageIcon);
        } catch (Exception e) {
            this.jLabel_ImgChooser.setText("NO IMAGE");
        }
        
        this.jTextField_TenSanPham.setText(x.getTenSanPham());
        this.jTextField_SoLuongTon.setText(x.getSoLuongTon() + "");
        this.jTextField_TacGia.setText(sanPham_BUS.getNameTacGiaByID(x.getTacGia().getTacGiaID()));
     
        this.jTextField_Barcode.setText(x.getBarcode());
        this.jTextField_NhaCungCap.setText(x.getNhaCungCap().getTenNhaCungCap());
        this.jTextField_GiaNhap.setText(x.getGiaNhap() + "");
        this.jTextField_Thue.setText(x.getThue() + "");
        this.jTextField_TheLoai.setText(x.getTheLoai().getTenTheLoai());
        this.jTextField1_NamSanXuat.setText(x.getNamSanXuat() + "");

        this.jTextField_DonViDoLuong.setText(x.getDonViDoLuong());
        this.jTextField_KichThuoc.setText(x.getKichThuoc());
        this.jTextField_XuatXu.setText(x.getXuatXu());
        this.jTextField_NgonNgu.setText(x.getNgonNgu());
        this.jTextField_NhaXuatBan.setText(sanPham_BUS.getNameNhaXuatBanByID(x.getNhaXuatBan().getNhaXuatBanID()));
        this.jTextField_DanhMuc.setText(sanPham_BUS.getNameDanhMucByID(x.getDanhMuc().getDanhMucID()));
        this.jTextField_TheLoai.setText(sanPham_BUS.getNameTheLoaiByID(x.getTheLoai().getTheLoaiID()));
        this.jTextField_NhaCungCap.setText(sanPham_BUS.getNameNhaCungCapByID(x.getNhaCungCap().getNhaCungCapID()));

        this.jTextField_SoTrang.setText(x.getSoTrang()+"");
        this.jTextField_LoaiBia.setText(x.getLoaiBia());
        if(x.getLoaiDoiTra().equals("DUOC_DOI_TRA"))
        {
            this.jComboBox_LoaiDoiTra.setSelectedIndex(0);
        }
        if(x.getLoaiDoiTra().equals("KHONG_DOI_TRA"))
        {
            this.jComboBox_LoaiDoiTra.setSelectedIndex(1);
        }
        this.txtNgay.setDate(x.getNgayNhap());
        
        comboBox_NCC.removeAllItems();
        jPanel_CBB_NhaCungCap.removeAll();
        comboBox_TG.removeAllItems();
        jPanel_CBB_TacGia.removeAll();
        comboBox_TL.removeAllItems();
        jPanel_CBB_TheLoai.removeAll();
        comboBox_NXB.removeAllItems();
        jPanel_CBB_NhaXuatBan.removeAll();
        comboBox_DM.removeAllItems();
        jPanel_CBB_DanhMuc.removeAll();
       
    }
    /**
     * @param args the command line arguments
     */
    
    public void disVisibleForLuu()
    {
        this.jButton_Sua.setBackground(new Color(204,204,204));
        this.jButton_Sua.setEnabled(false);
     
    }
    
    public void disVisibleForSua()
    {
        this.jButton_Luu.setBackground(new Color(204,204,204));
        this.jButton_Luu.setEnabled(false);
     
    }
    
    private javax.swing.JComboBox<String> comboBox_NCC;
    private javax.swing.JComboBox<String> comboBox_TL;
    private javax.swing.JComboBox<String> comboBox_TG;
    private javax.swing.JComboBox<String> comboBox_NXB;
    private javax.swing.JComboBox<String> comboBox_DM;
    
    
    
    private String[] arr = {"Huy1", "Nuy2", "Huy3"};
    
    private class TextFieldCaretListener_NCC implements CaretListener
    {
        @Override
        public void caretUpdate(CaretEvent e) {
            try{
                comboBox_NCC.removeAllItems();
//                comboBox.hidePopup();
                comboBox_NCC.setVisible(true);
                jPanel_CBB_NhaCungCap.remove(comboBox_NCC);
                if(e.getMark() > 0)
                {
                    for(String string : ncc_name)
                    {
                        if(string.toLowerCase().startsWith(jTextField_NhaCungCap.getText().toLowerCase()))
                        {
                            jPanel_CBB_NhaCungCap.add(comboBox_NCC);
                            comboBox_NCC.addItem(string);
                            comboBox_NCC.setMinimumSize(new Dimension(200, 25));
                            comboBox_NCC.showPopup();
                        }
                    }
                }
            }catch(Exception e1)
            {
                
            }

            if(e.getMark() < 2)
            {
                jPanel_CBB_NhaCungCap.removeAll();
            }
            
        }
        
    }
    
    private class TextFieldCaretListener_TG implements CaretListener
    {
        @Override
        public void caretUpdate(CaretEvent e) {
            try{
                comboBox_TG.removeAllItems();
//                comboBox.hidePopup();
                comboBox_TG.setVisible(true);
                jPanel_CBB_TacGia.remove(comboBox_TG);
                if(e.getMark() > 0)
                {
                    for(String string : tg_name)
                    {
                        if(string.toLowerCase().startsWith(jTextField_TacGia.getText().toLowerCase()))
                        {
                            jPanel_CBB_TacGia.add(comboBox_TG);
                            comboBox_TG.addItem(string);
                            comboBox_TG.showPopup();
                        }
                    }
                }
            }catch(Exception e1)
            {
                
            }
            if(e.getMark() < 2)
            {
                jPanel_CBB_TacGia.removeAll();
            }
            
        }
        
    }
    
    private class TextFieldCaretListener_NXB implements CaretListener
    {
        @Override
        public void caretUpdate(CaretEvent e) {
            try{
                comboBox_NXB.removeAllItems();
//                comboBox.hidePopup();
                comboBox_NXB.setVisible(true);
                jPanel_CBB_NhaXuatBan.remove(comboBox_NXB);
                if(e.getMark() > 0)
                {
                    for(String string : nxb_name)
                    {
                        if(string.toLowerCase().startsWith(jTextField_NhaXuatBan.getText().toLowerCase()))
                        {
                            jPanel_CBB_NhaXuatBan.add(comboBox_NXB);
                            comboBox_NXB.addItem(string);
                            comboBox_NXB.showPopup();
                        }
                    }
                }
            }catch(Exception e1)
            {
                
            }
            if(e.getMark() < 2)
            {
                jPanel_CBB_NhaXuatBan.removeAll();
            }
            
        }
        
    }
    private class TextFieldCaretListener_DM implements CaretListener
    {
        @Override
        public void caretUpdate(CaretEvent e) {
            try{
                comboBox_DM.removeAllItems();
//                comboBox.hidePopup();
                comboBox_DM.setVisible(true);
                jPanel_CBB_DanhMuc.remove(comboBox_DM);
                if(e.getMark() > 0)
                {
                    for(String string : dm_name)
                    {
                        if(string.toLowerCase().startsWith(jTextField_DanhMuc.getText().toLowerCase()))
                        {
                            jPanel_CBB_DanhMuc.add(comboBox_DM);
                            comboBox_DM.addItem(string);
                            comboBox_DM.showPopup();
                        }
                    }
                }
            }catch(Exception e1)
            {
                
            }
            if(e.getMark() < 2)
            {
                jPanel_CBB_DanhMuc.removeAll();
            }
            
        }
        
    }
    
    private class TextFieldCaretListener_TL implements CaretListener
    {
        @Override
        public void caretUpdate(CaretEvent e) {
            try{
                comboBox_TL.removeAllItems();
//                comboBox.hidePopup();
                comboBox_TL.setVisible(true);
                jPanel_CBB_TheLoai.remove(comboBox_TL);
                if(e.getMark() > 0)
                {
                    for(String string : tl_name)
                    {
                        if(string.toLowerCase().startsWith(jTextField_TheLoai.getText().toLowerCase()))
                        {
                            jPanel_CBB_TheLoai.add(comboBox_TL);
                            comboBox_TL.addItem(string);
                            comboBox_TL.showPopup();
                        }
                    }
                }
            }catch(Exception e1)
            {
                
            }
            if(e.getMark() < 2)
            {
                jPanel_CBB_TheLoai.removeAll();
            }
            
        }
        
    }
    
    
    

    private int ID;
    private File file;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler24;
    private javax.swing.Box.Filler filler25;
    private javax.swing.Box.Filler filler26;
    private javax.swing.Box.Filler filler28;
    private javax.swing.Box.Filler filler29;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler30;
    private javax.swing.Box.Filler filler31;
    private javax.swing.Box.Filler filler33;
    private javax.swing.Box.Filler filler34;
    private javax.swing.Box.Filler filler35;
    private javax.swing.Box.Filler filler36;
    private javax.swing.Box.Filler filler37;
    private javax.swing.Box.Filler filler38;
    private javax.swing.Box.Filler filler39;
    private javax.swing.Box.Filler filler40;
    private javax.swing.Box.Filler filler41;
    private javax.swing.Box.Filler filler42;
    private javax.swing.Box.Filler filler43;
    private javax.swing.Box.Filler filler44;
    private javax.swing.Box.Filler filler45;
    private javax.swing.Box.Filler filler46;
    private javax.swing.JButton jButton_Chon;
    private javax.swing.JButton jButton_Huy;
    private javax.swing.JButton jButton_Luu;
    private javax.swing.JButton jButton_Sua;
    private javax.swing.JComboBox<String> jComboBox_LoaiDoiTra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_Barcode;
    private javax.swing.JLabel jLabel_DonViDoLuong1;
    private javax.swing.JLabel jLabel_GiaNhap;
    private javax.swing.JLabel jLabel_Img;
    private javax.swing.JLabel jLabel_Img1;
    private javax.swing.JLabel jLabel_ImgChooser;
    private javax.swing.JLabel jLabel_KichThuoc;
    private javax.swing.JLabel jLabel_LoaiBia;
    private javax.swing.JLabel jLabel_NamSanXuat;
    private javax.swing.JLabel jLabel_NgayNhap;
    private javax.swing.JLabel jLabel_NgonNgu;
    private javax.swing.JLabel jLabel_NhaCungCap;
    private javax.swing.JLabel jLabel_SoLuongTon;
    private javax.swing.JLabel jLabel_SoLuongTon2;
    private javax.swing.JLabel jLabel_SoLuongTon3;
    private javax.swing.JLabel jLabel_SoLuongTon5;
    private javax.swing.JLabel jLabel_SoTrang;
    private javax.swing.JLabel jLabel_SoTrang1;
    private javax.swing.JLabel jLabel_TacGia;
    private javax.swing.JLabel jLabel_Thue1;
    private javax.swing.JLabel jLabel_Warning;
    private javax.swing.JLabel jLabel_XuatXu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_CBB_Barcode;
    private javax.swing.JPanel jPanel_CBB_DanhMuc;
    private javax.swing.JPanel jPanel_CBB_NhaCungCap;
    private javax.swing.JPanel jPanel_CBB_NhaXuatBan;
    private javax.swing.JPanel jPanel_CBB_SoLuongTon;
    private javax.swing.JPanel jPanel_CBB_TacGia;
    private javax.swing.JPanel jPanel_CBB_TenSanPham;
    private javax.swing.JPanel jPanel_CBB_TheLoai;
    private javax.swing.JPanel jPanel_GiaNhap;
    private javax.swing.JPanel jPanel_NhaXuatban;
    private javax.swing.JPanel jPanel_Title;
    private javax.swing.JPanel jPanel_Title1;
    private javax.swing.JPanel jPanel_Title2;
    private javax.swing.JTextField jTextField1_NamSanXuat;
    private javax.swing.JTextField jTextField_Barcode;
    private javax.swing.JTextField jTextField_DanhMuc;
    private javax.swing.JTextField jTextField_DonViDoLuong;
    private javax.swing.JTextField jTextField_GiaNhap;
    private javax.swing.JTextField jTextField_KichThuoc;
    private javax.swing.JTextField jTextField_LoaiBia;
    private javax.swing.JTextField jTextField_NgonNgu;
    private javax.swing.JTextField jTextField_NhaCungCap;
    private javax.swing.JTextField jTextField_NhaXuatBan;
    private javax.swing.JTextField jTextField_SoLuongTon;
    private javax.swing.JTextField jTextField_SoTrang;
    private javax.swing.JTextField jTextField_TacGia;
    private javax.swing.JTextField jTextField_TenSanPham;
    private javax.swing.JTextField jTextField_TheLoai;
    private javax.swing.JTextField jTextField_Thue;
    private javax.swing.JTextField jTextField_XuatXu;
    private com.toedter.calendar.JDateChooser txtNgay;
    // End of variables declaration//GEN-END:variables


 
}