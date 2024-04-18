/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.DanhMuc;
import entities.ThuongHieu;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IThuongHieu extends Remote{
    public List<ThuongHieu> getAllThuongHieu() throws RemoteException;
    public List<ThuongHieu> getThuongHieuTheoID(int x) throws RemoteException;
    public boolean addThuongHieu(ThuongHieu x) throws RemoteException;
    public boolean editThuongHieu (ThuongHieu x) throws RemoteException;
}
