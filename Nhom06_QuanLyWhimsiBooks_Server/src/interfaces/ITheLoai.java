/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.DanhMuc;
import entities.TheLoai;
import entities.ThuongHieu;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ITheLoai extends Remote{
    public List<TheLoai> getAllTheLoai() throws RemoteException;
    public List<TheLoai> getTheLoaiTheoID(int x) throws RemoteException;
    public boolean addTheLoai(TheLoai x) throws RemoteException;
    public boolean editTheLoai (TheLoai x) throws RemoteException;
}
