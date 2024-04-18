package bus;

import java.util.ArrayList;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.List;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.HoaDonTra;
import entities.SanPham;
import entities.ThuongHieu;
import interfaces.IChiTietHoaDon;
import interfaces.IChiTietTraHang;
import interfaces.IHoaDon;
import interfaces.IHoaDonTra;
import interfaces.ISanPham;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.naming.Context;
import javax.naming.InitialContext;

public class ThongKe_BUS {

	private ISanPham sanPham_DAO;
	private IHoaDon hoaDon_DAO;
	private IChiTietHoaDon chiTietHoaDon_DAO;
	private IHoaDonTra hoaDonTra_DAO;
	private IChiTietTraHang chiTietTraHang_DAO;

	public List<Object[]> thongKeXuHuongTheoThoiGian(Date timeStart, Date timeEnd) {
		List<Object[]> listThongKe;
		try {
			listThongKe = hoaDon_DAO.getDanhSachHoaDonThongKeXuHuong(timeStart, timeEnd);

			if (listThongKe == null) {
				listThongKe = new ArrayList<Object[]>();
			}
			HashMap<String, Object[]> listTraHang = getTongTraHangThongKeXuHuong(timeStart, timeEnd);
			for (int i = 0; i < listThongKe.size(); i++) {
				Object[] x = listThongKe.get(i);
				Object[] tempObj = listTraHang.get(x[1]);
				if (tempObj == null)
					continue;
				x[5] = tempObj[0];
				x[9] = (double) tempObj[1];
				listThongKe.set(i, x);
			}
			return listThongKe;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<Map.Entry<Date, double[]>> thongKeTheoThoiGian(Date timeStart, Date timeEnd) {
		List<HoaDon> listHoaDon;
		try {
			listHoaDon = hoaDon_DAO.getDanhSachHoaDonTheoThoiGian(timeStart, timeEnd);

			HashMap<Date, double[]> listThongKe = new HashMap<Date, double[]>();

			if (listHoaDon == null) {
				return new ArrayList<Map.Entry<Date, double[]>>();
			}

			for (HoaDon x : listHoaDon) {
				// doanhThu, tienVon, loiNhuan, traHang
				x.setListChiTietHoaDon(chiTietHoaDon_DAO.getAllChiTietCuaMotHoaDon(x.getHoaDonID()));
				double tienVonTemp = 0;
				for (ChiTietHoaDon y : x.getListChiTietHoaDon()) {
					tienVonTemp += y.getSoLuong() * y.getSanPham().getGiaNhap();
				}

				double[] thongKe = new double[] { x.getTongTien(), tienVonTemp, x.getTongTien() - tienVonTemp, 0f };
				thongKe[0] = (thongKe[0] < 0) ? 0 : thongKe[0];
				thongKe[1] = (thongKe[1] < 0) ? 0 : thongKe[1];
				thongKe[2] = (thongKe[2] < 0) ? 0 : thongKe[2];
				// System.out.println(String.format("Thống kê: %f %f %f %f", thongKe[0],
				// thongKe[1], thongKe[2], thongKe[3]));
				if (!x.getTrangThai().equalsIgnoreCase("DA_XU_LY")) {
					continue;
				}

				Date ngayLapHoaDon = new Date(x.getNgayLapHoaDon().getYear(), x.getNgayLapHoaDon().getMonth(),
						x.getNgayLapHoaDon().getDate());

				x.setListChiTietHoaDon(chiTietHoaDon_DAO.getAllChiTietCuaMotHoaDon(x.getHoaDonID()));
				if (listThongKe.get(ngayLapHoaDon) == null) {
					listThongKe.put(ngayLapHoaDon, thongKe);
				} else {
					double[] thongKeTruocDo = listThongKe.get(ngayLapHoaDon);
					listThongKe.remove(ngayLapHoaDon);
					thongKeTruocDo[0] = thongKeTruocDo[0] + thongKe[0];
					thongKeTruocDo[1] = thongKeTruocDo[1] + thongKe[1];
					thongKeTruocDo[2] = thongKeTruocDo[2] + thongKe[2];
					thongKeTruocDo[3] = thongKeTruocDo[3] + thongKe[3];
					listThongKe.put(ngayLapHoaDon, thongKeTruocDo);
				}
			}

			List<HoaDonTra> listHoaDonTra = hoaDonTra_DAO.getDanhSachHoaDonTheoThoiGian(timeStart, timeEnd);

			for (HoaDonTra x : listHoaDonTra) {
				if (x == null) {
					continue;
				}
				// x.setListChiTietHoaDon(chiTietTraHang_DAO.getAllChiTietCuaMotHoaDon(x.getHoaDonID()));
				Date ngayLapHoaDon = new Date(x.getNgayTraHoaDon().getYear(), x.getNgayTraHoaDon().getMonth(),
						x.getNgayTraHoaDon().getDate());

				double[] thongKe = { 0f, 0f, 0f, x.getTongHoan() };
				thongKe[3] = (thongKe[3] < 0) ? 0 : thongKe[3];

				if (listThongKe.get(ngayLapHoaDon) == null) {
					listThongKe.put(ngayLapHoaDon, thongKe);
				} else {
					double[] thongKeTruocDo = listThongKe.get(ngayLapHoaDon);
					listThongKe.remove(ngayLapHoaDon);
					thongKeTruocDo[0] = thongKeTruocDo[0] + thongKe[0];
					thongKeTruocDo[1] = thongKeTruocDo[1] + thongKe[1];
					thongKeTruocDo[2] = thongKeTruocDo[2] + thongKe[2];
					thongKeTruocDo[3] = thongKeTruocDo[3] + thongKe[3];
					listThongKe.put(ngayLapHoaDon, thongKeTruocDo);
				}
			}

			List<Map.Entry<Date, double[]>> entryList = new ArrayList<>(listThongKe.entrySet());

			Collections.sort(entryList, Comparator.comparing(Map.Entry::getKey));

			// Tạo một List mới để lưu trữ dữ liệu đã sắp xếp
			List<Map.Entry<Date, double[]>> sortedList = new ArrayList<>(entryList);

			return sortedList;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public HashMap<String, Object[]> getTongTraHangThongKeXuHuong(Date start, Date end) {
		HashMap<String, Object[]> listTraHang;
		try {
			listTraHang = hoaDonTra_DAO.getObjectThongKeXuHuong(start, end);
			return listTraHang;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ThongKe_BUS() {
		try {
			Context ctx = new InitialContext();
			sanPham_DAO = (ISanPham) ctx.lookup("rmi://" + ultilities.EnviromentConfigs.URL_RMI + "/sanPham");
			hoaDon_DAO = (IHoaDon) ctx.lookup("rmi://" + ultilities.EnviromentConfigs.URL_RMI + "/hoaDon");
			chiTietHoaDon_DAO = (IChiTietHoaDon) ctx
					.lookup("rmi://" + ultilities.EnviromentConfigs.URL_RMI + "/chiTietHoaDon");
			hoaDonTra_DAO = (IHoaDonTra) ctx.lookup("rmi://" + ultilities.EnviromentConfigs.URL_RMI + "/hoaDonTra");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
