/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.DanhMuc;
import entities.TacGia;
import entities.ThuongHieu;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ITacGia {
    public List<TacGia> getAllTacGia();
    public List<TacGia> getTacGiaTheoID(int x);
    public boolean addTacGia(TacGia x);
    public boolean editTacGia (TacGia x);
}
