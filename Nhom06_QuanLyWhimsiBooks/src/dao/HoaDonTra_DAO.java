package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import connectDB.ConnectDB;
import entities.HoaDon;
import entities.HoaDonTra;
import entities.KhachHang;
import entities.KhuyenMai;
import entities.NhanVien;
import interfaces.IHoaDon;
import interfaces.IHoaDonTra;
import ultilities.QueryBuilder;

public class HoaDonTra_DAO implements IHoaDonTra {

    private Connection conn;

    public HoaDonTra_DAO() {
        // TODO Auto-generated constructor stub
        conn = ConnectDB.getConnection();
    }

    @Override
    public boolean createHoaDon(HoaDonTra x) {
        // TODO Auto-generated method stub
        String query = "INSERT INTO HoaDonTra(HoaDonID, KhachHangID, NhanVienID, NgayTraHoaDon, TongHoan, TrangThai) VALUES(?, ? ,? ,?, ?, ?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, x.getHoaDonID());
            pstm.setString(2, (x.getKhachHang() == null) ? "KH0001" : x.getKhachHang().getKhachHangID());
            pstm.setString(3, (x.getNhanVien() == null) ? "NV0001" : x.getNhanVien().getNhanVienID());
            java.sql.Timestamp now = new java.sql.Timestamp(new Date().getTime());
            pstm.setTimestamp(4, now);
            pstm.setDouble(5, x.tinhTongHoan());
            pstm.setString(6, x.getTrangThai());
            return (pstm.executeUpdate() > 0);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateHoaDon(HoaDonTra x) {
        String query = "UPDATE HoaDonTra SET KhachHangID = ?, NhanVienID = ?, NgayTraHoaDon = ?, TongHoan = ?, TrangThai = ? WHERE HoaDonID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, (x.getKhachHang() == null) ? "KH0001" : x.getKhachHang().getKhachHangID());
            pstm.setString(2, (x.getNhanVien() == null) ? "NV0001" : x.getNhanVien().getNhanVienID());
            java.sql.Timestamp now = new java.sql.Timestamp(new Date().getTime());
            pstm.setTimestamp(3, now);
            pstm.setDouble(4, x.tinhTongHoan());
            pstm.setString(5, x.getTrangThai());
            pstm.setString(6, x.getHoaDonID());
            return (pstm.executeUpdate() > 0);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean cancelHoaDon(HoaDonTra x) {
        String query = "UPDATE HoaDonTra SET TrangThai = ? WHERE HoaDonID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, "HUY_BO");
            pstm.setString(2, x.getHoaDonID());
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<HoaDonTra> getDanhSachHoaDon() {
        List<HoaDonTra> listHoaDon = new ArrayList<HoaDonTra>();
        String query = "SELECT TOP 100 * FROM HoaDonTra hd JOIN NhanVien nv ON hd.NhanVienID = nv.NhanVienID JOIN KhachHang kh ON hd.KhachHangID = kh.KhachHangID WHERE YEAR(NgayTraHoaDon) = YEAR(GETDATE()) AND MONTH(NgayTraHoaDon) = MONTH(GETDATE()) AND DAY(NgayTraHoaDon) = DAY(GETDATE()) ORDER BY NgayTraHoaDon DESC";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                HoaDonTra hd = new HoaDonTra();

                String hoaDonID = rs.getString("HoaDonID");
                String khachHangID = rs.getString("KhachHangID");
                String nhanVienID = rs.getString("NhanVienID");
                Date NgayTraHoaDon = rs.getTimestamp("NgayTraHoaDon");
                double tongTien = rs.getDouble("tongHoan");
                String trangThai = rs.getString("TrangThai");

                hd.setHoaDonID(hoaDonID);
                hd.setNgayTraHoaDon(NgayTraHoaDon);
                hd.setTongHoan(tongTien);
                hd.setTrangThai(trangThai);
                hd.setTongHoan(tongTien);

                String hoTenNhanVien = rs.getString("HoTen");
                String chucVu = rs.getString("chucvu");

                NhanVien nv = new NhanVien(nhanVienID);
                nv.setHoTen(hoTenNhanVien);
                nv.setChucVu(chucVu);
                hd.setNhanVien(nv);

                String hoTenKH = rs.getString(22);
                String maSoThue = rs.getString("MaSoThue");
                String diaChi = rs.getString("diaChi");
                String loaiKH = rs.getString("LoaiKhachHang");
                String sdtKH = rs.getString("SoDienThoai");
                String emailKH = rs.getString("Email");

                KhachHang kh = new KhachHang(khachHangID);
                kh.setHoTen(hoTenKH);
                kh.setMaSoThue(maSoThue);
                kh.setDiaChi(diaChi);
                kh.setLoaiKhachHang(loaiKH);
                kh.setSoDienThoai(sdtKH);
                kh.setEmail(emailKH);
                hd.setKhachHang(kh);

                listHoaDon.add(hd);

            }
            return listHoaDon;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return listHoaDon;
        }
    }

    @Override
    public List<HoaDonTra> getDanhSachHoaDonTheoThoiGian(Date batDau, Date ketThuc) {
        // TODO Auto-generated method stub
        List<HoaDonTra> listHoaDon = new ArrayList<HoaDonTra>();

        String query = "SELECT * FROM HoaDonTra hd JOIN NhanVien nv ON hd.NhanVienID = nv.NhanVienID JOIN KhachHang kh ON hd.KhachHangID = kh.KhachHangID ?";

        try {
            QueryBuilder queryBuilder = new QueryBuilder(query);
            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.TIMESTAMP,
                    "NgayTraHoaDon",
                    ">=",
                    batDau
            );
            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.TIMESTAMP,
                    "NgayTraHoaDon",
                    "<=",
                    ketThuc
            );
            ResultSet rs = queryBuilder.setParamsForPrepairedStament(conn, "AND").executeQuery();

            while (rs.next()) {
                HoaDonTra hd = new HoaDonTra();

                String hoaDonID = rs.getString("HoaDonID");
                String khachHangID = rs.getString("KhachHangID");
                String nhanVienID = rs.getString("NhanVienID");
                Date NgayTraHoaDon = rs.getTimestamp("NgayTraHoaDon");
                double tongTien = rs.getDouble("tongHoan");
                String trangThai = rs.getString("TrangThai");

                hd.setHoaDonID(hoaDonID);
                hd.setNgayTraHoaDon(NgayTraHoaDon);
                hd.setTongHoan(tongTien);
                hd.setTrangThai(trangThai);
                hd.setTongHoan(tongTien);

                String hoTenNhanVien = rs.getString("HoTen");
                String chucVu = rs.getString("chucvu");

                NhanVien nv = new NhanVien(nhanVienID);
                nv.setHoTen(hoTenNhanVien);
                nv.setChucVu(chucVu);
                hd.setNhanVien(nv);

                String hoTenKH = rs.getString(22);
                String maSoThue = rs.getString("MaSoThue");
                String diaChi = rs.getString("diaChi");
                String loaiKH = rs.getString("LoaiKhachHang");
                String sdtKH = rs.getString("SoDienThoai");
                String emailKH = rs.getString("Email");

                KhachHang kh = new KhachHang(khachHangID);
                kh.setHoTen(hoTenKH);
                kh.setMaSoThue(maSoThue);
                kh.setDiaChi(diaChi);
                kh.setLoaiKhachHang(loaiKH);
                kh.setSoDienThoai(sdtKH);
                kh.setEmail(emailKH);
                hd.setKhachHang(kh);

                listHoaDon.add(hd);

            }
            return listHoaDon;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return listHoaDon;
        }
    }

    public HashMap<String, Object[]> getObjectThongKeXuHuong(Date batDau, Date ketThuc) {
        // TODO Auto-generated1 method stub
        HashMap<String, Object[]> listHoaDon = new HashMap<String, Object[]>();

        String query = "SELECT sp.Barcode, SUM(SoLuong) AS SoLuongTraHang, SUM(DonGia * SoLuong) AS TongGiaTriTra FROM SanPham sp JOIN ChiTietTraHang ctth ON sp.SanPhamID = ctth.SanPhamID JOIN HoaDonTra hdt ON ctth.HoaDonID = hdt.HoaDonID ? GROUP BY Barcode";

        try {
            QueryBuilder queryBuilder = new QueryBuilder(query);
            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.TIMESTAMP,
                    "NgayTraHoaDon",
                    ">=",
                    batDau
            );
            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.TIMESTAMP,
                    "NgayTraHoaDon",
                    "<=",
                    ketThuc
            );
            ResultSet rs = queryBuilder.setParamsForPrepairedStament(conn, "AND").executeQuery();

            while (rs.next()) {
                Object[] tempObj = {rs.getInt("SoLuongTraHang"),(double) rs.getDouble("TongGiaTriTra")};
                listHoaDon.put(rs.getString("barcode"),tempObj);
            }
            return listHoaDon;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return new HashMap<String, Object[]>();
        }
    }

    @Override
    public List<HoaDonTra> getDanhSachHoaDonNangCao(Object[] params) {
        // TODO Auto-generated method stub
        List<HoaDonTra> listHoaDon = new ArrayList<HoaDonTra>();

        String query = "SELECT * FROM HoaDonTra hd JOIN NhanVien nv ON hd.NhanVienID = nv.NhanVienID JOIN KhachHang kh ON hd.KhachHangID = kh.KhachHangID ?";

        try {
            QueryBuilder queryBuilder = new QueryBuilder(query);
            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.TIMESTAMP,
                    "NgayTraHoaDon",
                    ">",
                    params[0]
            );
            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.TIMESTAMP,
                    "NgayTraHoaDon",
                    "<=",
                    params[1]
            );

            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.STRING,
                    "TrangThai",
                    "=",
                    params[2]
            );

            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.DOUBLE,
                    "TongTien",
                    ">=",
                    params[3]
            );
            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.DOUBLE,
                    "TongTien",
                    "<=",
                    params[4]
            );

            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.STRING,
                    "HoaDonID",
                    "%?%",
                    params[5]
            );

            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.STRING,
                    "hd.KhachHangID",
                    "%?%",
                    params[6]
            );

            queryBuilder.addParameter(
                    QueryBuilder.Enum_DataType.STRING,
                    "hd.NhanVienID",
                    "%?%",
                    params[7]
            );

            ResultSet rs = queryBuilder.setParamsForPrepairedStament(conn, "AND").executeQuery();
            while (rs.next()) {
                HoaDonTra hd = new HoaDonTra();

                String hoaDonID = rs.getString("HoaDonID");
                String khachHangID = rs.getString("KhachHangID");
                String nhanVienID = rs.getString("NhanVienID");
                Date NgayTraHoaDon = rs.getTimestamp("NgayTraHoaDon");
                double tongTien = rs.getDouble("tongHoan");
                String trangThai = rs.getString("TrangThai");

                hd.setHoaDonID(hoaDonID);
                hd.setNgayTraHoaDon(NgayTraHoaDon);
                hd.setTongHoan(tongTien);
                hd.setTrangThai(trangThai);
                hd.setTongHoan(tongTien);

                String hoTenNhanVien = rs.getString("HoTen");
                String chucVu = rs.getString("chucvu");

                NhanVien nv = new NhanVien(nhanVienID);
                nv.setHoTen(hoTenNhanVien);
                nv.setChucVu(chucVu);
                hd.setNhanVien(nv);

                String hoTenKH = rs.getString(19);
                String maSoThue = rs.getString("MaSoThue");
                String diaChi = rs.getString("diaChi");
                String loaiKH = rs.getString("LoaiKhachHang");
                String sdtKH = rs.getString("SoDienThoai");
                String emailKH = rs.getString("Email");

                KhachHang kh = new KhachHang(khachHangID);
                kh.setHoTen(hoTenKH);
                kh.setMaSoThue(maSoThue);
                kh.setDiaChi(diaChi);
                kh.setLoaiKhachHang(loaiKH);
                kh.setSoDienThoai(sdtKH);
                kh.setEmail(emailKH);
                hd.setKhachHang(kh);

                listHoaDon.add(hd);

            }
            return listHoaDon;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return listHoaDon;
        }
    }

    @Override
    public HoaDonTra getHoaDonByID(HoaDonTra hd) {
        String query = "SELECT * FROM HoaDonTra hd JOIN NhanVien nv ON hd.NhanVienID = nv.NhanVienID JOIN KhachHang kh ON hd.KhachHangID = kh.KhachHangID WHERE HoaDonID = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, hd.getHoaDonID());
            ResultSet rs = pstm.executeQuery();

            if (!rs.next()) {
                return null;
            }

            String hoaDonID = rs.getString("HoaDonID");
            String khachHangID = rs.getString("KhachHangID");
            String nhanVienID = rs.getString("NhanVienID");
            Date NgayTraHoaDon = rs.getTimestamp("NgayTraHoaDon");
            double tongTien = rs.getDouble("TongHoan");
            String trangThai = rs.getString("TrangThai");

            hd.setHoaDonID(hoaDonID);
            hd.setNgayTraHoaDon(NgayTraHoaDon);
            hd.setTongHoan(tongTien);
            hd.setTrangThai(trangThai);
            hd.setTongHoan(tongTien);

            String hoTenNhanVien = rs.getString("HoTen");
            String chucVu = rs.getString("chucvu");

            NhanVien nv = new NhanVien(nhanVienID);
            nv.setHoTen(hoTenNhanVien);
            nv.setChucVu(chucVu);
            hd.setNhanVien(nv);

            String hoTenKH = rs.getString(22);
            String maSoThue = rs.getString("MaSoThue");
            String diaChi = rs.getString("diaChi");
            String loaiKH = rs.getString("LoaiKhachHang");
            String sdtKH = rs.getString("SoDienThoai");
            String emailKH = rs.getString("Email");

            KhachHang kh = new KhachHang(khachHangID);
            kh.setHoTen(hoTenKH);
            kh.setMaSoThue(maSoThue);
            kh.setDiaChi(diaChi);
            kh.setLoaiKhachHang(loaiKH);
            kh.setSoDienThoai(sdtKH);
            kh.setEmail(emailKH);
            hd.setKhachHang(kh);

            return hd;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getSoHoaDonTrongNgay() {
        // TODO Auto-generated method stub
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT COUNT(*) AS [SoLuong] FROM HoaDonTra WHERE YEAR(NgayTraHoaDon) = YEAR(GETDATE()) AND MONTH(NgayTraHoaDon) = MONTH(GETDATE()) AND DAY(NgayTraHoaDon) = DAY(GETDATE())");
            rs.next();
            return rs.getInt("SoLuong");
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        }
    }

}
