package bus;

import dao.ChiTietHoaDon_DAO;
import dao.ChiTietTraHang_DAO;
import dao.HoaDonTra_DAO;
import dao.HoaDon_DAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import dao.SanPham_DAO;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.HoaDonTra;
import entities.SanPham;
import entities.ThuongHieu;
import interfaces.ISanPham;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ThongKe_BUS {

    private SanPham_DAO sanPham_DAO;
    private HoaDon_DAO hoaDon_DAO;
    private ChiTietHoaDon_DAO chiTietHoaDon_DAO;
    private HoaDonTra_DAO hoaDonTra_DAO;
    private ChiTietTraHang_DAO chiTietTraHang_DAO;
    
    public ArrayList<Object[]> thongKeXuHuongTheoThoiGian(Date timeStart, Date timeEnd){
        ArrayList<Object[]> listThongKe = hoaDon_DAO.getDanhSachHoaDonThongKeXuHuong(timeStart, timeEnd);
        if (listThongKe == null){
            listThongKe = new ArrayList<Object[]>();
        }
        return listThongKe;
    }

    public ArrayList<Map.Entry<Date, double[]>> thongKeTheoThoiGian(Date timeStart, Date timeEnd) {
        ArrayList<HoaDon> listHoaDon = hoaDon_DAO.getDanhSachHoaDonTheoThoiGian(timeStart, timeEnd);
        HashMap<Date, double[]> listThongKe = new HashMap<Date, double[]>();

        if (listHoaDon == null) {
            return new ArrayList<Map.Entry<Date, double[]>>();
        }

        for (HoaDon x : listHoaDon) {
            //doanhThu, tienVon, loiNhuan, traHang
            x.setListChiTietHoaDon(chiTietHoaDon_DAO.getAllChiTietCuaMotHoaDon(x.getHoaDonID()));
            double tienVonTemp = 0;
            for (ChiTietHoaDon y : x.getListChiTietHoaDon()) {
                tienVonTemp += y.getSoLuong() * y.getSanPham().getGiaNhap();
            }

            double[] thongKe = new double[]{x.getTongTien(), tienVonTemp, x.getTongTien() - tienVonTemp, 0f};
            thongKe[0] = (thongKe[0] < 0) ? 0 : thongKe[0];
            thongKe[1] = (thongKe[1] < 0) ? 0 : thongKe[1];
            thongKe[2] = (thongKe[2] < 0) ? 0 : thongKe[2];
            //System.out.println(String.format("Thống kê: %f %f %f %f", thongKe[0], thongKe[1], thongKe[2], thongKe[3]));
            if (!x.getTrangThai().equalsIgnoreCase("DA_XU_LY")) {
                continue;
            }

            Date ngayLapHoaDon = new Date(x.getNgayLapHoaDon().getYear(), x.getNgayLapHoaDon().getMonth(), x.getNgayLapHoaDon().getDate());

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

        ArrayList<HoaDonTra> listHoaDonTra = hoaDonTra_DAO.getDanhSachHoaDonTheoThoiGian(timeStart, timeEnd);

        for (HoaDonTra x : listHoaDonTra) {
            if (x == null) {
                continue;
            }
            // x.setListChiTietHoaDon(chiTietTraHang_DAO.getAllChiTietCuaMotHoaDon(x.getHoaDonID()));
            Date ngayLapHoaDon = new Date(x.getNgayTraHoaDon().getYear(), x.getNgayTraHoaDon().getMonth(), x.getNgayTraHoaDon().getDate());

            double[] thongKe = {0f, 0f, 0f, x.getTongHoan()};
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

        // Tạo một ArrayList mới để lưu trữ dữ liệu đã sắp xếp
        ArrayList<Map.Entry<Date, double[]>> sortedList = new ArrayList<>(entryList);

        return sortedList;
    }

    public ThongKe_BUS() {
        sanPham_DAO = new SanPham_DAO();
        hoaDon_DAO = new HoaDon_DAO();
        chiTietHoaDon_DAO = new ChiTietHoaDon_DAO();
        hoaDonTra_DAO = new HoaDonTra_DAO();
        chiTietTraHang_DAO = new ChiTietTraHang_DAO();
    }

}
