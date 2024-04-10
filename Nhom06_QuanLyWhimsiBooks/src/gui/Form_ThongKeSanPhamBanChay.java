/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import bus.ThongKe_BUS;
import ultilities.ErrorMessage;
import ultilities.Numberic;
import ultilities.chartbar.Chart;
import ultilities.chartbar.ModelChart;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author duong
 */
public class Form_ThongKeSanPhamBanChay extends javax.swing.JPanel {

    private DefaultTableModel modelThongKeXuHuong;
    private ThongKe_BUS thongKe_BUS;
    private String[] quyTRANS = {"", "I", "II", "III", "IV"};

    /**
     * Creates new form Form_ThongKeDoanhThu
     */
    public Form_ThongKeSanPhamBanChay() {
        thongKe_BUS = new ThongKe_BUS();

        initComponents();
        Date ngayKetThuc = new Date();
        jPanel13.setVisible(false);
        btnXuatExel.setVisible(false);

        txtNgayBatDau.setEnabled(false);
        txtNgayKetThuc.setEnabled(false);
        cboQuy.setEnabled(false);

        Date ngayBatDau = new Date();
        ngayBatDau.setDate(ngayKetThuc.getDate() - 7);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTienVon = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblTraHang = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblLoiNhuan = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblDoanhThu = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTitleThongKe = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 15), new java.awt.Dimension(10, 15), new java.awt.Dimension(10, 15));
        jPanel13 = new javax.swing.JPanel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jLabel11 = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jComboBox1 = new javax.swing.JComboBox<>();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jPanel14 = new javax.swing.JPanel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jLabel12 = new javax.swing.JLabel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        cboBaoCaoTheo = new javax.swing.JComboBox<>();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        panelQuy = new javax.swing.JPanel();
        filler28 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jLabel15 = new javax.swing.JLabel();
        filler29 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        cboQuy = new javax.swing.JComboBox<>();
        filler30 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        filler31 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jPanel15 = new javax.swing.JPanel();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jLabel13 = new javax.swing.JLabel();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jPanel16 = new javax.swing.JPanel();
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        filler16 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jPanel17 = new javax.swing.JPanel();
        filler15 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jLabel14 = new javax.swing.JLabel();
        filler17 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        filler18 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        jPanel18 = new javax.swing.JPanel();
        filler21 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        txtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        filler22 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        filler20 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20));
        jPanel19 = new javax.swing.JPanel();
        filler23 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        btnThongKe = new javax.swing.JButton();
        filler24 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        filler27 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20));
        jPanel20 = new javax.swing.JPanel();
        filler25 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));
        btnXuatExel = new javax.swing.JButton();
        filler26 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10), new java.awt.Dimension(10, 10));

        setLayout(new java.awt.GridBagLayout());

        java.awt.GridBagLayout jPanel4Layout = new java.awt.GridBagLayout();
        jPanel4Layout.columnWidths = new int[] {0};
        jPanel4Layout.rowHeights = new int[] {0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0};
        jPanel4.setLayout(jPanel4Layout);

        java.awt.GridBagLayout jPanel5Layout = new java.awt.GridBagLayout();
        jPanel5Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel5Layout.rowHeights = new int[] {0};
        jPanel5.setLayout(jPanel5Layout);

        jPanel8.setBackground(new java.awt.Color(20, 116, 185));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tổng vốn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        jPanel8.add(jLabel1, gridBagConstraints);

        lblTienVon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTienVon.setForeground(new java.awt.Color(255, 255, 255));
        lblTienVon.setText("Chưa thống kê");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        jPanel8.add(lblTienVon, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel5.add(jPanel8, gridBagConstraints);

        jPanel9.setBackground(new java.awt.Color(20, 116, 185));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Trả hàng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        jPanel9.add(jLabel3, gridBagConstraints);

        lblTraHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTraHang.setForeground(new java.awt.Color(255, 255, 255));
        lblTraHang.setText("Chưa thống kê");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        jPanel9.add(lblTraHang, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel5.add(jPanel9, gridBagConstraints);

        jPanel10.setBackground(new java.awt.Color(20, 116, 185));
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Lợi nhuận");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        jPanel10.add(jLabel5, gridBagConstraints);

        lblLoiNhuan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLoiNhuan.setForeground(new java.awt.Color(255, 255, 255));
        lblLoiNhuan.setText("Chưa thống kê");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        jPanel10.add(lblLoiNhuan, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel5.add(jPanel10, gridBagConstraints);

        jPanel11.setBackground(new java.awt.Color(20, 116, 185));
        jPanel11.setLayout(new java.awt.GridBagLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tổng doanh thu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        jPanel11.add(jLabel7, gridBagConstraints);

        lblDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        lblDoanhThu.setText("Chưa thống kê");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        jPanel11.add(lblDoanhThu, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel5.add(jPanel11, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 29;
        gridBagConstraints.weightx = 0.1;
        jPanel4.add(jPanel5, gridBagConstraints);

        java.awt.GridBagLayout jPanel7Layout = new java.awt.GridBagLayout();
        jPanel7Layout.columnWidths = new int[] {0, 5, 0, 5, 0};
        jPanel7Layout.rowHeights = new int[] {0, 9, 0};
        jPanel7.setLayout(jPanel7Layout);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblTitleThongKe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTitleThongKe.setText("Sản phẩm bán chạy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(lblTitleThongKe, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel7.add(jPanel1, gridBagConstraints);

        jTable1.setModel(modelThongKeXuHuong = new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Barcode", "Tên sản phẩm", "SL tồn", "Đã bán", "Trả hàng", "Tổng thu", "Tổng vốn", "Lợi nhuận"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(15);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.8;
        jPanel4.add(jPanel7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jPanel4, gridBagConstraints);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel6.setMaximumSize(new java.awt.Dimension(80, 600));
        jPanel6.setPreferredSize(new java.awt.Dimension(80, 516));
        jPanel6.setRequestFocusEnabled(false);
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.Y_AXIS));

        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.LINE_AXIS));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("Tuỳ chọn báo cáo");
        jPanel12.add(jLabel10);

        jPanel6.add(jPanel12);

        filler2.setEnabled(false);
        jPanel6.add(filler2);

        jPanel13.setEnabled(false);
        jPanel13.setMaximumSize(new java.awt.Dimension(300, 25));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));
        jPanel13.add(filler5);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Thống kê theo:");
        jPanel13.add(jLabel11);
        jPanel13.add(filler3);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sản phẩm" }));
        jPanel13.add(jComboBox1);
        jPanel13.add(filler8);

        jPanel6.add(jPanel13);
        jPanel6.add(filler1);

        jPanel14.setMaximumSize(new java.awt.Dimension(300, 25));
        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.LINE_AXIS));
        jPanel14.add(filler6);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Báo cáo theo:  ");
        jPanel14.add(jLabel12);
        jPanel14.add(filler4);

        cboBaoCaoTheo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày hôm nay", "Tuần này", "Tháng này", "Năm nay", "Quý", "Thời gian tuỳ chọn" }));
        cboBaoCaoTheo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBaoCaoTheoActionPerformed(evt);
            }
        });
        jPanel14.add(cboBaoCaoTheo);
        jPanel14.add(filler7);

        jPanel6.add(jPanel14);
        jPanel6.add(filler12);

        panelQuy.setMaximumSize(new java.awt.Dimension(300, 25));
        panelQuy.setLayout(new javax.swing.BoxLayout(panelQuy, javax.swing.BoxLayout.LINE_AXIS));
        panelQuy.add(filler28);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Quý:");
        panelQuy.add(jLabel15);
        panelQuy.add(filler29);

        cboQuy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quý I (năm nay)", "Quý II (năm nay)", "Quý III (năm nay)", "Quý IV (năm nay)" }));
        cboQuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboQuyActionPerformed(evt);
            }
        });
        panelQuy.add(cboQuy);
        panelQuy.add(filler30);

        jPanel6.add(panelQuy);
        jPanel6.add(filler31);

        jPanel15.setMaximumSize(new java.awt.Dimension(300, 25));
        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.LINE_AXIS));
        jPanel15.add(filler9);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Thời gian bắt đầu:");
        jPanel15.add(jLabel13);
        jPanel15.add(filler10);

        jPanel6.add(jPanel15);
        jPanel6.add(filler13);

        jPanel16.setMaximumSize(new java.awt.Dimension(300, 25));
        jPanel16.setLayout(new javax.swing.BoxLayout(jPanel16, javax.swing.BoxLayout.LINE_AXIS));
        jPanel16.add(filler14);
        jPanel16.add(txtNgayBatDau);
        jPanel16.add(filler16);

        jPanel6.add(jPanel16);
        jPanel6.add(filler11);

        jPanel17.setMaximumSize(new java.awt.Dimension(300, 25));
        jPanel17.setLayout(new javax.swing.BoxLayout(jPanel17, javax.swing.BoxLayout.LINE_AXIS));
        jPanel17.add(filler15);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Thời gian kết thúc:");
        jPanel17.add(jLabel14);
        jPanel17.add(filler17);
        jPanel17.add(filler18);

        jPanel6.add(jPanel17);
        jPanel6.add(filler19);

        jPanel18.setMaximumSize(new java.awt.Dimension(300, 25));
        jPanel18.setLayout(new javax.swing.BoxLayout(jPanel18, javax.swing.BoxLayout.LINE_AXIS));
        jPanel18.add(filler21);
        jPanel18.add(txtNgayKetThuc);
        jPanel18.add(filler22);

        jPanel6.add(jPanel18);
        jPanel6.add(filler20);

        jPanel19.setMaximumSize(new java.awt.Dimension(300, 50));
        jPanel19.setPreferredSize(new java.awt.Dimension(95, 50));
        jPanel19.setLayout(new java.awt.GridBagLayout());
        jPanel19.add(filler23, new java.awt.GridBagConstraints());

        btnThongKe.setBackground(new java.awt.Color(15, 145, 239));
        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKe.setText("Thống kê");
        btnThongKe.setPreferredSize(new java.awt.Dimension(200, 50));
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel19.add(btnThongKe, gridBagConstraints);
        jPanel19.add(filler24, new java.awt.GridBagConstraints());

        jPanel6.add(jPanel19);
        jPanel6.add(filler27);

        jPanel20.setMaximumSize(new java.awt.Dimension(300, 50));
        jPanel20.setPreferredSize(new java.awt.Dimension(95, 50));
        jPanel20.setLayout(new java.awt.GridBagLayout());
        jPanel20.add(filler25, new java.awt.GridBagConstraints());

        btnXuatExel.setBackground(new java.awt.Color(85, 182, 83));
        btnXuatExel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXuatExel.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatExel.setText("Xuất Excel");
        btnXuatExel.setPreferredSize(new java.awt.Dimension(200, 50));
        btnXuatExel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel20.add(btnXuatExel, gridBagConstraints);
        jPanel20.add(filler26, new java.awt.GridBagConstraints());

        jPanel6.add(jPanel20);

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        add(jPanel3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnXuatExelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXuatExelActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
        int pos = cboBaoCaoTheo.getSelectedIndex();
        Date start = new Date();
        Date end = new Date();
        if (pos == 5) {
            Date ngayKetThuc = new Date();
            if (txtNgayBatDau.getDate() == null) {
                ErrorMessage.showMessageWithFocusTextField("Lỗi", "Vui lòng chọn ngày bắt đầu!", null);
                return;
            }

            if (txtNgayKetThuc.getDate() == null) {
                ErrorMessage.showMessageWithFocusTextField("Lỗi", "Vui lòng chọn ngày bắt đầu!", null);
                return;
            }
            start = txtNgayBatDau.getDate();
            end = txtNgayKetThuc.getDate();

            if (end.getTime() < start.getTime()) {
                ErrorMessage.showConfirmDialogYesNo("Chú ý",
                        "Thời gian bắt đầu không hợp lệ. Phải nhỏ hơn hoặc bằng thời gian kết thúc!");
                txtNgayBatDau.requestFocus();
                return;
            }
        } else if (pos == 0) {
            end = new Date();
            start = new Date();
        } else if (pos == 1) {
            end = new Date();
            start = new Date(end.getYear(), end.getMonth(), end.getDate() - 7);
        } else if (pos == 2) {
            end = new Date();
            start = new Date(end.getYear(), end.getMonth(), 1);
            end.setMonth(end.getMonth() + 1);
            end.setDate(0);
        } else if (pos == 3) {
            end = new Date();
            start = new Date(end.getYear() - 1, 0, 1);
        } else if (pos == 4) {
            int quyPos = cboQuy.getSelectedIndex();
            switch (quyPos) {
                case 0:
                    start = new Date();
                    start = new Date(start.getYear(), 0, 1);
                    end = new Date(start.getYear(), 2, 31);
                    break;
                case 1:
                    start = new Date();
                    start = new Date(start.getYear(), 3, 1);
                    end = new Date(start.getYear(), 5, 30);
                    break;
                case 2:
                    start = new Date();
                    start = new Date(start.getYear(), 6, 1);
                    end = new Date(start.getYear(), 8, 30);
                    break;
                case 3:
                    start = new Date();
                    start = new Date(start.getYear(), 9, 1);
                    end = new Date(start.getYear(), 11, 31);
                    break;
                default:
                    start = new Date();
                    start = new Date(start.getYear(), 0, 1);
                    end = new Date(start.getYear(), 2, 31);
                    break;
            }
        }

        end.setHours(23);
        end.setMinutes(59);
        end.setSeconds(59);
        start.setHours(0);
        start.setMinutes(0);
        start.setSeconds(0);
        loadThongKe(start, end, "Thống kê sản phẩm bán chạy");

    }//GEN-LAST:event_btnThongKeActionPerformed

    private void cboQuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboQuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboQuyActionPerformed

    private void cboBaoCaoTheoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBaoCaoTheoActionPerformed
        // TODO add your handling code here:
        int pos = cboBaoCaoTheo.getSelectedIndex();
        if (pos < 0) {
            return;
        }

        if (pos == 5) {
            txtNgayBatDau.setEnabled(true);
            txtNgayKetThuc.setEnabled(true);
            cboQuy.setEnabled(false);
            Date ngayHomNay = new Date();
            ngayHomNay.setHours(0);
            ngayHomNay.setMinutes(0);

            txtNgayBatDau.setDate(ngayHomNay);
            txtNgayKetThuc.setDate(ngayHomNay);
        } else {
            txtNgayBatDau.setEnabled(false);
            txtNgayKetThuc.setEnabled(false);
            if (pos == 4) {
                cboQuy.setEnabled(true);
            } else {
                cboQuy.setEnabled(false);
            }

            txtNgayBatDau.setDate(null);
            txtNgayKetThuc.setDate(null);
        }
    }//GEN-LAST:event_cboBaoCaoTheoActionPerformed

    public void loadThongKe(Date start, Date end, String tilte) {
        double tongDoanhThu = 0, tongTienVon = 0, tongLoiNhuan = 0, tongTraHang = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Object[]> listXuHuong = thongKe_BUS.thongKeXuHuongTheoThoiGian(start, end);
        while (modelThongKeXuHuong.getRowCount() > 0) {
            modelThongKeXuHuong.removeRow(0);
        }
        for (int i = 0; i < listXuHuong.size(); i++) {
            Object[] temp = listXuHuong.get(i);
            temp[0] = i + 1;
            modelThongKeXuHuong.addRow(temp);
            tongDoanhThu += (double) temp[6];
            tongLoiNhuan += (double) temp[8];
            tongTienVon += (double) temp[7];
            tongTraHang += (double) temp[9];
        }
        
        lblDoanhThu.setText(Numberic.formatD(tongDoanhThu));
        lblLoiNhuan.setText(Numberic.formatD(tongLoiNhuan));
        lblTraHang.setText(Numberic.formatD(tongTraHang));
        lblTienVon.setText(Numberic.formatD(tongTienVon));
        
        lblTitleThongKe.setText("Thống kê sản phẩm bán chạy từ ngày " + sdf.format(start) + " đến ngày " + sdf.format(end));
    }

    public int getDiffDate(Date d1, Date d2) {
        int temp = (int) ((d2.getTime() - d1.getTime()) / 1000 / 60 / 60 / 24);
        return temp;
    }

    public int getDiffMonth(Date d1, Date d2) {
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(d1);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(d2);

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        return diffMonth;
    }

    public int getDiffYear(Date d1, Date d2) {
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(d1);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(d2);

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        return diffYear;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnThongKe;
    public javax.swing.JButton btnXuatExel;
    public javax.swing.JComboBox<String> cboBaoCaoTheo;
    public javax.swing.JComboBox<String> cboQuy;
    public javax.swing.Box.Filler filler1;
    public javax.swing.Box.Filler filler10;
    public javax.swing.Box.Filler filler11;
    public javax.swing.Box.Filler filler12;
    public javax.swing.Box.Filler filler13;
    public javax.swing.Box.Filler filler14;
    public javax.swing.Box.Filler filler15;
    public javax.swing.Box.Filler filler16;
    public javax.swing.Box.Filler filler17;
    public javax.swing.Box.Filler filler18;
    public javax.swing.Box.Filler filler19;
    public javax.swing.Box.Filler filler2;
    public javax.swing.Box.Filler filler20;
    public javax.swing.Box.Filler filler21;
    public javax.swing.Box.Filler filler22;
    public javax.swing.Box.Filler filler23;
    public javax.swing.Box.Filler filler24;
    public javax.swing.Box.Filler filler25;
    public javax.swing.Box.Filler filler26;
    public javax.swing.Box.Filler filler27;
    public javax.swing.Box.Filler filler28;
    public javax.swing.Box.Filler filler29;
    public javax.swing.Box.Filler filler3;
    public javax.swing.Box.Filler filler30;
    public javax.swing.Box.Filler filler31;
    public javax.swing.Box.Filler filler4;
    public javax.swing.Box.Filler filler5;
    public javax.swing.Box.Filler filler6;
    public javax.swing.Box.Filler filler7;
    public javax.swing.Box.Filler filler8;
    public javax.swing.Box.Filler filler9;
    public javax.swing.JComboBox<String> jComboBox1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel10;
    public javax.swing.JPanel jPanel11;
    public javax.swing.JPanel jPanel12;
    public javax.swing.JPanel jPanel13;
    public javax.swing.JPanel jPanel14;
    public javax.swing.JPanel jPanel15;
    public javax.swing.JPanel jPanel16;
    public javax.swing.JPanel jPanel17;
    public javax.swing.JPanel jPanel18;
    public javax.swing.JPanel jPanel19;
    public javax.swing.JPanel jPanel20;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    public javax.swing.JPanel jPanel7;
    public javax.swing.JPanel jPanel8;
    public javax.swing.JPanel jPanel9;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    public javax.swing.JLabel lblDoanhThu;
    public javax.swing.JLabel lblLoiNhuan;
    public javax.swing.JLabel lblTienVon;
    public javax.swing.JLabel lblTitleThongKe;
    public javax.swing.JLabel lblTraHang;
    public javax.swing.JPanel panelQuy;
    public com.toedter.calendar.JDateChooser txtNgayBatDau;
    public com.toedter.calendar.JDateChooser txtNgayKetThuc;
    // End of variables declaration//GEN-END:variables
}
