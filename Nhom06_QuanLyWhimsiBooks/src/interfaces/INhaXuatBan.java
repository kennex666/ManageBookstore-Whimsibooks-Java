/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.NhaXuatBan;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public interface INhaXuatBan {
    public ArrayList<NhaXuatBan> getAllNhaXuatBan();
    public ArrayList<NhaXuatBan> getNhaXuatBanTheoID(String x);
    public boolean addNhaXuatBan(NhaXuatBan x);
    public boolean editNhaXuatBan (NhaXuatBan x);
}
