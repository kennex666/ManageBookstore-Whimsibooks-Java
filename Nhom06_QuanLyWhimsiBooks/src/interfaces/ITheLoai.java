/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.DanhMuc;
import entities.TheLoai;
import entities.ThuongHieu;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public interface ITheLoai {
    public ArrayList<TheLoai> getAllTheLoai();
    public ArrayList<TheLoai> getTheLoaiTheoID(int x);
    public boolean addTheLoai(TheLoai x);
    public boolean editTheLoai (TheLoai x);
}
