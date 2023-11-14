/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.lang.reflect.Array;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import bus.ChiTietKhuyenMai_BUS;
import bus.KhuyenMai_BUS;
import bus.SanPham_BUS;
import entities.ChiTietKhuyenMai;
import entities.KhuyenMai;
import entities.NhaCungCap;
import entities.SanPham;
import entities.ThuongHieu;

/**
 *
 * @author NguyenThanhLuan
 */
public class TAB_KhuyenMai extends javax.swing.JPanel {
	private DefaultTableModel tableModel;
	private DefaultTableModel tableModelSP;
	private KhuyenMai_BUS khuyenMai_BUS;
	private ArrayList<KhuyenMai> danhSachKM;
	private SanPham_BUS sanPham_BUS;
	private ArrayList<SanPham> danhSachSp;
	private ChiTietKhuyenMai_BUS chiTietKhuyenMai_BUS;
	private ArrayList<ChiTietKhuyenMai> danhSachCTTKM;
	private Calendar currentDate = Calendar.getInstance();
	private TableRowSorter<DefaultTableModel> sorter;
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    /**
     * Creates new form TAB_KhuyenMai
     */
    public TAB_KhuyenMai() {
        initComponents();
        khuyenMai_BUS = new KhuyenMai_BUS();
        sanPham_BUS = new SanPham_BUS();
        chiTietKhuyenMai_BUS = new ChiTietKhuyenMai_BUS();
        loadDataKM();
        loadDataSP();
    	loadDuLieuThuongHieu();
        currentDate = Calendar.getInstance();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlALL = new javax.swing.JPanel();
        title = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        center = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        NhapMa = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTenKM = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuongApDung = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtDonHangTu = new javax.swing.JTextField();
        hinhThuc = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtHinhThuc = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtMucGiamGia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        btnKhuyenMaiTao = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnLuu = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        tbLoi = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        titleSelectKhuyenMai = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        comboboxApDung = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        checkBoxSelectChoTatCa = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        TimMaSanPham = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        tableSelectKhuyenMai = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableChonSP = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        txtTimKMTheoMa = new javax.swing.JTextField();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        jLabel12 = new javax.swing.JLabel();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        txtTimTheoHinhThuc = new javax.swing.JComboBox<>();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        btnTimKiemKhuyenMai = new javax.swing.JButton();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 32767));
        jLabel11 = new javax.swing.JLabel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        ComboboxTimTheoMucGiam = new javax.swing.JComboBox<>();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 32767));
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableKM = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        pnlALL.setLayout(new java.awt.BorderLayout());

        title.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 145, 239));
        jLabel1.setText("Quản lý khuyến mãi");
        title.add(jLabel1);
        title.add(filler1);

        pnlALL.add(title, java.awt.BorderLayout.NORTH);

        center.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        center.setLayout(new javax.swing.BoxLayout(center, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 145, 239)), "Tạo khuyến mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1224, 350));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 8));
        jPanel3.setPreferredSize(new java.awt.Dimension(441, 300));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.PAGE_AXIS));

        NhapMa.setPreferredSize(new java.awt.Dimension(204, 160));
        NhapMa.setLayout(new java.awt.GridLayout(3, 1, 0, 8));

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setText("Mã khuyến mãi:");
        jLabel2.setPreferredSize(new java.awt.Dimension(110, 16));
        jPanel10.add(jLabel2);

        txtMaKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKMActionPerformed(evt);
            }
        });
        jPanel10.add(txtMaKM);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel21);

        NhapMa.add(jPanel10);

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setText("Tên khuyến mãi:");
        jLabel3.setPreferredSize(new java.awt.Dimension(110, 16));
        jPanel9.add(jLabel3);
        jPanel9.add(txtTenKM);

        NhapMa.add(jPanel9);

        jPanel8.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setText("Số lượng áp dụng:");
        jLabel4.setPreferredSize(new java.awt.Dimension(110, 16));
        jPanel13.add(jLabel4);
        jPanel13.add(txtSoLuongApDung);

        jPanel8.add(jPanel13);

        jPanel18.setLayout(new javax.swing.BoxLayout(jPanel18, javax.swing.BoxLayout.LINE_AXIS));

        jLabel9.setText("Đơn hàng từ: ");
        jPanel18.add(jLabel9);
        jPanel18.add(txtDonHangTu);

        jPanel8.add(jPanel18);

        NhapMa.add(jPanel8);

        jPanel3.add(NhapMa);

        hinhThuc.setPreferredSize(new java.awt.Dimension(425, 160));
        hinhThuc.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel15.setLayout(new java.awt.GridLayout(4, 1));

        jLabel5.setText("Hình thức giảm giá");
        jPanel15.add(jLabel5);

        txtHinhThuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PHAN_TRAM", "GIA_TRI" }));
        jPanel15.add(txtHinhThuc);

        jLabel7.setText("Thời gian bắt đầu giảm giá");
        jPanel15.add(jLabel7);
        jPanel15.add(txtNgayBatDau);

        hinhThuc.add(jPanel15);

        jPanel7.setLayout(new java.awt.GridLayout(4, 1));

        jLabel6.setText("Mức giảm giá");
        jPanel7.add(jLabel6);
        jPanel7.add(txtMucGiamGia);

        jLabel8.setText("Thời gian kết thúc giảm giá");
        jPanel7.add(jLabel8);
        jPanel7.add(txtNgayKetThuc);

        hinhThuc.add(jPanel7);

        jPanel3.add(hinhThuc);

        btnKhuyenMaiTao.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 10, 1));
        btnKhuyenMaiTao.setPreferredSize(new java.awt.Dimension(0, 60));
        btnKhuyenMaiTao.setLayout(new java.awt.GridLayout(1, 0, 18, 0));

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        btnLuu.setBackground(new java.awt.Color(15, 145, 239));
        btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/icon-luuKM.png"))); // NOI18N
        btnLuu.setText("Thêm");
        btnLuu.setIconTextGap(25);
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        jPanel5.add(btnLuu);

        btnKhuyenMaiTao.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        btnHuy.setBackground(new java.awt.Color(239, 162, 162));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/icon-huyKM.png"))); // NOI18N
        btnHuy.setText("Hủy bỏ");
        btnHuy.setIconTextGap(25);
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel6.add(btnHuy);

        btnKhuyenMaiTao.add(jPanel6);

        jPanel3.add(btnKhuyenMaiTao);

        jPanel22.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        tbLoi.setText("    ");
        jPanel22.add(tbLoi);

        jPanel3.add(jPanel22);

        jPanel1.add(jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 1, 1, 1));
        jPanel4.setPreferredSize(new java.awt.Dimension(602, 310));
        jPanel4.setLayout(new java.awt.BorderLayout());

        titleSelectKhuyenMai.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 8));
        titleSelectKhuyenMai.setPreferredSize(new java.awt.Dimension(602, 72));
        titleSelectKhuyenMai.setLayout(new java.awt.GridLayout(2, 2, 0, 8));

        jPanel17.setLayout(new javax.swing.BoxLayout(jPanel17, javax.swing.BoxLayout.LINE_AXIS));

        jLabel10.setText("Áp dụng theo thương hiệu: ");
        jPanel17.add(jLabel10);
        jPanel17.add(filler3);

        comboboxApDung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        comboboxApDung.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboboxApDungItemStateChanged(evt);
            }
        });
        jPanel17.add(comboboxApDung);

        titleSelectKhuyenMai.add(jPanel17);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        titleSelectKhuyenMai.add(jPanel16);

        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.LINE_AXIS));

        checkBoxSelectChoTatCa.setText("Áp dụng cho tất cả");
        checkBoxSelectChoTatCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkBoxSelectChoTatCaMouseClicked(evt);
            }
        });
        jPanel14.add(checkBoxSelectChoTatCa);

        titleSelectKhuyenMai.add(jPanel14);

        jPanel12.setLayout(new java.awt.BorderLayout(10, 0));

        TimMaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimMaSanPhamActionPerformed(evt);
            }
        });
        jPanel12.add(TimMaSanPham, java.awt.BorderLayout.CENTER);

        btnTimKiem.setBackground(new java.awt.Color(15, 145, 239));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/icon-addKM.png"))); // NOI18N
        btnTimKiem.setPreferredSize(new java.awt.Dimension(80, 23));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        jPanel12.add(btnTimKiem, java.awt.BorderLayout.EAST);

        titleSelectKhuyenMai.add(jPanel12);

        jPanel4.add(titleSelectKhuyenMai, java.awt.BorderLayout.PAGE_START);

        tableSelectKhuyenMai.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        tableSelectKhuyenMai.setPreferredSize(new java.awt.Dimension(870, 200));
        tableSelectKhuyenMai.setLayout(new java.awt.BorderLayout());

        tableChonSP.setModel(tableModelSP = new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Chọn", "Mã sản phẩm", "Tên sản phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableChonSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableChonSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableChonSP);

        tableSelectKhuyenMai.add(jScrollPane2, java.awt.BorderLayout.PAGE_START);

        jPanel4.add(tableSelectKhuyenMai, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4);

        center.add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 145, 239)), "Danh sách khuyến mãi"));
        jPanel2.setPreferredSize(new java.awt.Dimension(1764, 170));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel19.setMinimumSize(new java.awt.Dimension(163, 50));
        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanel20.setMinimumSize(new java.awt.Dimension(153, 28));
        jPanel20.setPreferredSize(new java.awt.Dimension(680, 28));
        jPanel20.setLayout(new javax.swing.BoxLayout(jPanel20, javax.swing.BoxLayout.LINE_AXIS));

        txtTimKMTheoMa.setPreferredSize(new java.awt.Dimension(180, 22));
        jPanel20.add(txtTimKMTheoMa);
        jPanel20.add(filler6);

        jLabel12.setText("Loại khuyến mãi:");
        jPanel20.add(jLabel12);
        jPanel20.add(filler10);

        txtTimTheoHinhThuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Giá trị", "Phần trăm" }));
        jPanel20.add(txtTimTheoHinhThuc);
        jPanel20.add(filler4);

        btnTimKiemKhuyenMai.setBackground(new java.awt.Color(15, 145, 239));
        btnTimKiemKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/icon-search.png"))); // NOI18N
        btnTimKiemKhuyenMai.setMinimumSize(new java.awt.Dimension(26, 32));
        btnTimKiemKhuyenMai.setPreferredSize(new java.awt.Dimension(85, 32));
        btnTimKiemKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemKhuyenMaiActionPerformed(evt);
            }
        });
        jPanel20.add(btnTimKiemKhuyenMai);
        jPanel20.add(filler7);
        jPanel20.add(filler2);

        jLabel11.setText("Sắp xếp giá trị");
        jPanel20.add(jLabel11);
        jPanel20.add(filler5);

        ComboboxTimTheoMucGiam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Tăng dần", "Giảm dần" }));
        ComboboxTimTheoMucGiam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboboxTimTheoMucGiamItemStateChanged(evt);
            }
        });
        jPanel20.add(ComboboxTimTheoMucGiam);
        jPanel20.add(filler8);

        jPanel19.add(jPanel20);

        jPanel2.add(jPanel19, java.awt.BorderLayout.PAGE_START);

        jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        tableKM.setModel(tableModel = new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã khuyễn mãi", "Tên khuyến mãi", "Loại khuyến mãi", "Giá trị", "Ngày bắt đầu", "Ngày kết thúc","DonHangTu","SoLuongKhuyenMai","SoLuotDaApDung","Xem sản phẩm"
            }
        ));
        tableKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKMMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableKM);

        jPanel11.add(jScrollPane3);

        jPanel2.add(jPanel11, java.awt.BorderLayout.CENTER);

        center.add(jPanel2);

        pnlALL.add(center, java.awt.BorderLayout.CENTER);

        add(pnlALL, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public  void Huy() {
    	txtTenKM.setText("");
    	txtHinhThuc.setSelectedIndex(0);
    	txtSoLuongApDung.setText("");
    	txtMucGiamGia.setText("");
    	txtNgayBatDau.setDate(currentDate.getTime());
    	Calendar currentDateToMoth = (Calendar) currentDate.clone();
    	currentDateToMoth.add(Calendar.MONTH, 1);
    	txtNgayKetThuc.setDate(currentDateToMoth.getTime());
    }
    
    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        Huy();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void tableChonSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableChonSPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableChonSPMouseClicked
    
    private String phatSinhMaKhuyenMai() {
		try {
			String maKhuyenMai = "KM" + String.format("%03d", khuyenMai_BUS.layMaNCCCuoiCung() + 1);
			return maKhuyenMai;
		} catch (NullPointerException e) {
			return "KM" + "001";
		}
	}
    // Lấy các giá trị có trong bảng
    // KiemTraDieuKienNhap
    public boolean kiemTraNhap() {
    	String maKM = txtMaKM.getText();
    	String tenKM = txtTenKM.getText();
    	String soLuongApDung = txtSoLuongApDung.getText();
    	String donHangTu = txtDonHangTu.getText();
    	String hinhThuc = txtHinhThuc.getSelectedItem().toString();
    	String mucGiam = txtMucGiamGia.getText();
    	java.util.Date ngayBatDauUtil =  txtNgayBatDau.getDate();
    	java.util.Date ngayKetThucUtil  = txtNgayKetThuc.getDate();
    	java.sql.Date ngayBatDau = new java.sql.Date(ngayBatDauUtil.getTime());
    	java.sql.Date ngayKetThuc = new java.sql.Date(ngayKetThucUtil.getTime());
    	ArrayList<SanPham> dsChonSP = khuyenMai_BUS.laySanPhamDuocChon(tableChonSP);
    	
    	if(!(maKM.length() > 0 && maKM.matches("^([A-Za-z1-9_]){6}$"))) {
    		new utilities.ShowMessageError().showError(this, txtMaKM, "Mã khuyến mãi không đúng định dạng (có 6 ký tự ví dụ: Abc_123)", "Thông báo");
    		return false;
    	}

    	if(!(tenKM.length() > 0 && tenKM.matches(utilities.RegexPattern.HOTEN))) {
    		new utilities.ShowMessageError().showError(this, txtTenKM, "Tên khuyến mãi không đúng định dạng", "Thông báo");
    		return false;
    	}
    	if(!(soLuongApDung.length() > 0 && Integer.valueOf(soLuongApDung) > 0)){
    		new utilities.ShowMessageError().showError(this, txtSoLuongApDung, "Số lượng > 0", "Thông báo");
    		return false;
    	}
    	if(!(donHangTu.length() > 0 && Integer.valueOf(donHangTu) > 0)){
    		new utilities.ShowMessageError().showError(this, txtDonHangTu,"Đơn hàng > 0", "Thông báo");
    		return false;
    	}
    	if(!(mucGiam.length() > 0 && Integer.valueOf(mucGiam) > 0)){
    		new utilities.ShowMessageError().showError(this, txtMucGiamGia,"Mức giảm > 0", "Thông báo");
    		return false;
    	}
    	if(ngayBatDau.after(ngayKetThuc)){
    		new utilities.ShowMessageError().showErrorNoTextFile(this, "Ngày bắt đầu phải trước ngày kết thúc", "Thông báo");
    		return false;
    	}
    	if(dsChonSP.size() <= 0) {
    		new utilities.ShowMessageError().showErrorNoTextFile(this, "Chưa chọn sản phẩm khuyến mãi", "Thông báo");
    		return false;
    	}
    	return true;
    }
    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
    	try {
        	if(kiemTraNhap()) {
        		String maKM = txtMaKM.getText();
            	String tenKM = txtTenKM.getText();
            	String soLuongApDung = txtSoLuongApDung.getText();
            	String donHangTu = txtDonHangTu.getText();
            	String hinhThuc = txtHinhThuc.getSelectedItem().toString();
            	String mucGiam = txtMucGiamGia.getText();
            	java.util.Date ngayBatDauUtil =  txtNgayBatDau.getDate();
            	java.util.Date ngayKetThucUtil  = txtNgayKetThuc.getDate();
            	java.sql.Date ngayBatDau = new java.sql.Date(ngayBatDauUtil.getTime());
            	java.sql.Date ngayKetThuc = new java.sql.Date(ngayKetThucUtil.getTime());
            	
            	ArrayList<SanPham> dsChonSP = khuyenMai_BUS.laySanPhamDuocChon(tableChonSP);
            	KhuyenMai khuyenMai = new KhuyenMai(maKM ,tenKM ,hinhThuc, Double.valueOf(mucGiam), ngayBatDau, ngayKetThuc, Double.valueOf(donHangTu),Integer.valueOf(soLuongApDung), 0);

                if (khuyenMai_BUS.addKhuyenMai(khuyenMai) && chiTietKhuyenMai_BUS.addSDanhSachSPKM(khuyenMai, dsChonSP)) {
        			JOptionPane.showMessageDialog(this, "Thêm thành công");
        			txtMaKM.setText(phatSinhMaKhuyenMai());
        			Huy();
        			loadDataKM();
        		}
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }//GEN-LAST:event_btnLuuActionPerformed
   
    private void checkBoxSelectChoTatCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkBoxSelectChoTatCaMouseClicked
	       int rowCount = tableChonSP.getRowCount();
	       boolean isSelected = checkBoxSelectChoTatCa.isSelected();
	       for (int i = 0; i < rowCount; i++) {
	           tableChonSP.setValueAt(isSelected, i, 0);
	       }
    }//GEN-LAST:event_checkBoxSelectChoTatCaMouseClicked

    private void btnTimKiemKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemKhuyenMaiActionPerformed
        String timMa = txtTimKMTheoMa.getText().trim();
        String timLoai = (String) txtTimTheoHinhThuc.getSelectedItem();
    	tableKM.removeAll();
    	tableKM.setRowSelectionAllowed(false);
    	tableModel.setRowCount(0);
    	ArrayList<KhuyenMai> dsKhuyenMais = new ArrayList<KhuyenMai>();
    	dsKhuyenMais = khuyenMai_BUS.TimKiemTheoDieuKien(timMa, timLoai);
    	int stt = 1;
    	for(KhuyenMai km : dsKhuyenMais) {
    		tableModel.addRow(new Object[] {stt++, km.getCodeKhuyenMai(), km.getTenKhuyenMai(), km.getLoaiKhuyenMai(),km.getGiaTri(), km.getNgayKhuyenMai(), km.getNgayHetHanKM(),km.getDonHangTu(), km.getSoLuongKhuyenMai(), km.getSoLuotDaApDung()});
    	}
    }//GEN-LAST:event_btnTimKiemKhuyenMaiActionPerformed

    private void ComboboxTimTheoMucGiamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboboxTimTheoMucGiamItemStateChanged
            String selectedOption = (String) ComboboxTimTheoMucGiam.getSelectedItem();
            switch (selectedOption) {
            case "Tăng dần":
                sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(4, SortOrder.ASCENDING))); // Sắp xếp theo cột "Giá trị" tăng dần
                break;
            case "Giảm dần":
                sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(4, SortOrder.DESCENDING))); // Sắp xếp theo cột "Giá trị" giảm dần
                break;
            case "Tất cả":
                sorter.setSortKeys(null); // Bỏ sắp xếp
                break;
        }
    }//GEN-LAST:event_ComboboxTimTheoMucGiamItemStateChanged

    private boolean kiemTraTimMaSP(String txtTimSp) {
        if(!(txtTimSp.matches("^\\d+$"))) {
        	utilities.ShowMessageError.showErrorNoTextFile(this,"Mã không hợp lệ", "Thông báo");
        	return false;
        }
        return true;
    }
    
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
//    	danhSachSp = new ArrayList<>();
//    	danhSachSp = sanPham_BUS.laySanPhamChoKM();
    	String txtTimSp = TimMaSanPham.getText();
//        if(kiemTraTimMaSP(txtTimSp)) {
//        	for(int i = 0; i < danhSachSp.size(); i++) {
//        		if(danhSachSp.get(i).getSanPhamID() == Integer.valueOf(txtTimSp)) {
//        			tableModelSP.setValueAt(true, i, 0);
//        		}
//        	}
//        }
        
        for (int i = 0; i < tableModelSP.getRowCount(); i++) {
        	int j = 1;
        	if (((int)tableModelSP.getValueAt(i, j) + "").equalsIgnoreCase(txtTimSp)) {
        		tableModelSP.setValueAt(true, i, 0);
        	}
        }
        
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void TimMaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimMaSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimMaSanPhamActionPerformed

    private void loadDuLieuThuongHieu() {
    	ArrayList<ThuongHieu> list = new ArrayList<ThuongHieu>();
    	list = sanPham_BUS.getThuongHieu();
        for (ThuongHieu thuongHieu : list) {
            comboboxApDung.addItem(thuongHieu.getThuongHieuID()+": "+thuongHieu.getTenThuongHieu());
        }
    }
    
    private void comboboxApDungItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboboxApDungItemStateChanged
        String maTen = (String) comboboxApDung.getSelectedItem();
        tableChonSP.removeAll();
    	tableChonSP.setRowSelectionAllowed(false);
    	tableModelSP.setRowCount(0);
    	if(maTen.equals("Tất cả")) {
        	danhSachSp = new ArrayList<>();
        	danhSachSp = sanPham_BUS.laySanPhamChoKM();
        	int stt = 1;
        	for(int i = 0; i < danhSachSp.size(); i++) {
        		tableModelSP.addRow(new Object[] {false ,danhSachSp.get(i).getSanPhamID(),danhSachSp.get(i).getTenSanPham()});
        	}
    	}
    	else {
    		String[] parts = maTen.split(": ");
    		String ma = parts[0];
    		danhSachSp = new ArrayList<>();
        	danhSachSp = sanPham_BUS.getSPTheoThuongHieu(ma);
        	int stt = 1;
        	for(int i = 0; i < danhSachSp.size(); i++) {
        		tableModelSP.addRow(new Object[] {false ,danhSachSp.get(i).getSanPhamID(),danhSachSp.get(i).getTenSanPham()});
        	}
    	}
    }//GEN-LAST:event_comboboxApDungItemStateChanged

    private void txtMaKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKMActionPerformed

    private void tableKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKMMouseClicked
         int selectedRow = tableKM.getSelectedRow();
         int selectedColumn = tableKM.getSelectedColumn();
         
         if (selectedColumn == tableKM.getColumnCount() - 1) {
             // Tạo và hiển thị màn hình mới (giả sử gui_XemChiTietKhuyeMai là một JFrame)
             GUI_XemChiTietKhuyeMai gui_XemChiTietKhuyeMai = new GUI_XemChiTietKhuyeMai();
             gui_XemChiTietKhuyeMai.setLocationRelativeTo(null);
             gui_XemChiTietKhuyeMai.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             gui_XemChiTietKhuyeMai.setVisible(true);
         }
    }//GEN-LAST:event_tableKMMouseClicked
    
    // Load date
    private void loadDataKM() {
    	tableKM.removeAll();
    	tableKM.setRowSelectionAllowed(false);
    	tableModel.setRowCount(0);
    	danhSachKM = new ArrayList<>();
    	danhSachKM = khuyenMai_BUS.getAllKhuyenMai();
    	int stt = 1;
    	for(KhuyenMai km : danhSachKM) {
    		tableModel.addRow(new Object[] {stt++, km.getCodeKhuyenMai(), km.getTenKhuyenMai(), km.getLoaiKhuyenMai(),km.getGiaTri(), km.getNgayKhuyenMai(), km.getNgayHetHanKM(),km.getDonHangTu(), km.getSoLuongKhuyenMai(), km.getSoLuotDaApDung()});
    	}
    	Calendar currentDate = Calendar.getInstance();
        txtNgayBatDau.setDate(currentDate.getTime());
        currentDate.add(currentDate.MONTH, 1);
        txtNgayKetThuc.setDate(currentDate.getTime());
        sorter = new TableRowSorter<>(tableModel);
        tableKM.setRowSorter(sorter);
    }
    
    private void loadDataSP() {
    	tableChonSP.removeAll();
    	tableChonSP.setRowSelectionAllowed(false);
    	tableModelSP.setRowCount(0);
    	danhSachSp = new ArrayList<>();
    	danhSachSp = sanPham_BUS.laySanPhamChoKM();
    	int stt = 1;
    	for(int i = 0; i < danhSachSp.size(); i++) {
    		tableModelSP.addRow(new Object[] {false ,danhSachSp.get(i).getSanPhamID(),danhSachSp.get(i).getTenSanPham()});
    	}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboboxTimTheoMucGiam;
    private javax.swing.JPanel NhapMa;
    private javax.swing.JTextField TimMaSanPham;
    private javax.swing.JButton btnHuy;
    private javax.swing.JPanel btnKhuyenMaiTao;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTimKiemKhuyenMai;
    private javax.swing.JPanel center;
    private javax.swing.JCheckBox checkBoxSelectChoTatCa;
    private javax.swing.JComboBox<String> comboboxApDung;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.JPanel hinhThuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnlALL;
    private javax.swing.JTable tableChonSP;
    private javax.swing.JTable tableKM;
    private javax.swing.JPanel tableSelectKhuyenMai;
    private javax.swing.JLabel tbLoi;
    private javax.swing.JPanel title;
    private javax.swing.JPanel titleSelectKhuyenMai;
    private javax.swing.JTextField txtDonHangTu;
    private javax.swing.JComboBox<String> txtHinhThuc;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtMucGiamGia;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayKetThuc;
    private javax.swing.JTextField txtSoLuongApDung;
    private javax.swing.JTextField txtTenKM;
    private javax.swing.JTextField txtTimKMTheoMa;
    private javax.swing.JComboBox<String> txtTimTheoHinhThuc;
    // End of variables declaration//GEN-END:variables
}
