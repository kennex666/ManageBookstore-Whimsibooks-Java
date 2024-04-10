/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.NhaXuatBan;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface INhaXuatBan {
    public List<NhaXuatBan> getAllNhaXuatBan();
    public List<NhaXuatBan> getNhaXuatBanTheoID(String x);
    public boolean addNhaXuatBan(NhaXuatBan x);
    public boolean editNhaXuatBan (NhaXuatBan x);
}
