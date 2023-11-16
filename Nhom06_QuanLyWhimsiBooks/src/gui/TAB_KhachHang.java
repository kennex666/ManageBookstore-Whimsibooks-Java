/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.formdev.flatlaf.json.ParseException;
import com.formdev.flatlaf.ui.FlatListCellBorder.Default;

import bus.KhachHang_BUS;
import bus.NhanVien_BUS;
import connectDB.ConnectDB;
import entities.KhachHang;
import entities.NhanVien;
import utilities.RegexPattern;

/**
 *
 * @author s2quy
 */
public class TAB_KhachHang extends javax.swing.JPanel {
	KhachHang_BUS khachHangBus = new KhachHang_BUS();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public TAB_KhachHang() {
		initComponents();
		customizeTable();
		loadKhachHangTable();
		showTuBangLenFormKhachHang();
		txtMa.setEditable(false);
		txtMaSoThue.setEditable(false);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		btnThem = new javax.swing.JPanel();
		Left = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		txtMa = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		txtSDT = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		txtTen = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		txtEmail = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		txtDiaChi = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		txtMaSoThue = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		cboLoaiKH = new javax.swing.JComboBox<>();
		dtmNgaySinh = new com.toedter.calendar.JDateChooser();
		cboGioiTinh = new javax.swing.JComboBox<>();
		btnXoaRong = new javax.swing.JButton();
		btnHienThiBang = new javax.swing.JButton();
		right = new javax.swing.JPanel();
		jLabel12 = new javax.swing.JLabel();
		txtMa1 = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();
		txtTen1 = new javax.swing.JTextField();
		jLabel14 = new javax.swing.JLabel();
		txtSDT1 = new javax.swing.JTextField();
		jLabel15 = new javax.swing.JLabel();
		cboGioiTinh1 = new javax.swing.JComboBox<>();
		jLabel16 = new javax.swing.JLabel();
		cboLoaiKH1 = new javax.swing.JComboBox<>();
		btnTimKiemKH = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblKhachHang = new javax.swing.JTable();
		btnThemKH = new javax.swing.JButton();
		btnSuaKH = new javax.swing.JButton();
		btnDangXuatKH = new javax.swing.JButton();
		btnImportKH = new javax.swing.JButton();
		btnExportKH = new javax.swing.JButton();
		btnXoaKH = new javax.swing.JButton();

		setLayout(new java.awt.BorderLayout());

		Left.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin nhân viên"));
		Left.setToolTipText("");

		jLabel3.setText("Mã Khách Hàng :");

		txtMa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtMaActionPerformed(evt);
			}
		});

		jLabel2.setText("Số Điện Thoại:");

		txtSDT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtSDTActionPerformed(evt);
			}
		});

		jLabel4.setText("Họ và tên : ");

		txtTen.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtTenActionPerformed(evt);
			}
		});

		jLabel5.setText("Ngày sinh :");

		jLabel6.setText("Email :");

		txtEmail.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtEmailActionPerformed(evt);
			}
		});

		jLabel7.setText("Giới Tính :");

		jLabel8.setText("Địa chỉ :");

		txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtDiaChiActionPerformed(evt);
			}
		});

		jLabel9.setText("Mã số thuế :");

		txtMaSoThue.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtMaSoThueActionPerformed(evt);
			}
		});

		jLabel10.setText("Loại Khách Hàng :");

		cboLoaiKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cá nhân", "Công ty" }));
		cboLoaiKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cboLoaiKHActionPerformed(evt);
			}
		});

		cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

		btnXoaRong.setBackground(new java.awt.Color(255, 51, 51));
		btnXoaRong.setForeground(new java.awt.Color(255, 255, 255));
		btnXoaRong.setText("Xoá rỗng");
		btnXoaRong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaRongActionPerformed(evt);
			}
		});

		btnHienThiBang.setBackground(new java.awt.Color(15, 145, 239));
		btnHienThiBang.setForeground(new java.awt.Color(255, 255, 255));
		btnHienThiBang.setText("Hiển thị bảng");
		btnHienThiBang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHienThiBangActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
		Left.setLayout(LeftLayout);
		LeftLayout.setHorizontalGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(LeftLayout.createSequentialGroup().addGap(34, 34, 34)
						.addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(txtSDT).addComponent(txtMa).addComponent(txtEmail).addComponent(txtDiaChi)
								.addComponent(cboLoaiKH, 0, 214, Short.MAX_VALUE))
						.addGap(108, 108, 108)
						.addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel7).addComponent(jLabel4).addComponent(jLabel5)
								.addComponent(jLabel9))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(LeftLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(cboGioiTinh, javax.swing.GroupLayout.Alignment.LEADING, 0,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(dtmNgaySinh, javax.swing.GroupLayout.Alignment.LEADING,
												javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
								.addGroup(LeftLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addGroup(LeftLayout.createSequentialGroup().addComponent(btnHienThiBang)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43,
														Short.MAX_VALUE)
												.addComponent(btnXoaRong))
										.addComponent(txtMaSoThue, javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txtTen, javax.swing.GroupLayout.Alignment.LEADING)))
						.addContainerGap(28, Short.MAX_VALUE)));
		LeftLayout.setVerticalGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(LeftLayout.createSequentialGroup().addGap(23, 23, 23)
						.addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3)
								.addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4).addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel2).addComponent(jLabel5))
								.addComponent(dtmNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6)
								.addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel7).addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel8)
								.addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMaSoThue, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel9))
						.addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(LeftLayout.createSequentialGroup().addGap(18, 18, 18)
										.addGroup(LeftLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel10).addComponent(cboLoaiKH,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										LeftLayout.createSequentialGroup()
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(LeftLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(btnHienThiBang).addComponent(btnXoaRong))
												.addGap(19, 19, 19)))));

		right.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm nhân viên"));

		jLabel12.setText("Mã khách hàng:");

		txtMa1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtMa1ActionPerformed(evt);
			}
		});

		jLabel13.setText("Họ và tên: ");

		txtTen1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtTen1ActionPerformed(evt);
			}
		});

		jLabel14.setText("Số điện thoại");

		txtSDT1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtSDT1ActionPerformed(evt);
			}
		});

		jLabel15.setText("Giới tính");

		cboGioiTinh1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"", "Nam", "Nữ" }));
		cboGioiTinh1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cboGioiTinh1ActionPerformed(evt);
			}
		});

		jLabel16.setText("Loại khách hàng");

		cboLoaiKH1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Cá nhân", "Công ty" }));
		cboLoaiKH1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cboLoaiKH1ActionPerformed(evt);
			}
		});

		btnTimKiemKH.setBackground(new java.awt.Color(15, 145, 239));
		btnTimKiemKH.setForeground(new java.awt.Color(255, 255, 255));
		btnTimKiemKH.setText("Tìm Kiếm");
		btnTimKiemKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTimKiemKHActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
		right.setLayout(rightLayout);
		rightLayout
				.setHorizontalGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightLayout.createSequentialGroup()
								.addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(rightLayout.createSequentialGroup()
												.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 116,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(rightLayout.createSequentialGroup().addGap(24, 24, 24)
												.addGroup(rightLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(rightLayout.createSequentialGroup()
																.addGroup(rightLayout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jLabel14,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(jLabel12,
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				96, Short.MAX_VALUE)
																		.addComponent(
																				jLabel15,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED))
														.addGroup(rightLayout
																.createSequentialGroup().addComponent(jLabel13)
																.addGap(22, 22, 22)))
												.addGroup(rightLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(rightLayout.createSequentialGroup()
																.addComponent(cboGioiTinh1,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 66,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(jLabel16,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 92,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(cboLoaiKH1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(txtSDT1).addComponent(txtTen1)
														.addComponent(txtMa1))))
								.addGap(22, 22, 22)));
		rightLayout.setVerticalGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(rightLayout.createSequentialGroup().addGap(17, 17, 17)
						.addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel12).addComponent(txtMa1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel13).addComponent(txtTen1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel14).addComponent(txtSDT1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel15)
								.addComponent(cboGioiTinh1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel16).addComponent(cboLoaiKH1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(27, 27, 27)
						.addComponent(btnTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(15, 145, 239));
		jLabel1.setText("Quản Lý Khách Hàng");

		tblKhachHang.setAutoCreateRowSorter(true);
		tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "STT", "Mã Khách Hàng", "Họ Tên", "Số Điện Thoại", "Ngày sinh", "Email", "Giới Tính",
				"Địa Chỉ", "Mã số thuế", "Loại Khách Hàng" }) {
			Class[] types = new Class[] { java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class, java.lang.String.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		jScrollPane1.setViewportView(tblKhachHang);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(17, Short.MAX_VALUE).addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(35, 35, 35)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout
						.createSequentialGroup().addContainerGap().addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(279, Short.MAX_VALUE)));

		btnThemKH.setBackground(new java.awt.Color(85, 182, 83));
		btnThemKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btnThemKH.setForeground(new java.awt.Color(255, 255, 255));
		btnThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_button/them.png"))); // NOI18N
		btnThemKH.setText("Thêm");
		btnThemKH.setVerifyInputWhenFocusTarget(false);
		btnThemKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemKHActionPerformed(evt);
			}
		});

		btnSuaKH.setBackground(new java.awt.Color(85, 182, 83));
		btnSuaKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btnSuaKH.setForeground(new java.awt.Color(255, 255, 255));
		btnSuaKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_button/sua.png"))); // NOI18N
		btnSuaKH.setText("Sửa");
		btnSuaKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSuaKHActionPerformed(evt);
			}
		});

		btnDangXuatKH.setBackground(new java.awt.Color(255, 102, 102));
		btnDangXuatKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btnDangXuatKH.setForeground(new java.awt.Color(255, 255, 255));
		btnDangXuatKH.setText("Đăng Xuất");
		btnDangXuatKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDangXuatKHActionPerformed(evt);
			}
		});

		btnImportKH.setBackground(new java.awt.Color(85, 182, 83));
		btnImportKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btnImportKH.setForeground(new java.awt.Color(255, 255, 255));
		btnImportKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_button/import.png"))); // NOI18N
		btnImportKH.setText("Import");
		btnImportKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnImportKHActionPerformed(evt);
			}
		});

		btnExportKH.setBackground(new java.awt.Color(85, 182, 83));
		btnExportKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btnExportKH.setForeground(new java.awt.Color(255, 255, 255));
		btnExportKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_button/export.png"))); // NOI18N
		btnExportKH.setText("Export");
		btnExportKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnExportKHActionPerformed(evt);
			}
		});

		btnXoaKH.setBackground(new java.awt.Color(85, 182, 83));
		btnXoaKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		btnXoaKH.setForeground(new java.awt.Color(255, 255, 255));
		btnXoaKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_button/xoa.png"))); // NOI18N
		btnXoaKH.setText("Xoá");
		btnXoaKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaKHActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout btnThemLayout = new javax.swing.GroupLayout(btnThem);
		btnThem.setLayout(btnThemLayout);
		btnThemLayout.setHorizontalGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnThemLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
						.addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(btnThemKH, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSuaKH, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnImportKH, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnExportKH, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnXoaKH, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDangXuatKH, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 250,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(116, 116, 116))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						btnThemLayout.createSequentialGroup()
								.addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(btnThemLayout.createSequentialGroup()
												.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(btnThemLayout.createSequentialGroup().addGap(23, 23, 23)
												.addComponent(Left, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(48, 48, 48)));
		btnThemLayout.setVerticalGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(btnThemLayout.createSequentialGroup().addGap(7, 7, 7).addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(Left, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(right, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(22, 22, 22)
						.addGroup(btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(btnThemLayout.createSequentialGroup().addGap(6, 6, 6)
										.addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnSuaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnXoaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(12, 12, 12)
										.addComponent(btnImportKH, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnExportKH, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnDangXuatKH, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		add(btnThem, java.awt.BorderLayout.CENTER);
	}// </editor-fold>//GEN-END:initComponents

	private void customizeTable() {
		// Lấy đối tượng JTableHeader của bảng tblNhanVien
		JTableHeader header = tblKhachHang.getTableHeader();
		DefaultTableCellRenderer headerTitle = new DefaultTableCellRenderer();
		// Tạo một đối tượng Color để đại diện cho màu nền
		Color headerBackgroundColor = Color.decode("#2FA1D2"); // Màu nền là màu mã hex #42d212

		// Tạo một đối tượng Color để đại diện cho màu chữ
		Color headerForegroundColor = Color.WHITE; // Màu chữ là màu trắng

		header.setBackground(headerBackgroundColor);
		header.setForeground(headerForegroundColor);
		header.setFont(new Font("arial", Font.BOLD, 12));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER); // Đặt kiểu căn giữa

		// Đặt renderer cho từng cột riêng lẻ
		for (int i = 0; i < tblKhachHang.getColumnCount(); i++) {
			tblKhachHang.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
	}

	private void btnXoaRongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaRongActionPerformed
		// TODO add your handling code here:
		xoaRong();
	}// GEN-LAST:event_btnXoaRongActionPerformed

	private void btnHienThiBangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHienThiBangActionPerformed
		loadKhachHangTable();
	}// GEN-LAST:event_btnHienThiBangActionPerformed

	private void btnTimKiemKHActionPerformed(java.awt.event.ActionEvent evt) {
		// Lấy thông tin từ các trường nhập liệu
		String maKhachHang = txtMa1.getText();
		String tenKhachHang = txtTen1.getText();
		String soDienThoai = txtSDT1.getText();
		String gioiTinh = (String) cboGioiTinh1.getSelectedItem();
		String loaiKhachHang = (String) cboLoaiKH1.getSelectedItem();

		// Gọi hàm tìm kiếm nâng cao từ lớp BUS
		ArrayList<KhachHang> resultList = khachHangBus.findKhachHangAdvanced(maKhachHang, tenKhachHang, soDienThoai,
				gioiTinh, loaiKhachHang);

		// Ví dụ hiển thị trên bảng (sử dụng một DefaultTableModel cho bảng jTable1)
		DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
		if (!resultList.isEmpty()) {
			model.setRowCount(0);
			for (int i = 0; i < resultList.size(); i++) {
				KhachHang kh = resultList.get(i);
				model.addRow(
						new Object[] { i + 1, kh.getKhachHangID(), kh.getHoTen(), kh.getSoDienThoai(), kh.getNgaySinh(),
								kh.getEmail(), kh.getGioiTinh(), kh.getDiaChi(), kh.getMaSoThue(), kh.getLoaiKhachHang() });
			}
		} else {
			JOptionPane.showMessageDialog(this, "Không tìm thấy");
		}
	}

	private void xoaRong() {
		txtMa.setText("");
		txtTen.setText("");
		txtSDT.setText("");
		dtmNgaySinh.setDate(null);
		txtEmail.setText("");
		txtMaSoThue.setText("");
		txtDiaChi.setText("");

		cboGioiTinh.setSelectedIndex(0);
		cboLoaiKH.setSelectedIndex(0);
	}

	private void loadKhachHangTable() {
		ConnectDB.connect();
		DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
		model.setRowCount(0);
		KhachHang_BUS khachHangBus = new KhachHang_BUS();
		ArrayList<KhachHang> listKH = khachHangBus.getAllKhachHang();
		for (int i = 0; i < listKH.size(); i++) {
			KhachHang kh = listKH.get(i);
			model.addRow(
					new Object[] { i + 1, kh.getKhachHangID(), kh.getHoTen(), kh.getSoDienThoai(), kh.getNgaySinh(),
							kh.getEmail(), kh.getGioiTinh(), kh.getDiaChi(), kh.getMaSoThue(), kh.getLoaiKhachHang() });
		}
	}

	private String phatSinhMaKhachHang() {
		try {
			int maxId = khachHangBus.phatSinhMaKhachHang();
			return "KH" + String.format("%04d", maxId + 1);
		} catch (Exception e) {

			return "KH" + "0001";
		}
	}

	private String phatSinhMaSoThue(String loaiKhachHang) {
		KhachHang_BUS khachHangBus = new KhachHang_BUS();
		return khachHangBus.phatSinhMaSoThue(loaiKhachHang);
	}

	private void showTuBangLenFormKhachHang() {
		tblKhachHang.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tblKhachHang.rowAtPoint(e.getPoint());
				if (row >= 0) {
					// Lấy giá trị từ bảng và hiển thị lên các JTextField và JComboBox
					txtMa.setText(tblKhachHang.getValueAt(row, 1).toString());
					txtTen.setText(tblKhachHang.getValueAt(row, 2).toString());
					txtSDT.setText(tblKhachHang.getValueAt(row, 3).toString());

					// Hiển thị ngày sinh
					String ngaySinh = tblKhachHang.getValueAt(row, 4).toString();
					try {
						Date ngaySinhDate = dateFormat.parse(ngaySinh);
						dtmNgaySinh.setDate(ngaySinhDate);
					} catch (java.text.ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					txtEmail.setText(tblKhachHang.getValueAt(row, 5).toString());
					cboGioiTinh.setSelectedItem(tblKhachHang.getValueAt(row, 6).toString());
					txtDiaChi.setText(tblKhachHang.getValueAt(row, 7).toString());
					txtMaSoThue.setText(tblKhachHang.getValueAt(row, 8).toString());
					cboLoaiKH.setSelectedItem(tblKhachHang.getValueAt(row, 9).toString());
				}
			}
		});
	}

	private boolean valid() {
		String errorMessage = "";
		String maKH = phatSinhMaKhachHang();
		String errorMessage1 = "";
		// Kiểm tra mã khách hàng
		if (maKH.isBlank()) {
			errorMessage += "Mã khách hàng không được trống.\n";
			JOptionPane.showMessageDialog(this, errorMessage);
			return false;
		}

		if (txtTen.getText().isEmpty()) {
			errorMessage += "Họ tên không được trống.\n";
			JOptionPane.showMessageDialog(this, errorMessage);
			return false;
		}
		if (!txtTen.getText().matches(RegexPattern.HOTEN)) {
			errorMessage1 += "Họ tên không hợp lệ phải viết hoa các chữ cái đầu.\n";
			JOptionPane.showMessageDialog(this, errorMessage1);
			return false;

		}
		// Kiểm tra số điện thoại
		if (txtSDT.getText().isBlank()) {
			errorMessage += "Số điện thoại không được trống.\n";
			JOptionPane.showMessageDialog(this, errorMessage);
			return false;
		}
		if (!txtSDT.getText().matches(RegexPattern.SDTVN)) {
			errorMessage1 += "Số điện thoại: phải Có định dạng là 0XXXXXXXXX . \n";
			JOptionPane.showMessageDialog(this, errorMessage1);
			return false;
		}
		// Kiểm tra ngày sinh
		if (dtmNgaySinh.getDate() == null) {
			errorMessage += "Ngày sinh không được trống.\n";
			JOptionPane.showMessageDialog(this, errorMessage);
			return false;
		}

		// Kiểm tra địa chỉ
		if (txtDiaChi.getText().isBlank()) {
			errorMessage += "Địa chỉ không được trống.\n";
			JOptionPane.showMessageDialog(this, errorMessage);
			return false;
		}

		// Kiểm tra loại khách hàng
		if (cboLoaiKH.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, errorMessage);
			errorMessage += "Vui lòng chọn loại khách hàng.\n";
			return false;
		}

		// Nếu errorMessage không trống, hiển thị thông báo lỗi
		if (!errorMessage.isEmpty()) {

			JOptionPane.showMessageDialog(this, errorMessage);
			return false;
		}

		return true;
	}

	private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {
		if (valid()) {
			try {
				String maKH = phatSinhMaKhachHang();
				String tenKH = txtTen.getText();
				String sdtKH = txtSDT.getText();
				java.util.Date chonNgaySinh = dtmNgaySinh.getDate();
				String ngaySinh = dateFormat.format(chonNgaySinh);
				String gioiTinh = (String) cboGioiTinh.getSelectedItem();
				String email = txtEmail.getText();

				String diaChi = txtDiaChi.getText();
				String loaiKH = (String) cboLoaiKH.getSelectedItem();
				String maSoThue = phatSinhMaSoThue(loaiKH);

				KhachHang newKhachHang = new KhachHang(maKH, tenKH, sdtKH, LocalDate.parse(ngaySinh), gioiTinh, email,
						maSoThue, diaChi, loaiKH);
				KhachHang_BUS khachHangBus = new KhachHang_BUS();
				if (khachHangBus.addKhachHang(newKhachHang)) {
					JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
					loadKhachHangTable();
					xoaRong();
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Lỗi các trường nhập vào...");
			}
		}
	}

	private void btnSuaKHActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSuaKHActionPerformed
		int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa không", "Xác nhận",
				JOptionPane.YES_NO_OPTION);
		if (valid()) {
//			KhachHang kh = new 
			String maKH = txtMa.getText();
			String tenKH = txtTen.getText();
			String sdtKH = txtSDT.getText();
			Date ngaySinh = dtmNgaySinh.getDate();
			LocalDate ngaySinh1 = ngaySinh.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			String email = txtEmail.getText();
			String gioiTinh = cboGioiTinh.getSelectedItem().toString();
			String diaChi = txtDiaChi.getText();
			String maSoThue = txtMaSoThue.getText();
			String loaiKH = cboLoaiKH.getSelectedItem().toString();
//			KhachHang exitingKhachHang = khachHangBus.getKhachHangByKhachHangID(maKH);
			KhachHang khachHang = new KhachHang(maKH, tenKH, sdtKH, ngaySinh1, gioiTinh, email, maSoThue, diaChi,
					loaiKH);
			boolean result = khachHangBus.editKhachHang(khachHang);
			if (result) {
				JOptionPane.showMessageDialog(this, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				loadKhachHangTable();
			} else {
				JOptionPane.showMessageDialog(this, "Sửa không thành công!", "Lỗi", JOptionPane.ERROR_MESSAGE);

			}

		}
	}

	private void btnXoaKHActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaKHActionPerformed
		try {
			// Lấy thông tin từ các trường nhập liệu trong giao diện
			String maKhachHang = txtMa.getText();

			// Kiểm tra xem người dùng đã chọn một khách hàng để xóa chưa
			if (maKhachHang.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn một khách hàng để xóa.", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa khách hàng này?",
					"Xác nhận xóa", JOptionPane.YES_NO_OPTION);

			if (confirm == JOptionPane.YES_OPTION) {
				// Tạo một đối tượng KhachHang với mã khách hàng để truyền vào hàm xóa
				KhachHang khachHangXoa = new KhachHang();
				khachHangXoa.setKhachHangID(maKhachHang);

				boolean result = khachHangBus.deleteKhachHang(khachHangXoa);

				// Hiển thị thông báo kết quả
				if (result) {
					JOptionPane.showMessageDialog(this, "Xóa thành công!", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					// Cập nhật lại bảng hoặc làm những gì đó cần thiết
					loadKhachHangTable();
				} else {
					JOptionPane.showMessageDialog(this, "Xóa không thành công!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Lỗi khi xóa khách hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_btnXoaKHActionPerformed

	private void btnImportKHActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnImportKHActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnImportKHActionPerformed

	private void btnExportKHActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExportKHActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnExportKHActionPerformed

	private void btnDangXuatKHActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDangXuatKHActionPerformed
		System.exit(0);
	}// GEN-LAST:event_btnDangXuatKHActionPerformed

	private void txtMa1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtMa1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtMa1ActionPerformed

	private void txtTen1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtTen1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtTen1ActionPerformed

	private void txtSDT1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtSDT1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtSDT1ActionPerformed

	private void cboLoaiKHActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboLoaiKHActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_cboLoaiKHActionPerformed

	private void txtMaSoThueActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtMaSoThueActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtMaSoThueActionPerformed

	private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtDiaChiActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtDiaChiActionPerformed

	private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtEmailActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtEmailActionPerformed

	private void txtTenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtTenActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtTenActionPerformed

	private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtSDTActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtSDTActionPerformed

	private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtMaActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtMaActionPerformed

	private void cboGioiTinh1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboGioiTinh1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_cboGioiTinh1ActionPerformed

	private void cboLoaiKH1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboLoaiKH1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_cboLoaiKH1ActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel Left;
	private javax.swing.JButton btnDangXuatKH;
	private javax.swing.JButton btnExportKH;
	private javax.swing.JButton btnHienThiBang;
	private javax.swing.JButton btnImportKH;
	private javax.swing.JButton btnSuaKH;
	private javax.swing.JPanel btnThem;
	private javax.swing.JButton btnThemKH;
	private javax.swing.JButton btnTimKiemKH;
	private javax.swing.JButton btnXoaKH;
	private javax.swing.JButton btnXoaRong;
	private javax.swing.JComboBox<String> cboGioiTinh;
	private javax.swing.JComboBox<String> cboGioiTinh1;
	private javax.swing.JComboBox<String> cboLoaiKH;
	private javax.swing.JComboBox<String> cboLoaiKH1;
	private com.toedter.calendar.JDateChooser dtmNgaySinh;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JPanel right;
	private javax.swing.JTable tblKhachHang;
	private javax.swing.JTextField txtDiaChi;
	private javax.swing.JTextField txtEmail;
	private javax.swing.JTextField txtMa;
	private javax.swing.JTextField txtMa1;
	private javax.swing.JTextField txtMaSoThue;
	private javax.swing.JTextField txtSDT;
	private javax.swing.JTextField txtSDT1;
	private javax.swing.JTextField txtTen;
	private javax.swing.JTextField txtTen1;
	// End of variables declaration//GEN-END:variables
}
