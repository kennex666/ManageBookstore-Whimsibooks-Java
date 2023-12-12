package loader;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import bus.ChiTietHoaDon_BUS;
import bus.HoaDon_BUS;
import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.SanPham_DAO;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhanVien;
import entities.SanPham;

public class AutoGenerateHoaDon {
	public static void main(String[] args) {
		System.out.println("Starting...!");

		ConnectDB.getInstance().connect();
		SanPham_DAO sanPham_DAO = new SanPham_DAO();
		NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
		KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
		Random random = new Random();
		HoaDon_BUS hoaDon_BUS = new HoaDon_BUS();
		ChiTietHoaDon_BUS chiTietHoaDon_BUS = new ChiTietHoaDon_BUS();

		// Tạo một số nguyên ngẫu nhiên trong phạm vi từ 1 đến 10

		ArrayList<NhanVien> listNhanVien = nhanVien_DAO.getAllEmployees();
		ArrayList<KhachHang> listKhachHang = khachHang_DAO.getAllKhachHang();
		ArrayList<SanPham> listSanPham = sanPham_DAO.getDanhSachSanPham();
		Date start = new Date();

		start.setDate(1);
		start.setMonth(0);
		start.setHours(0);
		start.setMinutes(0);
		start.setSeconds(0);

		for (int i = 0; i < 346; i++) {
			int randomHoaDon = random.nextInt(100);
			for (int k = 0; k < randomHoaDon; k++) {
				int hours = random.nextInt(23);
				int minute = random.nextInt(59);
				int second = random.nextInt(59);
				start.setHours(hours);
				start.setMinutes(minute);
				start.setSeconds(second);
				
				int nhanVienID = random.nextInt(listNhanVien.size() - 1);
				int khachHangID = random.nextInt(listKhachHang.size() - 1);
				int soLuongSanPhamMua = random.nextInt(1, 14);
				int danhSachIDSanPham[] = createRandomArray(soLuongSanPhamMua, listSanPham.size() - 1);
				HoaDon hoaDon = new HoaDon();
				hoaDon.setTrangThai("DA_XU_LY");
				hoaDon.setNhanVien(listNhanVien.get(nhanVienID));
				hoaDon.setKhachHang(listKhachHang.get(khachHangID));
				hoaDon.setNgayLapHoaDon(start);

				for (int j = 0; j < soLuongSanPhamMua; j++) {
					hoaDon.addChiTietHoaDon(
							new ChiTietHoaDon(listSanPham.get(danhSachIDSanPham[j]), random.nextInt(15)));
				}

				hoaDon_BUS.createHoaDon(hoaDon);
				chiTietHoaDon_BUS.addNhieuChiTietCuaMotHoaDon(hoaDon.getListChiTietHoaDon());
			}
			start.setDate(start.getDate() + 1);
		}
		System.out.println("Generate Success!");
	}

	public static int[] createRandomArray(int size, int max) {
		// Tạo một đối tượng Random
		Random random = new Random();

		// Khởi tạo mảng
		int[] array = new int[size];

		// Lặp qua mảng
		for (int i = 0; i < size; i++) {
			// Tạo số ngẫu nhiên
			int randomNumber = random.nextInt(max);

			// Kiểm tra xem số ngẫu nhiên đã tồn tại trong mảng hay chưa
			boolean isUnique = true;
			for (int j = 0; j < i; j++) {
				if (array[j] == randomNumber) {
					isUnique = false;
					break;
				}
			}

			// Nếu số ngẫu nhiên chưa tồn tại trong mảng, thì thêm vào mảng
			if (isUnique) {
				array[i] = randomNumber;
			}
		}

		return array;
	}
}
