
package gui;

import bus.ChiTietHoaDon_BUS;
import bus.HoaDon_BUS;
import bus.SanPham_BUS;
import connectDB.ConnectDB;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.SanPham;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import utilities.*;

/**
 *
 * @author duong
 */
public class TAB_BanHang extends javax.swing.JPanel implements MouseListener {
    private SanPham_BUS sanPham_BUS;
    private HoaDon_BUS hoaDon_BUS;
    private ChiTietHoaDon_BUS chiTietHoaDon_BUS;
    private HoaDon hoaDon;
    private DefaultTableModel tblModelCTHD;
    /**
     * Creates new form TAB_BanHang
     */
    public TAB_BanHang() {
    	// Hoá đơn mặc định.
        sanPham_BUS = new SanPham_BUS();
    	hoaDon = new HoaDon();
    	
        initComponents();
        
        jTable1.getColumn("-").setCellRenderer(new ButtonRender(
                ImageProcessing.resizeIcon(
                    new ImageIcon(getClass().getResource("/img/icon/btn-decrease.png"))
                , 15, 15)
        ));

        jTable1.getColumn("+").setCellRenderer(new ButtonRender(
                ImageProcessing.resizeIcon(
                    new ImageIcon(getClass().getResource("/img/icon/btn-increase.png"))
                , 15, 15)
        ));
        jTable1.getColumn("Xoá").setCellRenderer(new ButtonRender(
                ImageProcessing.resizeIcon(
                    new ImageIcon(getClass().getResource("/img/icon/btn-delete-no-transparent.png"))
                , 12, 15)
        ));
        
        jTable1.addMouseListener(this);
        
        // Placeholder text
        ((utilities.JTextFieldPlaceHolder) txtMaKhachHang).setPlaceholder("Nhập mã KH hoặc SĐT");
        ((utilities.JTextFieldPlaceHolder) txtKhuyenMai).setPlaceholder("Nhập mã khuyến mãi");
        
        WindowTitle.setTitle("Quản lý bán hàng");
        
        AbstractAction thanhToanAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnThanhToanActionPerformed(e);
            }
        };
        btnThanhToan.registerKeyboardAction(thanhToanAction, KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0), WHEN_IN_FOCUSED_WINDOW);
        
        tblModelCTHD.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent event) {
                int row = event.getFirstRow(), col = event.getColumn();
                int newValue = 0;
                if (col == 5){
                    newValue = (int) tblModelCTHD.getValueAt(row, col);
                    
                    if (newValue <= 0){
                        hoaDon.getListChiTietHoaDon().remove(row);
			tblModelCTHD.removeRow(row);
			reIndexTable();
                    }else{
                        hoaDon.getListChiTietHoaDon().get(row).setSoLuong(newValue);
                    }
                    updateThongTinBill();
                    
                }
            }
        });
    }
    
    public void reIndexTable() {
    	for (int i = 0; i < tblModelCTHD.getRowCount(); i++) {
    		tblModelCTHD.setValueAt(i + 1, i, 0);
    	}
    }
    
    public void updateThongTinBill() {
    	txtValueThanhTien.setText(Numberic.formatVND(hoaDon.tinhThanhTien())); 
    	txtValueChietKhau.setText(Numberic.formatVND(hoaDon.getGiaKhuyenMai()));
    	txtValueTongThue.setText(Numberic.formatVND(hoaDon.tinhTongThue()));
    	txtValueTongTien.setText(Numberic.formatVND(hoaDon.tinhTongTien()));
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    	ChiTietHoaDon cthd = null;
    	// TODO Auto-generated method stub
    	if (e.getSource().equals(jTable1)) {
    		JTable tbl = (JTable)e.getSource();
            int row = tbl.rowAtPoint( e.getPoint() );
            int column = tbl.columnAtPoint( e.getPoint() );
            cthd = hoaDon.getListChiTietHoaDon().get(row);
            // Không tồn tại.
            if (hoaDon.getListChiTietHoaDon().size() < row)
            	return;
            
            switch (column) {
				case 4 -> {
					if (cthd.getSoLuong() - 1 <= 0) {
						hoaDon.removeChiTietHoaDon(cthd);
						tblModelCTHD.removeRow(row);
						reIndexTable();
					}else {
						cthd.setSoLuong(cthd.getSoLuong() - 1);
						tblModelCTHD.setValueAt(cthd.getSoLuong(), row, 5);
                                                tblModelCTHD.setValueAt(cthd.tinhTongTien(), row, 8);
					}
				}
				case 6 -> {
					cthd.setSoLuong(cthd.getSoLuong() + 1);
					tblModelCTHD.setValueAt(cthd.getSoLuong(), row, 5);
                                        tblModelCTHD.setValueAt(cthd.tinhTongTien(), row, 8);

				}
				case 9 -> {
					if (!ErrorMessage.showConfirmDialogYesNo("Chú ý", "Bạn có chắc chắn muốn xoá sản phẩm " + tbl.getValueAt(row, 2) + " khỏi hoá đơn không??"))
						return;
					hoaDon.removeChiTietHoaDon(cthd);
					tblModelCTHD.removeRow(row);
					reIndexTable();
				}
				default ->{
					
				}
            }
            updateThongTinBill();
    	}
    	
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    	// TODO Auto-generated method stub
    	
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    	// TODO Auto-generated method stub
    	
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    	// TODO Auto-generated method stub
    	
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
    	// TODO Auto-generated method stub
    	
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        tabBanHang_HoaDon_Center = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tabBanHang_HoaDon_Button = new javax.swing.JPanel();
        btnHangCho = new javax.swing.JButton();
        btnCancelHD = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMaSanPham = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnThemSanPham = new javax.swing.JButton();
        btnXoaRongMaSP = new javax.swing.JButton();
        tabBanHang_HoaDon_Right = new javax.swing.JPanel();
        tabBanHang_HoaDon_Right_KhachHang = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        txtMaKhachHang = new utilities.JTextFieldPlaceHolder();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tabBanHang_HoaDon_Right_GiamGia = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        txtKhuyenMai = new utilities.JTextFieldPlaceHolder();
        jButton6 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        panel_TongTien = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtValueTongTien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtValueChietKhau = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtValueThanhTien = new javax.swing.JTextField();
        txtValueTongThue = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnKeyPad = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        TAB_BanHang_HoaDon = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());

        java.awt.GridBagLayout tabBanHang_HoaDon_CenterLayout = new java.awt.GridBagLayout();
        tabBanHang_HoaDon_CenterLayout.columnWidths = new int[] {0};
        tabBanHang_HoaDon_CenterLayout.rowHeights = new int[] {0, 0, 0};
        tabBanHang_HoaDon_Center.setLayout(tabBanHang_HoaDon_CenterLayout);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(tblModelCTHD = new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "-", "Số lượng", "+", "Thuế", "Thành tiền", "Xoá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(0).setHeaderValue("STT");
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Mã sản phẩm");
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Tên sản phẩm");
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Đơn giá");
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(4).setHeaderValue("-");
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(5).setHeaderValue("Số lượng");
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(6).setHeaderValue("+");
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(7).setHeaderValue("Thuế");
            jTable1.getColumnModel().getColumn(8).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setHeaderValue("Thành tiền");
            jTable1.getColumnModel().getColumn(9).setResizable(false);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(9).setHeaderValue("Xoá");
        }
        jTable1.getAccessibleContext().setAccessibleName("");

        jPanel7.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        java.awt.GridBagLayout tabBanHang_HoaDon_Right_GiamGia1Layout = new java.awt.GridBagLayout();
        tabBanHang_HoaDon_Right_GiamGia1Layout.columnWidths = new int[] {0, 8, 0, 8, 0};
        tabBanHang_HoaDon_Right_GiamGia1Layout.rowHeights = new int[] {0, 11, 0};
        tabBanHang_HoaDon_Button.setLayout(tabBanHang_HoaDon_Right_GiamGia1Layout);

        btnHangCho.setBackground(new java.awt.Color(15, 145, 239));
        btnHangCho.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHangCho.setForeground(new java.awt.Color(255, 255, 255));
        btnHangCho.setIcon(ImageProcessing.resizeIcon(
            new ImageIcon(getClass().getResource("/img/icon/btn-waitlist.png"))
            , 25, 25));
    btnHangCho.setText("Hàng chờ (F5)");
    btnHangCho.setIconTextGap(30);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridheight = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipady = 14;
    gridBagConstraints.weightx = 0.1;
    tabBanHang_HoaDon_Button.add(btnHangCho, gridBagConstraints);

    btnCancelHD.setBackground(new java.awt.Color(239, 162, 162));
    btnCancelHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    btnCancelHD.setForeground(new java.awt.Color(255, 255, 255));
    btnCancelHD.setText("Huỷ");
    btnCancelHD.setIconTextGap(30);
    btnCancelHD.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCancelHDActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridheight = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.1;
    tabBanHang_HoaDon_Button.add(btnCancelHD, gridBagConstraints);

    jPanel7.add(tabBanHang_HoaDon_Button, java.awt.BorderLayout.PAGE_END);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.weighty = 0.1;
    tabBanHang_HoaDon_Center.add(jPanel7, gridBagConstraints);

    java.awt.GridBagLayout jPanel6Layout = new java.awt.GridBagLayout();
    jPanel6Layout.columnWidths = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
    jPanel6Layout.rowHeights = new int[] {0, 10, 0, 10, 0};
    jPanel6.setLayout(jPanel6Layout);

    jLabel3.setText("Mã sản phẩm:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.weighty = 0.09;
    gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
    jPanel6.add(jLabel3, gridBagConstraints);

    txtMaSanPham.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddSanPhamActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.weighty = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
    jPanel6.add(txtMaSanPham, gridBagConstraints);

    java.awt.GridBagLayout jPanel5Layout = new java.awt.GridBagLayout();
    jPanel5Layout.columnWidths = new int[] {0, 22, 0, 22, 0, 22, 0};
    jPanel5Layout.rowHeights = new int[] {0};
    jPanel5.setLayout(jPanel5Layout);

    btnThemSanPham.setBackground(new java.awt.Color(15, 102, 165));
    btnThemSanPham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    btnThemSanPham.setForeground(new java.awt.Color(255, 255, 255));
    btnThemSanPham.setIcon(
        ImageProcessing.resizeIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/btn-add.png")), 20,20)
    );
    btnThemSanPham.setIconTextGap(10);
    btnThemSanPham.setPreferredSize(new java.awt.Dimension(50, 20));
    btnThemSanPham.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddSanPhamActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipady = 10;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.weighty = 0.5;
    jPanel5.add(btnThemSanPham, gridBagConstraints);

    btnXoaRongMaSP.setBackground(new java.awt.Color(239, 162, 162));
    btnXoaRongMaSP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    btnXoaRongMaSP.setForeground(new java.awt.Color(255, 255, 255));
    btnXoaRongMaSP.setIcon(
        ImageProcessing.resizeIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/btn-delete.png")), 15,20)
    );
    btnXoaRongMaSP.setIconTextGap(10);
    btnXoaRongMaSP.setPreferredSize(new java.awt.Dimension(50, 20));
    btnXoaRongMaSP.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnXoaRongMaSPActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipady = 15;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.weighty = 0.5;
    jPanel5.add(btnXoaRongMaSP, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 12;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 7;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.weighty = 0.2;
    jPanel6.add(jPanel5, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
    gridBagConstraints.weightx = 0.1;
    tabBanHang_HoaDon_Center.add(jPanel6, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.3;
    gridBagConstraints.weighty = 0.2;
    gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
    jPanel3.add(tabBanHang_HoaDon_Center, gridBagConstraints);

    java.awt.GridBagLayout tabBanHang_HoaDon_RightLayout = new java.awt.GridBagLayout();
    tabBanHang_HoaDon_RightLayout.columnWidths = new int[] {0};
    tabBanHang_HoaDon_RightLayout.rowHeights = new int[] {0, 14, 0, 14, 0};
    tabBanHang_HoaDon_Right.setLayout(tabBanHang_HoaDon_RightLayout);

    tabBanHang_HoaDon_Right_KhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder("Khách hàng"));
    tabBanHang_HoaDon_Right_KhachHang.setLayout(new java.awt.BorderLayout());

    java.awt.GridBagLayout jPanel11Layout = new java.awt.GridBagLayout();
    jPanel11Layout.columnWidths = new int[] {0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0};
    jPanel11Layout.rowHeights = new int[] {0, 9, 0, 9, 0, 9, 0};
    jPanel11.setLayout(jPanel11Layout);

    txtMaKhachHang.setMinimumSize(new java.awt.Dimension(16, 22));
    txtMaKhachHang.setPreferredSize(new java.awt.Dimension(150, 30));
    txtMaKhachHang.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtMaKhachHangActionPerformed(evt);
        }
    });
    jPanel12.add(txtMaKhachHang);

    jButton3.setBackground(new java.awt.Color(15, 102, 165));
    jButton3.setIcon(
        ImageProcessing.resizeIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/btn-search.png")), 20,20)
    );
    jButton3.setPreferredSize(new java.awt.Dimension(50, 30));
    jPanel12.add(jButton3);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 21;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    jPanel11.add(jPanel12, gridBagConstraints);

    jLabel8.setText("Tên khách hàng:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(3, 0, 2, 0);
    jPanel11.add(jLabel8, gridBagConstraints);

    jTextField7.setEditable(false);
    jTextField7.setFocusable(false);
    jTextField7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextField7ActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 11;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
    gridBagConstraints.weightx = 0.1;
    jPanel11.add(jTextField7, gridBagConstraints);

    jTextField8.setEditable(false);
    jTextField8.setFocusable(false);
    jTextField8.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextField8ActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 11;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
    gridBagConstraints.weightx = 0.1;
    jPanel11.add(jTextField8, gridBagConstraints);

    jLabel9.setText("Mã khách hàng:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
    jPanel11.add(jLabel9, gridBagConstraints);

    tabBanHang_HoaDon_Right_KhachHang.add(jPanel11, java.awt.BorderLayout.PAGE_START);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.weighty = 0.1;
    tabBanHang_HoaDon_Right.add(tabBanHang_HoaDon_Right_KhachHang, gridBagConstraints);

    tabBanHang_HoaDon_Right_GiamGia.setBorder(javax.swing.BorderFactory.createTitledBorder("Khuyến mãi"));
    tabBanHang_HoaDon_Right_GiamGia.setLayout(new java.awt.BorderLayout());

    java.awt.GridBagLayout jPanel15Layout = new java.awt.GridBagLayout();
    jPanel15Layout.columnWidths = new int[] {0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0};
    jPanel15Layout.rowHeights = new int[] {0, 9, 0, 9, 0, 9, 0};
    jPanel15.setLayout(jPanel15Layout);

    txtKhuyenMai.setMinimumSize(new java.awt.Dimension(16, 22));
    txtKhuyenMai.setPreferredSize(new java.awt.Dimension(150, 30));
    txtKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtKhuyenMaiActionPerformed(evt);
        }
    });
    jPanel16.add(txtKhuyenMai);

    jButton6.setBackground(new java.awt.Color(15, 102, 165));
    jButton6.setIcon(
        ImageProcessing.resizeIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/btn-tap.png")), 20,20)
    );
    jButton6.setPreferredSize(new java.awt.Dimension(50, 30));
    jPanel16.add(jButton6);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 21;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    jPanel15.add(jPanel16, gridBagConstraints);

    jLabel12.setText("Chương trình:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(3, 0, 2, 0);
    jPanel15.add(jLabel12, gridBagConstraints);

    jTextField14.setEditable(false);
    jTextField14.setFocusable(false);
    jTextField14.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextField14ActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 11;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
    gridBagConstraints.weightx = 0.1;
    jPanel15.add(jTextField14, gridBagConstraints);

    jTextField15.setEditable(false);
    jTextField15.setFocusable(false);
    jTextField15.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextField15ActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 11;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
    gridBagConstraints.weightx = 0.1;
    jPanel15.add(jTextField15, gridBagConstraints);

    jLabel13.setText("Mã giảm giá:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
    jPanel15.add(jLabel13, gridBagConstraints);

    tabBanHang_HoaDon_Right_GiamGia.add(jPanel15, java.awt.BorderLayout.PAGE_START);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.weighty = 0.1;
    tabBanHang_HoaDon_Right.add(tabBanHang_HoaDon_Right_GiamGia, gridBagConstraints);

    java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
    jPanel1Layout.columnWidths = new int[] {0, 33, 0};
    jPanel1Layout.rowHeights = new int[] {0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0};
    panel_TongTien.setLayout(jPanel1Layout);

    jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel5.setText("Tổng tiền:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    panel_TongTien.add(jLabel5, gridBagConstraints);

    txtValueTongTien.setEditable(false);
    txtValueTongTien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    txtValueTongTien.setFocusable(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
    panel_TongTien.add(txtValueTongTien, gridBagConstraints);

    jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel6.setText("Chiết khấu:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    panel_TongTien.add(jLabel6, gridBagConstraints);

    txtValueChietKhau.setEditable(false);
    txtValueChietKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    txtValueChietKhau.setFocusable(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
    panel_TongTien.add(txtValueChietKhau, gridBagConstraints);

    jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel7.setText("Thành tiền:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 12;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    panel_TongTien.add(jLabel7, gridBagConstraints);

    txtValueThanhTien.setEditable(false);
    txtValueThanhTien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    txtValueThanhTien.setFocusable(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 12;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
    panel_TongTien.add(txtValueThanhTien, gridBagConstraints);

    txtValueTongThue.setEditable(false);
    txtValueTongThue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    txtValueTongThue.setFocusable(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
    panel_TongTien.add(txtValueTongThue, gridBagConstraints);

    jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel10.setText("Thuế:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    panel_TongTien.add(jLabel10, gridBagConstraints);

    btnThanhToan.setBackground(new java.awt.Color(15, 145, 239));
    btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
    btnThanhToan.setIcon(ImageProcessing.resizeIcon(
        new ImageIcon(getClass().getResource("/img/icon/btn-purchase.png"))
        , 35, 35));
btnThanhToan.setText("Thanh toán (F12)");
btnThanhToan.setIconTextGap(30);
btnThanhToan.setMargin(new java.awt.Insets(0, 10, 0, 0));
btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnThanhToanActionPerformed(evt);
    }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 16;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipady = 12;
    panel_TongTien.add(btnThanhToan, gridBagConstraints);

    btnKeyPad.setBackground(new java.awt.Color(15, 145, 239));
    btnKeyPad.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    btnKeyPad.setForeground(new java.awt.Color(255, 255, 255));
    btnKeyPad.setIcon(ImageProcessing.resizeIcon(
        new ImageIcon(getClass().getResource("/img/icon/btn-keypad.png"))
        , 30, 30));
btnKeyPad.setText("Bàn phím số");
btnKeyPad.setIconTextGap(30);
btnKeyPad.setMargin(new java.awt.Insets(0, 0, 0, 25));
btnKeyPad.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnKeyPadActionPerformed(evt);
    }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 20;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipady = 12;
    panel_TongTien.add(btnKeyPad, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weighty = 0.4;
    tabBanHang_HoaDon_Right.add(panel_TongTien, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.weighty = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 0);
    jPanel3.add(tabBanHang_HoaDon_Right, gridBagConstraints);

    jTabbedPane1.addTab("Hoá đơn", jPanel3);

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 965, Short.MAX_VALUE)
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 581, Short.MAX_VALUE)
    );

    jTabbedPane1.addTab("Danh sách hoá đơn", jPanel4);

    javax.swing.GroupLayout TAB_BanHang_HoaDonLayout = new javax.swing.GroupLayout(TAB_BanHang_HoaDon);
    TAB_BanHang_HoaDon.setLayout(TAB_BanHang_HoaDonLayout);
    TAB_BanHang_HoaDonLayout.setHorizontalGroup(
        TAB_BanHang_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 965, Short.MAX_VALUE)
    );
    TAB_BanHang_HoaDonLayout.setVerticalGroup(
        TAB_BanHang_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 581, Short.MAX_VALUE)
    );

    jTabbedPane1.addTab("Hoá đơn", TAB_BanHang_HoaDon);

    add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKhachHangActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void txtKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKhuyenMaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKhuyenMaiActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void btnKeyPadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeyPadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKeyPadActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        if (hoaDon.getListChiTietHoaDon().size() < 1){
            ErrorMessage.showMessageWithFocusTextField("Cảnh báo", "Chưa có sản phẩm trong giỏ hàng, không thể tạo hoá đơn!", txtMaSanPham);
            return;
        }
        new Form_ThanhToan(hoaDon, ((JFrame)this.getTopLevelAncestor()), this).setVisible(true);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnXoaRongMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaRongMaSPActionPerformed
        // TODO add your handling code here:
        clearTextAndFocus(txtMaSanPham);
    }//GEN-LAST:event_btnXoaRongMaSPActionPerformed

    public void clearTextAndFocus(JTextField x){
        x.setText("");
        x.requestFocus();
    }
    
    private void btnAddSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSanPhamActionPerformed
        // TODO add your handling code here:
        int tempPos = -1;
        String maSanPham = txtMaSanPham.getText().trim();
        if (maSanPham.isEmpty() || maSanPham.isBlank()){
            ErrorMessage.showMessageWithFocusTextField("Thông tin", "Để thêm sản phẩm vào hoá đơn, hãy thêm mã sản phẩm trước", txtMaSanPham);
            return;
        }
        
        if (maSanPham.matches("\\D")){
            ErrorMessage.showMessageWithFocusTextField("Thông tin", "Barcode/Mã sản phẩm nội bộ không hợp lệ!", txtMaSanPham);
            return;
        }
        

        SanPham x = sanPham_BUS.getChiMotSanPhamTheoMaHoacBarcode(maSanPham);
        
        if (x == null){
            ErrorMessage.showMessageWithFocusTextField("Thông tin", "Sản phẩm không tồn tại, vui lòng kiểm tra lại barcode", txtMaSanPham);
            return;
        }
            
        ChiTietHoaDon ct = new ChiTietHoaDon(x, 1);
        tempPos = hoaDon.addChiTietHoaDon(ct);
        if (tempPos == -1)
        	addRowIntoChiTietHoaDon(ct);
        else {
        	tblModelCTHD.setValueAt(hoaDon.getListChiTietHoaDon().get(tempPos).getSoLuong(), tempPos, 5);
        }
        
        clearTextAndFocus(txtMaSanPham);
        updateThongTinBill();
        
    }//GEN-LAST:event_btnAddSanPhamActionPerformed

    private void btnCancelHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelHDActionPerformed
        // TODO add your handling code here:
        hoaDon.removeAllChiTietHoaDon();
        while (tblModelCTHD.getRowCount() > 0)
            tblModelCTHD.removeRow(0);
        updateThongTinBill();
    }//GEN-LAST:event_btnCancelHDActionPerformed
    
    public void thanhToanHoanTat() {
    	hoaDon = new HoaDon();
        while (tblModelCTHD.getRowCount() > 0)
            tblModelCTHD.removeRow(0);
        updateThongTinBill();
    }
    
    public void addRowIntoChiTietHoaDon(ChiTietHoaDon x) {
    	tblModelCTHD.addRow(hoaDon.tableRowChiTietHoaDon(x));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TAB_BanHang_HoaDon;
    private javax.swing.JButton btnCancelHD;
    private javax.swing.JButton btnHangCho;
    private javax.swing.JButton btnKeyPad;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.JButton btnXoaRongMaSP;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JPanel panel_TongTien;
    private javax.swing.JPanel tabBanHang_HoaDon_Button;
    private javax.swing.JPanel tabBanHang_HoaDon_Center;
    private javax.swing.JPanel tabBanHang_HoaDon_Right;
    private javax.swing.JPanel tabBanHang_HoaDon_Right_GiamGia;
    private javax.swing.JPanel tabBanHang_HoaDon_Right_KhachHang;
    private javax.swing.JTextField txtKhuyenMai;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtValueChietKhau;
    private javax.swing.JTextField txtValueThanhTien;
    private javax.swing.JTextField txtValueTongThue;
    private javax.swing.JTextField txtValueTongTien;
    // End of variables declaration//GEN-END:variables
}