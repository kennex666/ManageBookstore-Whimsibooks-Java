/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.DanhMuc;
import entities.ThuongHieu;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IThuongHieu {
    public List<ThuongHieu> getAllThuongHieu();
    public List<ThuongHieu> getThuongHieuTheoID(int x);
    public boolean addThuongHieu(ThuongHieu x);
    public boolean editThuongHieu (ThuongHieu x);
}
