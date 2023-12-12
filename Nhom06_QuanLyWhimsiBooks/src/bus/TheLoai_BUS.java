/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import dao.TheLoai_DAO;
import entities.TheLoai;
import interfaces.ITheLoai;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class TheLoai_BUS implements ITheLoai{
    TheLoai_DAO theLoai_DAO = new TheLoai_DAO();

    public TheLoai_BUS() {
    }
    @Override
    public ArrayList<TheLoai> getAllTheLoai() {
        return theLoai_DAO.getAllTheLoai();
    }

    @Override
    public ArrayList<TheLoai> getTheLoaiTheoID(int x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addTheLoai(TheLoai x) {
        return theLoai_DAO.addTheLoai(x);
    }

    @Override
    public boolean editTheLoai(TheLoai x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
