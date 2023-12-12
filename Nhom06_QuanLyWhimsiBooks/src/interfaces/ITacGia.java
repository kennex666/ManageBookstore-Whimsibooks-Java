/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.DanhMuc;
import entities.TacGia;
import entities.ThuongHieu;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public interface ITacGia {
    public ArrayList<TacGia> getAllTacGia();
    public ArrayList<TacGia> getTacGiaTheoID(int x);
    public boolean addTacGia(TacGia x);
    public boolean editTacGia (TacGia x);
}
