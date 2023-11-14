
package gui;

import bus.ChiTietHoaDon_BUS;
import bus.HoaDon_BUS;
import bus.KhachHang_BUS;
import bus.KhuyenMai_BUS;
import bus.NhanVien_BUS;
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
import entities.ChiTietKhuyenMai;
import entities.ChiTietTraHang;
import entities.HoaDon;
import entities.HoaDonTra;
import entities.KhachHang;
import entities.KhuyenMai;
import entities.NhanVien;
import entities.SanPham;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.CellEditor;
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
        private JTextField lastClicked;
	private SanPham_BUS sanPham_BUS;
	private NhanVien_BUS nhanVien_BUS;
	private KhachHang_BUS khachHang_BUS;
	private KhuyenMai_BUS khuyenMai_BUS;
	private HoaDon_BUS hoaDon_BUS;
	private ChiTietHoaDon_BUS chiTietHoaDon_BUS;

	private HoaDon hoaDon;
	private HoaDonTra hoaDonTra;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private KhuyenMai khuyenMai;

	private DefaultTableModel tblModelCTHD, tblHoaDon;
	private ArrayList<HoaDon> listHoaDon;
	private TAB_HoaDon_EditorMode trangThaiEditor; // Có 2 giá trị: THANH_TOAN và XEM_CHI_TIET
	// Thanh toán là giao diện bán hàng, xem chi tiết là trạng thái chỉ xem

	/**
	 * Creates new form TAB_BanHang
	 */
	public TAB_BanHang() {
		// Hoá đơn mặc định.
		sanPham_BUS = new SanPham_BUS();
		hoaDon_BUS = new HoaDon_BUS();
		chiTietHoaDon_BUS = new ChiTietHoaDon_BUS();
		nhanVien_BUS = new NhanVien_BUS();
		khachHang_BUS = new KhachHang_BUS();
		khuyenMai_BUS = new KhuyenMai_BUS();
                if (!CurrentSession.isLogin()){
                    JOptionPane.showMessageDialog(null , "Lỗi đăng nhập: Nhân viên không xác định!");
                }
		/**
		 * Test this case
		 */

		trangThaiEditor = TAB_HoaDon_EditorMode.BAN_HANG;

		initComponents();
                setDefaultEntities();

		tblChiTietHoaDon.getColumn("-").setCellRenderer(new ButtonRender(ImageProcessing
				.resizeIcon(new ImageIcon(getClass().getResource("/img/icon/btn-decrease.png")), 15, 15)));

		tblChiTietHoaDon.getColumn("+").setCellRenderer(new ButtonRender(ImageProcessing
				.resizeIcon(new ImageIcon(getClass().getResource("/img/icon/btn-increase.png")), 15, 15)));
		tblChiTietHoaDon.getColumn("Xoá").setCellRenderer(new ButtonRender(ImageProcessing
				.resizeIcon(new ImageIcon(getClass().getResource("/img/icon/btn-delete-no-transparent.png")), 12, 15)));

		tblChiTietHoaDon.addMouseListener(this);

		// Placeholder text
		((utilities.JTextFieldPlaceHolder) txtMaKhachHang).setPlaceholder("Nhập mã KH hoặc SĐT");
		((utilities.JTextFieldPlaceHolder) txtKhuyenMai).setPlaceholder("Nhập mã khuyến mãi");

		WindowTitle.setTitle("Quản lý bán hàng");

		tblModelCTHD.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent event) {
				int row = event.getFirstRow(), col = event.getColumn();
				if (row == -1)
					return;
				int newValue = 0;
				if (row + 1 > hoaDon.getListChiTietHoaDon().size())
					return;
				int oldValue = hoaDon.getListChiTietHoaDon().get(row).getSoLuong();
				if (col == 5) {
					newValue = (int) tblModelCTHD.getValueAt(row, col);

					// Chặn đổi trả
					if (trangThaiEditor == TAB_HoaDon_EditorMode.TRA_HANG && hoaDon.getListChiTietHoaDon().get(row)
							.getSanPham().getLoaiDoiTra().equalsIgnoreCase("KHONG_DOI_TRA")) {
						ErrorMessage.showMessageWithFocusTextField("Thông tin",
								"Sản phẩm này thuộc loại không được đổi trả!", txtMaSanPham);
						tblModelCTHD.setValueAt(oldValue, row, col);
						return;
					}
					if (trangThaiEditor == TAB_HoaDon_EditorMode.TRA_HANG && oldValue < newValue) {
						ErrorMessage.showMessageWithFocusTextField("Lưu ý", "Không được tăng số lượng hoá đơn trả.",
								txtMaSanPham);
						tblModelCTHD.setValueAt(oldValue, row, col);
					} else if (newValue <= 0) {
                                                
						hoaDon.getListChiTietHoaDon().remove(row);
						tblModelCTHD.removeRow(row);
						reIndexTable();
					} else {
                                                if (hoaDon.getListChiTietHoaDon().get(row).getSanPham().getSoLuongTon() < newValue){
                                                    ErrorMessage.showMessageWithFocusTextField("Thông tin",
                                                                        "Hiện chỉ còn " + hoaDon.getListChiTietHoaDon().get(row).getSanPham().getSoLuongTon() 
                                                            + " sản phẩm có thể bán. Hãy báo với QLCH nhé!", txtMaSanPham);
                                                    
                                                    hoaDon.getListChiTietHoaDon().get(row).setSoLuong(oldValue);
                                                    return;
                                                }
						hoaDon.getListChiTietHoaDon().get(row).setSoLuong(newValue);
					}

					// Nếu là trả hàng
					if (trangThaiEditor == TAB_HoaDon_EditorMode.TRA_HANG) {
						ChiTietTraHang ctth = new ChiTietTraHang(oldValue - newValue, "Không có lý do",
								hoaDon.getListChiTietHoaDon().get(row).getDonGia(), hoaDonTra,
								hoaDon.getListChiTietHoaDon().get(row).getSanPham());
						hoaDonTra.addChiTietHoaDon(ctth);
					}
					updateThongTinBill();

				}
			}
		});

		// Tab Danh sach hoa don
		loadTableHoaDon(hoaDon_BUS.getDanhSachHoaDon());

		// Shortcut Key
		createShortcutKey();
	}

	public void createShortcutKey() {
		AbstractAction thanhToanAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnThanhToanActionPerformed(e);
			}
		};
		btnThanhToan.registerKeyboardAction(thanhToanAction, KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0),
				WHEN_IN_FOCUSED_WINDOW);

		AbstractAction hangChoAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnHangChoActionPerformed(e);
			}
		};
		btnHangCho.registerKeyboardAction(hangChoAction, KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0),
				WHEN_IN_FOCUSED_WINDOW);

		AbstractAction huyHoaDonAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCancelHDActionPerformed(e);
			}
		};
		btnCancelHD.registerKeyboardAction(huyHoaDonAction, KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0),
				WHEN_IN_FOCUSED_WINDOW);
	}

	public void setTrangThaiEditor(TAB_HoaDon_EditorMode tt) {
		trangThaiEditor = tt;
		if (TAB_HoaDon_EditorMode.XEM_CHI_TIET_HOA_DON == tt) {
			txtKhuyenMai.setEditable(false);
			txtMaKhachHang.setEditable(false);
			txtMaSanPham.setEditable(false);
			txtMaSanPham.setText("Chế độ chỉ xem, không thể chỉnh sửa!");
			// Đổi tên nút
			btnCancelHD.setEnabled(true);
			btnCancelHD.setText("Trở về bán hàng (F9)");

			btnHangCho.setEnabled(false);
			btnKeyPad.setEnabled(false);
			btnThanhToan.setEnabled(false);
			btnThanhToan.setText("Thanh toán (F12)");
			btnThemSanPham.setEnabled(false);
			btnThemSanPham.setIcon(ImageProcessing
					.resizeIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/btn-add.png")), 20, 20));
			btnXoaRongMaSP.setEnabled(false);

			btnKhachHangEnter.setEnabled(false);
			btnKhuyenMaiEnter.setEnabled(false);

			tblChiTietHoaDon.setEnabled(false);

			lblChietKhau.setVisible(true);
			txtValueChietKhau.setVisible(true);

			lblThanhTien.setText("Thành tiền:");

			lblThue.setVisible(true);
			txtValueTongThue.setVisible(true);

			txtValueTongTien.setVisible(true);
			lblTongTien.setVisible(true);

		} else if (TAB_HoaDon_EditorMode.TRA_HANG == tt) {
			if (hoaDon.getTrangThai() != null)
				if (!hoaDon.getHoaDonID().isBlank() && !hoaDon.getTrangThai().equalsIgnoreCase("DA_XU_LY")) {
					ErrorMessage.showMessageWithFocusTextField("Lỗi",
							"Hoá đơn bạn vừa chọn đã bị huỷ hoặc đang được xử lý. Hãy tải lại hoá đơn!", txtMaSanPham);
					clearHoaDonDangTao();
					btn_DSHD_taiLai.doClick();
					jTabbed.setSelectedIndex(1);
					return;
				}
			txtKhuyenMai.setEditable(false);
			txtMaKhachHang.setEditable(false);
			txtMaSanPham.setEditable(true);
			txtMaSanPham.setText("");
			// Đổi tên nút
			btnCancelHD.setEnabled(true);
			btnCancelHD.setText("Huỷ đổi trả hàng");

			btnHangCho.setEnabled(false);
			btnKeyPad.setEnabled(true);
			btnThanhToan.setEnabled(true);
			btnThanhToan.setText("Trả hàng (F12)");
			btnThemSanPham.setEnabled(true);
			btnThemSanPham.setIcon(ImageProcessing
					.resizeIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/btn-remove.png")), 20, 20));
			btnXoaRongMaSP.setEnabled(true);

			btnKhachHangEnter.setEnabled(false);
			btnKhuyenMaiEnter.setEnabled(false);

			tblChiTietHoaDon.setEnabled(true);

			lblChietKhau.setVisible(false);
			txtValueChietKhau.setVisible(false);

			lblThanhTien.setText("Tổng hoàn:");

			lblThue.setVisible(false);
			txtValueTongThue.setVisible(false);

			txtValueTongTien.setVisible(false);
			lblTongTien.setVisible(false);
		} else {
			if (hoaDon.getHoaDonID() != null && hoaDon.getTrangThai() != null)
				if (!hoaDon.getHoaDonID().isBlank() && !hoaDon.getTrangThai().equalsIgnoreCase("CHO_XU_LY")) {
					ErrorMessage.showMessageWithFocusTextField("Lỗi",
							"Hoá đơn bạn vừa chọn đã bị huỷ hoặc đã xử lý xong. Hãy tải lại hoá đơn!", txtMaSanPham);
					clearHoaDonDangTao();
					btn_DSHD_taiLai.doClick();
					jTabbed.setSelectedIndex(1);
					return;
				}
			txtKhuyenMai.setEditable(true);
			txtMaKhachHang.setEditable(true);
			txtMaSanPham.setEditable(true);
			txtMaSanPham.setText("");

			// Đổi tên nút
			btnCancelHD.setEnabled(true);
			btnCancelHD.setText("Huỷ hoá đơn (F9)");

			btnHangCho.setEnabled(true);
			btnKeyPad.setEnabled(true);
			btnThanhToan.setEnabled(true);
			btnThanhToan.setText("Thanh toán (F12)");
			btnThemSanPham.setEnabled(true);
			btnThemSanPham.setIcon(ImageProcessing
					.resizeIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/btn-add.png")), 20, 20));
			btnXoaRongMaSP.setEnabled(true);

			btnKhachHangEnter.setEnabled(true);
			btnKhuyenMaiEnter.setEnabled(true);
			tblChiTietHoaDon.setEnabled(true);

			lblChietKhau.setVisible(true);
			txtValueChietKhau.setVisible(true);

			lblThanhTien.setText("Thành tiền:");

			lblThue.setVisible(true);
			txtValueTongThue.setVisible(true);

			txtValueTongTien.setVisible(true);
			lblTongTien.setVisible(true);
		}
		updateThongTinBill();
	}

	public void loadHoaDon(String x) {
		hoaDon = hoaDon_BUS.getHoaDonByID(new HoaDon(x));
		if (hoaDon == null) {
			hoaDon = new HoaDon();
			hoaDon.setNhanVien(CurrentSession.getNhanVien());
		}
		ArrayList<ChiTietHoaDon> cthdTemp = chiTietHoaDon_BUS.getAllChiTietCuaMotHoaDon(hoaDon.getHoaDonID());
		if (cthdTemp == null)
			cthdTemp = new ArrayList<ChiTietHoaDon>();
		hoaDon.setListChiTietHoaDon(cthdTemp);

		// Trả hàng
		if (trangThaiEditor == TAB_HoaDon_EditorMode.TRA_HANG) {
			hoaDonTra = new HoaDonTra(hoaDon.getHoaDonID());
		}

		loadTableChiTietHoaDon(hoaDon.tableChiTietHoaDon());
		updateThongTinBill();
	}

	public void loadTableHoaDon(ArrayList<HoaDon> x) {
		while (tblHoaDon.getRowCount() > 0)
			tblHoaDon.removeRow(0);
		listHoaDon = x;
		for (int i = 0; i < listHoaDon.size(); i++) {
			Object[] obj = listHoaDon.get(i).getRowTableHoaDon();
			obj[0] = i + 1;
			tblHoaDon.addRow(obj);
		}
	}

	public void loadTableChiTietHoaDon(ArrayList<Object[]> x) {
		while (tblModelCTHD.getRowCount() > 0)
			tblModelCTHD.removeRow(0);
		for (Object[] y : x) {
			tblModelCTHD.addRow(y);
		}
		jTabbed.setSelectedIndex(0); // Focus vào tab được chọn
	}

	public void reIndexTable() {
		for (int i = 0; i < tblModelCTHD.getRowCount(); i++) {
			tblModelCTHD.setValueAt(i + 1, i, 0);
		}
	}

	public void updateThongTinBill() {
		if (trangThaiEditor == TAB_HoaDon_EditorMode.TRA_HANG) {
			txtValueThanhTien.setText(Numberic.formatVND(hoaDonTra.tinhTongHoan()));
			return;
		}
		calcKhuyenMai();
		txtValueThanhTien.setText(Numberic.formatVND(hoaDon.tinhThanhTien()));
		txtValueChietKhau.setText(Numberic.formatVND(hoaDon.getGiaKhuyenMai()));
		txtValueTongThue.setText(Numberic.formatVND(hoaDon.tinhTongThue()));
		txtValueTongTien.setText(Numberic.formatVND(hoaDon.tinhTongTien()));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ChiTietHoaDon cthd = null;
		// TODO Auto-generated method stub
		if (TAB_HoaDon_EditorMode.XEM_CHI_TIET_HOA_DON == trangThaiEditor)
			return;
		if (e.getSource().equals(tblChiTietHoaDon)) {
			JTable tbl = (JTable) e.getSource();
			int row = tbl.rowAtPoint(e.getPoint());
			if (row < 0)
				return;
			int column = tbl.columnAtPoint(e.getPoint());
			cthd = hoaDon.getListChiTietHoaDon().get(row);
			// Không tồn tại.
			if (hoaDon.getListChiTietHoaDon().size() < row)
				return;

			// Chế độ trả hàng
			if (TAB_HoaDon_EditorMode.TRA_HANG == trangThaiEditor) {
				if (cthd.getSanPham().getLoaiDoiTra().equalsIgnoreCase("KHONG_DOI_TRA")) {
					ErrorMessage.showMessageWithFocusTextField("Thông tin",
							"Sản phẩm này thuộc loại không được đổi trả!", txtMaSanPham);
					return;
				}
				switch (column) {
				case 4 -> {
					ChiTietTraHang ctth = new ChiTietTraHang(1, TOOL_TIP_TEXT_KEY,
							hoaDon.getListChiTietHoaDon().get(row).getDonGia(), hoaDonTra,
							hoaDon.getListChiTietHoaDon().get(row).getSanPham());
					hoaDonTra.addChiTietHoaDon(ctth);
					if (cthd.getSoLuong() - 1 <= 0) {
						hoaDon.removeChiTietHoaDon(cthd);
						tblModelCTHD.removeRow(row);
						reIndexTable();
					} else {
						cthd.setSoLuong(cthd.getSoLuong() - 1);
						tblModelCTHD.setValueAt(cthd.getSoLuong(), row, 5);
						tblModelCTHD.setValueAt(cthd.tinhTongTien(), row, 8);
					}

				}
				case 6 -> {
					ErrorMessage.showMessageWithFocusTextField("Lưu ý", "Không được tăng số lượng hoá đơn trả.",
							txtMaSanPham);

				}
				case 9 -> {
					if (!ErrorMessage.showConfirmDialogYesNo("Chú ý",
							"Bạn có chắc chắn muốn hoàn toàn bộ sản phẩm " + tbl.getValueAt(row, 2) + " không??"))
						return;
					// Nếu là trả hàng
					ChiTietTraHang ctth = new ChiTietTraHang(hoaDon.getListChiTietHoaDon().get(row).getSoLuong(),
							"Không có", hoaDon.getListChiTietHoaDon().get(row).getDonGia(), hoaDonTra,
							hoaDon.getListChiTietHoaDon().get(row).getSanPham());
					hoaDonTra.addChiTietHoaDon(ctth);

					hoaDon.removeChiTietHoaDon(cthd);
					tblModelCTHD.removeRow(row);
					reIndexTable();

				}
				default -> {

				}
				}
				updateThongTinBill();
				return;
			} else {

				// Chế độ bán hàng
				switch (column) {
				case 4 -> {
					if (cthd.getSoLuong() - 1 <= 0) {
						hoaDon.removeChiTietHoaDon(cthd);
						tblModelCTHD.removeRow(row);
						reIndexTable();
					} else {
						cthd.setSoLuong(cthd.getSoLuong() - 1);
						tblModelCTHD.setValueAt(cthd.getSoLuong(), row, 5);
						tblModelCTHD.setValueAt(cthd.tinhTongTien(), row, 8);
					}
				}
				case 6 -> {
                                    if (cthd.getSanPham().getSoLuongTon() < cthd.getSoLuong() + 1){
                                        ErrorMessage.showMessageWithFocusTextField("Thông tin",
                                                            "Hiện chỉ còn " + cthd.getSanPham().getSoLuongTon() 
                                                            + " sản phẩm có thể bán. Hãy báo với QLCH nhé!", txtMaSanPham);
                                            return;
                                    }
					cthd.setSoLuong(cthd.getSoLuong() + 1);
					tblModelCTHD.setValueAt(cthd.getSoLuong(), row, 5);
					tblModelCTHD.setValueAt(cthd.tinhTongTien(), row, 8);
                                        

				}
				case 9 -> {
					if (!ErrorMessage.showConfirmDialogYesNo("Chú ý",
							"Bạn có chắc chắn muốn xoá sản phẩm " + tbl.getValueAt(row, 2) + " khỏi hoá đơn không??"))
						return;
					hoaDon.removeChiTietHoaDon(cthd);
					tblModelCTHD.removeRow(row);
					reIndexTable();
				}
				default -> {

				}
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
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbed = new javax.swing.JTabbedPane();
        tabbedHoaDon = new javax.swing.JPanel();
        tabBanHang_HoaDon_Center = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChiTietHoaDon = new javax.swing.JTable();
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
        btnKhachHangEnter = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtDisplayTenKH = new javax.swing.JTextField();
        txtDisplayMaKH = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tabBanHang_HoaDon_Right_GiamGia = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        txtKhuyenMai = new utilities.JTextFieldPlaceHolder();
        btnKhuyenMaiEnter = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtDisplayChuongTrinhKM = new javax.swing.JTextField();
        txtDisplayMaGiamGia = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lblTrangThaiApDungKM = new javax.swing.JLabel();
        panel_TongTien = new javax.swing.JPanel();
        lblTongTien = new javax.swing.JLabel();
        txtValueTongTien = new javax.swing.JTextField();
        lblChietKhau = new javax.swing.JLabel();
        txtValueChietKhau = new javax.swing.JTextField();
        lblThanhTien = new javax.swing.JLabel();
        txtValueThanhTien = new javax.swing.JTextField();
        txtValueTongThue = new javax.swing.JTextField();
        lblThue = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnKeyPad = new javax.swing.JButton();
        tabbedDanhSachHoaDon = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_DSHD_TuNLHD = new com.toedter.calendar.JDateChooser();
        txt_DSHD_DenNLHD = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbo_DSHD_TrangThai = new javax.swing.JComboBox<>();
        txt_DSHD_GiaTriTu = new javax.swing.JTextField();
        txt_DSHD_GiaTriDen = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_DSHD_MaHoaDon = new javax.swing.JTextField();
        txt_DSHD_MaKH = new javax.swing.JTextField();
        txt_DSHD_MaNV = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btn_DSHD_Search = new javax.swing.JButton();
        btn_DSHD_taiLai = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        btn_DSHD_xoaRong = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btn_DSHD_ThanhToan = new javax.swing.JButton();
        btn_DSHD_InHD = new javax.swing.JButton();
        btn_DSHD_XemChiTiet = new javax.swing.JButton();
        btn_DSHD_DoiTraHoaDon = new javax.swing.JButton();
        btn_DSHD_HuyHoaDon = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jTabbed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabSwitchBanHang(evt);
            }
        });
        jTabbed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedMouseClicked(evt);
            }
        });

        tabbedHoaDon.setLayout(new java.awt.GridBagLayout());

        java.awt.GridBagLayout tabBanHang_HoaDon_CenterLayout = new java.awt.GridBagLayout();
        tabBanHang_HoaDon_CenterLayout.columnWidths = new int[] {0};
        tabBanHang_HoaDon_CenterLayout.rowHeights = new int[] {0, 0, 0};
        tabBanHang_HoaDon_Center.setLayout(tabBanHang_HoaDon_CenterLayout);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.setLayout(new java.awt.BorderLayout());

        tblChiTietHoaDon.setModel(tblModelCTHD = new javax.swing.table.DefaultTableModel(
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
        tblChiTietHoaDon.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(tblChiTietHoaDon);
        if (tblChiTietHoaDon.getColumnModel().getColumnCount() > 0) {
            tblChiTietHoaDon.getColumnModel().getColumn(0).setResizable(false);
            tblChiTietHoaDon.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblChiTietHoaDon.getColumnModel().getColumn(0).setHeaderValue("STT");
            tblChiTietHoaDon.getColumnModel().getColumn(1).setResizable(false);
            tblChiTietHoaDon.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblChiTietHoaDon.getColumnModel().getColumn(1).setHeaderValue("Mã sản phẩm");
            tblChiTietHoaDon.getColumnModel().getColumn(2).setResizable(false);
            tblChiTietHoaDon.getColumnModel().getColumn(2).setHeaderValue("Tên sản phẩm");
            tblChiTietHoaDon.getColumnModel().getColumn(3).setResizable(false);
            tblChiTietHoaDon.getColumnModel().getColumn(3).setHeaderValue("Đơn giá");
            tblChiTietHoaDon.getColumnModel().getColumn(4).setResizable(false);
            tblChiTietHoaDon.getColumnModel().getColumn(4).setPreferredWidth(10);
            tblChiTietHoaDon.getColumnModel().getColumn(4).setHeaderValue("-");
            tblChiTietHoaDon.getColumnModel().getColumn(5).setResizable(false);
            tblChiTietHoaDon.getColumnModel().getColumn(5).setPreferredWidth(30);
            tblChiTietHoaDon.getColumnModel().getColumn(5).setHeaderValue("Số lượng");
            tblChiTietHoaDon.getColumnModel().getColumn(6).setResizable(false);
            tblChiTietHoaDon.getColumnModel().getColumn(6).setPreferredWidth(10);
            tblChiTietHoaDon.getColumnModel().getColumn(6).setHeaderValue("+");
            tblChiTietHoaDon.getColumnModel().getColumn(7).setResizable(false);
            tblChiTietHoaDon.getColumnModel().getColumn(7).setPreferredWidth(30);
            tblChiTietHoaDon.getColumnModel().getColumn(7).setHeaderValue("Thuế");
            tblChiTietHoaDon.getColumnModel().getColumn(8).setResizable(false);
            tblChiTietHoaDon.getColumnModel().getColumn(8).setHeaderValue("Thành tiền");
            tblChiTietHoaDon.getColumnModel().getColumn(9).setResizable(false);
            tblChiTietHoaDon.getColumnModel().getColumn(9).setPreferredWidth(25);
            tblChiTietHoaDon.getColumnModel().getColumn(9).setHeaderValue("Xoá");
        }
        tblChiTietHoaDon.getAccessibleContext().setAccessibleName("");

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
    btnHangCho.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnHangChoActionPerformed(evt);
        }
    });
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
    btnCancelHD.setText("Huỷ hoá đơn (F9)");
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

    txtMaSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTextFieldClicked(evt);
        }
    });
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
    tabbedHoaDon.add(tabBanHang_HoaDon_Center, gridBagConstraints);

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
    txtMaKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTextFieldClicked(evt);
        }
    });
    jPanel12.add(txtMaKhachHang);

    btnKhachHangEnter.setBackground(new java.awt.Color(15, 102, 165));
    btnKhachHangEnter.setIcon(
        ImageProcessing.resizeIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/btn-search.png")), 20,20)
    );
    btnKhachHangEnter.setPreferredSize(new java.awt.Dimension(50, 30));
    btnKhachHangEnter.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnKhachHangEnterAP(evt);
        }
    });
    jPanel12.add(btnKhachHangEnter);

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

    txtDisplayTenKH.setEditable(false);
    txtDisplayTenKH.setFocusable(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 11;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
    gridBagConstraints.weightx = 0.1;
    jPanel11.add(txtDisplayTenKH, gridBagConstraints);

    txtDisplayMaKH.setEditable(false);
    txtDisplayMaKH.setFocusable(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 11;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
    gridBagConstraints.weightx = 0.1;
    jPanel11.add(txtDisplayMaKH, gridBagConstraints);

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
    jPanel15Layout.rowHeights = new int[] {0, 9, 0, 9, 0, 9, 0, 9, 0};
    jPanel15.setLayout(jPanel15Layout);

    txtKhuyenMai.setMinimumSize(new java.awt.Dimension(16, 22));
    txtKhuyenMai.setPreferredSize(new java.awt.Dimension(150, 30));
    txtKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTextFieldClicked(evt);
        }
    });
    txtKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtKhuyenMaiActionPerformed(evt);
        }
    });
    jPanel16.add(txtKhuyenMai);

    btnKhuyenMaiEnter.setBackground(new java.awt.Color(15, 102, 165));
    btnKhuyenMaiEnter.setIcon(
        ImageProcessing.resizeIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/btn-tap.png")), 20,20)
    );
    btnKhuyenMaiEnter.setPreferredSize(new java.awt.Dimension(50, 30));
    btnKhuyenMaiEnter.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnKhuyenMaiEnterActionPer(evt);
        }
    });
    jPanel16.add(btnKhuyenMaiEnter);

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

    txtDisplayChuongTrinhKM.setEditable(false);
    txtDisplayChuongTrinhKM.setFocusable(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 11;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
    gridBagConstraints.weightx = 0.1;
    jPanel15.add(txtDisplayChuongTrinhKM, gridBagConstraints);

    txtDisplayMaGiamGia.setEditable(false);
    txtDisplayMaGiamGia.setFocusable(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 11;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
    gridBagConstraints.weightx = 0.1;
    jPanel15.add(txtDisplayMaGiamGia, gridBagConstraints);

    jLabel13.setText("Mã giảm giá:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
    jPanel15.add(jLabel13, gridBagConstraints);

    lblTrangThaiApDungKM.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
    lblTrangThaiApDungKM.setForeground(new java.awt.Color(255, 0, 51));
    lblTrangThaiApDungKM.setText("*Chỉ áp dụng cho đơn hàng từ X VND");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.gridwidth = 13;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    jPanel15.add(lblTrangThaiApDungKM, gridBagConstraints);

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

    lblTongTien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    lblTongTien.setText("Tổng tiền:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    panel_TongTien.add(lblTongTien, gridBagConstraints);

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

    lblChietKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    lblChietKhau.setText("Chiết khấu:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    panel_TongTien.add(lblChietKhau, gridBagConstraints);

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

    lblThanhTien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    lblThanhTien.setText("Thành tiền:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 12;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    panel_TongTien.add(lblThanhTien, gridBagConstraints);

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

    lblThue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    lblThue.setText("Thuế:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    panel_TongTien.add(lblThue, gridBagConstraints);

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
    gridBagConstraints.gridy = 20;
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
    gridBagConstraints.gridy = 16;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipady = 12;
    panel_TongTien.add(btnKeyPad, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
    gridBagConstraints.weighty = 0.4;
    tabBanHang_HoaDon_Right.add(panel_TongTien, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.weighty = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 0);
    tabbedHoaDon.add(tabBanHang_HoaDon_Right, gridBagConstraints);

    jTabbed.addTab("Hoá đơn", tabbedHoaDon);

    tabbedDanhSachHoaDon.setLayout(new java.awt.BorderLayout());

    jPanel1.setLayout(new java.awt.BorderLayout());

    jPanel2.setBackground(new java.awt.Color(255, 255, 255));
    jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
    jPanel2Layout.columnWidths = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0};
    jPanel2Layout.rowHeights = new int[] {0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0};
    jPanel2.setLayout(jPanel2Layout);

    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel1.setText("Tìm kiếm hoá đơn");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 5;
    gridBagConstraints.ipadx = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
    jPanel2.add(jLabel1, gridBagConstraints);

    jLabel2.setText("Trạng thái");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.gridwidth = 5;
    gridBagConstraints.ipadx = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
    jPanel2.add(jLabel2, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.ipadx = 17;
    jPanel2.add(txt_DSHD_TuNLHD, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.ipadx = 17;
    jPanel2.add(txt_DSHD_DenNLHD, gridBagConstraints);

    jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel4.setText("-");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.ipadx = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
    jPanel2.add(jLabel4, gridBagConstraints);

    jLabel11.setText("Ngày lập hoá đơn");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 5;
    gridBagConstraints.ipadx = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
    jPanel2.add(jLabel11, gridBagConstraints);

    cbo_DSHD_TrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Chờ xử lý", "Đã xử lý", "Huỷ bỏ" }));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 10;
    gridBagConstraints.gridwidth = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipadx = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
    jPanel2.add(cbo_DSHD_TrangThai, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 14;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipadx = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
    jPanel2.add(txt_DSHD_GiaTriTu, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 14;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipadx = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
    jPanel2.add(txt_DSHD_GiaTriDen, gridBagConstraints);

    jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel14.setText("-");
    jLabel14.setFocusable(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 14;
    gridBagConstraints.ipadx = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
    jPanel2.add(jLabel14, gridBagConstraints);

    jLabel15.setText("Giá trị hoá đơn");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 12;
    gridBagConstraints.gridwidth = 5;
    gridBagConstraints.ipadx = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
    jPanel2.add(jLabel15, gridBagConstraints);

    jLabel16.setText("Mã hoá đơn");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 16;
    gridBagConstraints.gridwidth = 5;
    gridBagConstraints.ipadx = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
    jPanel2.add(jLabel16, gridBagConstraints);

    txt_DSHD_MaHoaDon.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_DSHD_MaHoaDonActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 18;
    gridBagConstraints.gridwidth = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipadx = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
    jPanel2.add(txt_DSHD_MaHoaDon, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 22;
    gridBagConstraints.gridwidth = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipadx = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
    jPanel2.add(txt_DSHD_MaKH, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 26;
    gridBagConstraints.gridwidth = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipadx = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
    jPanel2.add(txt_DSHD_MaNV, gridBagConstraints);

    jLabel17.setText("Mã/Số điện thoại nhân viên bán");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 24;
    gridBagConstraints.gridwidth = 5;
    gridBagConstraints.ipadx = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
    jPanel2.add(jLabel17, gridBagConstraints);

    btn_DSHD_Search.setBackground(new java.awt.Color(15, 145, 239));
    btn_DSHD_Search.setForeground(new java.awt.Color(255, 255, 255));
    btn_DSHD_Search.setText("Tìm kiếm");
    btn_DSHD_Search.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_DSHD_SearchActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 30;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 19;
    gridBagConstraints.ipady = 8;
    jPanel2.add(btn_DSHD_Search, gridBagConstraints);

    btn_DSHD_taiLai.setBackground(new java.awt.Color(15, 145, 239));
    btn_DSHD_taiLai.setForeground(new java.awt.Color(255, 255, 255));
    btn_DSHD_taiLai.setText("Tải lại");
    btn_DSHD_taiLai.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_DSHD_taiLaiActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 30;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 19;
    gridBagConstraints.ipady = 8;
    jPanel2.add(btn_DSHD_taiLai, gridBagConstraints);

    jLabel18.setText("Mã/Số điện thoại khách hàng");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 20;
    gridBagConstraints.gridwidth = 5;
    gridBagConstraints.ipadx = 9;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
    jPanel2.add(jLabel18, gridBagConstraints);

    btn_DSHD_xoaRong.setBackground(new java.awt.Color(15, 145, 239));
    btn_DSHD_xoaRong.setForeground(new java.awt.Color(255, 255, 255));
    btn_DSHD_xoaRong.setText("Xoá rỗng");
    btn_DSHD_xoaRong.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_DSHD_xoaRongActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 34;
    gridBagConstraints.gridwidth = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 19;
    gridBagConstraints.ipady = 8;
    gridBagConstraints.insets = new java.awt.Insets(0, 0, 54, 0);
    jPanel2.add(btn_DSHD_xoaRong, gridBagConstraints);

    jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_START);

    jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    jPanel8.setLayout(new java.awt.BorderLayout());

    java.awt.GridBagLayout jPanel9Layout = new java.awt.GridBagLayout();
    jPanel9Layout.columnWidths = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
    jPanel9Layout.rowHeights = new int[] {0, 7, 0, 7, 0};
    jPanel9.setLayout(jPanel9Layout);

    btn_DSHD_ThanhToan.setBackground(new java.awt.Color(15, 145, 239));
    btn_DSHD_ThanhToan.setForeground(new java.awt.Color(255, 255, 255));
    btn_DSHD_ThanhToan.setIcon(ImageProcessing.resizeIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/btn-xulyhoadoncu.png")), 25,25));
    btn_DSHD_ThanhToan.setText("Xử lý hoá đơn");
    btn_DSHD_ThanhToan.setEnabled(false);
    btn_DSHD_ThanhToan.setIconTextGap(12);
    btn_DSHD_ThanhToan.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_DSHD_ThanhToanActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipady = 10;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(9, 0, 7, 0);
    jPanel9.add(btn_DSHD_ThanhToan, gridBagConstraints);

    btn_DSHD_InHD.setBackground(new java.awt.Color(137, 140, 141));
    btn_DSHD_InHD.setForeground(new java.awt.Color(255, 255, 255));
    btn_DSHD_InHD.setIcon(ImageProcessing.resizeIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/btn-print.png")), 25,25));
    btn_DSHD_InHD.setText("In hoá đơn");
    btn_DSHD_InHD.setEnabled(false);
    btn_DSHD_InHD.setIconTextGap(12);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipady = 10;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(9, 0, 7, 0);
    jPanel9.add(btn_DSHD_InHD, gridBagConstraints);

    btn_DSHD_XemChiTiet.setBackground(new java.awt.Color(137, 140, 141));
    btn_DSHD_XemChiTiet.setForeground(new java.awt.Color(255, 255, 255));
    btn_DSHD_XemChiTiet.setIcon(ImageProcessing.resizeIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/btn-viewdetails.png")), 25,25));
    btn_DSHD_XemChiTiet.setText("Xem chi tiết");
    btn_DSHD_XemChiTiet.setEnabled(false);
    btn_DSHD_XemChiTiet.setIconTextGap(12);
    btn_DSHD_XemChiTiet.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_DSHD_XemChiTietActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 6;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipady = 10;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(9, 0, 7, 0);
    jPanel9.add(btn_DSHD_XemChiTiet, gridBagConstraints);

    btn_DSHD_DoiTraHoaDon.setBackground(new java.awt.Color(137, 140, 141));
    btn_DSHD_DoiTraHoaDon.setForeground(new java.awt.Color(255, 255, 255));
    btn_DSHD_DoiTraHoaDon.setIcon(ImageProcessing.resizeIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/btn-doitrahoadon.png")), 25,25));
    btn_DSHD_DoiTraHoaDon.setText("Đổi trả hoá đơn");
    btn_DSHD_DoiTraHoaDon.setEnabled(false);
    btn_DSHD_DoiTraHoaDon.setIconTextGap(12);
    btn_DSHD_DoiTraHoaDon.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_DSHD_DoiTraHoaDonActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 8;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipady = 10;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(9, 0, 7, 0);
    jPanel9.add(btn_DSHD_DoiTraHoaDon, gridBagConstraints);

    btn_DSHD_HuyHoaDon.setBackground(new java.awt.Color(137, 140, 141));
    btn_DSHD_HuyHoaDon.setForeground(new java.awt.Color(255, 255, 255));
    btn_DSHD_HuyHoaDon.setIcon(ImageProcessing.resizeIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/btn-delete-white.png")), 25,25));
    btn_DSHD_HuyHoaDon.setText("Huỷ hoá đơn");
    btn_DSHD_HuyHoaDon.setEnabled(false);
    btn_DSHD_HuyHoaDon.setIconTextGap(12);
    btn_DSHD_HuyHoaDon.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_DSHD_HuyHoaDonActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 10;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.ipady = 10;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.insets = new java.awt.Insets(9, 0, 7, 0);
    jPanel9.add(btn_DSHD_HuyHoaDon, gridBagConstraints);

    jPanel8.add(jPanel9, java.awt.BorderLayout.PAGE_START);

    java.awt.GridBagLayout jPanel10Layout = new java.awt.GridBagLayout();
    jPanel10Layout.columnWidths = new int[] {0, 10, 0, 10, 0};
    jPanel10Layout.rowHeights = new int[] {0, 7, 0, 7, 0};
    jPanel10.setLayout(jPanel10Layout);

    jTable2.setModel(tblHoaDon = new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "STT", "Mã hoá đơn", "Tên khách hàng", "Nhân viên xử lý", "Thời gian lập HĐ", "Trạng thái", "Thành tiền"
        }
    ) {
        Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
        };
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false, false, false
        };

        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblHoaDonMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(jTable2);
    if (jTable2.getColumnModel().getColumnCount() > 0) {
        jTable2.getColumnModel().getColumn(0).setResizable(false);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTable2.getColumnModel().getColumn(1).setResizable(false);
        jTable2.getColumnModel().getColumn(2).setResizable(false);
        jTable2.getColumnModel().getColumn(3).setResizable(false);
        jTable2.getColumnModel().getColumn(4).setResizable(false);
        jTable2.getColumnModel().getColumn(5).setResizable(false);
        jTable2.getColumnModel().getColumn(6).setResizable(false);
    }

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 0.1;
    gridBagConstraints.weighty = 0.1;
    jPanel10.add(jScrollPane2, gridBagConstraints);

    jPanel8.add(jPanel10, java.awt.BorderLayout.CENTER);

    jPanel1.add(jPanel8, java.awt.BorderLayout.CENTER);

    tabbedDanhSachHoaDon.add(jPanel1, java.awt.BorderLayout.CENTER);

    jTabbed.addTab("Danh sách hoá đơn", tabbedDanhSachHoaDon);

    add(jTabbed, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

  
    private void btnKhuyenMaiEnterActionPer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuyenMaiEnterActionPer
        // TODO add your handling code here:
        khuyenMai = khuyenMai_BUS.getKhuyenMaiByCodeKMForSeller(txtKhuyenMai.getText());
        if (khuyenMai == null){
            khuyenMai = new KhuyenMai("NO_APPLY");
            khuyenMai.setTenKhuyenMai("Không áp dụng");
            ErrorMessage.showMessageWithFocusTextField("Thông tin", "Mã khuyến mãi không tồn tại trên hệ thống", txtKhuyenMai);
            return;
        }
        preloadInfomation();
        calcKhuyenMai();
    }//GEN-LAST:event_btnKhuyenMaiEnterActionPer

    private void txtKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKhuyenMaiActionPerformed
        // TODO add your handling code here:
        btnKhachHangEnter.doClick();
    }//GEN-LAST:event_txtKhuyenMaiActionPerformed

    private void jTextFieldClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldClicked
        // TODO add your handling code here:
        lastClicked = (JTextField) evt.getSource();
    }//GEN-LAST:event_jTextFieldClicked

    private void btnKhachHangEnterAP(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangEnterAP
        // TODO add your handling code here:
        try{
            if (txtMaKhachHang.getText().isBlank()){
                khachHang.setKhachHangID("KH0001");
                khachHang.setHoTen("Khách lẻ");
                txtDisplayMaKH.setText(khachHang.getKhachHangID());
                txtDisplayTenKH.setText(khachHang.getHoTen());
                ErrorMessage.showMessageWithFocusTextField("Cảnh báo", "Bạn chưa nhập mã/sdt khách hàng!", txtMaKhachHang);
                return;
            }

            khachHang = khachHang_BUS.getKhachHangTuMaVaSDT(txtMaKhachHang.getText().trim());
            if (khachHang == null){
                khachHang = new KhachHang();
                khachHang.setKhachHangID("KH0001");
                khachHang.setHoTen("Khách lẻ");
                ErrorMessage.showMessageWithFocusTextField("Thông tin", "Khách hàng không tồn tại!", txtMaKhachHang);
            }

            txtDisplayMaKH.setText(khachHang.getKhachHangID());
            txtDisplayTenKH.setText(khachHang.getHoTen());
            hoaDon.setKhachHang(khachHang);
            return;
        } catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnKhachHangEnterAP

    private void btn_DSHD_xoaRongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DSHD_xoaRongActionPerformed
        // TODO add your handling code here:
        txt_DSHD_DenNLHD.setCalendar(null);
        txt_DSHD_TuNLHD.setCalendar(null);
        txt_DSHD_GiaTriTu.setText("");
        txt_DSHD_GiaTriDen.setText("");
        txt_DSHD_MaHoaDon.setText("");
        txt_DSHD_MaKH.setText("");
        txt_DSHD_MaNV.setText("");
        cbo_DSHD_TrangThai.setSelectedIndex(0);
        
    }//GEN-LAST:event_btn_DSHD_xoaRongActionPerformed

    private void calcKhuyenMai(){ 
        double tempChietKhau = 0;
        hoaDon.setGiaKhuyenMai(tempChietKhau);
        if (khuyenMai.getCodeKhuyenMai().equalsIgnoreCase("NO_APPLY")){
        	return;
        }
        if (khuyenMai.getDonHangTu() > hoaDon.tinhTongTien()){
            showTrangThaiKhuyenMai("*Khuyến mãi áp dụng cho đơn hàng từ " + Numberic.formatVND(khuyenMai.getDonHangTu()));
            return;
        }
        
        if (khuyenMai.getChiTietKhuyenMai() == null)
            return;
        
        double giaTriGiam = khuyenMai.getGiaTri();
        boolean isApply = false;
        for (ChiTietKhuyenMai x : khuyenMai.getChiTietKhuyenMai()) {
	        for (ChiTietHoaDon y : hoaDon.getListChiTietHoaDon()) {
	        	if (x.getSanPham().getSanPhamID() == y.getSanPham().getSanPhamID()) {
	        		isApply = true;
	        		if (khuyenMai.getLoaiKhuyenMai().equalsIgnoreCase("PHAN_TRAM")) {
	        			tempChietKhau += (y.tinhTongTien() * (giaTriGiam/100));
	        		}else {
	        			tempChietKhau += giaTriGiam;
	        			break;
	        		}
	        	}
	        }
        }
        if (!isApply)
            showTrangThaiKhuyenMai("*Các sản phẩm không nằm trong danh sách khuyến mãi");
        else
        	lblTrangThaiApDungKM.setVisible(false);

        hoaDon.setGiaKhuyenMai(tempChietKhau);
    }
   
    public void setDefaultEntities(){
        try {
        hoaDonTra = new HoaDonTra();
        hoaDonTra.setNhanVien(CurrentSession.getNhanVien());
	hoaDon = new HoaDon();
	hoaDon.setNhanVien(CurrentSession.getNhanVien());
        
	khuyenMai = new KhuyenMai("NO_APPLY");
        khuyenMai.setTenKhuyenMai("Không áp dụng");
	khachHang = new KhachHang("KH0001");
        khachHang.setHoTen("Khách lẻ");

        txtDisplayMaGiamGia.setText(khuyenMai.getCodeKhuyenMai());
        txtDisplayChuongTrinhKM.setText(khuyenMai.getTenKhuyenMai());
        txtDisplayMaKH.setText(khachHang.getKhachHangID());
        txtDisplayTenKH.setText(khachHang.getHoTen());
        lblTrangThaiApDungKM.setVisible(false);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void showTrangThaiKhuyenMai(String x){
        lblTrangThaiApDungKM.setText(x);
        lblTrangThaiApDungKM.setVisible(true);
    }
    
    public void preloadInfomation(){
        try {
            txtDisplayMaGiamGia.setText(khuyenMai.getCodeKhuyenMai());
            txtDisplayChuongTrinhKM.setText(khuyenMai.getTenKhuyenMai());
            txtDisplayMaKH.setText(khachHang.getKhachHangID());
            txtDisplayTenKH.setText(khachHang.getHoTen());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    

	private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField7ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField7ActionPerformed

	private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField8ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField8ActionPerformed

	private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField14ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField14ActionPerformed

	private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField15ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField15ActionPerformed

	private void btnKeyPadActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnKeyPadActionPerformed
		// TODO add your handling code here:
            new Frame_KeyPad(this, txtKhuyenMai).setVisible(true);
	}// GEN-LAST:event_btnKeyPadActionPerformed

	private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThanhToanActionPerformed
		// TODO add your handling code here:
		switch (trangThaiEditor) {
		case BAN_HANG -> {
			if (hoaDon.getListChiTietHoaDon().size() < 1) {
				ErrorMessage.showMessageWithFocusTextField("Cảnh báo",
						"Chưa có sản phẩm trong giỏ hàng, không thể tạo hoá đơn!", txtMaSanPham);
				return;
			}
			new Form_ThanhToan(hoaDon, ((JFrame) this.getTopLevelAncestor()), this).setVisible(true);
		}
		case TRA_HANG -> {
                    if (hoaDonTra.getListChiTietHoaDon().size() < 1) {
				ErrorMessage.showMessageWithFocusTextField("Cảnh báo",
						"Chưa có thực hiện đổi trả sản phẩm nào, không thể tạo hoá đơn trả!!", txtMaSanPham);
				return;
			}
			new Form_TraHang(hoaDon, ((JFrame) this.getTopLevelAncestor()), this, hoaDonTra).setVisible(true);
		}
		default -> {

		}
		}
	}// GEN-LAST:event_btnThanhToanActionPerformed

	private void btnXoaRongMaSPActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaRongMaSPActionPerformed
		// TODO add your handling code here:
		clearTextAndFocus(txtMaSanPham);
	}// GEN-LAST:event_btnXoaRongMaSPActionPerformed

	public void clearTextAndFocus(JTextField x) {
		x.setText("");
		x.requestFocus();
	}

        public JTextField getLastClickedJTextField(){
            return lastClicked;
        }
	private void btnAddSanPhamActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddSanPhamActionPerformed
		// TODO add your handling code here:
		int tempPos = -1;
		String maSanPham = txtMaSanPham.getText().trim();
		if (maSanPham.isEmpty() || maSanPham.isBlank()) {
			ErrorMessage.showMessageWithFocusTextField("Thông tin",
					"Để thêm sản phẩm vào hoá đơn, hãy thêm mã sản phẩm trước", txtMaSanPham);
			return;
		}

		if (maSanPham.matches("\\D")) {
			ErrorMessage.showMessageWithFocusTextField("Thông tin", "Barcode/Mã sản phẩm nội bộ không hợp lệ!",
					txtMaSanPham);
			return;
		}

		SanPham x = sanPham_BUS.getChiMotSanPhamTheoMaHoacBarcode(maSanPham);

		if (x == null) {
			ErrorMessage.showMessageWithFocusTextField("Thông tin",
					"Sản phẩm không tồn tại, vui lòng kiểm tra lại barcode", txtMaSanPham);
			return;
		}
                if (x.getSoLuongTon() <= 0){
                                    ErrorMessage.showMessageWithFocusTextField("Thông tin",
                                                        "Sản phẩm này đã hết hàng, hãy báo với quản lý và bạn không được bán sản phẩm này!", txtMaSanPham);
                                        return;
                                }
		ChiTietHoaDon ct = new ChiTietHoaDon(x, 1);

		// Đổi trả hàng
		if (TAB_HoaDon_EditorMode.TRA_HANG == trangThaiEditor) {
			tempPos = hoaDon.getListChiTietHoaDon().indexOf(ct);
			if (tempPos < 0) {
				ErrorMessage.showMessageWithFocusTextField("Thông tin", "Sản phẩm này không nằm trong hoá đơn!",
						txtMaSanPham);
				return;
			}
			ct = hoaDon.getListChiTietHoaDon().get(tempPos);

			// Chặn đổi trả
			if (x.getLoaiDoiTra().equalsIgnoreCase("KHONG_DOI_TRA")) {
				ErrorMessage.showMessageWithFocusTextField("Thông tin", "Sản phẩm này thuộc loại không được đổi trả!",
						txtMaSanPham);
				return;
			}
                        
			if (ct.getSoLuong() - 1 <= 0) {
				hoaDon.removeChiTietHoaDon(ct);
				tblModelCTHD.removeRow(tempPos);
				reIndexTable();
			} else {
				ct.setSoLuong(ct.getSoLuong() - 1);
				tblModelCTHD.setValueAt(ct.getSoLuong(), tempPos, 5);
				tblModelCTHD.setValueAt(ct.tinhTongTien(), tempPos, 8);
			}
		} else {
                        // Kiểm tra tình trạng trước khi th 
                       tempPos = hoaDon.getListChiTietHoaDon().indexOf(ct);
			if (tempPos >= 0) {
				if (x.getSoLuongTon() < hoaDon.getListChiTietHoaDon().get(tempPos).getSoLuong() + 1){
                                ErrorMessage.showMessageWithFocusTextField("Thông tin",
                                                "Hiện chỉ còn " + x.getSoLuongTon() 
                                                            + " sản phẩm có thể bán. Hãy báo với QLCH nhé!", txtMaSanPham);
                                return;
                        }
                        }
                        
                            tempPos = hoaDon.addChiTietHoaDon(ct);
                            if (tempPos == -1)
                                    addRowIntoChiTietHoaDon(ct);
                            else {
                                    tblModelCTHD.setValueAt(hoaDon.getListChiTietHoaDon().get(tempPos).getSoLuong(), tempPos, 5);
                            }
		}
		clearTextAndFocus(txtMaSanPham);
		updateThongTinBill();

	}// GEN-LAST:event_btnAddSanPhamActionPerformed

	private void btnCancelHDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelHDActionPerformed
		// TODO add your handling code here:
		switch (trangThaiEditor) {
		case XEM_CHI_TIET_HOA_DON -> {
			if (ErrorMessage.showConfirmDialogYesNo("Thông tin", "Bạn muốn trở về chế độ bán hàng chứ?")) {
				clearHoaDonDangTao();
				setTrangThaiEditor(TAB_HoaDon_EditorMode.BAN_HANG);
			}
		}
		case TRA_HANG -> {
			if (ErrorMessage.showConfirmDialogYesNo("Thông tin",
					"Việc đổi trả hoá đơn chưa hoàn tất, bạn đã chắc chắn muốn trở lại chế độ bán hàng?")) {
				clearHoaDonDangTao();
				setTrangThaiEditor(TAB_HoaDon_EditorMode.BAN_HANG);
			}
		}
		default -> {
			if (hoaDon.getListChiTietHoaDon().size() < 1) {
				ErrorMessage.showMessageWithFocusTextField("Thông tin", "Hiện chưa khởi tạo đơn hàng!", txtMaSanPham);
				return;
			}
			if (ErrorMessage.showConfirmDialogYesNo("Thông tin",
					"Hoá đơn sẽ bị huỷ sau khi xác nhận, bạn đã chắc chắn chứ?")) {
				updateHoaDon("HUY_BO");
				clearHoaDonDangTao();
			}
		}
		}

	}// GEN-LAST:event_btnCancelHDActionPerformed

	public boolean updateHoaDon(String trangThai) {
		hoaDon.setTrangThai(trangThai);
		boolean result = hoaDon_BUS.createHoaDon(hoaDon);
		if (!result)
			return false;
		result = chiTietHoaDon_BUS.addNhieuChiTietCuaMotHoaDon(hoaDon.getListChiTietHoaDon());
		return result;
	}

	public void clearHoaDonDangTao() {
		setDefaultEntities();
		while (tblModelCTHD.getRowCount() > 0)
			tblModelCTHD.removeRow(0);
		updateThongTinBill();
	}

	private void btn_DSHD_ThanhToanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_DSHD_ThanhToanActionPerformed
		// TODO add your handling code here:
		if (jTable2.getSelectedRow() < 0) {
			ErrorMessage.showMessageWithFocusTextField("Lỗi", "Chưa chọn hoá đơn cần xử lý!", txt_DSHD_GiaTriTu);
			return;
		}
		if (ErrorMessage.showConfirmDialogYesNo("Thông tin", "Bạn có chắc chắn muốn xử lý lại hoá đơn "
				+ (String) tblHoaDon.getValueAt(jTable2.getSelectedRow(), 1) + " không?")) {
			loadHoaDon((String) tblHoaDon.getValueAt(jTable2.getSelectedRow(), 1));
			setTrangThaiEditor(trangThaiEditor);
		}
	}// GEN-LAST:event_btn_DSHD_ThanhToanActionPerformed

	private void tabSwitchBanHang(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_tabSwitchBanHang
		// TODO add your handling code here:
	}// GEN-LAST:event_tabSwitchBanHang

	private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblHoaDonMouseClicked
		// TODO add your handling code here:
		int row = jTable2.getSelectedRow();
		int col = jTable2.getSelectedColumn();

		if (tblHoaDon.getValueAt(row, 5).equals("Huỷ bỏ")) {
			btn_DSHD_DoiTraHoaDon.setEnabled(false);
			btn_DSHD_InHD.setEnabled(false);
			btn_DSHD_HuyHoaDon.setEnabled(false);
			btn_DSHD_ThanhToan.setEnabled(false);
			btn_DSHD_XemChiTiet.setEnabled(true);
			return;
		}

		if (tblHoaDon.getValueAt(row, 5).equals("Đã xử lý")) {
			btn_DSHD_DoiTraHoaDon.setEnabled(true);
			btn_DSHD_InHD.setEnabled(true);
			btn_DSHD_HuyHoaDon.setEnabled(false);
			btn_DSHD_ThanhToan.setEnabled(false);
			btn_DSHD_XemChiTiet.setEnabled(true);
			return;
		}

		if (tblHoaDon.getValueAt(row, 5).equals("Chờ xử lý")) {
			btn_DSHD_DoiTraHoaDon.setEnabled(false);
			btn_DSHD_InHD.setEnabled(false);
			btn_DSHD_HuyHoaDon.setEnabled(true);
			btn_DSHD_ThanhToan.setEnabled(true);
			btn_DSHD_XemChiTiet.setEnabled(true);
			return;
		}
	}// GEN-LAST:event_tblHoaDonMouseClicked

	private void btnHangChoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHangChoActionPerformed
		// TODO add your handling code here:
		if (hoaDon.getListChiTietHoaDon().size() < 1) {
			ErrorMessage.showMessageWithFocusTextField("Cảnh báo",
					"Chưa có sản phẩm trong giỏ hàng, không thể thêm vào hàng chờ!", txtMaSanPham);
			return;
		}
		if (ErrorMessage.showConfirmDialogYesNo("Thông tin", "Bạn muốn đưa hoá đơn vào hàng chờ chứ?")) {
			updateHoaDon("CHO_XU_LY");
			clearHoaDonDangTao();
		}
	}// GEN-LAST:event_btnHangChoActionPerformed

	private void btn_DSHD_HuyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_DSHD_HuyHoaDonActionPerformed
		// TODO add your handling code here:
		if (jTable2.getSelectedRow() < 0) {
			ErrorMessage.showMessageWithFocusTextField("Lỗi", "Chưa chọn hoá đơn cần xử lý!", txt_DSHD_GiaTriTu);
			return;
		}
		if (ErrorMessage.showConfirmDialogYesNo("Thông tin",
				"Bạn có chắc chắn muốn huỷ hoá đơn " + (String) tblHoaDon.getValueAt(jTable2.getSelectedRow(), 1)
						+ " không?\n\nCảnh báo: Hoá đơn sau khi huỷ sẽ không thể thanh toán trở lại!"))
			if (hoaDon_BUS.cancelHoaDon(new HoaDon((String) tblHoaDon.getValueAt(jTable2.getSelectedRow(), 1)))) {
				JOptionPane.showMessageDialog(null,
						"Hoá đơn " + (String) tblHoaDon.getValueAt(jTable2.getSelectedRow(), 1) + " đã bị huỷ!");
				btn_DSHD_taiLai.doClick();
			} else {
				JOptionPane.showMessageDialog(null, "Huỷ hoá đơn "
						+ (String) tblHoaDon.getValueAt(jTable2.getSelectedRow(), 1) + " thất bại! Lỗi CSDL.");
			}
	}// GEN-LAST:event_btn_DSHD_HuyHoaDonActionPerformed

	private void btn_DSHD_XemChiTietActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_DSHD_XemChiTietActionPerformed
		// TODO add your handling code here:
		if (jTable2.getSelectedRow() < 0) {
			ErrorMessage.showMessageWithFocusTextField("Lỗi", "Chưa chọn hoá đơn cần xử lý!", txt_DSHD_GiaTriTu);
			return;
		}
		if (ErrorMessage.showConfirmDialogYesNo("Thông tin",
				"Bạn đang chuẩn bị vào chế độ xem chi tiết hoá đơn.\n\nLưu ý: Chế độ này không thể chỉnh sửa hoá đơn.")) {
			loadHoaDon((String) tblHoaDon.getValueAt(jTable2.getSelectedRow(), 1));
			setTrangThaiEditor(TAB_HoaDon_EditorMode.XEM_CHI_TIET_HOA_DON);
		}
	}// GEN-LAST:event_btn_DSHD_XemChiTietActionPerformed

	private void btn_DSHD_taiLaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_DSHD_taiLaiActionPerformed
		// TODO add your handling code here:
		loadTableHoaDon(hoaDon_BUS.getDanhSachHoaDon());
	}// GEN-LAST:event_btn_DSHD_taiLaiActionPerformed

	private void btn_DSHD_SearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_DSHD_SearchActionPerformed
		Date start = txt_DSHD_TuNLHD.getDate(), end = txt_DSHD_DenNLHD.getDate();

		Object[] obj = new Object[8];
		// TODO add your handling code here:

		if (start != null && end != null) {
			if (end.getTime() < start.getTime()) {
				ErrorMessage.showConfirmDialogYesNo("Chú ý",
						"Thời gian bắt đầu không hợp lệ. Phải nhỏ hơn hoặc bằng thời gian kết thúc!");
				txt_DSHD_TuNLHD.requestFocus();
				return;
			}
		}

		if (start != null) {
			start.setDate(start.getDate() - 1);
			start.setHours(23);
			start.setMinutes(59);
			start.setSeconds(59);
		}

		if (end != null) {
			// end.setDate(end.getDate() + 1);
			end.setHours(23);
			end.setMinutes(59);
			end.setSeconds(59);
		}

		if (!txt_DSHD_GiaTriTu.getText().isBlank() && !Numberic.isDouble(txt_DSHD_GiaTriTu.getText())) {
			ErrorMessage.showConfirmDialogYesNo("Chú ý", "Giá trị bắt đầu có ký tự không hợp lệ!");
			txt_DSHD_GiaTriTu.requestFocus();
			return;
		}

		if (!txt_DSHD_GiaTriDen.getText().isBlank() && !Numberic.isDouble(txt_DSHD_GiaTriDen.getText())) {
			ErrorMessage.showConfirmDialogYesNo("Chú ý", "Giá trị kết thúc có ký tự không hợp lệ!");
			txt_DSHD_GiaTriDen.requestFocus();
			return;
		}

		if ((!txt_DSHD_GiaTriDen.getText().isBlank() && !txt_DSHD_GiaTriTu.getText().isBlank())
				&& Numberic.parseDouble(txt_DSHD_GiaTriDen.getText())
						- Numberic.parseDouble(txt_DSHD_GiaTriTu.getText()) < 0) {
			ErrorMessage.showConfirmDialogYesNo("Chú ý", "Giá trị bắt đầu nhỏ hơn giá trị kết thúc!");
			txt_DSHD_GiaTriTu.requestFocus();
			return;
		}

		obj[0] = start;
		obj[1] = end;
		obj[2] = HoaDon.parseTrangThaiHoaDon((String) cbo_DSHD_TrangThai.getSelectedItem()).equalsIgnoreCase("ALL")
				? null
				: HoaDon.parseTrangThaiHoaDon((String) cbo_DSHD_TrangThai.getSelectedItem());
		obj[3] = txt_DSHD_GiaTriTu.getText().isBlank() ? null : Numberic.parseDouble(txt_DSHD_GiaTriTu.getText());
		obj[4] = txt_DSHD_GiaTriDen.getText().isBlank() ? null : Numberic.parseDouble(txt_DSHD_GiaTriDen.getText());
		obj[5] = txt_DSHD_MaHoaDon.getText().isBlank() ? null : txt_DSHD_MaHoaDon.getText();
		obj[6] = txt_DSHD_MaKH.getText().isBlank() ? null : txt_DSHD_MaKH.getText();
		obj[7] = txt_DSHD_MaNV.getText().isBlank() ? null : txt_DSHD_MaNV.getText();

		loadTableHoaDon(hoaDon_BUS.getDanhSachHoaDonNangCao(obj));
	}// GEN-LAST:event_btn_DSHD_SearchActionPerformed

	private void txt_DSHD_MaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_DSHD_MaHoaDonActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txt_DSHD_MaHoaDonActionPerformed

	private void btn_DSHD_DoiTraHoaDonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_DSHD_DoiTraHoaDonActionPerformed
		// TODO add your handling code here:
		if (jTable2.getSelectedRow() < 0) {
			ErrorMessage.showMessageWithFocusTextField("Lỗi", "Chưa chọn hoá đơn cần xử lý!", txt_DSHD_GiaTriTu);
			return;
		}
		if (ErrorMessage.showConfirmDialogYesNo("Thông tin", "Bạn đang chuẩn bị vào chế độ trả hàng cho hoá đơn "
				+ (String) tblHoaDon.getValueAt(jTable2.getSelectedRow(), 1))) {
			setTrangThaiEditor(TAB_HoaDon_EditorMode.TRA_HANG);
			loadHoaDon((String) tblHoaDon.getValueAt(jTable2.getSelectedRow(), 1));
		}
	}// GEN-LAST:event_btn_DSHD_DoiTraHoaDonActionPerformed

	private void btnKhachHangEnterActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnKhachHangEnterActionPerformed
		// TODO add your handling code here:

	}// GEN-LAST:event_btnKhachHangEnterActionPerformed

	private void jTabbedMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTabbedMouseClicked
		// TODO add your handling code here:
		if (jTabbed.getSelectedIndex() == 1) {
			btn_DSHD_taiLai.doClick();
		}
	}// GEN-LAST:event_jTabbedMouseClicked

	public void thanhToanHoanTat() {
		setDefaultEntities();
		while (tblModelCTHD.getRowCount() > 0)
			tblModelCTHD.removeRow(0);
		if (trangThaiEditor == TAB_HoaDon_EditorMode.TRA_HANG) {
			setTrangThaiEditor(TAB_HoaDon_EditorMode.BAN_HANG);
		}
		updateThongTinBill();
	}

	public void addRowIntoChiTietHoaDon(ChiTietHoaDon x) {
		tblModelCTHD.addRow(hoaDon.tableRowChiTietHoaDon(x));
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelHD;
    private javax.swing.JButton btnHangCho;
    private javax.swing.JButton btnKeyPad;
    private javax.swing.JButton btnKhachHangEnter;
    private javax.swing.JButton btnKhuyenMaiEnter;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.JButton btnXoaRongMaSP;
    private javax.swing.JButton btn_DSHD_DoiTraHoaDon;
    private javax.swing.JButton btn_DSHD_HuyHoaDon;
    private javax.swing.JButton btn_DSHD_InHD;
    private javax.swing.JButton btn_DSHD_Search;
    private javax.swing.JButton btn_DSHD_ThanhToan;
    private javax.swing.JButton btn_DSHD_XemChiTiet;
    private javax.swing.JButton btn_DSHD_taiLai;
    private javax.swing.JButton btn_DSHD_xoaRong;
    private javax.swing.JComboBox<String> cbo_DSHD_TrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbed;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblChietKhau;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JLabel lblThue;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTrangThaiApDungKM;
    private javax.swing.JPanel panel_TongTien;
    private javax.swing.JPanel tabBanHang_HoaDon_Button;
    private javax.swing.JPanel tabBanHang_HoaDon_Center;
    private javax.swing.JPanel tabBanHang_HoaDon_Right;
    private javax.swing.JPanel tabBanHang_HoaDon_Right_GiamGia;
    private javax.swing.JPanel tabBanHang_HoaDon_Right_KhachHang;
    private javax.swing.JPanel tabbedDanhSachHoaDon;
    private javax.swing.JPanel tabbedHoaDon;
    private javax.swing.JTable tblChiTietHoaDon;
    private javax.swing.JTextField txtDisplayChuongTrinhKM;
    private javax.swing.JTextField txtDisplayMaGiamGia;
    private javax.swing.JTextField txtDisplayMaKH;
    private javax.swing.JTextField txtDisplayTenKH;
    private javax.swing.JTextField txtKhuyenMai;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtValueChietKhau;
    private javax.swing.JTextField txtValueThanhTien;
    private javax.swing.JTextField txtValueTongThue;
    private javax.swing.JTextField txtValueTongTien;
    private com.toedter.calendar.JDateChooser txt_DSHD_DenNLHD;
    private javax.swing.JTextField txt_DSHD_GiaTriDen;
    private javax.swing.JTextField txt_DSHD_GiaTriTu;
    private javax.swing.JTextField txt_DSHD_MaHoaDon;
    private javax.swing.JTextField txt_DSHD_MaKH;
    private javax.swing.JTextField txt_DSHD_MaNV;
    private com.toedter.calendar.JDateChooser txt_DSHD_TuNLHD;
    // End of variables declaration//GEN-END:variables
}