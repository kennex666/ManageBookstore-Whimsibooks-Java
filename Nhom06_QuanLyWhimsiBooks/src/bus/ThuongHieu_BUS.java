/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import dao.ThuongHieu_DAO;
import entities.ThuongHieu;
import interfaces.IThuongHieu;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ThuongHieu_BUS implements IThuongHieu{

    private ThuongHieu_DAO thuongHieu_DAO = new ThuongHieu_DAO();
    @Override
    public ArrayList<ThuongHieu> getAllThuongHieu() {
        return thuongHieu_DAO.getAllThuongHieu();
    }

    @Override
    public ArrayList<ThuongHieu> getThuongHieuTheoID(int x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addThuongHieu(ThuongHieu x) {
        return thuongHieu_DAO.addThuongHieu(x);
    }

    @Override
    public boolean editThuongHieu(ThuongHieu x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
