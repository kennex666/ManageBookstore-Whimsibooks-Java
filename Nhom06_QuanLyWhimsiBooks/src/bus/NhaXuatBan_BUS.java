/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import dao.NhaXuatBan_DAO;
import entities.NhaXuatBan;
import interfaces.INhaXuatBan;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class NhaXuatBan_BUS implements INhaXuatBan{
    NhaXuatBan_DAO nhaXuatBan_DAO = new NhaXuatBan_DAO();
    
    @Override
    public List<NhaXuatBan> getAllNhaXuatBan() {
        return nhaXuatBan_DAO.getAllNhaXuatBan();
    }

    @Override
    public List<NhaXuatBan> getNhaXuatBanTheoID(String x) {
        return nhaXuatBan_DAO.getNhaXuatBanTheoID(x);
    }

    @Override
    public boolean addNhaXuatBan(NhaXuatBan x) {
       return nhaXuatBan_DAO.addNhaXuatBan(x);
    }

    @Override
    public boolean editNhaXuatBan(NhaXuatBan x) {
        return nhaXuatBan_DAO.editNhaXuatBan(x);
    }
    
}
