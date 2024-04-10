/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import dao.TacGia_DAO;
import entities.TacGia;
import interfaces.ITacGia;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class TacGia_BUS implements ITacGia{
    TacGia_DAO tacGia_DAO = new TacGia_DAO();

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    @Override
    public List<TacGia> getAllTacGia() {
       return tacGia_DAO.getAllTacGia();
    }

    @Override
    public List<TacGia> getTacGiaTheoID(int x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addTacGia(TacGia x) {
        return tacGia_DAO.addTacGia(x);
                
    }

    @Override
    public boolean editTacGia(TacGia x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
