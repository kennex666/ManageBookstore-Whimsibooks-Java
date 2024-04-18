package bus;

import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entities.ChiTietKhuyenMai;
import entities.KhuyenMai;
import entities.NhaCungCap;
import entities.SanPham;
import gui.Form_DanhSachVoucher;
import interfaces.IChiTietHoaDon;
import interfaces.IKhuyenMai;
import interfaces.ISanPham;
import ultilities.EnviromentConfigs;

public class KhuyenMai_BUS implements IKhuyenMai {
	private IKhuyenMai khuyenMai_DAO;
	private ISanPham sanPham_BUS;

	public KhuyenMai_BUS() {
		try {
			Context ctx  = new InitialContext();
			khuyenMai_DAO = (IKhuyenMai) ctx.lookup("rmi://" + EnviromentConfigs.URL_RMI +"/khuyenMai");
			sanPham_BUS = (ISanPham) ctx.lookup("rmi://" + EnviromentConfigs.URL_RMI +"/sanPham");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<SanPham> laySanPhamTheoMa(String txt) {
		try {
			return khuyenMai_DAO.laySanPhamTheoMa(txt);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<SanPham> laySanPhamTheoTen(String txt) {
		try {
			return khuyenMai_DAO.laySanPhamTheoTen(txt);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<KhuyenMai> getKhuyenMaiByIDAndName(String maKhuyenMai, String tenKM) {
		// TODO Auto-generated method stub
		try {
			return khuyenMai_DAO.getKhuyenMaiByIDAndName(maKhuyenMai, tenKM);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<KhuyenMai> getKhuyenMaiTheoTen(String tenSK) {
		try {
			return khuyenMai_DAO.getKhuyenMaiTheoTen(tenSK);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<SanPham> laySanPhamDuocChon(JTable table) {
		List<SanPham> dsSanPhamDuocChon = new ArrayList<SanPham>();
		int rowCount = table.getRowCount();
		if (rowCount != 0) {
			for (int i = 0; i < rowCount; i++) {
				boolean isSelected = (boolean) table.getModel().getValueAt(i, 0);
				String maSanPham = table.getModel().getValueAt(i, 1).toString();
				String tenSanPham = table.getModel().getValueAt(i, 2).toString();
				if (isSelected) {
					SanPham sanPham = new SanPham(Integer.valueOf(maSanPham), tenSanPham);
					dsSanPhamDuocChon.add(sanPham);
				}
			}
			return dsSanPhamDuocChon;
		}
		return null;
	}

	@Override
	public List<KhuyenMai> getAllKhuyenMai() {
		// TODO Auto-generated method stub
		try {
			return khuyenMai_DAO.getAllKhuyenMai();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<KhuyenMai> getKhuyenMaiByID(String maKhuyenMai) {
		// TODO Auto-generated method stub
		try {
			return khuyenMai_DAO.getKhuyenMaiByID(maKhuyenMai);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<KhuyenMai> getKhuyenMaiFollowDay(Date startDay, Date expriedDay) {
		// TODO Auto-generated method stub
		try {
			return khuyenMai_DAO.getKhuyenMaiFollowDay(startDay, expriedDay);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addKhuyenMai(KhuyenMai khuyenMai) {
		// TODO Auto-generated method stub
		try {
			return khuyenMai_DAO.addKhuyenMai(khuyenMai);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean editKhuyenMai(KhuyenMai khuyenMai) {
		// TODO Auto-generated method stub
		try {
			return khuyenMai_DAO.editKhuyenMai(khuyenMai);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public long layMaNCCCuoiCung() {
		// TODO Auto-generated method stub
		try {
			return khuyenMai_DAO.layMaNCCCuoiCung();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public List<KhuyenMai> TimKiemTheoLoai(String hinhThuc) {
		try {
			return khuyenMai_DAO.TimKiemTheoLoai(hinhThuc);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<KhuyenMai> TimKiemTheoDieuKien(String ma, String loai) {
		try {
			return khuyenMai_DAO.TimKiemTheoDieuKien(ma, loai);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public KhuyenMai getKhuyenMaiByCodeKMForSeller(String maKhuyenMai) {
		try {
			return khuyenMai_DAO.getKhuyenMaiByCodeKMForSeller(maKhuyenMai);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public KhuyenMai getKhuyenMaiViaSanPhamAutoApply(int maSanPham) {
		// TODO Auto-generated method stub
		try {
			return khuyenMai_DAO.getKhuyenMaiViaSanPhamAutoApply(maSanPham);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}

	@Override
	public List<KhuyenMai> TimKiemKhuyenMaiTheoDieuKien(String query) {
		try {
			return khuyenMai_DAO.TimKiemKhuyenMaiTheoDieuKien(query);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}

	// Xuat file
	@Override
	public List<KhuyenMai> getDanhSachKhuyenMaiNangCao(Object[] params) throws ParseException {
		// TODO Auto-generated method stub
		try {
			return khuyenMai_DAO.getDanhSachKhuyenMaiNangCao(params);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}

	public boolean xuatFile(List<KhuyenMai> list) {
		JFileChooser excelFileChooser = new JFileChooser("D:\\");
		excelFileChooser.setDialogTitle("Save Excel File");
		FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xlsx");
		excelFileChooser.setFileFilter(fnef);

		int excelChooser = excelFileChooser.showSaveDialog(null);

		if (excelChooser == JFileChooser.APPROVE_OPTION) {
			File excelFile = excelFileChooser.getSelectedFile();

			// Kiểm tra nếu tên file không kết thúc bằng ".xlsx", thêm ".xlsx" vào
			if (!excelFile.getName().toLowerCase().endsWith(".xlsx")) {
				excelFile = new File(excelFile.getParentFile(), excelFile.getName() + ".xlsx");
			}

			// Kiểm tra xem file đã tồn tại chưa
			if (excelFile.exists()) {
				int result = JOptionPane.showConfirmDialog(null,
						"File đã tồn tại. Bạn có muốn ghi đè lên file hiện tại không?", "Ghi đè",
						JOptionPane.YES_NO_OPTION);
				if (result != JOptionPane.YES_OPTION) {
					// Người dùng không muốn ghi đè, trả về false
					return false;
				}
			}

			try {
				FileOutputStream fileOut = new FileOutputStream(excelFile);
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("Sheet1");

				int rowNum = 1;
				String[] title = { "Mã giảm giá", "Ngày tạo", "Ngày kích hoạt", "Ngày hết hạn ", "Hình thức giảm",
						"Đơn hàng từ", "Mức giảm giá" };
				Row head = sheet.createRow(0);
				head.createCell(0).setCellValue(title[0]);
				head.createCell(1).setCellValue(title[1]);
				head.createCell(2).setCellValue(title[2]);
				head.createCell(3).setCellValue(title[3]);
				head.createCell(4).setCellValue(title[4]);
				head.createCell(5).setCellValue(title[5]);
				head.createCell(6).setCellValue(title[6]);

				for (KhuyenMai km : list) {
					Row row = sheet.createRow(rowNum++);
					row.createCell(0).setCellValue(km.getCodeKhuyenMai());
					row.createCell(1).setCellValue(ultilities.GetToDay.today());
					row.createCell(2).setCellValue(km.getNgayKhuyenMai() + "");
					row.createCell(3).setCellValue(km.getNgayHetHanKM() + "");
					row.createCell(4).setCellValue(km.getLoaiKhuyenMai());
					row.createCell(5).setCellValue(km.getDonHangTu());
					row.createCell(6).setCellValue(km.getGiaTri());
				}

				workbook.write(fileOut);
				fileOut.close();

				// Thông báo thành công
				JOptionPane.showMessageDialog(null, "Xuất file thành công", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);

				return true;

			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Lỗi: File không tìm thấy", "Lỗi", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Lỗi khi ghi file", "Lỗi", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}

		// Người dùng đã hủy hoặc có lỗi, trả về false
		return false;
	}

	@Override
	public List<KhuyenMai> getKhuyenMaiByName(String name) {
		// TODO Auto-generated method stub
		try {
			return khuyenMai_DAO.getKhuyenMaiByName(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}

	@Override
	public boolean deleteKhuyenMai(String codeKhuyenMai) {
		// TODO Auto-generated method stub
		try {
			return khuyenMai_DAO.deleteKhuyenMai(codeKhuyenMai);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}

	// type ,String tenKM, int soLuong, double donGiaTu, String hinhThuc, double
	// mucGiam, Date ngayBatDau, Date ngayKetThuc
	private String VoucherCode() {
		String voucherCode;
		String nameRequired = "Voucher_";
		Set<String> generatedCodes = new HashSet<>();

		for (int i = 0; i < getAllKhuyenMai().size(); i++) {
			generatedCodes.add(getAllKhuyenMai().get(i).getCodeKhuyenMai());
		}

		voucherCode = ultilities.RandomVoucherCode.VoucherCode(nameRequired, generatedCodes);

		return voucherCode;
	}

	public boolean update(Object[] obj, Object[] objProduct) {
		List<KhuyenMai> list = getKhuyenMaiByName(obj[9].toString());

		String typeUpdate = (String) obj[0];
		String maKhuyenMai = String.valueOf(obj[1]);
		String tenKM = String.valueOf(obj[2]);
		int countNew = Integer.valueOf(obj[3].toString());
		double donHangTu = Double.valueOf(obj[4].toString());
		String hinhThuc = String.valueOf(obj[5]);
		double mucGiam = Double.valueOf(obj[6].toString());
		Date ngayBatDau = Date.valueOf(obj[7].toString());
		Date ngayKetThuc = Date.valueOf(obj[8].toString());
		int Count = list.size();
		int countOld = getSoLuongChuaSD(new Object[] { tenKM, null });

		boolean checkConfirm = false;

		try {
			// Update Voucher
			if (typeUpdate.contains("Voucher")) {
				for (KhuyenMai km : list) {
					KhuyenMai khuyenMai = new KhuyenMai(km.getCodeKhuyenMai(), tenKM, hinhThuc, mucGiam, ngayBatDau,
							ngayKetThuc, donHangTu, 1, km.getSoLuotDaApDung());
					editKhuyenMai(khuyenMai);
				}
				// số lượng không thay đổi
				if (countNew == countOld) {
					return true;
				}
				// Tăng số lượng
				if (countNew > countOld) {
					int SLTang = countNew - countOld;
					List<KhuyenMai> khuyenMais = new ArrayList<KhuyenMai>();
					for (int i = 0; i < SLTang; i++) {
						KhuyenMai khuyenMai = new KhuyenMai(VoucherCode(), tenKM, hinhThuc, Double.valueOf(mucGiam),
								ngayBatDau, ngayKetThuc, donHangTu, 1, 0);
						khuyenMais.add(khuyenMai);
						addKhuyenMai(khuyenMai);
					}
					Form_DanhSachVoucher danhSachVoucher = new Form_DanhSachVoucher(khuyenMais);
					danhSachVoucher.setVisible(true);
					return true;
				}
				// Giảm số lượng
				if (countNew < countOld) {
					int SLGiam = countOld - countNew;
					List<KhuyenMai> listChuaSD = getKhuyenMaiByName(obj[9].toString());
					for (int i = 0; i < SLGiam; i++) {
						if (listChuaSD.get(i).getSoLuotDaApDung() == 0)
							deleteKhuyenMai(listChuaSD.get(i).getCodeKhuyenMai());
					}
					return true;
				}
			}
			// Update khuyenMai
			if (typeUpdate.equals("KhuyenMai")) {
				KhuyenMai khuyenMai = new KhuyenMai(maKhuyenMai, tenKM, hinhThuc, mucGiam, ngayBatDau, ngayKetThuc,
						donHangTu, 1, 0);
				editKhuyenMai(khuyenMai);
				List<ChiTietKhuyenMai> listCTTKM = getChiTietKhuyenMaiTheoMa(maKhuyenMai);

				int countCTKM_Old = listCTTKM.size();
				int countCTKM_New = objProduct.length;

				for (int j = 0; j < countCTKM_Old; j++) {
					xoaSanPhamKhuyenMai(maKhuyenMai);
				}

				for (int i = 0; i < countCTKM_New; i++) {
					addSanPhamKhuyenMaiKhiUpdate(maKhuyenMai, Integer.valueOf(objProduct[i].toString()));
				}
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int getSoLuongChuaSD(Object[] params) {
		// TODO Auto-generated method stub
		try {
			return khuyenMai_DAO.getSoLuongChuaSD(params);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1; 
		}
	}

	@Override
	public boolean addSanPhamKhuyenMaiKhiUpdate(String makhuyenMai, int masanPham) {
		// TODO Auto-generated method stub
		try {
			return khuyenMai_DAO.addSanPhamKhuyenMaiKhiUpdate(makhuyenMai, masanPham);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}

	@Override
	public List<ChiTietKhuyenMai> getChiTietKhuyenMaiTheoMa(String maKM) {
		// TODO Auto-generated method stub
		try {
			return khuyenMai_DAO.getChiTietKhuyenMaiTheoMa(maKM);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}

	@Override
	public boolean xoaSanPhamKhuyenMai(String makhuyenMai) {
		// TODO Auto-generated method stub
		try {
			return khuyenMai_DAO.xoaSanPhamKhuyenMai(makhuyenMai);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
	}

	@Override
	public List<KhuyenMai> getRecentKhuyenMai(int limit) {
		// TODO Auto-generated method stub
		try {
			return khuyenMai_DAO.getRecentKhuyenMai(limit);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}

	@Override
	public List<KhuyenMai> getKhuyenMaiTheoTen1(String tenSK) {
		// TODO Auto-generated method stub
		try {
			return khuyenMai_DAO.getKhuyenMaiTheoTen1(tenSK);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
	}

}
