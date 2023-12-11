/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import bus.DanhMuc_BUS;
import bus.NhaCungCap_BUS;
import bus.NhaXuatBan_BUS;
import bus.SanPham_BUS;
import bus.ThuongHieu_BUS;
import connectDB.ConnectDB;
import entities.DanhMuc;
import entities.NhaCungCap;
import entities.NhaXuatBan;
import entities.SanPham;
import entities.TacGia;
import entities.TheLoai;
import entities.ThuongHieu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utilities.ImageProcessing;

/**
 *
 * @author duong
 */
public class TAB_SanPham extends javax.swing.JPanel {



    /**
     * Creates new form TAB_SanPham
     */
    public TAB_SanPham() {

        initComponents();
        SanPham_BUS sanPham_BUS = new SanPham_BUS();
        ArrayList<SanPham> list_SanPham = sanPham_BUS.getDanhSachSanPham();
        loadSanPham(list_SanPham);

//        this.jPanel_CBB_TenSanPham.removeAll();
//        comboBox = new JComboBox<String>();
//        this.jPanel_CBB_TenSanPham.add(comboBox);
//        this.jTextField_TenSanPham.addCaretListener(new TextFieldCaretListener());
//        
//        comboBox.removeAll();
//        
//        comboBox.addActionListener(new ActionListener() {
//        public void actionPerformed(ActionEvent arg0) {
//        try {
//            jTextField_TenSanPham.setText(comboBox.getSelectedItem().toString());
//            comboBox.removeAllItems();
//            comboBox.hidePopup();
//            jPanel_CBB_TenSanPham.removeAll();
//            } catch (Exception e) {
//            }
//        }
//        });
    }
    int dem_sach = 0;
    int dem_spk = 0;

    public void loadSanPham(ArrayList<SanPham> list_SanPham) {
        int dem_sach_SoLuong = 0;
        int dem_spk_SoLuong = 0;
        DanhMuc_BUS danhMuc_BUS = new DanhMuc_BUS();
        ArrayList<DanhMuc> list_danhMuc = new DanhMuc_BUS().getAllDanhMuc();
        jComboBox_DanhMuc.addItem("Tất cả");
        for (DanhMuc dm : list_danhMuc) {
            this.jComboBox_DanhMuc.addItem(dm.getTenDanhMuc().toString());
        }
        NhaXuatBan_BUS nhaXuatBan_BUS = new NhaXuatBan_BUS();
        ArrayList<NhaXuatBan> list_nhaXuatBan = nhaXuatBan_BUS.getAllNhaXuatBan();
        jComboBox_NhaXuatBan.addItem("Tất cả");
        for (NhaXuatBan nhaXuatBan : list_nhaXuatBan) {
            this.jComboBox_NhaXuatBan.addItem(nhaXuatBan.getTenNhaXuatBan().toString());
        }
        ThuongHieu_BUS thuongHieu_BUS = new ThuongHieu_BUS();
        ArrayList<ThuongHieu> list_ThuongHieu = thuongHieu_BUS.getAllThuongHieu();
        jComboBox_ThuongHieu.addItem("Tất cả");
        for (ThuongHieu thuongHieu : list_ThuongHieu) {
            this.jComboBox_ThuongHieu.addItem(thuongHieu.getTenThuongHieu().toString());
        }
        jComboBox_TrangThai.setSelectedIndex(0);
        jComboBox_SapXepTheo.setSelectedIndex(0);
        jComboBox_SapXepTheo1.setSelectedIndex(0);
        jComboBox_TrangThai_SPK.setSelectedIndex(0);
//       
        jPanel_Empty1.setBackground(new Color(242, 242, 242));
        jPanel_Empty2.setBackground(new Color(242, 242, 242));

        jPanel_Empty3.setBackground(new Color(242, 242, 242));
        jPanel_Empty4.setBackground(new Color(242, 242, 242));

//            jPanel_Empty1.setPreferredSize(new Dimension(400, 10));
//            jPanel_Empty2.setPreferredSize(new Dimension(400, 10));
        jPanel_Empty1.setMaximumSize(new Dimension(410, 235));
        jPanel_Empty2.setMaximumSize(new Dimension(410, 235));

        jPanel_Empty3.setMaximumSize(new Dimension(411, 190));
        jPanel_Empty4.setMaximumSize(new Dimension(411, 190));

        box_SP.removeAll();
        box_SPK.removeAll();
        int i = 100;
        int j = 100;

        for (SanPham sanPham : list_SanPham) {
            if (sanPham.getLoaiSanPham().equals("SACH")) {
                dem_sach_SoLuong++;
                if(dem_sach_SoLuong > 100)
                {
                    break;
                }
                TAB_ChiTietSanPham_Sach jPanel_New_SanPham = new TAB_ChiTietSanPham_Sach(sanPham);
                if (dem_sach == 0) {
                    box_SP.add(jPanel_New_SanPham);
                    jPanel_Empty1.setVisible(true);
                    jPanel_Empty2.setVisible(true);
                    box_SP.add(jPanel_Empty1);
                    box_SP.add(jPanel_Empty2);

                    jPanel_List_SanPham.setPreferredSize(new Dimension(500, i += 250));
                    jPanel_List_SanPham.add(box_SP);
                    ++dem_sach;

                } else {
                    if (dem_sach == 2) {

                        //                box = new Box(BoxLayout.X_AXIS);
                        //box.remove(jPanel_Empty1);
                        jPanel_Empty1.setVisible(false);
                        box_SP.add(jPanel_New_SanPham);

                        //box.add(jPanel_New_SanPham);
                        box_SP = new Box(BoxLayout.X_AXIS);
                        Row_Sach++;
                        jPanel_List_SanPham.add(box_SP);
                        dem_sach = 0;

                    } else if (dem_sach == 1) {

//                box.remove(jPanel_Empty1);
//                box.remove(jPanel_Empty2);
                        jPanel_Empty1.setVisible(false);
                        jPanel_Empty2.setVisible(false);

                        box_SP.add(jPanel_New_SanPham);

                        jPanel_Empty1.setVisible(true);
                        box_SP.add(jPanel_Empty1);

                        jPanel_List_SanPham.add(box_SP);

                        ++dem_sach;

                    }
                }
            }
        }
        this.revalidate();

        for (SanPham sanPham : list_SanPham) {
            if (sanPham.getLoaiSanPham().equals("SAN_PHAM_KHAC")) {
                dem_spk_SoLuong++;
                if(dem_spk_SoLuong > 100)
                {
                    break;
                }
                TAB_ChiTietSanPham_SanPhamKhac jPanel_New_SanPhamKhac = new TAB_ChiTietSanPham_SanPhamKhac(sanPham);
                if (dem_spk == 0) {
                    box_SPK.add(jPanel_New_SanPhamKhac);
                    jPanel_Empty3.setVisible(true);
                    jPanel_Empty4.setVisible(true);
                    box_SPK.add(jPanel_Empty3);
                    box_SPK.add(jPanel_Empty4);

                    jPanel_List_SanPham1.setPreferredSize(new Dimension(500, j += 190));
                    jPanel_List_SanPham1.add(box_SPK);
                    ++dem_spk;

                } else {
                    if (dem_spk == 2) {

                        //                box = new Box(BoxLayout.X_AXIS);
                        //box.remove(jPanel_Empty1);
                        jPanel_Empty3.setVisible(false);
                        box_SPK.add(jPanel_New_SanPhamKhac);

                        //box.add(jPanel_New_SanPham);
                        box_SPK = new Box(BoxLayout.X_AXIS);
                        Row_SPK++;
                        jPanel_List_SanPham1.add(box_SPK);
                        dem_spk = 0;

                    } else if (dem_spk == 1) {

//                box.remove(jPanel_Empty1);
//                box.remove(jPanel_Empty2);
                        jPanel_Empty3.setVisible(false);
                        jPanel_Empty4.setVisible(false);

                        box_SPK.add(jPanel_New_SanPhamKhac);

                        jPanel_Empty3.setVisible(true);
                        box_SPK.add(jPanel_Empty3);

                        jPanel_List_SanPham1.add(box_SPK);

                        ++dem_spk;

                    }
                }
            }
        }
        this.revalidate();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    public void refresh() {
        // TODO add your handling code here:
        this.jPanel_List_SanPham.removeAll();
        this.jPanel_List_SanPham1.removeAll();

        jComboBox_DanhMuc.removeAllItems();
        jComboBox_NhaXuatBan.removeAllItems();
        jComboBox_ThuongHieu.removeAllItems();
        dem_sach = 0;
        dem_spk = 0;

        SanPham_BUS sanPham_BUS = new SanPham_BUS();
        ArrayList<SanPham> list_SanPham = sanPham_BUS.getDanhSachSanPham();
        this.jTextField_TimKiem.setText("");
        this.jTextField_TimKiem1.setText("");

        //this.revalidate();
        this.repaint();
//
        loadSanPham(list_SanPham);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel_Sach = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton_ThemSanPham = new javax.swing.JButton();
        jButton_Import = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_TimKiem = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_SapXepTheo = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox_DanhMuc = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_NhaXuatBan = new javax.swing.JComboBox<>();
        jPanel18 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox_TrangThai = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jButton_TimKiem = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jButton_refresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel_List_SanPham = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(32767, 32767));
        jPanel_SanPhamKhac = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton_Them_SPK = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_TimKiem1 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox_SapXepTheo1 = new javax.swing.JComboBox<>();
        jPanel17 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox_ThuongHieu = new javax.swing.JComboBox<>();
        jPanel19 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox_TrangThai_SPK = new javax.swing.JComboBox<>();
        jPanel20 = new javax.swing.JPanel();
        jButton_TimKiem_SPK = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jButton_refresh_SPK = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel_List_SanPham1 = new javax.swing.JPanel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(32767, 32767));

        setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(500, 200));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(500, 700));

        jPanel_Sach.setMinimumSize(new java.awt.Dimension(16, 500));
        jPanel_Sach.setPreferredSize(new java.awt.Dimension(1280, 500));
        jPanel_Sach.setLayout(new java.awt.BorderLayout());

        jPanel4.setAutoscrolls(true);
        jPanel4.setFocusable(false);

        jButton_ThemSanPham.setBackground(new java.awt.Color(15, 145, 239));
        jButton_ThemSanPham.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton_ThemSanPham.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ThemSanPham.setIcon(ImageProcessing.resizeIcon(new ImageIcon(getClass().getResource("/img/icon/ico-plus.png")), 12 , 12));
        jButton_ThemSanPham.setText("Thêm sản phẩm");
        jButton_ThemSanPham.setAutoscrolls(true);
        jButton_ThemSanPham.setFocusable(false);
        jButton_ThemSanPham.setIconTextGap(15);
        jButton_ThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemSanPhamActionPerformed(evt);
            }
        });

        jButton_Import.setBackground(new java.awt.Color(204, 204, 204));
        jButton_Import.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton_Import.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Import.setIcon(ImageProcessing.resizeIcon(new ImageIcon(getClass().getResource("/img/icon/ico-export.png")), 12 , 12));
        jButton_Import.setText("Import Sản phẩm");
        jButton_Import.setFocusCycleRoot(true);
        jButton_Import.setFocusable(false);
        jButton_Import.setIconTextGap(12);
        jButton_Import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImportActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Tìm kiếm");

        jTextField_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_TimKiem)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(jPanel8);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Sắp xếp theo");

        jComboBox_SapXepTheo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Giá cao nhất", "Giá thấp nhất", "Số lượng tăng", "Sản phẩm sắp hết" }));
        jComboBox_SapXepTheo.setName(""); // NOI18N
        jComboBox_SapXepTheo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_SapXepTheoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox_SapXepTheo, 0, 123, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_SapXepTheo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(jPanel6);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Danh mục");

        jComboBox_DanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_DanhMucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jComboBox_DanhMuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_DanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel11);

        jPanel10.setPreferredSize(new java.awt.Dimension(265, 88));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Nhà xuất bản");
        jLabel4.setPreferredSize(new java.awt.Dimension(85, 22));

        jComboBox_NhaXuatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_NhaXuatBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jComboBox_NhaXuatBan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_NhaXuatBan, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(jPanel10);

        jPanel18.setPreferredSize(new java.awt.Dimension(250, 88));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Tìm trạng thái");

        jComboBox_TrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Còn bán", "Ngưng bán" }));
        jComboBox_TrangThai.setName(""); // NOI18N
        jComboBox_TrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(jComboBox_TrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(jComboBox_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(jPanel18);

        jPanel9.setPreferredSize(new java.awt.Dimension(100, 88));

        jButton_TimKiem.setBackground(new java.awt.Color(15, 145, 239));
        jButton_TimKiem.setForeground(new java.awt.Color(255, 255, 255));
        jButton_TimKiem.setIcon(ImageProcessing.resizeIcon(new ImageIcon(getClass().getResource("/img/icon/btn-search.png")), 20 , 20));
        jButton_TimKiem.setFocusable(false);
        jButton_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton_TimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                    .addContainerGap(40, Short.MAX_VALUE)
                    .addComponent(jButton_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jPanel5.add(jPanel9);

        jPanel12.setPreferredSize(new java.awt.Dimension(100, 88));

        jButton_refresh.setBackground(new java.awt.Color(15, 145, 239));
        jButton_refresh.setForeground(new java.awt.Color(255, 255, 255));
        jButton_refresh.setIcon(ImageProcessing.resizeIcon(new ImageIcon(getClass().getResource("/img/icon/ico-refresh.png")), 30 , 30));
        jButton_refresh.setFocusable(false);
        jButton_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                    .addContainerGap(40, Short.MAX_VALUE)
                    .addComponent(jButton_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jPanel5.add(jPanel12);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_ThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButton_Import, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_Import, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButton_ThemSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_Sach.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setBackground(new java.awt.Color(255, 204, 204));
        jScrollPane1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(16, 20));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(50, 50));

        jPanel_List_SanPham.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel_List_SanPham.setMinimumSize(new java.awt.Dimension(500, 500));
        jPanel_List_SanPham.setName(""); // NOI18N
        jPanel_List_SanPham.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel_List_SanPham.setLayout(new javax.swing.BoxLayout(jPanel_List_SanPham, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(jPanel_List_SanPham);

        jPanel_Sach.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        filler1.setBackground(new java.awt.Color(242, 242, 242));
        jPanel_Sach.add(filler1, java.awt.BorderLayout.LINE_END);

        jTabbedPane1.addTab("Sách", jPanel_Sach);

        jPanel_SanPhamKhac.setMinimumSize(new java.awt.Dimension(16, 500));
        jPanel_SanPhamKhac.setPreferredSize(new java.awt.Dimension(1280, 500));
        jPanel_SanPhamKhac.setLayout(new java.awt.BorderLayout());

        jPanel7.setAutoscrolls(true);
        jPanel7.setFocusable(false);

        jButton_Them_SPK.setBackground(new java.awt.Color(15, 145, 239));
        jButton_Them_SPK.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton_Them_SPK.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Them_SPK.setIcon(ImageProcessing.resizeIcon(new ImageIcon(getClass().getResource("/img/icon/ico-plus.png")), 12 , 12));
        jButton_Them_SPK.setText("Thêm sản phẩm");
        jButton_Them_SPK.setAutoscrolls(true);
        jButton_Them_SPK.setFocusable(false);
        jButton_Them_SPK.setIconTextGap(15);
        jButton_Them_SPK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Them_SPKActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(ImageProcessing.resizeIcon(new ImageIcon(getClass().getResource("/img/icon/ico-export.png")), 12 , 12));
        jButton5.setText("Import Sản phẩm");
        jButton5.setFocusCycleRoot(true);
        jButton5.setFocusable(false);
        jButton5.setIconTextGap(12);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(204, 204, 255));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Tìm kiếm");

        jTextField_TimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TimKiem1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_TimKiem1)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_TimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel13.add(jPanel14);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Sắp xếp theo");

        jComboBox_SapXepTheo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Giá cao nhất", "Giá thấp nhất", "Số lượng tăng", "Sản phẩm sắp hết" }));
        jComboBox_SapXepTheo1.setName(""); // NOI18N
        jComboBox_SapXepTheo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_SapXepTheo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox_SapXepTheo1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_SapXepTheo1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel13.add(jPanel15);

        jPanel17.setPreferredSize(new java.awt.Dimension(265, 88));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Thương hiệu");
        jLabel8.setPreferredSize(new java.awt.Dimension(85, 22));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jComboBox_ThuongHieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_ThuongHieu, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel13.add(jPanel17);

        jPanel19.setPreferredSize(new java.awt.Dimension(250, 88));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Tìm trạng thái");

        jComboBox_TrangThai_SPK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Còn bán", "Ngưng bán" }));
        jComboBox_TrangThai_SPK.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(jComboBox_TrangThai_SPK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(jComboBox_TrangThai_SPK, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel13.add(jPanel19);

        jPanel20.setPreferredSize(new java.awt.Dimension(100, 88));

        jButton_TimKiem_SPK.setBackground(new java.awt.Color(15, 145, 239));
        jButton_TimKiem_SPK.setForeground(new java.awt.Color(255, 255, 255));
        jButton_TimKiem_SPK.setIcon(ImageProcessing.resizeIcon(new ImageIcon(getClass().getResource("/img/icon/btn-search.png")), 20 , 20));
        jButton_TimKiem_SPK.setFocusable(false);
        jButton_TimKiem_SPK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiem_SPKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 99, Short.MAX_VALUE)
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton_TimKiem_SPK, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                    .addContainerGap(40, Short.MAX_VALUE)
                    .addComponent(jButton_TimKiem_SPK, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jPanel13.add(jPanel20);

        jPanel21.setPreferredSize(new java.awt.Dimension(100, 88));

        jButton_refresh_SPK.setBackground(new java.awt.Color(15, 145, 239));
        jButton_refresh_SPK.setForeground(new java.awt.Color(255, 255, 255));
        jButton_refresh_SPK.setIcon(ImageProcessing.resizeIcon(new ImageIcon(getClass().getResource("/img/icon/ico-refresh.png")), 30 , 30));
        jButton_refresh_SPK.setFocusable(false);
        jButton_refresh_SPK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_refresh_SPKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 99, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton_refresh_SPK, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                    .addContainerGap(40, Short.MAX_VALUE)
                    .addComponent(jButton_refresh_SPK, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jPanel13.add(jPanel21);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Them_SPK, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButton_Them_SPK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_SanPhamKhac.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jScrollPane2.setBackground(new java.awt.Color(255, 204, 204));
        jScrollPane2.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(16, 20));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(50, 50));

        jPanel_List_SanPham1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel_List_SanPham1.setMinimumSize(new java.awt.Dimension(500, 500));
        jPanel_List_SanPham1.setName(""); // NOI18N
        jPanel_List_SanPham1.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel_List_SanPham1.setLayout(new javax.swing.BoxLayout(jPanel_List_SanPham1, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(jPanel_List_SanPham1);

        jPanel_SanPhamKhac.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        filler2.setBackground(new java.awt.Color(242, 242, 242));
        jPanel_SanPhamKhac.add(filler2, java.awt.BorderLayout.LINE_END);

        jTabbedPane1.addTab("Sản phẩm khác", jPanel_SanPhamKhac);

        add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_refreshActionPerformed
        this.refresh();
    }//GEN-LAST:event_jButton_refreshActionPerformed

    private void jButton_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemActionPerformed
        String timKiem_Ten = this.jTextField_TimKiem.getText();
        String timKiem_SapXep = this.jComboBox_SapXepTheo.getSelectedItem().toString();
        String timKiem_DanhMuc = this.jComboBox_DanhMuc.getSelectedItem().toString();
        String timKiem_NhaXuatBan = this.jComboBox_NhaXuatBan.getSelectedItem().toString();
        String timKiem_TrangThai = this.jComboBox_TrangThai.getSelectedItem().toString();

        SanPham_BUS sanPham_BUS = new SanPham_BUS();
        int tacGiaID = sanPham_BUS.getIdTacGiaByName(timKiem_Ten.toString());
        int theLoaiID = sanPham_BUS.getIdTheloaiByName(timKiem_Ten.toString());
        int danhMucID = sanPham_BUS.getIdDanhMucByName(timKiem_DanhMuc.toString());
        int nhaXuatBanID = sanPham_BUS.getIdNhaXuatBanByName(timKiem_NhaXuatBan.toString());

        String query1 = "SELECT * FROM SanPham WHERE TenSanPham LIKE " + "N'%" + timKiem_Ten + "%'";
        if (tacGiaID != -1) {
            query1 += " OR TacGiaID = " + tacGiaID;
        }

        if (theLoaiID != -1) {
            query1 += " OR TheLoaiID = " + theLoaiID;
        }

        if (danhMucID != -1) {
            query1 += " AND DanhMucID = " + danhMucID;
        }
        if (nhaXuatBanID != -1) {
            query1 += " AND NhaXuatBanID = " + nhaXuatBanID;
        }

        if (timKiem_TrangThai.equals("Còn bán")) {
            query1 += " AND TinhTrang = " + "'CON_HANG'";
        } else if (timKiem_TrangThai.equals("Ngưng bán")) {
            query1 += " AND TinhTrang = " + "'NGUNG_KINH_DOANH'";
        }

        this.jPanel_List_SanPham.removeAll();

        jComboBox_DanhMuc.removeAllItems();
        jComboBox_NhaXuatBan.removeAllItems();

        dem_sach = 0;
        dem_spk = 0;

        this.jTextField_TimKiem.setText("");
        this.jTextField_TimKiem1.setText("");

        this.revalidate();
        this.repaint();

        ArrayList<SanPham> list = sanPham_BUS.getDanhSachSanPham(query1);
        if (timKiem_SapXep.equals("Giá cao nhất")) {
            sanPham_BUS.SapXepGiamTheoGia(list);
        }
        else if (timKiem_SapXep.equals("Giá thấp nhất")) {
            sanPham_BUS.SapXepTangTheoGia(list);
        }
        else if (timKiem_SapXep.equals("Số lượng tăng")) {
            sanPham_BUS.SapXepTangTheoSoLuong(list);
        }
        else if(timKiem_SapXep.equals("Sản phẩm sắp hết"))
        {
            list = sanPham_BUS.getDanhSachSanPhamSapHet();
        }
        loadSanPham(list);
        jScrollPane1.getVerticalScrollBar().setValue(0);
        jScrollPane1.getHorizontalScrollBar().setValue(0);

    }//GEN-LAST:event_jButton_TimKiemActionPerformed


    private void jComboBox_DanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_DanhMucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_DanhMucActionPerformed

    private void jComboBox_SapXepTheoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_SapXepTheoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_SapXepTheoActionPerformed

    private void jTextField_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TimKiemActionPerformed

    private void jButton_ThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemSanPhamActionPerformed
        TAB_ThemSanPham taB_ThemSanPham = new TAB_ThemSanPham();
        taB_ThemSanPham.setLocationRelativeTo(null);
        taB_ThemSanPham.setVisible(true);
        taB_ThemSanPham.disVisibleForLuu();
    }//GEN-LAST:event_jButton_ThemSanPhamActionPerformed

    private void jButton_Them_SPKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Them_SPKActionPerformed
        // TODO add your handling code here:
        TAB_ThemSanPhamKhac taB_ThemSanPhamKhac = new TAB_ThemSanPhamKhac();
        taB_ThemSanPhamKhac.setLocationRelativeTo(null);
        taB_ThemSanPhamKhac.setVisible(true);
        taB_ThemSanPhamKhac.disVisibleForLuu();

    }//GEN-LAST:event_jButton_Them_SPKActionPerformed

//    private class TextFieldCaretListener implements CaretListener
//    {
//        @Override
//        public void caretUpdate(CaretEvent e) {
//            try{
//                comboBox.removeAllItems();
//                comboBox.hidePopup();
//                jPanel_CBB_TenSanPham.remove(comboBox);
//                if(e.getMark() > 0)
//                {
//                    for(String string : arr)
//                    {
//                        if(string.toLowerCase().startsWith(jTextField_TenSanPham.getText().toLowerCase()))
//                        {
//                            jPanel_CBB_TenSanPham.add(comboBox);
//                            comboBox.addItem(string);
//                            comboBox.showPopup();
//                        }
//                    }
//                }
//            }catch(Exception e1)
//            {
//                
//            }
//            if(e.getMark() < 2)
//            {
//                jPanel_CBB_TenSanPham.remove(comboBox);
//            }
//        }
//        
//    }
    private void jTextField_TimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TimKiem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TimKiem1ActionPerformed

    private void jComboBox_SapXepTheo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_SapXepTheo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_SapXepTheo1ActionPerformed

    private void jButton_TimKiem_SPKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiem_SPKActionPerformed
        String timKiem_Ten = this.jTextField_TimKiem1.getText();
        String timKiem_SapXep = this.jComboBox_SapXepTheo1.getSelectedItem().toString();
        String timKiem_ThuongHieu = this.jComboBox_ThuongHieu.getSelectedItem().toString();
        String timKiem_TrangThai = this.jComboBox_TrangThai_SPK.getSelectedItem().toString();

        SanPham_BUS sanPham_BUS = new SanPham_BUS();
        int thuongHieuID = sanPham_BUS.getIdThuongHieuByName(timKiem_ThuongHieu.toString());

        String query1 = "SELECT * FROM SanPham WHERE TenSanPham LIKE " + "N'%" + timKiem_Ten + "%'";

        if (thuongHieuID != -1) {
            query1 += " AND ThuongHieuID = " + thuongHieuID;
        }

        if (timKiem_TrangThai.equals("Còn bán")) {
            query1 += " AND TinhTrang = " + "'CON_HANG'";
        } else if (timKiem_TrangThai.equals("Ngưng bán")) {
            query1 += " AND TinhTrang = " + "'NGUNG_KINH_DOANH'";
        }
        

        this.jPanel_List_SanPham1.removeAll();
        jComboBox_ThuongHieu.removeAllItems();
        dem_sach = 0;
        dem_spk = 0;

        this.jTextField_TimKiem1.setText("");

        this.revalidate();
        this.repaint();

        ArrayList<SanPham> list = sanPham_BUS.getDanhSachSanPham(query1);
        if (timKiem_SapXep.equals("Giá cao nhất")) {
            sanPham_BUS.SapXepGiamTheoGia(list);
        }
        else if (timKiem_SapXep.equals("Giá thấp nhất")) {
            sanPham_BUS.SapXepTangTheoGia(list);
        }
        else if (timKiem_SapXep.equals("Số lượng tăng")) {
            sanPham_BUS.SapXepTangTheoSoLuong(list);
        } 
        else if(timKiem_SapXep.equals("Sản phẩm sắp hết"))
        {
            list = sanPham_BUS.getDanhSachSanPhamSapHet();
        }
        loadSanPham(list);
        jScrollPane2.getVerticalScrollBar().setValue(0);
        jScrollPane2.getHorizontalScrollBar().setValue(0);

    }//GEN-LAST:event_jButton_TimKiem_SPKActionPerformed

    private void jButton_refresh_SPKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_refresh_SPKActionPerformed
        // TODO add your handling code here:
        this.refresh();
    }//GEN-LAST:event_jButton_refresh_SPKActionPerformed

    private void jComboBox_NhaXuatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_NhaXuatBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_NhaXuatBanActionPerformed

    private void jComboBox_TrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_TrangThaiActionPerformed

    private void jButton_ImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ImportActionPerformed

        // TODO add your handling code here:
//            JFileChooser chooser;
//            chooser = new JFileChooser();
//            chooser.showOpenDialog(null);
//            File file = chooser.getSelectedFile();
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImportToJTable = null;
        String defaultCurrentDirectoryPath = "D:";
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        excelFileChooser.setDialogTitle("Chọn file excel");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showOpenDialog(null);
        SanPham_BUS sanPham_BUS = new SanPham_BUS();
        NhaCungCap_BUS nhaCungCap_BUS = new NhaCungCap_BUS();
        ArrayList<SanPham> list_SanPham = sanPham_BUS.getDanhSachSanPham();
        ArrayList<NhaCungCap> list_NhaCungCap = nhaCungCap_BUS.getAllNhaCungCap();
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            Set<Object> maSanPhamSet = new HashSet<>();
            try {
                excelFile = excelFileChooser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelImportToJTable = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);
                
//                XSSFRow excelRow = excelSheet.getRow(1);
//                XSSFCell excelNgayNhap = excelRow.getCell(7);
//                String ngayNhap = excelNgayNhap.toString().trim();
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                LocalDate localDate = LocalDate.parse(ngayNhap, formatter);

                XSSFRow excelRow = excelSheet.getRow(6);
                XSSFCell excelNhaCungCap = excelRow.getCell(2);
                String tenNhaCungCap = excelNhaCungCap.toString().trim();
                XSSFCell excelsoDienThoai = excelRow.getCell(5);
                String soDienThoai = excelsoDienThoai.toString().trim();

                excelRow = excelSheet.getRow(7);
                String diaChi = excelSheet.getRow(2).toString();
                int check1 = 0;
                for(NhaCungCap ncc : list_NhaCungCap)
                {
                    if(ncc.getTenNhaCungCap().equals(tenNhaCungCap))
                    {
                        check1 = 1;
                        break;
                    }
                }
                if(check1 == 0)
                {
                	JOptionPane.showMessageDialog(null, "Nhà cung cấp không có sẳn!");
                	return;
                }
                

                for (int row = 11; row <= excelSheet.getLastRowNum(); row++) {
                	excelRow = excelSheet.getRow(row);
                    XSSFCell excelSTT = excelRow.getCell(0);
                    XSSFCell excelBarcode = excelRow.getCell(1);
                    XSSFCell excelTenHang = excelRow.getCell(2);
                    XSSFCell excelLSP = excelRow.getCell(3);
                    XSSFCell excelSoLuong = excelRow.getCell(4);
                    XSSFCell excelDonGia = excelRow.getCell(5);
                    XSSFCell excelCK = excelRow.getCell(6);
                    XSSFCell excelThanhTien = excelRow.getCell(7);
                    XSSFCell excelGhiChu = excelRow.getCell(8);
                   
                    String barCode = excelBarcode.toString().trim();
                    String tenHang = excelTenHang.toString().trim();
                    String loaiSanPham = excelLSP.toString().trim();
                    int soLuong = (int) Double.parseDouble(excelSoLuong.toString().trim());
                    double donGia = Double.parseDouble(excelDonGia.toString().trim());
                    double chiecKhau = Double.parseDouble(excelCK.toString().trim());
                    int check = 0;

                    for(SanPham sp : list_SanPham)
                    {
                        if(sp.getBarcode().equals(barCode))
                        {
                            sp.setSoLuongTon(sp.getSoLuongTon() + soLuong);
                            sanPham_BUS.editSanPham(sp);
                            check = 1;
                            break;
                        }
                    }
                    
                    if(check == 0)
                    {
                        SanPham new_SanPham = new SanPham();
                        new_SanPham.setBarcode(barCode);
                        new_SanPham.setTenSanPham(tenHang);
                        new_SanPham.setGiaNhap(donGia);
                        new_SanPham.setThue(chiecKhau);
                        new_SanPham.setTacGia(new TacGia(1));
                        new_SanPham.setDanhMuc(new DanhMuc(1));
                        new_SanPham.setNhaXuatBan(new NhaXuatBan(1));
                        new_SanPham.setThuongHieu(new ThuongHieu(1));
                        new_SanPham.setNhaCungCap(new NhaCungCap(sanPham_BUS.getIdNhaCungCapByName(tenNhaCungCap)));
                        new_SanPham.setTheLoai(new TheLoai(1));
                        if(loaiSanPham.equals("Sách"))
                        {
                        	new_SanPham.setLoaiSanPham("SACH");
                        }
                        else
                        {
                        	new_SanPham.setLoaiSanPham("SAN_PHAM_KHAC");
                        }
                        sanPham_BUS.addSanPham(new_SanPham);
                    }
        
                }
                JOptionPane.showMessageDialog(null, "Nhập thành công");
            } catch (IOException iOException) {
            	JOptionPane.showMessageDialog(null, "Nhập thất bại");
                JOptionPane.showMessageDialog(null, iOException.getMessage());

            } catch (Exception ex) {
            	JOptionPane.showMessageDialog(null, "Nhập thất bại");
                Logger.getLogger(TAB_SanPham.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (excelFIS != null) {
                        excelFIS.close();
                    }
                    if (excelBIS != null) {
                        excelBIS.close();
                    }
                    if (excelImportToJTable != null) {
                        excelImportToJTable.close();
                    }
                } catch (IOException iOException) {
                    JOptionPane.showMessageDialog(null, iOException.getMessage());
                }
            }
        }


    }//GEN-LAST:event_jButton_ImportActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    Box box_SP = new Box(BoxLayout.X_AXIS);
    Box box_SPK = new Box(BoxLayout.X_AXIS);
    int Row_Sach = 0;
    int Row_SPK = 0;
    JPanel jPanel_Empty1 = new JPanel();
    JPanel jPanel_Empty2 = new JPanel();
    JPanel jPanel_Empty3 = new JPanel();
    JPanel jPanel_Empty4 = new JPanel();


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton_Import;
    private javax.swing.JButton jButton_ThemSanPham;
    private javax.swing.JButton jButton_Them_SPK;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JButton jButton_TimKiem_SPK;
    private javax.swing.JButton jButton_refresh;
    private javax.swing.JButton jButton_refresh_SPK;
    private javax.swing.JComboBox<String> jComboBox_DanhMuc;
    private javax.swing.JComboBox<String> jComboBox_NhaXuatBan;
    private javax.swing.JComboBox<String> jComboBox_SapXepTheo;
    private javax.swing.JComboBox<String> jComboBox_SapXepTheo1;
    private javax.swing.JComboBox<String> jComboBox_ThuongHieu;
    private javax.swing.JComboBox<String> jComboBox_TrangThai;
    private javax.swing.JComboBox<String> jComboBox_TrangThai_SPK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_List_SanPham;
    private javax.swing.JPanel jPanel_List_SanPham1;
    private javax.swing.JPanel jPanel_Sach;
    private javax.swing.JPanel jPanel_SanPhamKhac;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField_TimKiem;
    private javax.swing.JTextField jTextField_TimKiem1;
    // End of variables declaration//GEN-END:variables
}
