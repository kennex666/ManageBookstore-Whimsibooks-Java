/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import entities.NhanVien;


/**
 *
 * @author duong
 */
public class CurrentSession {
    private static CurrentSession instance = new CurrentSession();
    private static NhanVien nhanVien;
    public static enum EnumQuyenHan{
        NHAN_VIEN_QUAN_LY,
        NHAN_VIEN_BAN_HANG,
        NHAN_VIEN_CU
    }

    public void setNhanVienHienHanh(NhanVien x){
        this.nhanVien = x;
    }
    
    public static boolean isLogin(){
        if (nhanVien == null)
            return false;
        if (nhanVien.getNhanVienID().isBlank())
            return false;
        return true;
    }
    
    public static EnumQuyenHan checkQuyenTruyCap(){
        if (nhanVien.getChucVu().equalsIgnoreCase("NGUOI_QUAN_LY"))
            return EnumQuyenHan.NHAN_VIEN_QUAN_LY;
        if (nhanVien.getChucVu().equalsIgnoreCase("NHAN_VIEN_BAN_HANG"))
            return EnumQuyenHan.NHAN_VIEN_BAN_HANG;
        return EnumQuyenHan.NHAN_VIEN_CU;
    }
    
    public static String getTenNhanVienDangNhap(){
        return nhanVien.getHoTen();
    }
    
    public static String getMaNhanVienDangNhap(){
        return nhanVien.getNhanVienID();
    }
    
    public static NhanVien getNhanVien() {
    	return nhanVien;
    }

    public CurrentSession() {
    }
    
    public static CurrentSession getInstance(){
        return instance;
    }
    
    @Override
    public String toString() {
        return "utilities.CurrentSession[ id= ]";
    }
    
}
