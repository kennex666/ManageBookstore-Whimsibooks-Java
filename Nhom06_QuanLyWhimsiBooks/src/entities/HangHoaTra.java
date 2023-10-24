package entities;

import java.util.Date;

public class HangHoaTra {
    private String hoaDonID;
    private Date ngayTraHoaDon;
    private String trangThai;

    public HangHoaTra() {
    }

    public HangHoaTra(String hoaDonID, Date ngayTraHoaDon, String trangThai) {
        setHoaDonID(hoaDonID);
        setNgayTraHoaDon(ngayTraHoaDon);
        setTrangThai(trangThai);
    }

    public HangHoaTra(HangHoaTra other) {
        this(other.hoaDonID, other.ngayTraHoaDon, other.trangThai);
    }

    

    public String getHoaDonID() {
        return hoaDonID;
    }

    public void setHoaDonID(String hoaDonID) {
        // Phát sinh tự động theo quy tắc
        if (hoaDonID == null || !hoaDonID.matches("HD\\d+")) {
            throw new IllegalArgumentException("Hóa đơn ID không hợp lệ");
        }
        this.hoaDonID = hoaDonID;
    }

    public Date getNgayTraHoaDon() {
        return ngayTraHoaDon;
    }

    public void setNgayTraHoaDon(Date ngayTraHoaDon) {
        this.ngayTraHoaDon = ngayTraHoaDon;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        if (trangThai == null || trangThai.isEmpty() || !trangThai.equals("HUY_BO")) {
            throw new IllegalArgumentException("Trạng thái không rõ");
        }
        this.trangThai = trangThai;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "Hàng hoá trả [Hóa đơn ID: " + hoaDonID +
               ", Ngày trả hóa đơn: " + ngayTraHoaDon +
               ", Trạng thái: " + trangThai + "]";
    }
}

