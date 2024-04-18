/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.DanhMuc;
import entities.TacGia;
import entities.ThuongHieu;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ITacGia extends Remote{
    public List<TacGia> getAllTacGia() throws RemoteException;
    public List<TacGia> getTacGiaTheoID(int x) throws RemoteException;
    public boolean addTacGia(TacGia x) throws RemoteException;
    public boolean editTacGia (TacGia x) throws RemoteException;
}
