package application;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import connectDB.ConnectDB;
import dao.ChiTietHoaDon_DAO;
import dao.ChiTietKhuyenMai_DAO;
import dao.ChiTietTraHang_DAO;
import dao.DanhMuc_DAO;
import dao.HoaDonTra_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.KhuyenMai_DAO;
import dao.NhaCungCap_DAO;
import dao.NhaXuatBan_DAO;
import dao.NhanVien_DAO;
import dao.SanPham_DAO;
import dao.TacGia_DAO;
import dao.TheLoai_DAO;
import dao.ThuongHieu_DAO;
import interfaces.IChiTietHoaDon;
import interfaces.IChiTietKhuyenMai;
import interfaces.IChiTietTraHang;
import interfaces.IDanhMuc;
import interfaces.IHoaDon;
import interfaces.IHoaDonTra;
import interfaces.IKhachHang;
import interfaces.IKhuyenMai;
import interfaces.INhaCungCap;
import interfaces.INhaXuatBan;
import interfaces.INhanVien;
import interfaces.ISanPham;
import interfaces.ITacGia;
import interfaces.ITheLoai;
import interfaces.IThuongHieu;

public class GUI_Server {
	private static final String HOST = "localhost";
	private static final int PORT = 2003;
	private static boolean isRunning = false;
	private static Context ctx;
    private static JLabel lblStatus;
	public static void main(String[] args) {

		try {
			JFrame server = new JFrame("Server - Whimsibooks");
						
			server.setResizable(false);
			
			server.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			server.addWindowListener(new java.awt.event.WindowAdapter() {
				@Override
				public void windowClosing(java.awt.event.WindowEvent windowEvent) {
					if (!isRunning) {
						System.exit(0);
					}
					
					if (JOptionPane.showConfirmDialog(server, "Tác vụ này sẽ đóng server đang chạy, bạn có chắc muốn tiếp tục?", "Close Window?",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
						if (isRunning) {
							try {
								ctx.close();
								isRunning = false;
							} catch (Exception e) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						System.exit(0);
					}
				}
			});
			

			server.setSize(300, 100);
			server.setLocationRelativeTo(null);
			server.setVisible(true);

			JPanel panel = new JPanel( new FlowLayout() );
			
			server.add(panel, BorderLayout.NORTH);

			JButton btnStart = new JButton("Start Server");

			panel.add(btnStart);

			btnStart.addActionListener(e -> {
				if (isRunning) {
					JOptionPane.showMessageDialog(null, "Server is running on " + HOST + ":" + PORT, "Server",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				try {
					lblStatus.setText("Starting server...");

					isRunning = true;
					

					ConnectDB.connect();

					IChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon_DAO();
					IChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai_DAO();
					IChiTietTraHang chiTietTraHang = new ChiTietTraHang_DAO();
					IDanhMuc danhMuc = new DanhMuc_DAO();
					IHoaDon hoaDon = new HoaDon_DAO();
					IHoaDonTra hoaDonTra = new HoaDonTra_DAO();
					IKhachHang khachHang = new KhachHang_DAO();
					IKhuyenMai khuyenMai = new KhuyenMai_DAO();
					INhaCungCap nhaCungCap = new NhaCungCap_DAO();
					INhanVien nhanVien = new NhanVien_DAO();
					INhaXuatBan nhaXuatBan = new NhaXuatBan_DAO();
					ISanPham sanPham = new SanPham_DAO();
					ITacGia tacGia = new TacGia_DAO();
					ITheLoai theLoai = new TheLoai_DAO();
					IThuongHieu thuongHieu = new ThuongHieu_DAO();

					ctx = new InitialContext();

					// If the registry is not created, create it
					try {
						LocateRegistry.createRegistry(PORT);
					} catch (Exception e1) {
					}

					ctx.bind("rmi://" + HOST + ":" + PORT + "/chiTietHoaDon", chiTietHoaDon);
					ctx.bind("rmi://" + HOST + ":" + PORT + "/chiTietKhuyenMai", chiTietKhuyenMai);
					ctx.bind("rmi://" + HOST + ":" + PORT + "/chiTietTraHang", chiTietTraHang);
					ctx.bind("rmi://" + HOST + ":" + PORT + "/danhMuc", danhMuc);
					ctx.bind("rmi://" + HOST + ":" + PORT + "/hoaDon", hoaDon);
					ctx.bind("rmi://" + HOST + ":" + PORT + "/hoaDonTra", hoaDonTra);
					ctx.bind("rmi://" + HOST + ":" + PORT + "/khachHang", khachHang);
					ctx.bind("rmi://" + HOST + ":" + PORT + "/khuyenMai", khuyenMai);
					ctx.bind("rmi://" + HOST + ":" + PORT + "/nhaCungCap", nhaCungCap);
					ctx.bind("rmi://" + HOST + ":" + PORT + "/nhanVien", nhanVien);
					ctx.bind("rmi://" + HOST + ":" + PORT + "/nhaXuatBan", nhaXuatBan);
					ctx.bind("rmi://" + HOST + ":" + PORT + "/sanPham", sanPham);
					ctx.bind("rmi://" + HOST + ":" + PORT + "/tacGia", tacGia);
					ctx.bind("rmi://" + HOST + ":" + PORT + "/theLoai", theLoai);
					ctx.bind("rmi://" + HOST + ":" + PORT + "/thuongHieu", thuongHieu);
					JOptionPane.showMessageDialog(null, "Server is running on " + HOST + ":" + PORT, "Server",
							JOptionPane.INFORMATION_MESSAGE);
					lblStatus.setText("Server is running on " + HOST + ":" + PORT);
					
					btnStart.setEnabled(false);

				} catch (Exception ex) {
					btnStart.setEnabled(true);
					isRunning = false;
					close(ctx);
					lblStatus.setText("Server is not running");

					ex.printStackTrace();
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			});

			JButton btnStop = new JButton("Stop Server");

			panel.add(btnStop);

			btnStop.addActionListener(e -> {
				if (!isRunning) {
					JOptionPane.showMessageDialog(null, "Server đang không chạy", "Server",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đóng server?", "Server",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					try {
						close(ctx);
						JOptionPane.showMessageDialog(null, "Server đã dừng", "Server",
								JOptionPane.INFORMATION_MESSAGE);
						
						ConnectDB.getEntityManager().close();
						
						btnStart.setEnabled(true);
						
					} catch (Exception ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				lblStatus.setText("Server is not running");

			});
			
			lblStatus = new JLabel("Server is not running");
			
			server.add(lblStatus, BorderLayout.CENTER);

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
	private static void close(Context ctx) {
		try {
			ctx.unbind("rmi://" + HOST + ":" + PORT + "/chiTietHoaDon");
			ctx.unbind("rmi://" + HOST + ":" + PORT + "/chiTietKhuyenMai");
			ctx.unbind("rmi://" + HOST + ":" + PORT + "/chiTietTraHang");
			ctx.unbind("rmi://" + HOST + ":" + PORT + "/danhMuc");
			ctx.unbind("rmi://" + HOST + ":" + PORT + "/hoaDon");
			ctx.unbind("rmi://" + HOST + ":" + PORT + "/hoaDonTra");
			ctx.unbind("rmi://" + HOST + ":" + PORT + "/khachHang");
			ctx.unbind("rmi://" + HOST + ":" + PORT + "/khuyenMai");
			ctx.unbind("rmi://" + HOST + ":" + PORT + "/nhaCungCap");
			ctx.unbind("rmi://" + HOST + ":" + PORT + "/nhanVien");
			ctx.unbind("rmi://" + HOST + ":" + PORT + "/nhaXuatBan");
			ctx.unbind("rmi://" + HOST + ":" + PORT + "/sanPham");
			ctx.unbind("rmi://" + HOST + ":" + PORT + "/tacGia");
			ctx.unbind("rmi://" + HOST + ":" + PORT + "/theLoai");
			ctx.unbind("rmi://" + HOST + ":" + PORT + "/thuongHieu");
			ctx.close();
			ctx = null;
			isRunning = false;
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Đóng server thất bại!");
			e.printStackTrace();
		}
	
	}
}
